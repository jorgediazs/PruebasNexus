package com.pruebaNexus.pruebaNexusApp.InicializacionDatos;


import com.pruebaNexus.pruebaNexusApp.dominio.Autor;
import com.pruebaNexus.pruebaNexusApp.dominio.Editorial;
import com.pruebaNexus.pruebaNexusApp.dominio.Libro;
import com.pruebaNexus.pruebaNexusApp.repositorio.RepositorioAutor;
import com.pruebaNexus.pruebaNexusApp.repositorio.RepositorioEditorial;
import com.pruebaNexus.pruebaNexusApp.repositorio.RepositorioLibros;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class InicializarDatos implements CommandLineRunner {

    private final RepositorioAutor repositorioAutor;
    private final RepositorioLibros repositorioLibros;
    private final RepositorioEditorial repositorioEditorial;

    public InicializarDatos(RepositorioAutor repositorioAutor, RepositorioLibros repositorioLibros,
                            RepositorioEditorial repositorioEditorial){
        this.repositorioAutor = repositorioAutor;
        this.repositorioLibros = repositorioLibros;
        this.repositorioEditorial = repositorioEditorial;
    }

    @Override
    public void run(String... args) throws Exception {

        Autor pepe = new Autor("pepe", "eleuterio", "perro", "gato",
                20-20-2021, "La PM", "pepeperrogato@algo.com" );

        Libro nuevoLibro = new Libro("El arte de hablar M", 20-20-2020, "varios",
                3, pepe);

        Editorial editoriallibro = new Editorial();
        editoriallibro.setNombreEditorial("No sirve");
        editoriallibro.setTelefonoEditorial("20202020");
        editoriallibro.setDireccionCorrespondencia("Cll falsa 123");
        editoriallibro.setCorreoElectronicoEditorial("nosirve@algo.com");

        repositorioEditorial.save(editoriallibro);

        pepe.getLibros().add(nuevoLibro);
        nuevoLibro.getAutores().add(pepe);
        nuevoLibro.setEditorial(editoriallibro);
        editoriallibro.getLibros().add(nuevoLibro);

        repositorioAutor.save(pepe);
        repositorioLibros.save(nuevoLibro);
        repositorioEditorial.save(editoriallibro);
    }
}
