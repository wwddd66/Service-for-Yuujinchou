package com.dane.springboot.demo.view;

import com.dane.springboot.demo.mapper.PostMapper;
import com.dane.springboot.demo.mapper.UserMapper;
import com.dane.springboot.demo.pojo.Post;
import com.dane.springboot.demo.pojo.User;
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
public class PostView {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;

    //展实动态列表
    @RequestMapping("/posts")
    public String list(Model model) {
        Collection<Post> postCollection = postMapper.queryPostList();
        model.addAttribute("posts", postCollection);
        //System.out.println(allUser);
        return "/post/list";
    }

    //跳转到增加动态页面
    @GetMapping("/post")
    public String toAddPage(Model model) {
        //查出所有用户信息
        List<User> users = userMapper.queryUserList();
        model.addAttribute("users", users);
        return "post/add";
    }

    //增加动态
    @PostMapping("/post")
    public String addPost(Post post) {
        //添加操作
        System.out.println("insert===>" + post);
        post.setUserId(post.getUser().getId());
        postMapper.addPost(post);//调用底层业务保存动态信息
        return "redirect:/posts";
    }

    //跳转到修改动态界面
    @GetMapping("/post/{id}")
    public String toUpdateUser(@PathVariable("id") int id, Model model) {
        Post post = postMapper.queryPostListById(id);
        model.addAttribute("post", post);
        return "post/update";
    }

    //修改用户
    @PostMapping("/updatePostInfo")
    public String updateUser(Post post) {
        /*post.setUserId(post.getUser().getId());
        post.setDate(post.getDate());*/
        System.out.println(post);
        postMapper.updatePost(post);
        return "redirect:/posts";
    }

    //删除用户
    @GetMapping("/delpost/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        postMapper.deletePost(id);
        return "redirect:/posts";
    }

}

