package com.nix.romanenko.tests;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nix.romanenko.dao.RoleDao;
import com.nix.romanenko.dao.UserDao;

abstract public class DbTestConfig {
    protected final String INSERT_DATASET = "insert_dataset.xml";
    protected final String UPDATE_DATASET = "update_dataset.xml";
    protected final String REMOVE_DATASET = "remove_dataset.xml";
    protected final String INIT_DATASET = "init_dataset.xml";
    
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    protected Connection connection;
    protected UserDao userDao;
    protected RoleDao roleDao;
    protected String url;
    protected String driver;
    protected String user;
    protected String password;
    
    public DbTestConfig() {
        Properties props = new Configuration().configure().getProperties();
        url = props.getProperty("hibernate.connection.url");
        driver = props.getProperty("hibernate.connection.driver_class");
        user = props.getProperty("hibernate.connection.username");
        password = props.getProperty("hibernate.connection.password");
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }  
    }
    
    public Connection getDatabaseConnection() throws Exception {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    protected IDatabaseConnection getConnection() throws Exception {
        IDatabaseConnection connection = new DatabaseConnection(getDatabaseConnection());

        DatabaseConfig dbConfig = connection.getConfig();

        dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY,
                new H2DataTypeFactory());
        return connection;
        
    }
    
    protected IDataSet getDataSet(String path) throws Exception {
        return new FlatXmlDataSetBuilder()
                .build(getResourceFile(path));
    } 
    
    protected File getResourceFile(String path) {
        return  new File(getClass()
                .getClassLoader().getResource(path).getFile());
    }
}