package com.dane.springboot.demo.view;

import com.dane.springboot.demo.mapper.UserMapper;
import com.dane.springboot.demo.pojo.User;
import com.dane.springboot.demo.util.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class UserView {

    @Autowired
    private UserMapper userMapper;

    //展实用户列表
    @RequestMapping("/users")
    public String list(Model model) {
        Collection<User> allUser = userMapper.queryUserList();
        model.addAttribute("users", allUser);
        //System.out.println(allUser);
        return "/user/list";
    }

    //跳转到增加用户页面
    @GetMapping("/user")
    public String toAddPage() {
        //查出所有部门信息
        return "user/add";
    }

    //增加用户
    @PostMapping("/user")
    public String addUser(User user) {
        System.out.println("save==>" + user);
        userMapper.addUser(user);
        return "redirect:/users";
    }

    //跳转到修改用户界面
    @GetMapping("/user/{id}")
    public String toUpdateUser(@PathVariable("id") int id, Model model) {
        User user = userMapper.queryUserById(id);
        model.addAttribute("user", user);
        return "user/update";
    }

    //修改用户
    @PostMapping("/updateUserInfo")
    public String updateUser(User user) {
        userMapper.updateUser(user);
        return "redirect:/users";
    }

    //删除用户
    @GetMapping("/deluser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userMapper.deleteUser(id);
        return "redirect:/users";
    }

}
