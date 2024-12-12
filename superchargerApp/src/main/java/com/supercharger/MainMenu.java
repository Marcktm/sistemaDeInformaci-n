package com.supercharger;

import com.supercharger.model.Cliente;
import com.supercharger.util.HibernateUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainMenu extends Application {
    private Stage primaryStage;
    private static SessionFactory sessionFactory;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Comprobar si estamos en modo test
        String testEnv = System.getProperty("test.env");
        if (!"true".equalsIgnoreCase(testEnv)) {
            // Si no estamos en modo test, inicializamos la base de datos
            initializeDatabase();
        } else {
            System.out.println("Omitiendo la inicialización de la BD en entorno de prueba.");
        }

        VBox root = new VBox(10);
        root.setPadding(new Insets(15));

        Label tituloMenu = new Label("Menú Principal");
        tituloMenu.setId("menuPrincipalLabel");
        root.getChildren().add(tituloMenu);

        Button solicitarTurno = new Button("Solicitar Turno");
        Button registrarAsistencia = new Button("Registrar Asistencia");
        Button fichaMecanica = new Button("Ficha Mecánica");
        Button listados = new Button("Listados");
        Button informesMensuales = new Button("Informes Mensuales");

        solicitarTurno.setOnAction(e -> new SolicitudTurno().startWithBackButton(primaryStage, this));
        registrarAsistencia.setOnAction(e -> new RegistroAsistencia().startWithBackButton(primaryStage, this));
        fichaMecanica.setOnAction(e -> new FichaMecanica().startWithBackButton(primaryStage, this));
        listados.setOnAction(e -> new Listados().startWithBackButton(primaryStage, this));
        informesMensuales.setOnAction(e -> new InformesMensuales().startWithBackButton(primaryStage, this));

        // Estilos opcionales
        solicitarTurno.setStyle("-fx-font-size: 14px;");
        registrarAsistencia.setStyle("-fx-font-size: 14px;");
        fichaMecanica.setStyle("-fx-font-size: 14px;");
        listados.setStyle("-fx-font-size: 14px;");
        informesMensuales.setStyle("-fx-font-size: 14px;");

        root.getChildren().addAll(solicitarTurno, registrarAsistencia, fichaMecanica, listados, informesMensuales);

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Menú Principal - Supercharger");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeDatabase() {
        sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            long count = (long) session.createQuery("select count(c) from Cliente c where c.documento = :documento")
                    .setParameter("documento", "12345678")
                    .uniqueResult();

            if (count == 0) {
                Cliente testCliente = new Cliente();
                testCliente.setNombre("Cliente de prueba");
                testCliente.setDocumento("12345678");
                testCliente.setTelefono("123456789");
                session.save(testCliente);
                System.out.println("Cliente de prueba añadido.");
            } else {
                System.out.println("Cliente de prueba ya existe.");
            }

            session.getTransaction().commit();
            System.out.println("Base de datos inicializada correctamente.");
        } catch (Exception e) {
            System.err.println("Error al inicializar la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
