package com.example.student.controller;

import com.example.student.dto.StudentDto;
import com.example.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.createStudent(studentDto) , HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer id){
        StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> studentDtos = studentService.getAllStudents();
        return ResponseEntity.ok(studentDtos);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<StudentDto> updateStudentCourse(@PathVariable Integer id,@RequestBody Map<String, String> request){
        String course = request.get("course");
        StudentDto studentDto = studentService.updateStudentCourse(id, course);
        return ResponseEntity.ok(studentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Integer id,@RequestBody StudentDto studentDto){
        StudentDto studentDtos = studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok(studentDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("student deleted", HttpStatus.OK);
    }

}
