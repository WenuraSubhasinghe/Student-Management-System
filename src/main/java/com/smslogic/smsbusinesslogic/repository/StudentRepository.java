package com.smslogic.smsbusinesslogic.repository;

import com.smslogic.smsbusinesslogic.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
