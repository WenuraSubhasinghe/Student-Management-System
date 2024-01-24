package com.smslogic.smsbusinesslogic.service.impl;

import com.smslogic.smsbusinesslogic.dto.StudentDto;
import com.smslogic.smsbusinesslogic.entity.Student;
import com.smslogic.smsbusinesslogic.exception.ResourceNotFoundException;
import com.smslogic.smsbusinesslogic.mapper.StudentMapper;
import com.smslogic.smsbusinesslogic.repository.StudentRepository;
import com.smslogic.smsbusinesslogic.service.DepartmentService;
import com.smslogic.smsbusinesslogic.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private DepartmentService departmentService;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        Student student = StudentMapper.mapToStudent(studentDto, departmentService);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id :" + studentId));

        return StudentMapper.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(Long studentId, StudentDto updatedStudent) {
        return null;
    }
}
