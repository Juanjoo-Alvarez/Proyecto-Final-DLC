package com.example.demo.controller;

import com.example.demo.model.Restaurantes;
import com.example.demo.service.RestaurantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurantes")
public class RestaurantController {

    @Autowired
    private RestaurantesService restaurantesService;

    @PostMapping("/{id}/agregarResena")
    public Restaurantes agregarResena(@PathVariable Long id, @RequestParam Double calificacion) {
        // Llama al servicio para actualizar la calificación
        return restaurantesService.agregarResena(id, calificacion);
    }
}
