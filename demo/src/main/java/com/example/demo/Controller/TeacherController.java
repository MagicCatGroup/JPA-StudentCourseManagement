package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.Open_Course;
import com.example.demo.Model.Student;
import com.example.demo.Model.Teacher;
import com.example.demo.Model.Choose_Course;
import com.example.demo.Model.Course;
import com.example.demo.Repository.Choose_CourseRepository;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.Open_CourseRepository;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.TeacherRepository;

@Controller
@RequestMapping("/Teacher")
public class TeacherController {
    @Autowired
    Open_CourseRepository OCRe;
    @Autowired
    TeacherRepository TRe;
    @Autowired
    Choose_CourseRepository CCRe;
    @Autowired
    StudentRepository SRe;
    @Autowired
    CourseRepository CRe;

    @GetMapping("/{id}")
    public String TeacherPage(@PathVariable Integer id, Model model) {
        Map<Course, List<Student>> userMap = new HashMap<Course, List<Student>>();
        List<Open_Course> Open_Cs = OCRe.findByOPTid(id);
        for (Open_Course OC : Open_Cs) {
            List<Student> temp_S = new ArrayList<>();
            List<Choose_Course> temp_CC = CCRe.findBycid(OC.getOCid());
            for(Choose_Course CC: temp_CC){
                temp_S.add(SRe.findByid(CC.getSid()));
            }
            userMap.put(CRe.findByid(OC.getOCid()).get(0), temp_S);
        }
        Teacher T = TRe.findById(id).get(0);
        model.addAttribute("userMap", userMap);
        model.addAttribute("Teacher", T);
        return "Teacher";
    }
}
