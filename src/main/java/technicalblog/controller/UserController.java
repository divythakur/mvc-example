package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.model.IModel;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.service.postservice;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserController {
    @Autowired
    private postservice postservice;
    @RequestMapping("users/login")
    public String login(){
        return "users/login";

    }
    @RequestMapping(value = "users/login", method=RequestMethod.POST)
    public String loginUser(User user) {
        return "redirect:/posts";
    }
    @RequestMapping(value = "users/logout", method=RequestMethod.POST)
    public String logout(Model model){
        ArrayList<Post> posts=postservice.getAllPosts();
        model.addAttribute("posts",posts);

        return "index";
    }


}
