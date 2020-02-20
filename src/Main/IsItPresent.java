package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import entity.*;

public class IsItPresent {
    public boolean test(String id)
    {
        SessionFactory sessionFactory= createHibernateSession.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        if(session.get(customer.class,id)==null)
            return false;
        return  true;
    }
}
