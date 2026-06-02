package com.example.first_project.SignUp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepository extends JpaRepository<SignUp, Long> { //

    SignUp findByNickName(String nickName); // 이름을 찾아오는 함수 근데 이건 생성자도 아니고 변수에() 이거 붙이는 거 모르겠음
    SignUp findByPhoneNumber(String phoneNumber); // 전화번호를 찾아오는 함
    SignUp findByPassword(String password);
}




