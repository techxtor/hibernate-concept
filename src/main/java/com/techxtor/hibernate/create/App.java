package com.techxtor.hibernate.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
        Alien techxtor = new Alien();

        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        SessionFactory sessionFactory = config.buildSessionFactory(reg );
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        techxtor.setaId(104);
        techxtor.setaName("Sneha");
        techxtor.setaColor("White");

        session.save(techxtor);

        tx.commit();
    }
}
