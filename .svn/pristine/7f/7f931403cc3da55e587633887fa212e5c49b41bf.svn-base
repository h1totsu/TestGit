package com.nix.romanenko.tests;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.nix.romanenko.dao.UserDao;
import com.nix.romanenko.entity.Role;
import com.nix.romanenko.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
@DatabaseSetup("/init_dataset.xml")
public class HibernateUserDaoTest extends DbTestConfig {
	@Autowired
    UserDao userDao;
    
    @Test
    @ExpectedDatabase(table = "User", value = "/update_dataset.xml",
    	assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testUpdate() throws Exception {
        User user = new User();
        user.setId(2);
        user.setLogin("login2Updated");
        user.setPassword("pass2Updated");
        user.setLastname("lname2Updated");
        
        userDao.update(user);
    }
    
    @Test(expected=RuntimeException.class)
    public void testRemoveNull() throws Exception {
        userDao.remove(null);
    }
    
    @Test
    @ExpectedDatabase(table = "User", value = "/remove_dataset.xml")
    public void testRemove() throws Exception {
        User user = new User();
        user.setId(1);
        userDao.remove(user);
    }
    
    @Test
    @ExpectedDatabase(table = "User", value = "/insert_dataset.xml", 
    assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testCreate() throws Exception {
        User user = new User();
        user.setId(3);
        user.setLogin("login3");
        user.setPassword("pass3");
        user.setFirstname("fname3");
        user.setLastname("lname3");
        user.setEmail("email3");
        user.setBirthday(Date.valueOf("1970-01-01"));
        user.setRole(new Role(1, "role1"));
        userDao.create(user); 
    }
    
    @Test(expected=RuntimeException.class) 
    public void testCreateWithoutRole() throws Exception {
        User user = new User();
        user.setLogin("newLogin");
        user.setEmail("new@mail.test");
        user.setRole(new Role(4, "newRole"));
        userDao.create(user);
    }
    
    @Test(expected=RuntimeException.class)
    public void testCreateNull() throws Exception {
        userDao.create(null);
    }
    
    @Test(expected=RuntimeException.class)
    public void testCreateSameLogin() throws Exception {
        User user = new User();
        user.setLogin("login1");
        userDao.create(user);
        User user1 = new User();
        user1.setLogin("login1");
        userDao.create(user1);
    }
    
    @Test(expected=RuntimeException.class)
    public void testCreateSameEmail() throws Exception {
        User user = new User();
        user.setEmail("email1");
        userDao.create(user);
        User user1 = new User();
        user1.setEmail("email1");
        userDao.create(user1);
    }
    
    @Test(expected=RuntimeException.class)
    public void testUpdateNull() throws Exception {
        userDao.update(null);
    }
    
    @Test
    public void testFindAll() throws Exception {	
        Assert.assertEquals("should be 2 after init dataset", 2, 
                userDao.findAll().size());
    }

    @Test
    public void testFindByLogin() throws Exception {
        String expectedLogin = "wrongLogin";
        Assert.assertNull(userDao.findByLogin(expectedLogin));
        expectedLogin = "login1";
        Assert.assertEquals(expectedLogin, userDao.findByLogin(expectedLogin)
                .getLogin());
    }
    
    @Test
    public void testFindByEmail() throws Exception {
        String expectedEmail = "wrongEmail";
        Assert.assertNull("should return null for wrong email", userDao.findByEmail(expectedEmail));
        expectedEmail = "email1";
        Assert.assertEquals(expectedEmail, userDao.findByEmail(expectedEmail).getEmail());
    }
}
