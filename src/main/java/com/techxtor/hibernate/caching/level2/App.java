package com.techxtor.hibernate.caching.level2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
                .build();
        SessionFactory factory = config.buildSessionFactory(registry);

        Session session1 = factory.openSession();
        session1.beginTransaction();

        session1.get(Student.class, 1); // fires query

        session1.getTransaction().commit();
        session1.close();

        // session2 ======

        Session session2 = factory.openSession();
        session2.beginTransaction();

        session2.get(Student.class, 1); // does not fire query

        session2.getTransaction().commit();
        session2.close();
    }
}
