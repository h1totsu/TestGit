package com.nix.romanenko.dao;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nix.romanenko.dao.RoleDao;
import com.nix.romanenko.entity.Role;

@Repository
@Named("roleDao")
public class HibernateRoleDao implements RoleDao {
    private final String FIND_NAME_OPERATION = "FROM Role WHERE name = :name";
        
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
    public void create(Role role) {
    	sessionFactory.getCurrentSession().save(role);
    }

    @Transactional
    @Override
    public void update(Role role) {
    	sessionFactory.getCurrentSession().update(role);
    }

    @Transactional
    @Override
    public void remove(Role role) {
        sessionFactory.getCurrentSession().delete(role);
    }

    @Transactional
    @Override
    public Role findByName(String name) {
        Query query = sessionFactory.getCurrentSession()
        		.createQuery(FIND_NAME_OPERATION);
        query.setParameter("name", name);
        return (Role) query.uniqueResult();
    }
}
