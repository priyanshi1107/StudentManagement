package com.student.studentManagement.dao;

import com.student.studentManagement.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDao extends JpaRepository<School,Integer>{
}
