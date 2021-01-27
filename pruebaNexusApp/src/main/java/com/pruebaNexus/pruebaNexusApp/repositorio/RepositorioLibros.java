package com.pruebaNexus.pruebaNexusApp.repositorio;

import com.pruebaNexus.pruebaNexusApp.dominio.Libro;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioLibros extends CrudRepository<Libro, Long> {
}
