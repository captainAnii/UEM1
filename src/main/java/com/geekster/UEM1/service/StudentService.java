package com.geekster.UEM1.service;

import com.geekster.UEM1.model.Department;
import com.geekster.UEM1.model.Student;
import com.geekster.UEM1.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void updateStudentDepartment(Integer id, Department department) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setDepartment(department);
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }
}
