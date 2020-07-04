package com.dane.springboot.demo.mapper;

import com.dane.springboot.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper     //这个注解表示了这是一个mybatis的mapper类（Dao）
@Repository
public interface UserMapper {

    List<User> queryUserList();

    List<User> queryUserByUsername(String username);

    User queryUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

}
