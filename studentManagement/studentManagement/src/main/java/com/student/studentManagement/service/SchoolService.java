package com.student.studentManagement.service;

import com.student.studentManagement.dao.SchoolDao;
import com.student.studentManagement.model.School;
import com.student.studentManagement.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    SchoolDao schoolDao;
    public ResponseEntity<School> createSchool(School school) {
        return new ResponseEntity<>(schoolDao.save(school), HttpStatus.CREATED);
    }

    public ResponseEntity<Integer> deleteSchoolIdBySchoolId(Integer schoolId) {
        schoolDao.deleteById(schoolId);
        return ResponseEntity.ok(schoolId);
    }

    public ResponseEntity<School> updateSchoolId(Integer schoolId, School updatedSchoolId) {
        Optional<School> school = schoolDao.findById(schoolId);
        if (school.isPresent()){
            School existingSchool = school.get();

            existingSchool.setSchoolId(updatedSchoolId.getSchoolId());

            School UpdatedId = schoolDao.save(updatedSchoolId);
            return new ResponseEntity<>(UpdatedId,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
