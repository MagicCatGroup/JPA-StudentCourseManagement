package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Open_Course;

public interface Open_CourseRepository extends CrudRepository<Open_Course, Long> {
    Open_Course findByOCid(Integer oCid);
    List<Open_Course> findByOPTid(Integer oPTid);
    List<Open_Course> findAll();
}
