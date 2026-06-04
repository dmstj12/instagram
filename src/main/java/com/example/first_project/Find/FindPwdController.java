package com.example.first_project.Find;

import com.example.first_project.SignUp.SignUp;
import com.example.first_project.SignUp.SignUpRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FindPwdController {

    private final SignUpRepository signUpRepository;

    public FindPwdController(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }

    @GetMapping("/find_password")
    public String findPwd() {
        return "Find_Pwd";
    }

    @PostMapping("/find_password")
    public String findPwd(@RequestParam int id, @RequestParam String phoneNumber, Model model) {
        SignUp member = signUpRepository.findByPhoneNumber(phoneNumber);

        if (member.getPhoneNumber().equals(phoneNumber) && member.getId() == id) {
            model.addAttribute("FindByPwd", member.getPassword());
        }

        return "Find_Pwd";
    }
}
