package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entity.*;

import javax.swing.*;

/**
 * Created by tasmidur on 1/16/2019.
 */
public class Retrip
{
    Retrip()
    {

    }
    public customer Retripp(String id)
    {
        SessionFactory sessionFactory = createHibernateSession.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        customer c=(customer)session.get(customer.class,id);

        session.getTransaction().commit();
        session.close();

        return  c;
    }
}
