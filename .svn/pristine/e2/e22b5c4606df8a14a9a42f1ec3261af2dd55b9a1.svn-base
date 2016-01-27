package com.nix.romanenko.actions;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import com.nix.romanenko.dao.RoleDao;
import com.nix.romanenko.dao.UserDao;
import com.nix.romanenko.entity.User;
import com.nix.romanenko.utils.ValidateUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AddEditAction extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    UserDao userDao;
    @Inject
    RoleDao roleDao;
    @Inject
    ValidateUtils validateUtils;
    
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
    private List<User> userList;
    
    public void validate() {
        if (!validateUtils.validateFieldsEmpty(login, password, rePassword, email,
                firstname, lastname, birthday)) {
            addFieldError("login", "Any fields is empty");
        }
        if (!validateUtils.validateLogin(login)) {
            addFieldError("login", "Incorrect login format (3-15 symbols, "
                + "only letters and digits");
        }
        if (!validateUtils.validateEmail(email)) {
            addFieldError("email", "Incorrect e-mail format");
        }
        if (!validateUtils.validatePassword(password)) {
            addFieldError("password", "Incorrect password format, must contain "
                + "at least 6 symbols 1 lowercase, 1 uppercase, 1 special "
                + "symbol (!?@#$%)");
        }
        if (!validateUtils.validateDate(birthday)) {
            addFieldError("birthday", "Incorrect date format (Correct date "
                + "format: 2010-10-10)");
        }
        
        String tempLogin = login;
        if ("add".equals(type)) {
            tempLogin = null;
            if (validateUtils.checkUserExists(login)) {
                addFieldError("login", "Login '" + login + "' already exists");
            }
        }
        if (validateUtils.checkEmailExists(email, tempLogin)) {
            addFieldError("email", "Email '" + email + "' already exists");
        }
        if (!validateUtils.checkPasswordMatch(password, rePassword)) {
            addFieldError("rePassword", "Passwords does not matches");
        }
    }
    
    public String execute() {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setBirthday(Date.valueOf(birthday));
        user.setRole(roleDao.findByName("ROLE_" + role));
        if ("edit".equals(type)) {
            user.setId(Long.parseLong(id));
            
            userDao.update(user);
        } else {
            userDao.create(user);
        }
        setUserList(userDao.findAll());
        return Action.SUCCESS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
