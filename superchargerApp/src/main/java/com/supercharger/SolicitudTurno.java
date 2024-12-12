package com.supercharger;

import com.supercharger.dao.TurnoDAO;
import com.supercharger.model.Turno;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SolicitudTurno {
    public void startWithBackButton(Stage primaryStage, MainMenu mainMenu) {
        VBox root = new VBox(10);

        // Título de la ventana, se le puede asignar ID para tests si se desea
        Label titulo = new Label("Solicitud de Turno");
        // ID opcional para facilitar las pruebas por ID en lugar de texto
        // titulo.setId("solicitudDeTurnoLabel");

        // Etiqueta de error visible cuando faltan campos
        Label errorLabel = new Label();
        errorLabel.setId("errorLabel");
        errorLabel.setVisible(false);

        TextField nombre = new TextField();
        nombre.setPromptText("Nombre del cliente");
        nombre.setId("nombreField");

        TextField documento = new TextField();
        documento.setPromptText("Documento");
        documento.setId("documentoField");

        TextField telefono = new TextField();
        telefono.setPromptText("Teléfono");
        telefono.setId("telefonoField");

        TextField compania = new TextField();
        compania.setPromptText("Compañía de seguro");
        compania.setId("companiaField");

        TextField marca = new TextField();
        marca.setPromptText("Marca del vehículo");
        marca.setId("marcaField");

        TextField modelo = new TextField();
        modelo.setPromptText("Modelo del vehículo");
        modelo.setId("modeloField");

        TextField poliza = new TextField();
        poliza.setPromptText("Número de póliza");
        poliza.setId("polizaField");

        ComboBox<String> especialidad = new ComboBox<>();
        especialidad.getItems().addAll("Mecánica general", "Electricidad", "Chapa y pintura");
        especialidad.setPromptText("Especialidad");
        especialidad.setId("especialidadCombo");

        ComboBox<String> horario = new ComboBox<>();
        horario.getItems().addAll("8:00 AM", "10:00 AM", "2:00 PM");
        horario.setPromptText("Horario");
        horario.setId("horarioCombo");

        Button confirmar = new Button("Confirmar Turno");
        confirmar.setId("confirmarButton");

        Button volver = new Button("Volver");
        volver.setId("volverButton");
        volver.setOnAction(e -> mainMenu.start(primaryStage));

        confirmar.setOnAction(e -> {
            // Validación de campos obligatorios
            if (nombre.getText().trim().isEmpty() ||
                    documento.getText().trim().isEmpty() ||
                    telefono.getText().trim().isEmpty() ||
                    compania.getText().trim().isEmpty()) {
                errorLabel.setText("Todos los campos son obligatorios.");
                errorLabel.setVisible(true);
                return;
            }

            try {
                TurnoDAO turnoDAO = new TurnoDAO();
                int nuevoId = turnoDAO.getNextId();

                LocalDate fecha = LocalDate.parse("2024-12-08", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                String horaSeleccionada = horario.getValue();
                if (horaSeleccionada == null || horaSeleccionada.isEmpty()) {
                    errorLabel.setText("Debe seleccionar un horario.");
                    errorLabel.setVisible(true);
                    return;
                }

                LocalTime horaPar = LocalTime.parse(horaSeleccionada, DateTimeFormatter.ofPattern("h:mm a"));

                // Crear y guardar el turno
                Turno nuevoTurno = new Turno(
                        nuevoId,
                        fecha,
                        horaPar,
                        "pendiente",
                        null
                );

                turnoDAO.guardarTurno(nuevoTurno);
                System.out.println("Turno confirmado y guardado exitosamente.");

                // Volver al menú principal
                mainMenu.start(primaryStage);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        root.getChildren().addAll(
                titulo, errorLabel,
                nombre, documento, telefono, compania,
                marca, modelo, poliza, especialidad, horario,
                confirmar, volver
        );

        primaryStage.setScene(new Scene(root, 400, 500));
        primaryStage.setTitle("Solicitud de Turno");
    }
}

