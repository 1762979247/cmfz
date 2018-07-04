package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/4.
 * @author zhy
 * @version 1.0
 */
public class Admin implements Serializable {
    private String id;
    private String username;
    private String password;
    private String salt;
    private String status;

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Admin(String id, String username, String password, String salt, String status) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.status = status;
    }
}
