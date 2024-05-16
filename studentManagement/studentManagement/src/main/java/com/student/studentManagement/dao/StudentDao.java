package com.student.studentManagement.dao;

import com.student.studentManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {
    List<Student> findBySchool_SchoolId(Integer schoolId);
}
