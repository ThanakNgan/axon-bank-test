package com.example.axonbanktest.repository;

import com.example.axonbanktest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Copyright (c) GL Finance Plc. All rights reserved. (http://www.gl-f.com/)
 * Author: Thanak Ngan (t.ngan@gl-f.com) on 10/20/2017.
 */
public interface StudentRepository extends JpaRepository<Student, String> {
}
