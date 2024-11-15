package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    
    @Autowired
    private PersonaRepository personaRepository;
    
    public List<Persona> listarTodas() {
        return personaRepository.findAll();
    }
    
    public Persona guardar(Persona persona) {
        return personaRepository.save(persona);
    }
    
    public Optional<Persona> obtenerPorId(Long id) {
        return personaRepository.findById(id);
    }
    
    public void eliminar(Long id) {
        personaRepository.deleteById(id);
    }
    
    public Optional<Persona> findByEmail(String email) {
        return personaRepository.findByEmail(email);
    }
    
    public boolean existeEmail(String email) {
        return personaRepository.existsByEmail(email);
    }
}