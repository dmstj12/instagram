package com.example.first_project.Post;

import com.example.first_project.SignUp.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findById(long id);
    Post findByWriter(SignUp writer);
}
