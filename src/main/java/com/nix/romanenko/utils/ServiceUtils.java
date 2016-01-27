package com.nix.romanenko.utils;

import java.sql.Date;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.nix.romanenko.dao.RoleDao;
import com.nix.romanenko.entity.User;
import com.nix.romanenko.form.UserForm;

@Named("serviceUtils")
public class ServiceUtils {
    @Autowired
    RoleDao roleDao;
    
    Logger logger = LoggerFactory.getLogger(ServiceUtils.class);
    
    public User getUser(UserForm form, String role) {
        User user = new User();
        user.setLogin(form.getLogin());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        user.setFirstname(form.getFirstname());
        user.setLastname(form.getLastname());
        user.setBirthday(Date.valueOf(form.getBirthday()));
        user.setRole(roleDao.findByName(role));
        return user;
    }
    
    public GrantedAuthority getAuthority() {
    	Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
    	return auth.getAuthorities().iterator().next();
    }
}
