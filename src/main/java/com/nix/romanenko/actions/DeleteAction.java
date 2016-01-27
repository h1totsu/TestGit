package com.nix.romanenko.actions;

import javax.inject.Inject;

import com.nix.romanenko.dao.UserDao;
import com.opensymphony.xwork2.Action;

public class DeleteAction {
    @Inject
    UserDao userDao;
    
    private String login;
    
    public String execute() {
        userDao.remove(userDao.findByLogin(login));
        return Action.SUCCESS;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
