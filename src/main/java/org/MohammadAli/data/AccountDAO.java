package org.MohammadAli.data;

import org.MohammadAli.entities.Account;

public interface AccountDAO {
    void save(Account account);

    Account findAccount(String accountId);

    boolean deleteAccount(String accountId);
}
