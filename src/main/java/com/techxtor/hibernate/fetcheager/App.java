package com.techxtor.hibernate.fetcheager;

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
        Session session = factory.openSession();

        // transactions
        session.beginTransaction();

        Student s1 = session.get(Student.class,  1);

        session.getTransaction().commit();

    }
}
