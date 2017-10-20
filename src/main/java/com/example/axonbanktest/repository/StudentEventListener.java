package com.example.axonbanktest.repository;

import com.example.axonbanktest.event.StudentAddedEvent;
import com.example.axonbanktest.model.Student;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 10/20/2017.
 */
@Component
public class StudentEventListener {
  private final StudentRepository repository;

  @Inject
  public StudentEventListener(StudentRepository repository) {
    this.repository = repository;
  }

  @EventHandler
  public void on(StudentAddedEvent event){
    Student student = new Student();
    student.setId(event.getId());
    student.setName(event.getStudent().getName());
    repository.save(student);
  }
}
