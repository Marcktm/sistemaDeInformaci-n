package com.supercharger.dao;

import com.supercharger.model.FichaMecanica;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.supercharger.util.HibernateUtil;

import java.util.List;

public class FichaMecanicaDAO {
    public void guardarFichaMecanica(FichaMecanica fichaMecanica) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(fichaMecanica);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<FichaMecanica> obtenerFichasMecanicas() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from FichaMecanica", FichaMecanica.class).list();
        }
    }

    public void eliminarFichaMecanica(FichaMecanica ficha) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ficha);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

}
