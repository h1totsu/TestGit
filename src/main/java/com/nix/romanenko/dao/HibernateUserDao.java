package com.nix.romanenko.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nix.romanenko.dao.UserDao;
import com.nix.romanenko.entity.User;

@Repository
@Named("userDao")
public class HibernateUserDao implements UserDao {
    private final String FIND_ALL_OPERATION = "FROM User";
    private final String FIND_LOGIN_OPERATION = "FROM User WHERE login = :login";
    private final String FIND_EMAIL_OPERATION = "FROM User WHERE email = :email";  

    @Inject
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Transactional
    @Override
    public void create(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Transactional
    @Override
    public void update(User user) {
    	sessionFactory.getCurrentSession().update(user);
    }

    @Transactional
    @Override
    public void remove(User user) {
    	sessionFactory.getCurrentSession().delete(user);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() {
    	Query query = sessionFactory.getCurrentSession()
    			.createQuery(FIND_ALL_OPERATION);
        return query.list();     
    }

    @Transactional
    @Override
    public User findByLogin(String login) {
        Query query = sessionFactory.getCurrentSession()
        		.createQuery(FIND_LOGIN_OPERATION);
        query.setParameter("login", login);
        return (User) query.uniqueResult();
    }

    @Transactional
    @Override
    public User findByEmail(String email) {
        Query query = sessionFactory.getCurrentSession()
        		.createQuery(FIND_EMAIL_OPERATION);
        query.setParameter("email", email);
        return (User) query.uniqueResult();
    }

    @Transactional
    public User findByid(long id) {
        return sessionFactory.getCurrentSession()
    		   .load(User.class, id);
    }
}
