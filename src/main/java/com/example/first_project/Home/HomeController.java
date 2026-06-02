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
        Object user = session.getAttribute("user"); // 만약에 user라는 user라는 이름표에 저장

        if (user == null) {
            return "redirect:/login"; // 권한이 존재하지 않는다면 다시 로그인 페이지로 넘겨버림
        }

        SignUp member = (SignUp) user; // Sign 타입인 member 변수에 Object 타입인 user를 Sign 타입으로 바꿔서 저장 타입을 왜 바꿔서 저장하는 지 모르겠음 그냥 왜 저장하는 지 자체를 모르겠음
        model.addAttribute("userName", member.getNickName()); // html에 사용자 id 띄워주기

        return "Home";
    }
}
