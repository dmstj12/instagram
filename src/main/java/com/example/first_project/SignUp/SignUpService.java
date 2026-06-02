package com.example.first_project.SignUp;

import org.springframework.stereotype.Service;

@Service // 서비스 어노테이션
public class SignUpService {

    private SignUpRepository signUpRepository; // SignUpRepository 가져옴

    public SignUpService(SignUpRepository signUpRepository) { // 생성자에게 SignUpRepository 쥐어줌 쥐어주는데 변수선언을 따로 하고 생성자 안에 넣는 이유를 모르겠음
        this.signUpRepository = signUpRepository;
    }

    public void join(SignUp member) { // 저장 함수 Sign 타입의 변수를 SignUpRepository에 저장
            signUpRepository.save(member);
    }
}
