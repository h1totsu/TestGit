package com.nix.romanenko.tests;

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
import com.nix.romanenko.dao.RoleDao;
import com.nix.romanenko.entity.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@DatabaseSetup("/init_dataset.xml")
@ContextConfiguration(locations = { "classpath:**/test-context.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
public class HibernateRoleDaoTest {
	@Autowired
    RoleDao roleDao;
    
    @Test
    @ExpectedDatabase(table = "Role", value = "/insert_dataset.xml", 
    assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testCreate() throws Exception {
        roleDao.create(new Role(3, "role3"));
    }
    
    @Test(expected=RuntimeException.class)
    public void testCreateNull() throws Exception {
        roleDao.create(null);
    }
    
    @Test(expected=RuntimeException.class) // unique value
    public void testCreateExists() throws Exception {
        roleDao.create(new Role(1, "role1"));
    }
    
    
    @Test(expected=RuntimeException.class)
    public void testUpdateNull() throws Exception {
        roleDao.update(null);
    }
    
    @Test
    @ExpectedDatabase(table = "Role", value = "/update_dataset.xml",
    	assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void testUpdate() throws Exception {
        Role role = new Role(2, "role2Updated");
        roleDao.update(role);
    }
    
    @Test(expected=RuntimeException.class)
    public void testRemoveNull() throws Exception {
        roleDao.remove(null);
    }
    
    @Test(expected=RuntimeException.class) 
    public void testRemoveNotExists() throws Exception {
        roleDao.remove(new Role(4, "role4"));
    }

    
    @Test
    @ExpectedDatabase(table = "Role", value = "/remove_dataset.xml")
    public void testRemove() throws Exception {
        roleDao.remove(new Role(1, "role1"));
    }  
    
    @Test
    public void testFindByName() throws Exception {
    	String roleName = "role1";
    	Assert.assertEquals(roleName, roleDao.findByName(roleName).getName());
    } 
}
