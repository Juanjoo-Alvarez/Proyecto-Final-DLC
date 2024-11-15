package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author usermacbook
 */
public class RestaurantController {
    
    @GetMapping("/resenas")
    public String mostrarResena(@RequestParam String restaurantName, Model model) {
        model.addAttribute("restaurantName", restaurantName); // Agregar el nombre al modelo
        return "resenas"; // Nombre de tu archivo HTML de reseñas
}
}
