package com.example.demo.repository;

import com.example.demo.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author usermacbook
 */
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}
