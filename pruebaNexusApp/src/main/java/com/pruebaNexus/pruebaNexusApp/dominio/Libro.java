package com.pruebaNexus.pruebaNexusApp.dominio;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String tituloLibro;
    private Date anoLibro;
    private String generoLibro;
    private int numeroPaginas;

    @ManyToOne
    private Editorial editorial;

    @ManyToMany
    @JoinTable(name="autor_libro", @JoinColumn(name="libro_id"), inverseJoinColumns = @JoinColumn("autor_id"))
    private Set<Autor> autores = new HashSet<>();

    public Libro() {

    }

    public Libro(String tituloLibro, Date anoLibro, String generoLibro, int numeroPaginas,
                 Set<com.pruebaNexus.pruebaNexusApp.dominio.Autor> autores) {
        this.tituloLibro = tituloLibro;
        this.anoLibro = anoLibro;
        this.generoLibro = generoLibro;
        this.numeroPaginas = numeroPaginas;
        this.autores = autores;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public Date getAnoLibro() {
        return anoLibro;
    }

    public void setAnoLibro(Date anoLibro) {
        this.anoLibro = anoLibro;
    }

    public String getGeneroLibro() {
        return generoLibro;
    }

    public void setGeneroLibro(String generoLibro) {
        this.generoLibro = generoLibro;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Set<Autor> getAutores() {
        return autores;
    }

    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", tituloLibro='" + tituloLibro + '\'' +
                ", anoLibro=" + anoLibro +
                ", generoLibro='" + generoLibro + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", autores=" + autores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Libro libro = (Libro) o;

        return id != null ? id.equals(libro.id) : libro.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
