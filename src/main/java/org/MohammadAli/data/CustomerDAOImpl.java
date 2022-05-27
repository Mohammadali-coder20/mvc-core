package org.MohammadAli.data;

import org.MohammadAli.Util.Repository;
import org.MohammadAli.entities.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerDAOImpl implements CustomerDAO {

    private final Repository<Customer> repo;

    public CustomerDAOImpl() {
        repo = new Repository<>();
    }

    @Override
    public void save(Customer customer) {
        repo.getCollector().add(customer);
    }

    @Override
    public Map<String , Customer> findCustomerInfoByName(String name) {
        Map<String, Customer> collect = repo.getCollector().stream()
                                                           .filter(customer -> customer.getName().equalsIgnoreCase(name))
                                                           .collect(Collectors.toMap(Customer::getAccountID, customer -> customer));
        return collect;
    }

    @Override
    public Customer findCustomerByAccountID(String id) {
        return repo.getCollector().stream()
                                  .filter(customer -> customer.getAccountID().equals(id))
                                  .collect(Collectors.toList())
                                  .get(0);

    }

    @Override
    public Collection<Customer> findAllCustomers() {
        return new ArrayList<>(repo.getCollector());
    }

    @Override
    public boolean deleteCustomerInfo(String accountId) {
       return repo.getCollector().removeIf(customer -> customer.getAccountID().equals(accountId));
    }
}
