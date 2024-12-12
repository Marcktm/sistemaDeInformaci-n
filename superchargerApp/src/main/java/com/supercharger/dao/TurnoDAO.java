package com.supercharger.dao;

import com.supercharger.model.Turno;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.supercharger.util.HibernateUtil;

import java.util.Collections;
import java.util.List;

public class TurnoDAO {

    // Guardar un turno en la base de datos
    public void guardarTurno(Turno turno) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(turno);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback(); // Rollback si ocurre algún error
            e.printStackTrace();
        }
    }

    // Obtener todos los turnos
    public List<Turno> obtenerTurnos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Turno", Turno.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList(); // Devuelve lista vacía en caso de error
        }
    }

    // Obtener el próximo ID disponible para Turno
    public int getNextId() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String query = "select max(t.id) from Turno t";
            Integer maxId = session.createQuery(query, Integer.class).uniqueResult();
            return (maxId != null) ? maxId + 1 : 1; // Si no hay registros, devuelve 1
        } catch (Exception e) {
            e.printStackTrace();
            return 1; // En caso de error, devolver un valor predeterminado
        }
    }

    public void eliminarTurno(Turno turno) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(turno);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void eliminarTodos() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Turno").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }


}
