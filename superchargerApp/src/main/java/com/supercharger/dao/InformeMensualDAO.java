package com.supercharger.dao;

import com.supercharger.model.InformeMensual;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.supercharger.util.HibernateUtil;

import java.util.List;

public class InformeMensualDAO {
    public void guardarInformeMensual(InformeMensual informeMensual) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(informeMensual);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<InformeMensual> obtenerInformesMensuales() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from InformeMensual", InformeMensual.class).list();
        }
    }
}
