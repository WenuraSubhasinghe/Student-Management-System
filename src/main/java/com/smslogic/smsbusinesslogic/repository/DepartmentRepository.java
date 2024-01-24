package com.smslogic.smsbusinesslogic.repository;

import com.smslogic.smsbusinesslogic.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
