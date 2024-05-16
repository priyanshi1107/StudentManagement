package com.student.studentManagement.service;

import com.student.studentManagement.dao.StudentDao;
import com.student.studentManagement.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    public ResponseEntity<Student> addStudent(Student student) {
        return new ResponseEntity<>(studentDao.save(student), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Student>> getAllStudentsBySchoolId(Integer schoolId) {
        return new ResponseEntity<>(studentDao.findBySchool_SchoolId(schoolId), HttpStatus.OK);
    }

    public ResponseEntity<Student> getStudentById(Integer sId) {
        Optional<Student> studentOptional = studentDao.findById(sId);
        if (studentOptional.isPresent()) {
            return new ResponseEntity<>(studentOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Integer> deleteById(Integer sId) {
        studentDao.deleteById(sId);
        return ResponseEntity.ok(sId);
    }

    public ResponseEntity<Student> updateStudentById(Integer sId, Student updatedStudent) {

        Optional<Student> student1 = studentDao.findById(sId);
        if (student1.isPresent()) {
            Student existingStudent = student1.get();

            existingStudent.setSName(updatedStudent.getSName());
            existingStudent.setAddress(updatedStudent.getAddress());
            existingStudent.setSchool(updatedStudent.getSchool());

            Student updatedEntity = studentDao.save(existingStudent);

            return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<Student> updateStudentName(Integer sId, Student updateStudentName) {

        Optional<Student> student2 = studentDao.findById(sId);
        if (student2.isPresent()){
            Student existingStudent = student2.get();

            existingStudent.setSName(updateStudentName.getSName());

            Student update = studentDao.save(existingStudent);
            return new ResponseEntity<>(update,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
