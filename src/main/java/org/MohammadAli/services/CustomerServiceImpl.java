package org.MohammadAli.services;

import org.MohammadAli.data.CustomerDAO;
import org.MohammadAli.data.CustomerDAOImpl;
import org.MohammadAli.entities.Account;
import org.MohammadAli.entities.Customer;
import org.MohammadAli.models.AccountDTO;
import org.MohammadAli.models.CustomerDTO;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    private final static ModelMapper mapper = new ModelMapper();

    private final static CustomerDAO dao = new CustomerDAOImpl();

    private final static AccountService accountService = new AccountServiceImpl();


    @Override
    public void connectCustomerToAccount(CustomerDTO.CREATE dto, String accountId) {
        Customer customer = mapper.map(dto, Customer.class);
        customer.setAccountID(accountId);
        dao.save(customer);
    }

    @Override
    public Collection<CustomerDTO> findCustomerInfoByName(String name) {
        Map<String, Customer> customerInfoByName = dao.findCustomerInfoByName(name);
        Collection<CustomerDTO> collect = new ArrayList<>();
        customerInfoByName.forEach((accountId, customer) -> {
            AccountDTO accountDTO = accountService.findAccount(accountId);
            CustomerDTO.RETRIEVE customerDTO = mapper.map(customer, CustomerDTO.RETRIEVE.class);
            customerDTO.setAccountDTO(accountDTO);
            collect.add(customerDTO);
        });
        return collect;
    }

    @Override
    public CustomerDTO findCustomerByAccountID(String id) {
        AccountDTO account = accountService.findAccount(id);
        Customer customer = dao.findCustomerByAccountID(id);
        CustomerDTO.RETRIEVE dto = mapper.map(customer , CustomerDTO.RETRIEVE.class);
        dto.setAccountDTO(account);
        return dto;
    }

    @Override
    public Collection<CustomerDTO> findAllCustomers() {
        Collection<Customer> allCustomers = dao.findAllCustomers();
        return allCustomers.stream().map(customer ->{
            CustomerDTO.RETRIEVE dto = mapper.map(customer , CustomerDTO.RETRIEVE.class);
            dto.setAccountDTO(accountService.findAccount(customer.getAccountID()));
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public boolean deleteCustomerInfo(String accountId) {
        return dao.deleteCustomerInfo(accountId);
    }


}
