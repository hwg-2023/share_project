package com.zan.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zan.common.R;
import com.zan.model.User;
import com.zan.model.dto.LoginDto;
import com.zan.service.LoginService;
import com.zan.mapper.LoginMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
@Slf4j
public class LoginServiceImpl extends ServiceImpl<LoginMapper, User>
    implements LoginService {
    private static final String salt = "zan";


    @Override
    public R<User> login(LoginDto loginDto) {
        //业务层，一般在该层实现业务逻辑
        //返回的代码需要进行隐密（将一些涉及隐私的信息不进行返回）
        String bytes = DigestUtils.md5DigestAsHex((salt + loginDto.getUserPassword()).getBytes());
        log.info("加密后的玩意为：{}" , bytes);
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(User::getUserAccount,loginDto.getUserAccount());
        User result = this.getOne(lambdaQueryWrapper);
        if (null == result){
            return R.error("用户名不存在");
        }
        if (!result.getUserPassword().equals(bytes)) {
            return R.error("密码错误，请重新输入");
        }
        User user = new User();
        user.setId(result.getId());
        user.setAvatarUrl(result.getAvatarUrl());
        user.setUserName(result.getUserName());
        user.setUserAccount(result.getUserAccount());
        user.setIsValid(result.getIsValid());
        return R.success(user);
    }

    @Override
    public R<User> register(LoginDto loginDto) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserAccount,loginDto.getUserAccount());
        int count = (int) this.count(lambdaQueryWrapper);
        if (count > 0){
            return R.error("用户名已存在，请登录");
        }
        User user = new User();
        user.setUserAccount(loginDto.getUserAccount());
        String bytes = DigestUtils.md5DigestAsHex((salt + loginDto.getUserPassword()).getBytes());
        user.setUserPassword(bytes);
        boolean result1 = this.save(user);
        if (result1){
            return R.success1("注册成功");
        }
        return R.error("未知错误");
    }
}




