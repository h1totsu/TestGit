package com.nix.romanenko.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nix.romanenko.dao.UserDao;
import com.nix.romanenko.entity.User;

@Service("myUserDetailsService")
public class UserService implements UserDetailsService {
    
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) 
            throws UsernameNotFoundException {
        User user = userDao.findByLogin(login);
        
        if (user == null) {
            throw new UsernameNotFoundException("Login not found");
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

        return new org.springframework.security.core
                .userdetails.User(user.getLogin(), user.getPassword(), true, true, true,
                true, authorities);    
    }
    
    
}
