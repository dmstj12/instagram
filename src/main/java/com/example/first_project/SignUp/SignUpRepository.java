package com.example.first_project.SignUp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepository extends JpaRepository<SignUp, Long> {

    SignUp findByNickName(String nickName);
    SignUp findByPhoneNumber(String phoneNumber);
}




