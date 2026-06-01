package com.example.first_project.SignUp;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@Entity

@Table(name = "Users")
public class SignUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "이름을 입력해주세요.")
    @Pattern(regexp = "^[가-힣]{2,5}$", message = "다시 입력해주세요.")
    private String realName;

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
