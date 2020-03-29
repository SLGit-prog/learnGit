package com.springboot.stumanage.controller;

import com.springboot.stumanage.entity.User;
import com.springboot.stumanage.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeleteController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/root/deleteUser")
    public String deleteUser(User user) {
        String username = user.getUsername();
        List<User> userList = userRepository.findByusername(username);
        if (userList.size() != 0) {
            User user1 = userList.get(0);
            if (user1.getPassword().equals(user.getPassword())) {
                userRepository.deleteUserByUsername(user.getUsername());
                return "success";
            } else {
                return "password wrong";
            }
        }
        return "does not exist";
    }
}
