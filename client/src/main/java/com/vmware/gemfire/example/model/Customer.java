package com.vmware.gemfire.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.io.Serializable;

@Region("Customer")
public class Customer implements Serializable {

  @Id
  private final String id;
  private final String firstname;
  private final String lastname;

  public Customer(int id, String firstname, String lastname) {
    this.id = String.valueOf(id);
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public int getId() {
    return Integer.parseInt(id);
  }
}
