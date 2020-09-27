package com.madinabonu.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployeeDemo {
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
            System.out.println(employee1);
            session.save(employee1);
            session.save(employee2);
            session.save(employee3);

            //commit transaction
            session.getTransaction().commit();

            //Getting Employee using Employee ID Primary key
            System.out.println("Saved employee. Generated ID: "+employee1.getId());

            session= factory.getCurrentSession();
            session.beginTransaction();

            //Getting Employee by ID
            System.out.println("Getting employee with id: "+employee1.getId());

            Employees employees1 = session.get(Employees.class, employee1.getId());

            System.out.println("Get complete: "+employees1);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}
