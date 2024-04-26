package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
public class accounts {
    @Id
    private Integer id;
    private String account;
    private String password;
    private int is_student;
    public accounts(){}
}
