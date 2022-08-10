package com.zan.controller;

import com.zan.common.R;
import com.zan.model.User;
import com.zan.model.dto.LoginDto;
import com.zan.service.LoginService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    LoginService loginService;

    /**
     * 登录模块
     * @param loginDto
     * @return
     */
    @RequestMapping("login1")
    public R<User> login(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }

    /**
     * 注册模块
     * @param loginDto
     * @return
     */
    @RequestMapping("register")
    public R<User> register(@RequestBody LoginDto loginDto){
        return loginService.register(loginDto);
    }

}
