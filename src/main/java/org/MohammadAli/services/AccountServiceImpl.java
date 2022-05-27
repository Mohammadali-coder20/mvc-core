package org.MohammadAli.services;

import org.MohammadAli.data.AccountDAO;
import org.MohammadAli.data.AccountDAOImpl;
import org.MohammadAli.entities.Account;
import org.MohammadAli.models.AccountDTO;
import org.MohammadAli.models.CustomerDTO;
import org.modelmapper.ModelMapper;

public class AccountServiceImpl implements AccountService{


    private final static ModelMapper mapper = new ModelMapper();

    private final static AccountDAO dao = new AccountDAOImpl();

    private final static CustomerService customerService = new CustomerServiceImpl();

    @Override
    public String createAccount(CustomerDTO.CREATE dto) {
        Account account = new Account();
        account.setAccountID(dto.getName() , dto.getAge());
        dao.save(account);
        return account.getAccountID();
    }

    @Override
    public AccountDTO findAccount(String accountId) {
        return mapper.map(dao.findAccount(accountId) , AccountDTO.class);
    }

    @Override
    public boolean deleteAccount(String accountId) {
        boolean wasExisted = dao.deleteAccount(accountId);
        if (wasExisted)
           return customerService.deleteCustomerInfo(accountId);
        return false;
    }
}
