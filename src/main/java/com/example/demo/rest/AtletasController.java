package com.example.demo.rest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController // indica que esta clase es un controlador de tipo rest
@RequestMapping("/Atletas")

public class AtletasController {


    // Mapeo a la pagina de inicio
    @GetMapping("/consultaInicial") 

    public String consultaInicial() {
        return "Aquí se mostrará una tabla con los atletas actuales de nuestra base de datos";
    }
}