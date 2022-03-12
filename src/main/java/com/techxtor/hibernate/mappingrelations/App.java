package com.techxtor.hibernate.mappingrelations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();

        laptop.setlId(101);
        laptop.setlName("Dell");

        Student student = new Student();
        student.setRollNo(1);
        student.setName("Manish");
        student.setMarks(50);
//        student.setLaptop(laptop); // for o2o
        student.getLaptops().add(laptop);

        laptop.setStudent(student);


        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
                .build();
        SessionFactory factory = config.buildSessionFactory(registry);
        Session session = factory.openSession();

        System.out.println(student.toString());

        // transactions
        session.beginTransaction();

        session.save(laptop);
        session.save(student);

        session.getTransaction().commit();

    }
}
