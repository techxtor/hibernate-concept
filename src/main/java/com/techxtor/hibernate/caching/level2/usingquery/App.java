package com.techxtor.hibernate.caching.level2.usingquery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {

        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
                .build();
        SessionFactory factory = config.buildSessionFactory(registry);

        Session session1 = factory.openSession();
        session1.beginTransaction();

        Query q1 = session1.createQuery("from Student where rollNo=1");  // fires query
        q1.setCacheable(true);
        q1.uniqueResult();

        session1.getTransaction().commit();
        session1.close();

        // session2 ======

        Session session2 = factory.openSession();
        session2.beginTransaction();

        Query q2 = session2.createQuery("from Student where rollNo=1");  // does not fire query
        q2.setCacheable(true);
        q2.uniqueResult();

        session2.getTransaction().commit();
        session2.close();
    }
}
