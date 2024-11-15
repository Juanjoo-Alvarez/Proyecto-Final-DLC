package com.example.demo.service;

import com.example.demo.model.Restaurantes;
import com.example.demo.repository.RestaurantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantesService {

    @Autowired
    private RestaurantesRepository restaurantesRepository;

    public List<Restaurantes> listarTodos() {
        return restaurantesRepository.findAll();
    }
}
