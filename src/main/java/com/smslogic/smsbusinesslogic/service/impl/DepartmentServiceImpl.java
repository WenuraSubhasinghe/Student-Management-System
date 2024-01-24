package com.smslogic.smsbusinesslogic.service.impl;

import com.smslogic.smsbusinesslogic.dto.DepartmentDto;
import com.smslogic.smsbusinesslogic.entity.Department;
import com.smslogic.smsbusinesslogic.entity.Student;
import com.smslogic.smsbusinesslogic.exception.ResourceNotFoundException;
import com.smslogic.smsbusinesslogic.mapper.DepartmentMapper;
import com.smslogic.smsbusinesslogic.mapper.StudentMapper;
import com.smslogic.smsbusinesslogic.repository.DepartmentRepository;
import com.smslogic.smsbusinesslogic.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department doesn't exists with given id :" + departmentId));

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public Department getDepartmentEntityById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department doesn't exist with given id: " + departmentId));
        return department;
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }
}
