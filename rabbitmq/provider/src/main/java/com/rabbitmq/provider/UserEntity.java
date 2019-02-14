package com.rabbitmq.provider;

import java.io.Serializable;
import java.math.BigDecimal;

//@Data
//@Table(name = "user_info")
//@Entity
public class UserEntity implements Serializable
{
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 用户编号
     */
//    @Id
//    @GeneratedValue
//    @Column(name = "UI_ID")
    private Long id;
    /**
     * 用户名称
     */
//    @Column(name = "UI_USER_NAME")
    private String userName;
    /**
     * 姓名
     */
//    @Column(name = "UI_NAME")
    private String name;
    /**
     * 年龄
     */
//    @Column(name = "UI_AGE")
    private int age;
    /**
     * 余额
     */
//    @Column(name = "UI_BALANCE")
    private BigDecimal balance;
}
