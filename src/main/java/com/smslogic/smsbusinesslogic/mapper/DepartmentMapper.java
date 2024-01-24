package com.smslogic.smsbusinesslogic.mapper;

import com.smslogic.smsbusinesslogic.dto.DepartmentDto;
import com.smslogic.smsbusinesslogic.entity.Department;

public class DepartmentMapper {

    public static DepartmentDto mapToDepartmentDto(Department department){

        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName()
        );
    }

    public static Department mapToDepartment(DepartmentDto departmentDto){

        Department department = new Department();
        department.setId(department.getId());
        department.setDepartmentName(departmentDto.getDepartmentName());

        return department;
    }
}
