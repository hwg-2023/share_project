package com.zan.service;

import com.zan.common.R;
import com.zan.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zan.model.dto.LoginDto;

/**
 *
 */
public interface LoginService extends IService<User> {
    R<User> login(LoginDto loginDto);

    R<User> register(LoginDto loginDto);
}
