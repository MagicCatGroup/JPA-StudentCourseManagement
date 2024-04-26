package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Course")
public class Course {
    @Id
    private Integer id;
    private String Cname;
    private String Cterm;
    public Course(){}
}
