package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.accounts;
import com.example.demo.Repository.accountsRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private accountsRepository accountsRepository;

    @GetMapping
    public String LoginPage() {
        return "login";
    }

    @PostMapping
    public String LoginSucc(HttpServletRequest request){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        accounts user = accountsRepository.findByAccount(name);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                String id = user.getId().toString();
                if (user.getIs_student() == 1) {
                    return "redirect:/Student/"+id;
                }else{
                    return "redirect:/Teacher/"+id;
                }
            }else{
                return "redirect:/Login";
            }
        }
        return null;
    }

}
