package com.vmware.gemfire.example.repository;

import com.vmware.gemfire.example.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

  List<Customer> findByFirstname(String firstname);

  List<Customer> findByLastname(String lastname);
}
