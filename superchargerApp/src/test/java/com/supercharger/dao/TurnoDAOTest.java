package com.supercharger.dao;

import com.supercharger.model.Cliente;
import com.supercharger.model.Turno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

public class TurnoDAOTest {
    private TurnoDAO turnoDAO = new TurnoDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();

    @BeforeEach
    public void setup() {
        // Limpia los datos de la base de datos antes de cada prueba
        turnoDAO.eliminarTodos();
        clienteDAO.eliminarTodos();
    }

    @Test
    public void testGuardarTurno() {
        // Crear y guardar un cliente para asociarlo al turno
        Cliente cliente = new Cliente(0, "Maria Lopez", "87654321", "555-5678");
        clienteDAO.guardarCliente(cliente);

        // Crear y guardar un turno
        Turno turno = new Turno();
        turno.setFecha(LocalDate.of(2024, 12, 8));
        turno.setHora(LocalTime.of(10, 0));
        turno.setEstado("pendiente");
        turno.setCliente(cliente);

        assertDoesNotThrow(() -> turnoDAO.guardarTurno(turno));
    }

    @Test
    public void testObtenerTurnos() {
        // Crear y guardar un cliente para asociarlo al turno
        Cliente cliente = new Cliente(0, "Juan Perez", "12345678", "555-1234");
        clienteDAO.guardarCliente(cliente);

        // Crear y guardar un turno
        Turno turno = new Turno();
        turno.setFecha(LocalDate.of(2024, 12, 8));
        turno.setHora(LocalTime.of(14, 0));
        turno.setEstado("confirmado");
        turno.setCliente(cliente);
        turnoDAO.guardarTurno(turno);

        assertNotNull(turnoDAO.obtenerTurnos());
        assertFalse(turnoDAO.obtenerTurnos().isEmpty());
    }
}

