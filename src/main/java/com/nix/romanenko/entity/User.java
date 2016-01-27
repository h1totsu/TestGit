package com.nix.romanenko.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity 
@Table(name="user")
public class User implements Serializable {    
    private static final long serialVersionUID = -5098096643462542564L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long    id;
    
    @Column(name="login", unique=true)
    private String  login;
    
    @Column(name="password")
    private String  password;
    
    @Column(name="email", unique=true)
    private String  email;
    
    @Column(name="firstname")
    private String  firstname;
    
    @Column(name="lastname")
    private String  lastname;
    
    @Column(name="birthday")
    private Date    birthday;
    
    @ManyToOne
    @JoinColumn(name="roleid")
    @OnDelete(action=OnDeleteAction.CASCADE)
    private Role    role;
    
    public User() {}
    
    public User(long id, String login, String pass, String email, Role role) {
        this.id = id;
        this.login = login;
        this.password = pass;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", login=" + login + ", password=" + password
                + ", email=" + email + ", firstname=" + firstname
                + ", lastname=" + lastname + ", birthday=" + birthday
                + ", role=" + role + "]";
    }
    
    
}
