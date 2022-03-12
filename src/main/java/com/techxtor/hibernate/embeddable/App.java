package com.techxtor.hibernate.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {

        AlienName alienName = new AlienName();
        alienName.setfName("Manish");
        alienName.setmName("Kumar");
        alienName.setlName("Jha");

        Alien techxtor = new Alien();
        techxtor.setaId(105);
        techxtor.setaColor("White");
        techxtor.setaName(alienName);

        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        SessionFactory sessionFactory = config.buildSessionFactory(reg );
        Session session = sessionFactory.openSession();

        // db transaction
        Transaction tx = session.beginTransaction();
        session.save(techxtor);

        tx.commit();

        System.out.println(techxtor.toString());
    }
}
