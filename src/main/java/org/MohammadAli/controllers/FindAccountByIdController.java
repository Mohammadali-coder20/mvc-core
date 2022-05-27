package org.MohammadAli.controllers;

import org.MohammadAli.Util.*;
import org.MohammadAli.models.CustomerDTO;
import org.MohammadAli.services.AccountService;
import org.MohammadAli.services.AccountServiceImpl;
import org.MohammadAli.services.CustomerService;
import org.MohammadAli.services.CustomerServiceImpl;

public class FindAccountByIdController implements RequestHandler {

    private final static CustomerService customerService = new CustomerServiceImpl();

    @Override
    public void service(Request req, Response resp) {
        CustomRequest request = (CustomRequest) req;
        CustomResponse response = (CustomResponse) resp;
        String id = (String) request.getAttribute("id");
        CustomerDTO dto = customerService.findCustomerByAccountID(id);
        response.setAttribute("dto", dto);
    }
}
