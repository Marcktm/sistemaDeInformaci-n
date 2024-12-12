// RegistroAsistencia.java
package com.supercharger;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegistroAsistencia {
    public void startWithBackButton(Stage primaryStage, MainMenu mainMenu) {
        VBox root = new VBox(10);

        // Agregar Label con "Registro de Asistencia"
        Label titulo = new Label("Registro de Asistencia");

        TextField documento = new TextField("Ingrese el documento");
        Label turnoInfo = new Label("Información del turno:");
        Button registrar = new Button("Registrar Asistencia");
        registrar.setOnAction(e -> turnoInfo.setText("Asistencia registrada para el documento: " + documento.getText()));

        Button volver = new Button("Volver");
        volver.setOnAction(e -> mainMenu.start(primaryStage));

        root.getChildren().addAll(titulo, documento, turnoInfo, registrar, volver);

        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.setTitle("Registro de Asistencia");
    }
}
