package org.MohammadAli.services;

import org.MohammadAli.models.AccountDTO;
import org.MohammadAli.models.CustomerDTO;

public interface AccountService {
    String createAccount(CustomerDTO.CREATE dto);

    AccountDTO findAccount(String accountId);

    boolean deleteAccount(String accountId);
}
