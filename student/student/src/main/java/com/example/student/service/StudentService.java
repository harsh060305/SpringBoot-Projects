package com.example.student.service;

import com.example.student.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);

    StudentDto getStudentById(Integer id);

    List<StudentDto> getAllStudents();

    StudentDto updateStudentCourse(Integer id,String course);

    StudentDto updateStudent(Integer id, StudentDto studentDto);

    void deleteStudent(Integer id);
}
