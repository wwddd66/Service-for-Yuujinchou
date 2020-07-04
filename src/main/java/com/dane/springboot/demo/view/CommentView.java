package com.dane.springboot.demo.view;

import com.dane.springboot.demo.mapper.CommentMapper;
import com.dane.springboot.demo.mapper.PostMapper;
import com.dane.springboot.demo.mapper.UserMapper;
import com.dane.springboot.demo.pojo.Comment;
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
public class CommentView {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;

    //展示评论列表
    @RequestMapping("/comments")
    public String list(Model model) {
        Collection<Comment> commentCollection = commentMapper.queryCommentList();
        model.addAttribute("comments", commentCollection);
        return "/comment/list";
    }

    //跳转到添加评论页面
    @GetMapping("/comment")
    public String toAddPage(Model model) {
        //查出所有用户信息
        List<User> users = userMapper.queryUserList();
        model.addAttribute("users", users);
        //查询所有动态信息
        List<Post> posts = postMapper.queryPostList();
        model.addAttribute("posts", posts);
        return "comment/add";
    }

    //增加评论
    @PostMapping("/comment")
    public String addComment(Comment comment) {
        //添加操作
        System.out.println("insert===>" + comment);
        comment.setUserId(comment.getUser().getId());
        comment.setPostId(comment.getPost().getId());
        commentMapper.addComment(comment);//调用底层业务保存动态信息
        return "redirect:/comments";
    }

    //跳转到修改评论界面
    @GetMapping("/comment/{id}")
    public String toUpdateUser(@PathVariable("id") int id, Model model) {
        Comment comment = commentMapper.queryCommentById(id);
        model.addAttribute("comment", comment);
        return "comment/update";
    }

    //修改评论
    @PostMapping("/updateCommentInfo")
    public String updateUser(Comment comment) {
        commentMapper.updateComment(comment);
        return "redirect:/comments";
    }

    //删除评论
    @GetMapping("/delcomment/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        commentMapper.deleteComment(id);
        return "redirect:/comments";
    }

}
