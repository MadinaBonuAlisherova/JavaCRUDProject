package com.madinabonu.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployeeDemo {
    public static void main(String[] args) {
        //Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Create Session
        Session session = factory.getCurrentSession();

        try{

            int employeeId =1;

            session= factory.getCurrentSession();
            session.beginTransaction();

            //Getting Employee by ID
            System.out.println("Getting employee with id: "+employeeId);

            Employees employees1 = session.get(Employees.class, employeeId);

            System.out.println("Updating Employee: "+employees1);
            employees1.setLastname("Carlo");

            //commit transaction
            session.getTransaction().commit();


            session= factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Update emails for all Employees");

            session.createQuery(("update employees set email = 'gxl@mail.ru"))
                    .executeUpdate();

            //commit transaction
            session.getTransaction().commit();


            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}
