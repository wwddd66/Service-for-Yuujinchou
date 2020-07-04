package com.dane.springboot.demo.mapper;



import com.dane.springboot.demo.pojo.Post;
import com.dane.springboot.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostMapper {

    Post queryPostListById(int id);

    List<Post> queryPostListByUser(User user);

    List<Post> queryPostList();

    void addPost(Post post);

    void updatePost(Post post);

    void deletePost(int id);
}
