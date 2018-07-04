package com.neo.theriddler;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static final SessionFactory concreteSessionFactory;
    static {
        try {
            Properties prop= new Properties();
            prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/db_riddles");
            prop.setProperty("hibernate.connection.username", "myself");
            prop.setProperty("hibernate.connection.password", "kekko");
            prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

            concreteSessionFactory = new Configuration()
                    .addPackage("com.neo.theriddler.persistence")
                    .addProperties(prop)
                    .addAnnotatedClass(Riddle.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession()
            throws HibernateException {
        return concreteSessionFactory.openSession();
    }

}
