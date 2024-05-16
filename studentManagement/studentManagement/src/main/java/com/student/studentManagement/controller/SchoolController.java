package com.student.studentManagement.controller;

import com.student.studentManagement.model.School;
import com.student.studentManagement.model.Student;
import com.student.studentManagement.service.SchoolService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @PostMapping("createSchool")
    public ResponseEntity<School> createSchool(@RequestBody School school){
        return schoolService.createSchool(school);
    }

    @DeleteMapping("deleteSchoolIdBySchoolId/{schoolId}")
    public ResponseEntity<Integer> deleteSchoolIdBySchoolId(@PathVariable Integer schoolId) {
        return schoolService.deleteSchoolIdBySchoolId(schoolId);
    }

    @PutMapping("updateSchoolId/{schoolId}")
    public ResponseEntity<School> updateSchoolId(@PathVariable Integer schoolId, @RequestBody School updatedSchoolId){
        return schoolService.updateSchoolId(schoolId,updatedSchoolId);
    }
}
