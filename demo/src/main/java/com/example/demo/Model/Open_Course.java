package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Open_Course")
public class Open_Course {
    @Id
    private Integer id;
    private Integer OCid;
    private Integer OPTid;
    private String OPTime;
    public Open_Course(){}
}
