package com.example.axonbanktest.config;

import com.example.axonbanktest.command.AddStudentCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.Aggregate;
import org.axonframework.commandhandling.model.AggregateNotFoundException;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.eventhandling.EventBus;

import static org.axonframework.eventhandling.GenericEventMessage.asEventMessage;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 10/20/2017.
 */
public class BankAccountCommandHandler {
  private Repository<BankAccount> repository;
  private EventBus eventBus;

  public BankAccountCommandHandler(Repository<BankAccount> repository, EventBus eventBus) {
    this.repository = repository;
    this.eventBus = eventBus;
  }

  @CommandHandler
  public void handle(AddStudentCommand command) {
    try {
      Aggregate<BankAccount> bankAccountAggregate = repository.load(command.getId());
      bankAccountAggregate.execute(bankAccount -> bankAccount
              .debit(command.getAmount(), command.getBankTransferId()));
    } catch (AggregateNotFoundException exception) {
      eventBus.publish(asEventMessage(new SourceBankAccountNotFoundEvent(command.getBankTransferId())));
    }
  }
}
