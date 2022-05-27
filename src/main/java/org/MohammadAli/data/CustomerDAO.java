package org.MohammadAli.data;

import org.MohammadAli.entities.Customer;

import java.util.Collection;
import java.util.Map;

public interface CustomerDAO {
    void save(Customer customer);

    Map<String,Customer> findCustomerInfoByName(String name);

    Customer findCustomerByAccountID(String id);

    Collection<Customer> findAllCustomers();

    boolean deleteCustomerInfo(String accountId);
}
