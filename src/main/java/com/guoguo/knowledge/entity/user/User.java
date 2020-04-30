package com.guoguo.knowledge.entity.user;

import lombok.Data;

import java.util.Date;

/**
 * 用户
 */
@Data
public class User {
    private Long id;
    /**
     * 账号
     */
    private String account;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 添加时间
     */
    private Date addTime;
    /**
     * 是否删除 0正常 1删除
     */
    private Integer delete;
    /**
     * 页码
     */
    private Integer page;
    /**
     * 数据条数
     */
    private Integer limit;
}
