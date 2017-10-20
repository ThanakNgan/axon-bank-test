package com.example.axonbanktest.config;

import com.example.axonbanktest.command.AddStudentCommand;
import com.example.axonbanktest.event.StudentAddedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 10/20/2017.
 */
@Aggregate
public class BankAccount {

  @AggregateIdentifier
  private String id;
  @SuppressWarnings("unused")
  private BankAccount() {
  }

  @CommandHandler
  public void addStudent(AddStudentCommand command){
    apply(new StudentAddedEvent(command.getId(), command.getStudent()));
  }

}
