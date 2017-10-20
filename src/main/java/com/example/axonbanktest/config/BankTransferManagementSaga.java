package com.example.axonbanktest.config;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 10/20/2017.
 */
@Saga
public class BankTransferManagementSaga {

  private transient CommandBus commandBus;

  @Autowired
  public void setCommandBus(CommandBus commandBus) {
    this.commandBus = commandBus;
  }

  private String sourceBankAccountId;
  private String destinationBankAccountId;
  private long amount;

}
