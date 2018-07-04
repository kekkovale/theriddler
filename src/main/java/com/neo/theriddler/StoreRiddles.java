package com.neo.theriddler;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

import javax.transaction.Transaction;

import static com.neo.theriddler.HibernateUtil.getSession;

public class StoreRiddles {

    public static void storeRiddle( Riddle riddle) {

        Session session=getSession();
        session.beginTransaction();
        session.save(riddle);
        session.getTransaction().commit();
        session.close();

    }
}
