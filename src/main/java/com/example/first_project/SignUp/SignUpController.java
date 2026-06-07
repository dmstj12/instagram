package com.example.first_project.SignUp;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService; // 서비스 가져옴 final 왜 씀?
    private final SignUpRepository signUpRepository; // 저장소 가져옴 final 왜 씀?


    @GetMapping("/signup")
    public String signup() {
        return "SignUp/SignUp";
    }

    @PostMapping("/signup")
    public String signup(@Valid SignUp User, BindingResult result) { // User로 변수 선언 안에 변수들을 검사 결과는 result
        SignUp nickName_existing = signUpRepository.findByNickName(User.getNickName()); // SignUp 타입 변수에 저장소에 있는 User의 이름을 저장
        SignUp phoneNumber_existing =  signUpRepository.findByPhoneNumber(User.getPhoneNumber()); // SignUp 타입 변수에 저장소에 있는 전화번호를 저장
        // 어차피 안에 있는 값 다 가져오면 이거 굳이 다 선언할 필요 X 맞나..?

        if (result.hasErrors()) {
            return "redirect:/signup"; // 결과가 에러라면 /signup으로 돌아감
        }

        if (nickName_existing != null) {
            return "redirect:/signup?error=existing_id"; // 만약에 db에 이미 닉네임 존재한다면 에러
        }

        if (phoneNumber_existing != null) {
            return "redirect:/signup?error=existing_phoneNumber"; // 만약에 db안에 이미 같은 전화번호가 존재한다면 에러
        }

        signUpService.join(User); // 앞에 조건 다 통과시에 저장
        return "redirect:/login"; // 저장 후 /login페이지로 넘어감
    }


}
