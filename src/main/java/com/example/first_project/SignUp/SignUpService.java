package com.example.first_project.SignUp;

import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    private SignUpRepository signUpRepository;

    public SignUpService(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }

    public void join(SignUp member) {
            signUpRepository.save(member);
    }
}
