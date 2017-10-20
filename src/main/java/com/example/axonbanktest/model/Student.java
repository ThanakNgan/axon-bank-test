package com.example.axonbanktest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 10/20/2017.
 */
@Data
@Entity
public class Student {
  @Id
  private String id;
  private String name;
}
