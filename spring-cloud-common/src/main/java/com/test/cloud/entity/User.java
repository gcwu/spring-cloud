package com.test.cloud.entity;

import java.io.Serializable;
import java.math.BigInteger;

public class User implements Serializable {

    private BigInteger userId;

    private String username;

    private  String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }
}
