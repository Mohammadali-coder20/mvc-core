package org.MohammadAli.controllers;

import org.MohammadAli.Util.*;
import org.MohammadAli.models.CustomerDTO;
import org.MohammadAli.services.AccountService;
import org.MohammadAli.services.AccountServiceImpl;
import org.MohammadAli.services.CustomerService;
import org.MohammadAli.services.CustomerServiceImpl;

import java.util.Collection;

public class FindCustomerByNameController implements RequestHandler {

    private final static CustomerService customerService = new CustomerServiceImpl();


    @Override
    public void service(Request req, Response resp) {
        CustomResponse response = (CustomResponse) resp;
        CustomRequest request = (CustomRequest) req;
        String name  = (String) request.getAttribute("name");
        Collection<CustomerDTO> dtoCollection = customerService.findCustomerInfoByName(name);
        response.setAttribute("customers",dtoCollection);
    }
}
