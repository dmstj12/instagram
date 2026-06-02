package com.example.first_project.SignUp;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@Entity // 이건 데이터베이스 클래스라는 것을 알려줌 맞나..?

@Table(name = "Users") // db에 저장 될 테이블 이름을 Users로 지정
public class SignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id값 1씩 자동 증가
    private Long id; // id 넣을 수 있는 크기 Long

    @NotBlank(message = "이름을 입력해주세요.") // 공백 금지
    @Pattern(regexp = "^[가-힣]{2,5}$", message = "다시 입력해주세요.") // 입력 조건
    private String realName; // 변수 선언

    @NotBlank(message = "아이디를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{4,12}$", message = "아이디 양식이 잘못되었습니다.")
    private String nickName;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+])[A-Za-z0-9!@#$%^&*()_+]{8,}$", message = "비밀번호 양식이 잘못되었습니다.")
    private String password;

    @NotBlank(message = "전화번호를 입력해주세요.")
    @Pattern(regexp = "^[0-9]{11}$", message = "전화번호 양식이 잘못되었습니다.")
    private String phoneNumber;
}
