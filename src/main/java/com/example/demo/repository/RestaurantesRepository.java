package com.example.demo.repository;

import com.example.demo.model.Restaurantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantesRepository extends JpaRepository<Restaurantes, Long> {
}
