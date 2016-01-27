package com.nix.romanenko.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class UserForm {
    @Pattern(regexp="^[a-zA-Z0-9_-]{3,15}$", message="Incorrect login format"
            + " (3-15 symbols, only letters and digits")
    private String login;
    
    @Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!?@#$%]).{6,20})",
        message="Incorrect password format, must contain al least 6 symbols"
        + " 1 lowercase, 1 uppercase, 1 special symbol (!?@#$%)")
    private String password;
    
    @NotBlank(message = "Field cant be empty")
    private String rePassword;
    
    @Email(regexp="[\\w-]+@([\\w-]+\\.)+[\\w-]+", message="Incorrect e-mail format")
    private String email;
    
    @NotBlank(message = "Field cant be empty")
    private String firstname;
    
    @NotBlank(message = "Field cant be empty")
    private String lastname;
    
    @Pattern(regexp="^\\d{4}-((0\\d)|(1[012]))-(([012]\\d)|3[01])$",
            message="Invalid date format, (yyyy-mm-dd) format required")
    private String birthday;
    
    private String captcha;
    
    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
