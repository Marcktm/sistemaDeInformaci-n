package com.supercharger.dao;

import com.supercharger.model.Cliente;
import com.supercharger.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import java.util.List;

/**
 * Data Access Object (DAO) for the Cliente entity.
 * Provides methods to interact with the database for Cliente operations.
 */
public class ClienteDAO {

    /**
     * Saves a Cliente entity to the database.
     *
     * @param cliente the Cliente entity to be saved
     */
    public void guardarCliente(Cliente cliente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Begin transaction
            transaction = session.beginTransaction();
            // Save the Cliente entity
            session.save(cliente);
            // Commit the transaction
            transaction.commit();
        } catch (HibernateException e) {
            // Rollback transaction in case of error
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error saving Cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Retrieves all Cliente entities from the database.
     *
     * @return a list of Cliente entities
     */
    public List<Cliente> obtenerClientes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Query the database and return the results
            return session.createQuery("from Cliente", Cliente.class).list();
        } catch (HibernateException e) {
            System.err.println("Error retrieving Clientes: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Retrieves a Cliente by its ID.
     *
     * @param id the ID of the Cliente
     * @return the Cliente entity, or null if not found
     */
    public Cliente obtenerClientePorId(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Cliente.class, id);
        } catch (HibernateException e) {
            System.err.println("Error retrieving Cliente by ID: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Updates an existing Cliente entity in the database.
     *
     * @param cliente the Cliente entity with updated information
     */
    public void actualizarCliente(Cliente cliente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Begin transaction
            transaction = session.beginTransaction();
            // Update the Cliente entity
            session.update(cliente);
            // Commit the transaction
            transaction.commit();
        } catch (HibernateException e) {
            // Rollback transaction in case of error
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error updating Cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Deletes a Cliente entity from the database.
     *
     * @param cliente the Cliente entity to be deleted
     */
    public void eliminarCliente(Cliente cliente) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Begin transaction
            transaction = session.beginTransaction();
            // Delete the Cliente entity
            session.delete(cliente);
            // Commit the transaction
            transaction.commit();
        } catch (HibernateException e) {
            // Rollback transaction in case of error
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("Error deleting Cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminarTodos() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Cliente").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

}
