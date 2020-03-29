package com.springboot.stumanage.controller;

import com.springboot.stumanage.entity.User;
import com.springboot.stumanage.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CheckyidController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/root/checkyidUser")
    public String deleteUser(User user){
        List<User> userList = userRepository.findByid(user.getId());
        if (userList.size() != 0) {
            User user1 = userList.get(0);
            String ret = "用户名: " + user1.getUsername() +
                    "。用户密码: " + user1.getPassword() +
                    "。用户身份: " + user1.getTab() +
                    "。ID：" + user1.getId();
            return ret;
        }
        return "does not exist";
    }

}
