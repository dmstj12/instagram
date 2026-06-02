package com.example.first_project.Find;

import com.example.first_project.SignUp.SignUp;
import com.example.first_project.SignUp.SignUpRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FindIdController {

    private final SignUpRepository signUpRepository;

    public FindIdController(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }

    @GetMapping("/find_id")
    public String findId() {
        return "Find_ID";
    }

    @PostMapping("/find_id")
    public String FindId(@RequestParam String phoneNumber, Model model) {
        SignUp member = signUpRepository.findByPhoneNumber(phoneNumber);

        if (member.getPhoneNumber().equals(phoneNumber)) {
            model.addAttribute("userId", member.getNickName());
        }
        return "Find_ID";
    }
}
