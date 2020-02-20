package Main;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.print.attribute.standard.MediaSize;
import javax.swing.*;


public class Insert
{

    Insert() {}
    void Insertt(String id, String Name)
    {
        customer e=new customer();
        e.setId(id);
        e.setName(Name);

        SessionFactory sessionFactory=createHibernateSession.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();

        session.save(e);
        session.getTransaction().commit();
        session.close();
        //sessionFactory.close();
    }
}
