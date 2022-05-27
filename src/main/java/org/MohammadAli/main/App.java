package org.MohammadAli.main;

import org.MohammadAli.Util.CustomRequest;
import org.MohammadAli.Util.CustomResponse;
import org.MohammadAli.controllers.*;
import org.MohammadAli.models.CustomerDTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------Welcome TO Customer Services--------------");
        int input;
        boolean managementFlag;
        final CreateCustomerAccountController createCustomerAccountController = new CreateCustomerAccountController();
        final FindCustomerByNameController findCustomerByNameController = new FindCustomerByNameController();
        final FindAccountByIdController findAccountByIdController = new FindAccountByIdController();
        final FindAllAccountController findAllAccountController = new FindAllAccountController();
        final DeleteAccountByIdController deleteAccountByIdController = new DeleteAccountByIdController();
        CustomRequest request;
        CustomResponse response;
        while (true) {
            System.out.println("1) Accounts Management");
            System.out.println("2) Exit");
            input = scanner.nextInt();
            if (input == 2) break;
            managementFlag = true;
            while (managementFlag) {
                System.out.println("1) Create Account ");
                System.out.println("2) find Account by customer name");
                System.out.println("3) find Account by account id");
                System.out.println("4) get all customer");
                System.out.println("5) delete account by id");
                System.out.println("6) back");
                input = scanner.nextInt();
                switch (input) {
                    case 1:
                        request = new CustomRequest(HashMap::new);
                        response = new CustomResponse(HashMap::new);
                        System.out.println("Enter your name:");
                        String name = scanner.next();
                        System.out.println("Enter your family:");
                        String family = scanner.next();
                        System.out.println("Enter your age:");
                        float age = scanner.nextInt();
                        request.setAttribute("name", name);
                        request.setAttribute("family", family);
                        request.setAttribute("age", age);
                        createCustomerAccountController.service(request , response);
                        break;
                    case 2:
                        request = new CustomRequest(HashMap::new);
                        response = new CustomResponse(HashMap::new);
                        System.out.println("Enter the Customer name that you want to find");
                        name = scanner.next();
                        request.setAttribute("name",name);
                        findCustomerByNameController.service(request,response);
                        Collection<CustomerDTO> dtoCollection = (Collection<CustomerDTO>) response.getAttribute("customers");
                        dtoCollection.forEach(System.out::println);
                        break;
                    case 3:
                        request = new CustomRequest(HashMap::new);
                        response = new CustomResponse(HashMap<String,Object>::new);
                        System.out.println("Enter the account id that you want to find");
                        String accountId = scanner.next();
                        request.setAttribute("id",accountId);
                        findAccountByIdController.service(request,response);
                        Object dto = response.getAttribute("dto");
                        System.out.println(dto);
                        break;
                    case 4:
                        request = new CustomRequest(HashMap::new);
                        response = new CustomResponse(HashMap<String,Object>::new);
                        findAllAccountController.service(request , response);
                        Collection<CustomerDTO> customers = (Collection<CustomerDTO>) response.getAttribute("customers");
                        customers.forEach(System.out::println);
                        break;
                    case 5:
                        request = new CustomRequest(HashMap::new);
                        response = new CustomResponse(HashMap<String,Object>::new);
                        System.out.println("Enter Account id that you want to delete it");
                        accountId = scanner.next();
                        request.setAttribute("id", accountId);
                        deleteAccountByIdController.service(request , response);
                        break;
                    case 6:
                        managementFlag = false;
                        break;
                    default:
                        System.out.println("please choose valid number");
                }
            }
        }
    }
}
