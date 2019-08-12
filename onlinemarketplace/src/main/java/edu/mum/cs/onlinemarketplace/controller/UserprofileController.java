package edu.mum.cs.onlinemarketplace.controller;

import edu.mum.cs.onlinemarketplace.domain.Address;
import edu.mum.cs.onlinemarketplace.domain.User;
import edu.mum.cs.onlinemarketplace.repository.UserRepository;
import edu.mum.cs.onlinemarketplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserprofileController {

    @Autowired
    UserService userService;

    @GetMapping("/profile/{id}")
    public String getUserProfile(@PathVariable("id") Long id, Model model){


//        model.addAttribute("user", userService.getUserById(id));
        return "profile";
    }

    @GetMapping("/profile/{id}/edit")
    public String getEditProfile(@ModelAttribute @PathVariable User user, Long id, Model model){
        return "editProfile";
    }







}
