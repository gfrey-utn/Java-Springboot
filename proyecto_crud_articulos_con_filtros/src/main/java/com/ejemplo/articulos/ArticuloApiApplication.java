package com.ejemplo.articulos;

// Importamos la clase SpringApplication, que permite arrancar la app
import org.springframework.boot.SpringApplication;
// Importamos la anotación SpringBootApplication, que marca el punto de entrada
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Indica a Spring Boot que esta es la clase de configuración principal
public class ArticuloApiApplication { // Declaración de la clase pública

    /**
     * Método main: punto de entrada estándar de una aplicación Java.
     * Desde aquí se inicia el contexto de Spring y el servidor embebido.
     */
    public static void main(String[] args) {
        // Llamamos a run para iniciar la aplicación Spring Boot
        SpringApplication.run(ArticuloApiApplication.class, args); // Ejecuta la app levantando el contexto y el servidor
    }
}