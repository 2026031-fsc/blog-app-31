package com.example.blog_app;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    private final BlogRepository blogRepository;

    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @GetMapping("/all")
    public String blogs(Model model) {
        model.addAttribute("blogs", blogRepository.findAll());
        return "All";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/new")
    public String newBlog() {
        return "new";
    }

    @GetMapping("/blogs/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<Blog> blogOpt = blogRepository.findById(id);
        if (blogOpt.isEmpty()) {
            return "redirect:/blogss";
        }
        model.addAttribute("blog", blogOpt.get());
        return "detail";
    }

    @PostMapping("/blogs")
    public String create(@ModelAttribute BlogForm form) {
        blogRepository.save(form);
        return "redirect:/all";
    }

}
