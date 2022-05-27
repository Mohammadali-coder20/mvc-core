package org.MohammadAli.controllers;

import org.MohammadAli.Util.CustomResponse;
import org.MohammadAli.Util.Request;
import org.MohammadAli.Util.RequestHandler;
import org.MohammadAli.Util.Response;
import org.MohammadAli.models.CustomerDTO;
import org.MohammadAli.services.AccountService;
import org.MohammadAli.services.AccountServiceImpl;
import org.MohammadAli.services.CustomerService;
import org.MohammadAli.services.CustomerServiceImpl;

import java.util.Collection;

public class FindAllAccountController implements RequestHandler {

    private final static CustomerService customerService = new CustomerServiceImpl();
    private final static AccountService accountService = new AccountServiceImpl();

    @Override
    public void service(Request req, Response resp) {
        CustomResponse response = (CustomResponse) resp;
        Collection<CustomerDTO> dtoCollection = customerService.findAllCustomers();
        response.setAttribute("customers", dtoCollection);
    }
}
