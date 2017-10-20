package com.example.axonbanktest.command;

import com.example.axonbanktest.model.Student;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 10/20/2017.
 */
@Value
public class AddStudentCommand {
  @TargetAggregateIdentifier
  String id;
  Student student;
}
