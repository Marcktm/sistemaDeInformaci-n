package com.supercharger.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Utility class to manage Hibernate SessionFactory.
 */
public class HibernateUtil {

    // Singleton instance of SessionFactory
    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Builds the SessionFactory using the Hibernate configuration file.
     *
     * @return the SessionFactory
     */
    private static SessionFactory buildSessionFactory() {
        try {
            // Load Hibernate configuration from hibernate.cfg.xml
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception with details to help debugging
            System.err.println("Initial SessionFactory creation failed. Details: " + ex.getMessage());
            ex.printStackTrace();
            // Throw a custom exception to stop the application initialization
            throw new ExceptionInInitializerError("Failed to create SessionFactory. Check configuration and logs.");
        }
    }

    /**
     * Provides the singleton SessionFactory instance.
     *
     * @return the SessionFactory instance
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Shuts down the SessionFactory, releasing all resources.
     */
    public static void shutdown() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
