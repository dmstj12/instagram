package com.example.first_project.SignUp;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    private final SignUpService signUpService;
    private final SignUpRepository signUpRepository;

    public SignUpController(SignUpService signUpService, SignUpRepository signUpRepository) {
        this.signUpService = signUpService;
        this.signUpRepository = signUpRepository;
    }

    @GetMapping("/signup")
    public String signup() {
        return "SignUp";
    }

    @PostMapping("/signup")
    public String signup(@Valid SignUp User, BindingResult result) {
        SignUp nickName_existing = signUpRepository.findByNickName(User.getNickName());
        SignUp phoneNumber_existing =  signUpRepository.findByPhoneNumber(User.getPhoneNumber());

        if (result.hasErrors()) {
            return "redirect:/signup";
        }

        if (nickName_existing != null) {
            return "redirect:/signup?error=existing_id";
        }

        if (phoneNumber_existing != null) {
            return "redirect:/signup?error=existing_phoneNumber";
        }

        signUpService.join(User);
        return "redirect:/login";
    }


}
