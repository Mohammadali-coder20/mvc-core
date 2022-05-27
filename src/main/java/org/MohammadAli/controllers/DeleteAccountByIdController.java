package org.MohammadAli.controllers;

import org.MohammadAli.Util.*;
import org.MohammadAli.services.AccountService;
import org.MohammadAli.services.AccountServiceImpl;
import org.MohammadAli.services.CustomerService;
import org.MohammadAli.services.CustomerServiceImpl;

public class DeleteAccountByIdController implements RequestHandler {

    private final static AccountService accountService = new AccountServiceImpl();

    @Override
    public void service(Request req, Response resp) {
        CustomRequest request = (CustomRequest) req;
        CustomResponse response = (CustomResponse) resp;
        String accountId = (String) request.getAttribute("id");
        accountService.deleteAccount(accountId);
    }
}
