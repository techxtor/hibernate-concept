package com.techxtor.hibernate.fetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
        Alien techxtor;

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        SessionFactory sessionFactory = configuration.buildSessionFactory(reg);
        Session session = sessionFactory.openSession();

        // db transaction
        Transaction tx = session.beginTransaction();
//        techxtor = (Alien) session.get(Alien.class, 101); // same as below
        techxtor = session.get(Alien.class, 101);

        tx.commit();

        System.out.println(techxtor.toString());
    }
}
