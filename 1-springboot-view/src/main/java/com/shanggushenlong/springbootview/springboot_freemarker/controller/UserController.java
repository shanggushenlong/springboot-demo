package com.shanggushenlong.springbootview.springboot_freemarker.controller;

import com.shanggushenlong.springbootview.springboot_freemarker.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * springboot整合freemarker
 */
@Controller
public class UserController {

    @GetMapping("/user")
    public String user(Model model){
        List<User> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++){
            User user = new User();
            user.setId(i);
            user.setUsername("shangushenlong>>"+i);
            user.setAge(i);
            list.add(user);
        }
        model.addAttribute("users",list);
        return "userInfo";
    }
}
