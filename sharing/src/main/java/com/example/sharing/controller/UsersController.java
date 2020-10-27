package com.example.sharing.controller;

import com.example.sharing.entity.Resp;
import com.example.sharing.entity.Users;
import com.example.sharing.servise.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    private IUsersService iUsersService;

    /*日期：2020.10.22
    *创建人：张思远*/
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    private Users users(@RequestParam String username,@RequestParam String password){
        return iUsersService.users(username, password);
    }
    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    private Users signin(@RequestParam String username,@RequestParam String password){
        return iUsersService.signin(username, password);
    }
    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    private int signup(@RequestParam String username,
                       @RequestParam String password,
                       @RequestParam String userImg,
                       @RequestParam String phone,
                       @RequestParam String QQNum,
                       @RequestParam String WeChatNum,                /* 顺序和mapper中一样 大小写也一样*/
                       @RequestParam byte sex){
        Users user=new Users();
        user.setUserNa(username);
        user.setPassword(password);
        user.setPhone(phone);
        user.setUserImg(userImg);
        user.setQQNum(QQNum);
        user.setWeChatNum(WeChatNum);
        user.setSex(sex);
        user.setAttentionNum(0);
        user.setFansNum(0);
        iUsersService.signup(user);
        return 1;
    }
    @RequestMapping(value = "/signinStatus",method = RequestMethod.POST)
    private Users signinStatus(@RequestParam String phone){
        return iUsersService.signinStatus(phone);
    }
    @RequestMapping(value = "/changePwd",method = RequestMethod.POST)
    private void changePwd(@RequestParam String username,@RequestParam String password){
        iUsersService.changePwd(username,password);
    }


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    private Resp<String> upload(@RequestParam("file")MultipartFile file){
        return iUsersService.upload(file);
    }



}
