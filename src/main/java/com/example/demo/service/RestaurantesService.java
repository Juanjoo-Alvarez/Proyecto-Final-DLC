package com.example.demo.service;

import com.example.demo.model.Restaurantes;
import com.example.demo.repository.RestaurantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantesService {

    @Autowired
    private RestaurantesRepository restaurantesRepository;

    public List<Restaurantes> listarTodos() {
        return restaurantesRepository.findAll();
    }
    

    public Restaurantes agregarResena(Long id, Double nuevaCalificacion) {
        // Busca el restaurante por ID
        Optional<Restaurantes> restauranteOpt = restaurantesRepository.findById(id);
        
        if (restauranteOpt.isPresent()) {
            Restaurantes restaurante = restauranteOpt.get();

            // Calcula el nuevo promedio de calificaciones
            Integer numeroResenas = restaurante.getNumeroResenas();
            Double promedioActual = restaurante.getPromedio();

            // Actualización de promedio usando una fórmula acumulativa
            Double nuevoPromedio = ((promedioActual * numeroResenas) + nuevaCalificacion) / (numeroResenas + 1);

            // Actualiza el promedio y el número de reseñas
            restaurante.setPromedio(nuevoPromedio);
            restaurante.setNumeroResenas(numeroResenas + 1);

            // Guarda los cambios en la base de datos
            return restaurantesRepository.save(restaurante);
        } else {
            throw new RuntimeException("Restaurante no encontrado con ID: " + id);
        }
    }
}
