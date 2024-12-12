// FichaMecanica.java
package com.supercharger;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FichaMecanica {
    public void startWithBackButton(Stage primaryStage, MainMenu mainMenu) {
        VBox root = new VBox(10);

        // Agregar Label con "Ficha Mecánica"
        Label titulo = new Label("Ficha Mecánica");

        TextField infoVehiculo = new TextField("Información del vehículo");
        TextArea actividades = new TextArea("Descripción de actividades realizadas");
        Button guardar = new Button("Guardar Ficha");
        Button volver = new Button("Volver");
        volver.setOnAction(e -> mainMenu.start(primaryStage));

        root.getChildren().addAll(titulo, infoVehiculo, actividades, guardar, volver);

        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.setTitle("Ficha Mecánica");
    }
}
