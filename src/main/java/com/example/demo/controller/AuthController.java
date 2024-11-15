package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    
    @Autowired
    private PersonaService personaService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String login() {
        return "index";
    }
    
    @PostMapping("/register")
    public String registerUser(Persona persona, RedirectAttributes redirectAttributes) {
        // Verificar si el email ya existe
        if (personaService.existeEmail(persona.getEmail())) {
            redirectAttributes.addFlashAttribute("error", "El email ya está registrado");
            return "redirect:/login";
        }
        
        // Encriptar la contraseña
        persona.setPassword(passwordEncoder.encode(persona.getPassword()));
        
        try {
            personaService.guardar(persona);
            redirectAttributes.addFlashAttribute("success", "Registro exitoso. Por favor, inicia sesión");
            return "redirect:/login";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al registrar el usuario");
            return "redirect:/login";
        }
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout=true";
    }
}