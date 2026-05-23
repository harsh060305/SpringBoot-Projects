package com.example.student.service.impl;

import com.example.student.dto.StudentDto;
import com.example.student.entity.Student;
import com.example.student.mapper.StudentMapper;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public StudentDto createStudent(StudentDto studentDto) {
         Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not exists"));
        return StudentMapper.mapToStudentDto(student);

    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentMapper::mapToStudentDto).toList();
    }

    @Override
    public StudentDto updateStudentCourse(Integer id, String course) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not exists"));
        student.setCourse(course);
        Student updatedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updatedStudent);
    }

    @Override
    public StudentDto updateStudent(Integer id , StudentDto studentDto) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not exists"));
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setCourse(studentDto.getCourse());
        Student updatedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updatedStudent);


    }

    @Override
    public void deleteStudent(Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("student not exists"));
        studentRepository.delete(student);
    }


}
