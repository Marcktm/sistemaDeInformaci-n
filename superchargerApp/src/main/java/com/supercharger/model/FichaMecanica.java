package com.supercharger.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FichaMecanica")
public class FichaMecanica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 255)
    private String actividades;

    @Column(nullable = false, length = 255)
    private String insumos;

    @OneToOne
    @JoinColumn(name = "turno_id", nullable = false)
    private Turno turno;

    public FichaMecanica() {}

    public FichaMecanica(int id, String actividades, String insumos, Turno turno) {
        this.id = id;
        this.actividades = actividades;
        this.insumos = insumos;
        this.turno = turno;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getInsumos() {
        return insumos;
    }

    public void setInsumos(String insumos) {
        this.insumos = insumos;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    // toString
    @Override
    public String toString() {
        return "FichaMecanica{" +
                "id=" + id +
                ", actividades='" + actividades + '\'' +
                ", insumos='" + insumos + '\'' +
                ", turno=" + turno +
                '}';
    }

    // hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id, actividades, insumos, turno);
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FichaMecanica that = (FichaMecanica) obj;
        return id == that.id &&
                Objects.equals(actividades, that.actividades) &&
                Objects.equals(insumos, that.insumos) &&
                Objects.equals(turno, that.turno);
    }
}
