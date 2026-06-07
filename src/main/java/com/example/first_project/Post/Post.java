package com.example.first_project.Post;


import com.example.first_project.SignUp.SignUp;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String content;

    @ManyToOne
    private SignUp writer;

    private LocalDateTime createDate;
}
