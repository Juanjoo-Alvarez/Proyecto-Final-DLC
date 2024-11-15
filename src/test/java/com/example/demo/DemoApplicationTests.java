package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // Esta prueba verifica que el contexto de Spring se carga correctamente
    }
    
    // Puedes añadir más pruebas aquí si lo necesitas
    @Test
    void testEnvironment() {
        // Esta prueba solo verifica que el ambiente de pruebas funciona
        assert(true);
    }
}