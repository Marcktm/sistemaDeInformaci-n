package com.supercharger.functional;

import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;
import com.supercharger.MainMenu;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainMenuTest extends ApplicationTest {

    @Override
    public void start(Stage stage) {
        new MainMenu().start(stage);
    }

    @Test
    public void testBotonSolicitarTurno() {
        // Simular clic en el botón "Solicitar Turno"
        clickOn("Solicitar Turno");

        // Verificar que se muestra la ventana de "Solicitud de Turno"
        javafx.scene.Node ventanaSolicitudTurno = lookup("Solicitud de Turno").queryAs(javafx.scene.Node.class);
        assertNotNull(ventanaSolicitudTurno, "La ventana 'Solicitud de Turno' no se encontró.");
        assertTrue(ventanaSolicitudTurno.isVisible(), "La ventana 'Solicitud de Turno' no está visible.");

        // Regresar al menú principal
        clickOn("Volver");
    }

    @Test
    public void testBotonRegistrarAsistencia() {
        // Simular clic en el botón "Registrar Asistencia"
        clickOn("Registrar Asistencia");

        // Verificar que se muestra la ventana de "Registro de Asistencia"
        javafx.scene.Node ventanaRegistroAsistencia = lookup("Registro de Asistencia").queryAs(javafx.scene.Node.class);
        assertNotNull(ventanaRegistroAsistencia, "La ventana 'Registro de Asistencia' no se encontró.");
        assertTrue(ventanaRegistroAsistencia.isVisible(), "La ventana 'Registro de Asistencia' no está visible.");

        // Regresar al menú principal
        clickOn("Volver");
    }

    @Test
    public void testBotonFichaMecanica() {
        // Simular clic en el botón "Ficha Mecánica"
        clickOn("Ficha Mecánica");

        // Verificar que se muestra la ventana de "Ficha Mecánica"
        javafx.scene.Node ventanaFichaMecanica = lookup("Ficha Mecánica").queryAs(javafx.scene.Node.class);
        assertNotNull(ventanaFichaMecanica, "La ventana 'Ficha Mecánica' no se encontró.");
        assertTrue(ventanaFichaMecanica.isVisible(), "La ventana 'Ficha Mecánica' no está visible.");

        // Regresar al menú principal
        clickOn("Volver");
    }

    @Test
    public void testBotonListados() {
        // Simular clic en el botón "Listados"
        clickOn("Listados");

        // Verificar que se muestra la ventana de "Listados"
        javafx.scene.Node ventanaListados = lookup("Listados").queryAs(javafx.scene.Node.class);
        assertNotNull(ventanaListados, "La ventana 'Listados' no se encontró.");
        assertTrue(ventanaListados.isVisible(), "La ventana 'Listados' no está visible.");

        // Regresar al menú principal
        clickOn("Volver");
    }

    @Test
    public void testBotonInformesMensuales() {
        // Simular clic en el botón "Informes Mensuales"
        clickOn("Informes Mensuales");

        // Verificar que se muestra la ventana de "Informes Mensuales"
        javafx.scene.Node ventanaInformesMensuales = lookup("Informes Mensuales").queryAs(javafx.scene.Node.class);
        assertNotNull(ventanaInformesMensuales, "La ventana 'Informes Mensuales' no se encontró.");
        assertTrue(ventanaInformesMensuales.isVisible(), "La ventana 'Informes Mensuales' no está visible.");

        // Regresar al menú principal
        clickOn("Volver");
    }
}
