package com.example.axonbanktest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 10/20/2017.
 */
@Entity
@Data
public class Customer {
  @Id
  private String id;
  private String name;
  private String gender;

}
