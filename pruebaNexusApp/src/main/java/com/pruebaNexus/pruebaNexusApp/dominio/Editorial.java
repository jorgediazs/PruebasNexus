package com.pruebaNexus.pruebaNexusApp.dominio;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String NombreEditorial;
    private String DireccionCorrespondencia;
    private String TelefonoEditorial;
    private String CorreoElectronicoEditorial;
    private int MaxNumLibrosRegistrados;

    @OneToMany
    @JoinColumn(name="editorial_id")
    private Set<Libro> libros = new HashSet<>();

    public Editorial() {

    }

    public Editorial(String nombreEditorial, String direccionCorrespondencia, String telefonoEditorial,
                     String correoElectronicoEditorial, int maxNumLibrosRegistrados, Set<Libro> libros) {
        NombreEditorial = nombreEditorial;
        DireccionCorrespondencia = direccionCorrespondencia;
        TelefonoEditorial = telefonoEditorial;
        CorreoElectronicoEditorial = correoElectronicoEditorial;
        MaxNumLibrosRegistrados = maxNumLibrosRegistrados;

    }

    public String getNombreEditorial() {
        return NombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        NombreEditorial = nombreEditorial;
    }

    public String getDireccionCorrespondencia() {
        return DireccionCorrespondencia;
    }

    public void setDireccionCorrespondencia(String direccionCorrespondencia) {
        DireccionCorrespondencia = direccionCorrespondencia;
    }

    public String getTelefonoEditorial() {
        return TelefonoEditorial;
    }

    public void setTelefonoEditorial(String telefonoEditorial) {
        TelefonoEditorial = telefonoEditorial;
    }

    public String getCorreoElectronicoEditorial() {
        return CorreoElectronicoEditorial;
    }

    public void setCorreoElectronicoEditorial(String correoElectronicoEditorial) {
        CorreoElectronicoEditorial = correoElectronicoEditorial;
    }

    public int getMaxNumLibrosRegistrados() {
        return MaxNumLibrosRegistrados;
    }

    public void setMaxNumLibrosRegistrados(int maxNumLibrosRegistrados) {
        MaxNumLibrosRegistrados = maxNumLibrosRegistrados;
    }

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "id=" + id +
                ", NombreEditorial='" + NombreEditorial + '\'' +
                ", DireccionCorrespondencia='" + DireccionCorrespondencia + '\'' +
                ", TelefonoEditorial='" + TelefonoEditorial + '\'' +
                ", CorreoElectronicoEditorial='" + CorreoElectronicoEditorial + '\'' +
                ", MaxNumLibrosRegistrados=" + MaxNumLibrosRegistrados +
                ", libros=" + libros +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Editorial editorial = (Editorial) o;

        return id != null ? id.equals(editorial.id) : editorial.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
