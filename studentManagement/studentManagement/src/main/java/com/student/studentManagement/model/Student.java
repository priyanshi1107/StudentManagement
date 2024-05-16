package com.student.studentManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sId;
    private String sName;
    private String address;

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonIgnoreProperties("students")
    private School school;
}
