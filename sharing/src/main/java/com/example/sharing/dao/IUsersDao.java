package com.example.sharing.dao;

import com.example.sharing.entity.Users;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersDao {
    Users users(@Param("username") String username ,@Param("password") String password);
    void signup(Users user);
    Users signin(@Param("username") String username,@Param("password") String password);
    void changePwd(@Param("username") String username,@Param("password") String password);
    Users signinStatus(@Param("phone")String phone);



}
