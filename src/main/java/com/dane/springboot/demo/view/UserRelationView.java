package com.dane.springboot.demo.view;

import com.dane.springboot.demo.mapper.UserMapper;
import com.dane.springboot.demo.mapper.UserRelationMapper;
import com.dane.springboot.demo.pojo.User;
import com.dane.springboot.demo.pojo.UserRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class UserRelationView {

    @Autowired
    private UserRelationMapper relationMapper;
    @Autowired
    private UserMapper userMapper;

    //展示好友列表
    @RequestMapping("/relations")
    public String list(Model model) {
        Collection<UserRelation> relations = relationMapper.queryRelationList();
        model.addAttribute("relations", relations);
        return "/relation/list";
    }

    //跳转到添加好友页面
    @GetMapping("/relation")
    public String toAddPage(Model model) {
        //查出所有用户信息
        List<User> users = userMapper.queryUserList();
        model.addAttribute("users", users);
        return "relation/add";
    }

    //添加好友
    @PostMapping("/relation")
    public String addRelation(UserRelation relation) {
        //添加操作
        System.out.println("insert===>" + relation);
        relation.setUserId(relation.getUser().getId());
        relation.setFriendId(relation.getFriend().getId());
        relationMapper.addRelation(relation);//调用底层业务保存动态信息
        return "redirect:/relations";
    }


    //删除评论
    @GetMapping("/delrelation/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        relationMapper.deleteRelation(id);
        return "redirect:/relations";
    }


}
