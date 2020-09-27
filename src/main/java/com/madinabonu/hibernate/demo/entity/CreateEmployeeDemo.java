package com.madinabonu.hibernate.demo.entity;

import com.madinabonu.hibernate.demo.entity.Employees;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateEmployeeDemo {
    public static void main(String[] args) {

        //Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employees.class)
                .buildSessionFactory();

        //Create Session
        Session session = factory.getCurrentSession();

        try{
            //use session objects
            System.out.println("Creating new employee object");
            Employees employee1 = new Employees("Bonu", "Alisherova","alish@inha.gmail.com","Engineering", 8000);

            //start transaction
            session.beginTransaction();

            //save employees object
            System.out.println("Saving the employee");
            session.save(employee1);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");
        }finally {
            factory.close();
        }
    }
}
