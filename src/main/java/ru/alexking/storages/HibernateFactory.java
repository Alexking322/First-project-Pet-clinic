package ru.alexking.storages;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author alexking
 * @since 30.01.2017
 */
public class HibernateFactory {
    private static final Logger log = getLogger(HibernateFactory.class);
    private static final SessionFactory factory = new Configuration()
            .configure()
            .buildSessionFactory();

    private HibernateFactory() {
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
