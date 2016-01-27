package com.nix.romanenko.actions;

import javax.inject.Inject;

import com.nix.romanenko.dao.UserDao;
import com.nix.romanenko.entity.User;
import com.opensymphony.xwork2.Action;

public class ServiceAction {
    @Inject
    UserDao userDao;
    
    private String id;
    private String login;
    private String password;
    private String rePassword;
    private String email;
    private String firstname;
    private String lastname;
    private String birthday;
    private String role;
    private String type;
    
    public String execute() {
        if (login == null) {
            setType("add");
            return Action.SUCCESS;
        } 
        User user = userDao.findByLogin(login);
        setId(user.getId().toString());
        setLogin(user.getLogin());
        setPassword(user.getPassword());
        setRePassword(user.getPassword());
        setEmail(user.getEmail());
        setFirstname(user.getFirstname());
        setLastname(user.getLastname());
        setBirthday(user.getBirthday().toString());
        setType("edit");
        setRole(user.getRole().getName());
        
        return Action.SUCCESS;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
