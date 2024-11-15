package com.example.demo.controller;

import com.example.demo.model.Restaurantes;
import com.example.demo.repository.RestaurantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReseñaController {

    @Autowired
    private RestaurantesRepository restauranteRepository;

    @GetMapping("/resenas")
    public String mostrarResena(@RequestParam String restaurantName, Model model) {
        model.addAttribute("restaurantName", restaurantName);
        return "resenas";
    }

    @PostMapping("/guardarResena")
    public ResponseEntity<String> guardarResena(
            @RequestParam String restaurantName,
            @RequestParam int rating) {

        if (rating < 1 || rating > 5) {
            return ResponseEntity.badRequest().body("La calificación debe estar entre 1 y 5");
        }

        // Buscar el restaurante por su nombre
        Restaurantes restaurante = restauranteRepository.findByNombre(restaurantName);

        if (restaurante != null) {
            // Calcular el nuevo promedio
            int totalResenas = restaurante.getNumeroResenas();
            double nuevoPromedio = ((restaurante.getPromedio() * totalResenas) + rating) / (totalResenas + 1);

            // Actualizar el promedio y el número de reseñas
            restaurante.setPromedio(nuevoPromedio);
            restaurante.setNumeroResenas(totalResenas + 1);

            // Guardar los cambios en la BD
            restauranteRepository.save(restaurante);

            return ResponseEntity.ok("Reseña guardada exitosamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Restaurante no encontrado");
        }
    }
}
