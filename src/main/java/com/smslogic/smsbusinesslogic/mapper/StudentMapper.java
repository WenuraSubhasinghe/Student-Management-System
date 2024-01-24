package com.smslogic.smsbusinesslogic.mapper;

import com.smslogic.smsbusinesslogic.dto.DepartmentDto;
import com.smslogic.smsbusinesslogic.dto.StudentDto;
import com.smslogic.smsbusinesslogic.entity.Department;
import com.smslogic.smsbusinesslogic.entity.Student;
import com.smslogic.smsbusinesslogic.service.DepartmentService;

public class StudentMapper {

    private DepartmentService departmentService;

    public static StudentDto mapToStudentDto(Student student){
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getDateOfBirth(),
                student.getEmail(),
                student.getAddress(),
                student.getDepartment().getId()
        );
    }

    public static Student mapToStudent(StudentDto studentDto, DepartmentService departmentService){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setEmail(studentDto.getEmail());
        student.setAddress(studentDto.getAddress());

        if(studentDto.getDepartmentId() != null){
            Department department = departmentService.getDepartmentEntityById(studentDto.getDepartmentId());
            student.setDepartment(department);
        }
        return student;
    }
}
