
package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;
    
    @GetMapping
    public String listarPersonas(Model model) {
        model.addAttribute("personas", personaService.listarTodas());
        return "persona-list";
    }
    
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevaPersona(Model model) {
        model.addAttribute("persona", new Persona());
        return "persona-form";
    }
    
    @PostMapping
    public String guardarPersona(Persona persona) {
        personaService.guardar(persona);
        return "redirect:/personas";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id, Model model) {
        model.addAttribute("persona", personaService.obtenerPorId(id));
        return "persona-form";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable Long id) {
        personaService.eliminar(id);
        return "redirect:/personas";
    }
}