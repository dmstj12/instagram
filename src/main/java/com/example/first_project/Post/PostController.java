package com.example.first_project.Post;

import com.example.first_project.SignUp.SignUp;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @GetMapping("/post")
    public String post() {
        return "Post";
    }

    @PostMapping("/post")
    public String post(String content, HttpSession session) {
        SignUp member = (SignUp) session.getAttribute("user");
        if (member == null) {
            return "redirect:/login";
        }
        Post post = new Post();

        post.setContent(content);
        post.setWriter(member);
        post.setCreateDate(LocalDateTime.now());

        postService.save(post);

        return "Post";
    }
}
