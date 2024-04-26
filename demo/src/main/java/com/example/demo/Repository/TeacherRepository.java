package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Teacher;
import java.util.List;


public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    List<Teacher> findById(Integer id);
}
