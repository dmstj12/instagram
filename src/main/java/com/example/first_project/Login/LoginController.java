package com.example.first_project.Login;

import com.example.first_project.SignUp.SignUp;
import com.example.first_project.SignUp.SignUpRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final SignUpRepository signUpRepository;

    public LoginController(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String nickName, @RequestParam String password, HttpSession session) {
        SignUp member = signUpRepository.findByNickName(nickName);

        if (nickName.isBlank() || password.isBlank()) {
            return "redirect:/login?error=null";
        } else if (member == null) {
            return "redirect:/login?error=notfound";
        } else if (member.getPassword().equals(password)){
            session.setAttribute("user", member);
            return "redirect:/home";
        } else {
            return "redirect:/login?error=notsame";
        }
    }
}