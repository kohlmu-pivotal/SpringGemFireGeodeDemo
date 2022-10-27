package com.vmware.gemfire.example.service;

import com.vmware.gemfire.example.model.Customer;
import com.vmware.gemfire.example.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

  private final CustomerRepository repository;

  public CustomerService(CustomerRepository repository) {
    this.repository = repository;
  }

  public void clearRepository() {
    repository.deleteAll();
  }

  public void addCustomers() {
    repository.save(new Customer(1, "Mario", "Andretti"));
    repository.save(new Customer(2, "Michael", "Schumacher"));
    repository.save(new Customer(3, "Alain", "Prost"));
    repository.save(new Customer(4, "Ayrton", "Senna"));
    repository.save(new Customer(5, "Nigel", "Mansell"));
    repository.save(new Customer(6, "Jackie", "Stewart"));
    repository.save(new Customer(7, "Niki", "Lauda"));
    repository.save(new Customer(8, "Jim", "Clark"));
    repository.save(new Customer(9, "Juan Manuel", "Fangio"));
    repository.save(new Customer(10, "Stirling", "Moss"));
    repository.save(new Customer(11, "Emerson", "Fittipaldi"));
  }

  public List<Customer> findByFirstname(String firstname) {
    return repository.findByFirstname(firstname);
  }

  public List<Customer> findByLastname(String lastname) {
    return repository.findByLastname(lastname);
  }

  public Iterable<Customer> findAll() {
    return repository.findAll();
  }
}
