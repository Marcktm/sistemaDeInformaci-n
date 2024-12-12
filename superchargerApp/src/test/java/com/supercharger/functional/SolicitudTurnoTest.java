package com.supercharger.functional;

import javafx.scene.input.KeyCode;
import org.testfx.framework.junit5.ApplicationTest;
import javafx.stage.Stage;
import com.supercharger.MainMenu;

import static org.junit.jupiter.api.Assertions.*;

public class SolicitudTurnoTest extends ApplicationTest {

    @Override
    public void start(Stage stage) {
        new MainMenu().start(stage);
    }

    @org.junit.jupiter.api.Test
    public void testIngresarSolicitudTurno() {
        // Simular clic en el botón "Solicitar Turno"
        clickOn("Solicitar Turno");

        // Verificar que se muestra la ventana de "Solicitud de Turno"
        assertTrue(
                lookup("Solicitud de Turno")
                        .queryAs(javafx.scene.Node.class)
                        .isVisible(),
                "La ventana 'Solicitud de Turno' no está visible."
        );

        // Llenar los campos del formulario
        clickOn("#nombreField").write("Juan Perez");
        clickOn("#documentoField").write("12345678");
        clickOn("#telefonoField").write("555-1234");
        clickOn("#companiaField").write("Seguros ABC");

        // Simular clic en el botón de confirmar
        clickOn("#confirmarButton");

    }

    @org.junit.jupiter.api.Test
    public void testCamposVacios() {
        // Simular clic en el botón "Solicitar Turno"
        clickOn("Solicitar Turno");

        // Verificar que se muestra la ventana de "Solicitud de Turno"
        assertTrue(
                lookup("Solicitud de Turno")
                        .queryAs(javafx.scene.Node.class)
                        .isVisible(),
                "La ventana 'Solicitud de Turno' no está visible."
        );

        // Simular clic en el botón confirmar sin llenar los campos
        clickOn("#confirmarButton");

        // Verificar que aparece un mensaje de error (simulación de mensaje esperado)
        javafx.scene.Node mensajeError = lookup("#errorLabel").queryAs(javafx.scene.Node.class);
        assertNotNull(mensajeError, "El mensaje de error no apareció.");
        assertTrue(
                mensajeError.isVisible(),
                "El mensaje de error no es visible cuando los campos están vacíos."
        );
    }
}
