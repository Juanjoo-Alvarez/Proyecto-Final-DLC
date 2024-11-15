package com.example.demo.controller;


//se importan las librerias necesarias
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.RestaurantesService;


//se crea la clase HomeController
@Controller
public class HomeController {

    //se inyecta el servicio de restaurantes
    @Autowired
    private RestaurantesService restaurantesService;

    //se crea el metodo para mostrar la pagina principal
    @GetMapping("/HomePage")
    public String mostrarHomePage(Model model) {
        // Obtén la lista de restaurantes desde el servicio y añádela al modelo
        model.addAttribute("restaurantes", restaurantesService.listarTodos());
        return "mainPage";
    }
}
