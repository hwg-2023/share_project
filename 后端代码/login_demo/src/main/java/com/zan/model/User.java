package com.zan.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
public class User implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 头像：就是一串url地址
     */
    private String avatarUrl;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 账户名
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 电话号码
     */
    private String mobilePhone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别：1代表男，0代表女
     */
    private Byte gender;

    /**
     * 是否禁用：0代表禁用，1代表可用
     */
    private Byte isValid;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除：逻辑上的删除（0代表删除，1代表未删除）
     */
    private Byte isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}