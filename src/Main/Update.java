package Main;

import entity.*;
import org.hibernate.Session;
import entity.*;
import org.hibernate.SessionFactory;

import javax.swing.*;


/**
 * Created by tasmidur on 1/16/2019.
 */
public class Update
{
    Update(){};

    void Updatee(String id,String Name)
    {
        SessionFactory sessionFactory=createHibernateSession.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        customer ee=(customer) session.get(customer.class,id);

        System.out.println(ee.getId()+" "+ee.getName()+".............\n\n\n\n\n\n\n\n\n");

        ee.setName(Name);
        session.update(ee);
        System.out.println("Updated");
        session.getTransaction().commit();
        session.close();
    }
}
