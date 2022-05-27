package org.MohammadAli.data;

import org.MohammadAli.Util.Repository;
import org.MohammadAli.entities.Account;

public class AccountDAOImpl implements AccountDAO {

    private final /*static*/ Repository<Account> repo;

    public AccountDAOImpl(){
        repo = new Repository<>();
    }

    @Override
    public void save(Account account) {
        repo.getCollector().add(account);
    }

    @Override
    public Account findAccount(String accountId) {
        for (Account account : repo.getCollector() ) {
            if (account.getAccountID().equals(accountId))
                return account;
        }
        return null;
    }

    @Override
    public boolean deleteAccount(String accountId) {
       return repo.getCollector().removeIf(account -> account.getAccountID().equals(accountId));
    }
}
