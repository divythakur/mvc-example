package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.model.Post;
import technicalblog.service.postservice;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {
    @Autowired
    private postservice postservice;

    @RequestMapping("/")

    public String getAllPosts(Model model){
        ArrayList<Post> posts = postservice.getAllPosts();
        model.addAttribute("posts",posts);
        return "index";

    }
}
