package com.vmware.gemfire.example.controller;

import com.vmware.gemfire.example.model.Customer;
import com.vmware.gemfire.example.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
  private CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping(value = "/customers", produces = "text/plain;charset=UTF-8")
  public String getAllCustomers() {
    Iterable<Customer> allCustomers = customerService.findAll();
    StringBuilder stringBuilder = new StringBuilder();
    for (Customer customer : allCustomers) {
      stringBuilder.append(customer.getFirstname());
      stringBuilder.append(" ");
      stringBuilder.append(customer.getLastname());
      stringBuilder.append(System.getProperty("line.separator"));
    }
    String returnString = stringBuilder.toString();
    return returnString.isEmpty() ? "No values found" : returnString;
  }

  @GetMapping(value = "/customers/add", produces = "text/plain;charset=UTF-8")
  public String addCustomers() {
    customerService.addCustomers();
    return "Customers added";
  }

  @GetMapping(value = "/customers/clear", produces = "text/plain;charset=UTF-8")
  public String clearCustomers() {
    customerService.clearRepository();
    return "Customers cleared";
  }
}
