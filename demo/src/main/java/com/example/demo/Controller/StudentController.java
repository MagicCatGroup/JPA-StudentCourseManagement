package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Choose_Course;
import com.example.demo.Model.Course;
import com.example.demo.Model.Open_Course;
import com.example.demo.Model.Student;
import com.example.demo.Model.Teacher;
import com.example.demo.Repository.Choose_CourseRepository;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.Open_CourseRepository;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Repository.TeacherRepository;

@Controller
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    Choose_CourseRepository CCRe;
    @Autowired
    CourseRepository CRe;
    @Autowired
    StudentRepository S;
    @Autowired
    Open_CourseRepository OCRe;
    @Autowired
    TeacherRepository TRe;

    @GetMapping("/{id}")
    public String StudentPage(@PathVariable Integer id, Model model) {
        Map<Course, Teacher> userMap = new HashMap<Course, Teacher>();

        Student Student = S.findByid(id);
        List<Choose_Course> Cids = CCRe.findBysid(id);
        for (Choose_Course CC : Cids) {
            int temp = CC.getCid();
            List<Course> c = CRe.findByid(temp);
            userMap.put(c.get(0), TRe.findById(OCRe.findByOCid(temp).getOPTid()).get(0));
        }
        model.addAttribute("userMap", userMap);
        model.addAttribute("Student", Student);
        model.addAttribute("ID", id);
        return "Student";
    }

    @GetMapping("/{id}/StudentChoose")
    public String StudentChoosePage(@PathVariable Integer id, Model model) {
        Map<Course, Teacher> userMap = new HashMap<Course, Teacher>();

        List<Choose_Course> CCs = CCRe.findBysid(id);
        List<Integer> CCs_ids = new ArrayList<>();
        for (Choose_Course CC : CCs) {
            CCs_ids.add(CC.getCid());
        }

        List<Open_Course> AllCourses = OCRe.findAll();
        List<Integer> AllC_ids = new ArrayList<>();
        for (Open_Course AllCourse : AllCourses) {
            AllC_ids.add(AllCourse.getOCid());
        }
        List<Integer> canChoose = (List) AllC_ids.stream().filter(item -> !CCs_ids.contains(item))
                .collect(Collectors.toList());
        for (Integer temp_id : canChoose) {
            userMap.put(CRe.findByid(temp_id).get(0), TRe.findById(OCRe.findByOCid(temp_id).getOPTid()).get(0));
        }
        model.addAttribute("ID", id);
        model.addAttribute("userMap", userMap);
        return "StudentChoose";
    }

    @PostMapping("/{id}/update")
    public String update_ChooseCourse(@PathVariable Integer id, @RequestParam("Info") String Info) {
        Integer cid = Integer.valueOf(Info);
        CCRe.save(new Choose_Course(null, cid, id));
        return "redirect:/Student/" + id;
    }
}
