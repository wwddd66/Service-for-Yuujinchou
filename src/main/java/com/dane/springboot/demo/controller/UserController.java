package com.dane.springboot.demo.controller;


import com.dane.springboot.demo.mapper.UserMapper;
import com.dane.springboot.demo.pojo.User;
import com.dane.springboot.demo.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //查询所有用户
    //实现！！！
    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();
        /*for (User user : userList) {
            System.out.println(user);
        }*/
        return userList;
    }

    //通过用户名查找用户
    @RequestMapping("/queryUserByUsername")
    List<User> queryUserByUsername(String username) {
        List<User> users = userMapper.queryUserByUsername("%" + username + "%");
        System.out.println(users);
        return users;
    }

    //添加一个用户
    //实现！！！
    @PostMapping("/insertUser")
    void addUser(String username, String password, String email, String nickname, String image) {
        image = Base64Util.image;
        User newUser = new User(username, password, email, nickname, image);
        userMapper.addUser(newUser);
    }

    //更新用户信息
    @PostMapping("/updateUser")
    void updateUser(int id, String username, String password, String email, String nickname, String image) {
        User user = userMapper.queryUserByUsername(username).get(0);
        System.out.println("用户名：" + username + "\t" + "密码：" + password + "\t" + "昵称：" + nickname);
        //不可更改的信息
        user.setId(user.getId());
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        //可以更改的信息
        if (password.equals("")) {
            user.setPassword(user.getPassword());
        } else {
            user.setPassword(password);
        }
        if (nickname.equals("")) {
            user.setNickname(user.getNickname());
        } else {
            user.setNickname(nickname);
        }
        if (image.equals("")) {
            user.setImage(user.getImage());
        } else {
            user.setImage(image);
        }
        userMapper.updateUser(user);
    }

}
