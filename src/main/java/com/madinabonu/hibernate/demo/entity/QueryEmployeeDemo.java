package com.madinabonu.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryEmployeeDemo {
    public static void main(String[] args) {
        //Create Session Factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employees.class)
                .buildSessionFactory();

        //Create Session
        Session session = factory.getCurrentSession();

        try{

            //start transaction
            session.beginTransaction();

            //Query Employee
            List<Employees> employee1 = session.createQuery("from Employees").getResultList();

            //Showing employee
            for ( Employees employees : employee1){
                System.out.println(employee1);
            }

            //Query lastName is Smith
            employee1 = session.createQuery("from Employees s where s.lastName = 'Smith' ").getResultList();

            //Displaying Employee
            System.out.println("Employee with last name Of Smith");

            for ( Employees employees : employee1){
                System.out.println(employee1);
            }

            //Query Employees: firstName = 'Paul' OR lastName = 'Smith'
            employee1 = session.createQuery("from Employees s where "
                    +" s.firstName ='Paul' OR s.lastName ='Smith'").getResultList();
            System.out.println("\nEmployee with first name = Paul OR Last name = Smith ");
            for ( Employees employees : employee1){
                System.out.println(employee1);
            }

            //Query Employees where email LIKE %smith@foo.com
            employee1 = session.createQuery("from Employees s where "
             +" s.email LIKE '%smith@foo.com' ").getResultList();
            System.out.println("Employee whose email is ending like %smith@foo.com");
            for ( Employees employees : employee1){
                System.out.println(employee1);
            }

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");
        }finally {
            factory.close();
        }
    }

}
