package com.geekster.UEM1.controller;

import com.geekster.UEM1.model.Department;
import com.geekster.UEM1.model.Student;
import com.geekster.UEM1.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/addStudent")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        Student savedStudent = studentService.addStudent(student);
        return ResponseEntity.ok(savedStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudentDepartment(@PathVariable Integer id, @RequestParam Department department) {
        studentService.updateStudentDepartment(id, department);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(student);
        }
    }
}