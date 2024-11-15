package com.example.demo.service;

import com.example.demo.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private PersonaService personaService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Persona persona = personaService.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + email));

        return User.builder()
            .username(persona.getEmail())
            .password(persona.getPassword())
            .roles("USER")
            .build();
    }
}