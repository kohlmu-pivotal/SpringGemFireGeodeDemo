package com.vmware.gemfire.example.model;

import java.io.Serializable;

public class Customer implements Serializable {

  private final String firstname;
  private final String lastname;

  public Customer(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }
}
