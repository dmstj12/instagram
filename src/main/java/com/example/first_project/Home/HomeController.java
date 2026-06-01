package com.example.first_project.Home;

import com.example.first_project.SignUp.SignUp;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpSession session, Model model){
        Object user = session.getAttribute("user");

        if (user == null) {
            return "redirect:/login";
        }

        SignUp member = (SignUp) user;
        model.addAttribute("userName", member.getNickName());

        return "Home";
    }
}
