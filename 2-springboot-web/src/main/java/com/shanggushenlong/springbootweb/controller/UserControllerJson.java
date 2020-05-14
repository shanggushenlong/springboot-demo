package com.shanggushenlong.springbootweb.controller;

import com.shanggushenlong.springbootweb.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @USER: shanggushenlong
 * @DATE: 2020/5/14
 * @PROJECT_NAME: springboot-web
 **/
@Controller
public class UserControllerJson {

    /**
     * 测试responsebody
     * @return
     */
    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        for(int i=0; i < 10 ; i++){
            User user = new User();
            user.setId(String.valueOf(i));
            user.setUsername("shanggushenlong>>>"+i);
            user.setAge(i);
            user.setBirthday(new Date());
            users.add(user);
        }
        return users;
    }


    /**
     * 前端传入json数据，后端以String字符串接收
     * @param userStr
     * @return
     */
    @RequestMapping("/setUser")
    @ResponseBody
    public String getUser(@RequestBody String userStr){
        System.out.println(userStr);
        return userStr.toString();
    }

    /**
     * 前端传入json，后端用 user 对象接收，@RequestBody 能够自动将前端传入的json与bean
     * 自动序列化对应成功一个实例对象
     * @param user
     * @return
     */
    @RequestMapping("/setUser2")
    @ResponseBody
    public String getUser2(@RequestBody User user){
        System.out.println(user);
        return user.toString();
    }

    /**
     * 前端传入json，后端用 user 对象接收，@RequestBody 能够自动将前端传入的json与bean
     * 自动序列化对应成功一个实例对象
     * @param user
     * @return
     */
    @RequestMapping("/setUser3")
    @ResponseBody
    public User getUser3(@RequestBody User user){
        System.out.println(user);
        return user;
    }
}
