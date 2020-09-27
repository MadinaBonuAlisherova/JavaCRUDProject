package com.madinabonu.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeydemo {
    public static void main(String[] args) {
        //Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Create Session
        Session session = factory.getCurrentSession();

        try{
            //use session objects
            System.out.println("Creating ne employee object");
            Employees employee1 = new Employees("Bonu", "Alisherova","alish@inha.gmail.com","Engineering", 8000);
            Employees employee2 = new Employees("Valisher", "Alisherov","valisher@inha.gmail.com","Engineering", 8000);
            Employees employee3 = new Employees("MK", "Alisherov","mk@inha.gmail.com","Engineering", 8000);

            //start transaction
            session.beginTransaction();

            //save employees object
            System.out.println("Saving the employees...");
            session.save(employee1);
            session.save(employee2);
            session.save(employee3);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");
        }finally {
            factory.close();
        }
    }
}
