package com.dane.springboot.demo.mapper;

import com.dane.springboot.demo.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    List<Comment> queryCommentList();//查询全部评论

    List<Comment> queryCommentListByPost(Comment comment);

    Comment queryCommentById(int id);

    void addComment(Comment comment);

    void updateComment(Comment comment);

    void deleteComment(int id);


}
