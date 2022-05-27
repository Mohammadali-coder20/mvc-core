package org.MohammadAli.controllers;

import org.MohammadAli.Util.CustomRequest;
import org.MohammadAli.Util.Request;
import org.MohammadAli.Util.RequestHandler;
import org.MohammadAli.Util.Response;
import org.MohammadAli.models.CustomerDTO;
import org.MohammadAli.services.AccountService;
import org.MohammadAli.services.AccountServiceImpl;
import org.MohammadAli.services.CustomerService;
import org.MohammadAli.services.CustomerServiceImpl;

public class CreateCustomerAccountController implements RequestHandler {

    private final static AccountService  accountService = new AccountServiceImpl();
    private final static CustomerService customerService = new CustomerServiceImpl();

    @Override
    public void service(Request req , Response resp) {
        CustomRequest request = (CustomRequest) req;
        CustomerDTO.CREATE dto = new CustomerDTO.CREATE((String) request.getAttribute("name"), (String) request.getAttribute("family"), (Float) request.getAttribute("age"));
        String accountID = accountService.createAccount(dto);
        customerService.connectCustomerToAccount(dto , accountID);

    }
}
