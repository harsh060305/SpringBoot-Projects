package com.example.student.mapper;

import com.example.student.dto.StudentDto;
import com.example.student.entity.Student;

public class StudentMapper {

    public static Student mapToStudent(StudentDto studentDto) {
        Student student = new Student(
                studentDto.getId(),
                studentDto.getName(),
                studentDto.getEmail(),
                studentDto.getCourse()
        );
        return student;
    }

    public static StudentDto mapToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse()
        );
        return studentDto;
    }


}

