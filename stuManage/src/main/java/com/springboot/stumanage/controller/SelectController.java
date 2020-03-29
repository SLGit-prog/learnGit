package com.springboot.stumanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SelectController {

//    @Autowired
//    private UserRepository userRepository;

    @RequestMapping("/root/select")
    public String selectFunction(@RequestParam("selectFunction") String selectFunction){
        String function = selectFunction;
        if ("加".equals(function)) {
            return "addUser";
        }else if ("删".equals(function)) {
            return "deleteUser";
        }else if ("改".equals(function)) {
            return "modifyUser";
        }else if ("查名".equals(function)) {
            return "checkyUser";
        }else if ("查ID".equals(function)) {
            return "checkyidUser";
        }
        return "false";
    }

}
