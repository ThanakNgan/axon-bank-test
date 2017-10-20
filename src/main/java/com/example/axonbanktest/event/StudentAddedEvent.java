package com.example.axonbanktest.event;

import com.example.axonbanktest.model.Student;
import lombok.Value;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 10/20/2017.
 */
@Value
public class StudentAddedEvent {
  String id;
  Student student;
}
