package com.example.axonbanktest.config;

import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.config.SagaConfiguration;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.messaging.interceptors.BeanValidationInterceptor;
import org.axonframework.spring.config.AxonConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 10/20/2017.
 */
@Configuration
public class ApplicationConfig {

  @Autowired
  private AxonConfiguration axonConfiguration;
  @Autowired
  private EventBus eventBus;

  @Bean
  public BankAccountCommandHandler bankAccountCommandHandler() {
    return new BankAccountCommandHandler(axonConfiguration.repository(BankAccount.class), eventBus);
  }

  @Bean
  public SagaConfiguration bankTransferManagementSagaConfiguration() {
    return SagaConfiguration.trackingSagaManager(BankTransferManagementSaga.class);
  }

  @Autowired
  public void configure(@Qualifier("localSegment") SimpleCommandBus simpleCommandBus) {
    simpleCommandBus.registerDispatchInterceptor(new BeanValidationInterceptor<>());
  }
}
