package com.klu.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class ClientDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();

        insertTicket(sf);
        updateTicket(sf,1,"Updated Name","Resolved");

        sf.close();
    }

    // Insert Ticket
    public static void insertTicket(SessionFactory sf)
    {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        Ticket t1 = new Ticket();
        t1.setName("Technical Support");
        t1.setDate("2026-03-13");
        t1.setStatus("Pending");

        session.save(t1);

        t.commit();
        System.out.println("Ticket Inserted Successfully");

        session.close();
    }

    // Update Ticket using HQL
    public static void updateTicket(SessionFactory sf,int id,String newName,String newStatus)
    {
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        String hql="UPDATE Ticket SET name=?1,status=?2 WHERE id=?3";

        Query query=session.createQuery(hql);
        query.setParameter(1,newName);
        query.setParameter(2,newStatus);
        query.setParameter(3,id);

        int rows=query.executeUpdate();

        t.commit();

        System.out.println(rows+" record updated");

        session.close();
    }
}