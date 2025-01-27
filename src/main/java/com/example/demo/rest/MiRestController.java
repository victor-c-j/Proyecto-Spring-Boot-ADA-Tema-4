package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController // indica que esta clase es un controlador de tipo rest
@RequestMapping("/saludos")
public class MiRestController {

    // Mapeo a la pagina de inicio
    @GetMapping("/holaAlumnos") // cremaos el método que devuelve un mensaje al realizar el mapeo,
    // esta anotación indica que el método saludo,
    // va a manejar a las solicitudes get a partir de este endpoint, esta ruta, la /,
    // y devolverá esta cadena de texto.
    public String saludo() {
        return "Hola alumnos";
    }

    @GetMapping("/saludoNombreEdad/{nombre}/{edad}") // endpoint asociado a este método,
    // con el orden de los parámetros de entrada que va a recibir, no es obligatorio
    // que esté en el mismo orden, pero se recomienda por
    // convención
    //EJEMPLO DE USO EN NAVEGADOR:
        //localhost:8080/saludos/saludoNombreEdad/ManuelVico/99
    public String holaMundoNombre(@PathVariable String nombre, @PathVariable int edad) {
        // pathvariabel indica que esta variable se corresponde con uno de los
        // parámetros de entrada que vamos a encontrar en el endpoint
        // que usará el usuario o el front end
        return "Hola " + nombre + " , tu edad es: " + edad;
    }
}
