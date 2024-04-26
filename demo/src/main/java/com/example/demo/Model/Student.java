package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
public class Student {
    @Id
    private Integer id; // id
    @Column(name = "snum")
    private Long snum; // 学号
    @Column(name = "sname")
    private String sname; // 姓名
    @Column(name = "ssex")
    private String ssex;
    @Column(name = "sage")
    private int sage;
    @Column(name = "sclass")
    private String sclass;
    public Student(){}
}
