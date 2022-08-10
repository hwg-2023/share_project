package com.zan.service;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zan.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class LoginServiceTest {
    @Resource
    LoginService loginService;
    @Test
    public void Test1(){
        User user1 = new User();
        user1.setUserAccount("13567490157");
        user1.setUserPassword("zhoupeizhong.com");
        boolean result = loginService.save(user1);
        if (result){
            System.out.println("插入成功");
        }
    }
}
@SpringBootTest
class FinallyTest {
    @Test
    public void test1(){
        Map a = new HashMap();
        a.put(1,"1");
        a.put(2,null);
        System.out.println(a.size());
    }
    @Test
    public void test2(){
        int value = 2;
        System.out.println(value);
        System.out.println(++value);
        System.out.println(value);
    }
}

