package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Choose_Course;

@Repository
public interface Choose_CourseRepository extends CrudRepository<Choose_Course, Integer> {
    List<Choose_Course> findBysid(Integer sid);
    List<Choose_Course> findBycid(Integer cid);
    Choose_Course save(Choose_Course C);
}
