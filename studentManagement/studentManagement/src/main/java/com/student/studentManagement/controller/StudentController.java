package com.student.studentManagement.controller;

import com.student.studentManagement.model.Student;
import com.student.studentManagement.service.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("addStudents")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);

    }

    @GetMapping("getAllStudentsBySchoolId/{schoolId}")
    public  ResponseEntity<List<Student>> getAllStudentsBySchoolId(@PathVariable Integer schoolId){
        return studentService.getAllStudentsBySchoolId(schoolId);
    }

    @GetMapping("getStudenById/{sId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer sId){
        return studentService.getStudentById(sId);
    }

    @DeleteMapping("deleteById/{sId}")
    public ResponseEntity<Integer> deleteById(@PathVariable Integer sId){
        return studentService.deleteById(sId);
    }

    @PutMapping("updateStudentById/{sId}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Integer sId,@RequestBody Student updatedStudent){
        return studentService.updateStudentById(sId,updatedStudent);
    }

    @PutMapping("updateStudentName/{sId}")
    public ResponseEntity<Student> updateStudentName(@PathVariable Integer sId, @RequestBody Student updateStudentName){
        return studentService.updateStudentName(sId,updateStudentName);
    }


}
