package com.dane.springboot.demo.mapper;

import com.dane.springboot.demo.pojo.UserRelation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRelationMapper {
    //查询好友列表
    List<UserRelation> queryRelationList();

    //添加好友
    void addRelation(UserRelation relation);

    //删除好友
    void deleteRelation(int id);

}
