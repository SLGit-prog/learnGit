package com.springboot.stumanage.controller;


import com.springboot.stumanage.entity.User;
import com.springboot.stumanage.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RootController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/root/addUser")
    public String deleteUser(User user){
        String username = user.getUsername();
        List<User> userList = userRepository.findByusername(username);
        if (userList.size() == 0) {
            userRepository.save(user);
            return "yes";
        }
        return "all ready exist";
    }
}
