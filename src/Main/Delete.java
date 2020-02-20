package Main;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;

/**
 * Created by tasmidur on 1/16/2019.
 */
public class Delete {
    Delete(){}
    void Deletee(String id)
    {
        SessionFactory sessionFactory=createHibernateSession.getSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();

        customer ee=(customer) session.get(customer.class,id);
        session.delete(ee);
        session.getTransaction().commit();
        session.close();
    }
}
