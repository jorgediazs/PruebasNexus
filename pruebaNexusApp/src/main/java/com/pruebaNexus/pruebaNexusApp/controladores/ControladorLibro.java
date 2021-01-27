package com.pruebaNexus.pruebaNexusApp.controladores;

import com.pruebaNexus.pruebaNexusApp.repositorio.RepositorioLibros;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ControladorLibro {

    private final RepositorioLibros repositorioLibros;

    public ControladorLibro(RepositorioLibros repositorioLibros){
        this.repositorioLibros = repositorioLibros;
    }

    @RequestMapping("/libros")
    public String getLibros(Model model){
        model.addAttribute(attributeName: "libros", repositorioLibros.findAll());

        return "libros";
    }

}
