/*
 * package com.example.demo.rest;
 * 
 * import org.springframework.stereotype.Controller;
 * import org.springframework.web.bind.annotation.GetMapping;
 * 
 * 
 * 
 * @Controller//indica que esta clase es un controlador de tipo rest
 * public class MiController{
 * 
 * //Mapeo a la pagina de inicio
 * 
 * @GetMapping("/")//cremaos el método que devuelve un mensaje al realizar el
 * mapeo,
 * //esta anotación indica que el método saludo,
 * //va a manejar alas solicitudes get a partir de este endpoint, esta ruta, la
 * /, y devolverá esta cadena de texto.
 * public String saludo() {
 * return "index";//devolvemos el nombre de la plantilla html.
 * }
 * 
 * 
 * 
 * @GetMapping("/info")//cuando escribamos info en la url, se aplicará este
 * método
 * public String informacion() {
 * return "info";
 * }
 * 
 * 
 * 
 * }
 */