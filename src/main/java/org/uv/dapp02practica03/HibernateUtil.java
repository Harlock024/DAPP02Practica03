package org.uv.dapp02practica03;


import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;


/**
 *
 * @author harlock024
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory(){
        try {
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml");
            return  config.buildSessionFactory();
        } catch (HibernateException ex) {
            System.err.println("SessionFactory creation failed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown(){
        getSessionFactory().close();
    }
    
}
