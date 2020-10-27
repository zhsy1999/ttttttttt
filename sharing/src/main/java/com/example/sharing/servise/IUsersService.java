package com.example.sharing.servise;

import com.example.sharing.entity.Resp;
import com.example.sharing.entity.Users;
import org.springframework.web.multipart.MultipartFile;

public interface IUsersService {
    Users users(String username , String password);
    void signup(Users user);
    Users signin(String username , String password);
    void changePwd(String username , String password);
    Users signinStatus(String phone);

    Resp<String> upload(MultipartFile file);
}
