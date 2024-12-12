// InformesMensuales.java
package com.supercharger;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InformesMensuales {
    public void startWithBackButton(Stage primaryStage, MainMenu mainMenu) {
        VBox root = new VBox(10);

        // Agregar Label con "Informes Mensuales"
        Label titulo = new Label("Informes Mensuales");

        ComboBox<String> compania = new ComboBox<>();
        compania.getItems().addAll("Aseguradora 1", "Aseguradora 2", "Aseguradora 3");
        compania.setPromptText("Seleccione compañía aseguradora");

        TextArea servicios = new TextArea();
        servicios.setPromptText("Servicios realizados");

        Button generar = new Button("Generar Informe");
        Button volver = new Button("Volver");
        volver.setOnAction(e -> mainMenu.start(primaryStage));

        root.getChildren().addAll(titulo, compania, servicios, generar, volver);

        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.setTitle("Informes Mensuales");
    }
}

