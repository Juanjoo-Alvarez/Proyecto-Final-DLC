package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usermacbook
 */
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

    public Persona obtenerPorId(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        personaRepository.deleteById(id);
    }
}
