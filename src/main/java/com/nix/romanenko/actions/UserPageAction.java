package com.nix.romanenko.actions;

import java.util.List;

import javax.inject.Inject;

import com.nix.romanenko.dao.UserDao;
import com.nix.romanenko.entity.User;
import com.opensymphony.xwork2.Action;

public class UserPageAction {
    
    private List<User> userList;
    
    @Inject 
    UserDao userDao;
    
    public String execute() {
        setUserList(userDao.findAll());
        return Action.SUCCESS;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
