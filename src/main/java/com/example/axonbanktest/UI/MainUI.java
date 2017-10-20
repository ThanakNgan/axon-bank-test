package com.example.axonbanktest.UI;

import com.example.axonbanktest.command.AddStudentCommand;
import com.example.axonbanktest.model.Student;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.axonframework.commandhandling.gateway.CommandGateway;

import javax.inject.Inject;
import java.util.UUID;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 10/20/2017.
 */
@SpringUI
public class MainUI extends UI {

  private final CommandGateway commandGateway;

  @Inject
  public MainUI(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @Override
  protected void init(VaadinRequest request) {
    FormLayout cssLayout = new FormLayout();
    TextField name = new TextField("Name");
    Button buttonAdd = new Button("Add student");
    buttonAdd.setStyleName(ValoTheme.BUTTON_PRIMARY);
    cssLayout.addComponents(name, buttonAdd);
    buttonAdd.addClickListener(event -> {
      Student student = new Student();
      student.setName(name.getValue());
      commandGateway.send(new AddStudentCommand(UUID.randomUUID().toString(),student));
      Notification.show("Add success");
    });
    setContent(cssLayout);
  }
}
