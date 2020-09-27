package com.madinabonu.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployeeDemo {
    public static void main(String[] args) {
        //Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        //Create Session
        Session session = factory.getCurrentSession();

        try{

            int employeeId =3;

            session= factory.getCurrentSession();
            session.beginTransaction();

            //Getting Employee by ID
            System.out.println("Getting employee with id: "+employeeId);

            Employees employees1 = session.get(Employees.class, employeeId);

            System.out.println("Deleting Employee: "+employees1);
            //deleting one way from database
             session.delete(employees1);

            //deleting another way
            session.createQuery("delete from Employees where id=4")
                    .executeUpdate();

            //commit transaction
            session.getTransaction().commit();


            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}
