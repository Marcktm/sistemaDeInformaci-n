// Listados.java
package com.supercharger;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Listados {
    public void startWithBackButton(Stage primaryStage, MainMenu mainMenu) {
        VBox root = new VBox(10);

        // Agregar Label con "Listados"
        Label titulo = new Label("Listados");

        ComboBox<String> especialidad = new ComboBox<>();
        especialidad.getItems().addAll("Mecánica general", "Electricidad", "Chapa y pintura");
        especialidad.setPromptText("Seleccione especialidad");

        TextArea detalles = new TextArea();
        detalles.setPromptText("Detalles de los listados");

        Button exportar = new Button("Exportar Listado");
        Button volver = new Button("Volver");
        volver.setOnAction(e -> mainMenu.start(primaryStage));

        root.getChildren().addAll(titulo, especialidad, detalles, exportar, volver);

        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.setTitle("Listados");
    }
}
