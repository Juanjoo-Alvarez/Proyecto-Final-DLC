package com.example.demo.controller;

import com.example.demo.model.Restaurantes;
import com.example.demo.service.RestaurantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private RestaurantesService restaurantesService;

    @GetMapping("/HomePage")
    public String mostrarHomePage(Model model) {
        // Obtén la lista de restaurantes desde el servicio y añádela al modelo
        model.addAttribute("restaurantes", restaurantesService.listarTodos());
        return "mainPage";
    }
}
