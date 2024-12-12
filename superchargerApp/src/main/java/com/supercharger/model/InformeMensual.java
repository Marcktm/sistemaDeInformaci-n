package com.supercharger.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "InformeMensual")
public class InformeMensual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String companiaSeguro;

    @Column(nullable = false, length = 255)
    private String servicios;

    @ManyToOne
    @JoinColumn(name = "ficha_id", nullable = false)
    private FichaMecanica fichaMecanica;

    public InformeMensual() {}

    public InformeMensual(int id, String companiaSeguro, String servicios, FichaMecanica fichaMecanica) {
        this.id = id;
        this.companiaSeguro = companiaSeguro;
        this.servicios = servicios;
        this.fichaMecanica = fichaMecanica;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompaniaSeguro() {
        return companiaSeguro;
    }

    public void setCompaniaSeguro(String companiaSeguro) {
        this.companiaSeguro = companiaSeguro;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public FichaMecanica getFichaMecanica() {
        return fichaMecanica;
    }

    public void setFichaMecanica(FichaMecanica fichaMecanica) {
        this.fichaMecanica = fichaMecanica;
    }

    // toString
    @Override
    public String toString() {
        return "InformeMensual{" +
                "id=" + id +
                ", companiaSeguro='" + companiaSeguro + '\'' +
                ", servicios='" + servicios + '\'' +
                ", fichaMecanica=" + fichaMecanica +
                '}';
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, companiaSeguro, servicios, fichaMecanica);
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InformeMensual that = (InformeMensual) obj;
        return id == that.id &&
                Objects.equals(companiaSeguro, that.companiaSeguro) &&
                Objects.equals(servicios, that.servicios) &&
                Objects.equals(fichaMecanica, that.fichaMecanica);
    }
}
