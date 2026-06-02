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
    public String login(@RequestParam String nickName, @RequestParam String password, HttpSession session) { // /login 페이지에서 입력값 아이디와 비밀번호를 받아옴
        SignUp member = signUpRepository.findByNickName(nickName); // db에서 아이디를 찾아옴

        if (nickName.isBlank() || password.isBlank()) { // 만약 받아온 값에 공백이 존재하면 에러
            return "redirect:/login?error=null";
        } else if (member == null) {
            return "redirect:/login?error=notfound"; // 만약 존재하지 않는다면 에러
        } else if (member.getPassword().equals(password)){
            session.setAttribute("user", member); // 로그인에 성공한다면 user라는 권한 넘겨주고 /home으로 이동
            return "redirect:/home";
        } else {
            return "redirect:/login?error=notsame"; // 다 아니면 에러
        }
    }
}