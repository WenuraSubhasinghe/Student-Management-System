package com.smslogic.smsbusinesslogic.service;

import com.smslogic.smsbusinesslogic.dto.DepartmentDto;
import com.smslogic.smsbusinesslogic.entity.Department;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentById(Long departmentId);

    Department getDepartmentEntityById(Long departmentId);

    List<DepartmentDto> getAllDepartments();
}
