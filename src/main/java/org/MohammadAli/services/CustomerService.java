package org.MohammadAli.services;

import org.MohammadAli.models.CustomerDTO;

import java.util.Collection;

public interface CustomerService {
    void connectCustomerToAccount(CustomerDTO.CREATE dto , String accountId);

    Collection<CustomerDTO> findCustomerInfoByName(String name);

    CustomerDTO findCustomerByAccountID(String id);

    Collection<CustomerDTO> findAllCustomers();

    boolean deleteCustomerInfo(String accountId);
}
