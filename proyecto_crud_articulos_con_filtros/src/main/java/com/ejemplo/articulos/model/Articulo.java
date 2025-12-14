package com.ejemplo.articulos.model; // Paquete donde se encuentra la entidad Articulo

// Importamos todas las anotaciones de JPA con jakarta.persistence
import jakarta.persistence.Entity;       // Marca la clase como entidad JPA
import jakarta.persistence.Table;        // Permite personalizar el nombre de la tabla
import jakarta.persistence.Id;           // Indica el campo que será clave primaria
import jakarta.persistence.GeneratedValue; // Indica que el valor será generado automáticamente
import jakarta.persistence.GenerationType; // Tipo de estrategia de generación de la clave primaria
import jakarta.persistence.Column;       // Permite personalizar el nombre y propiedades de columnas

/**
 * Clase de dominio que representa a un Articulo en el sistema.
 * Esta clase se mapea a una tabla de base de datos usando JPA.
 */
@Entity // Indica que esta clase es una entidad persistente
@Table(name = "articulo") // Nombre de la tabla asociada en la base de datos
public class Articulo { // Declaración de la clase pública Articulo

    @Id // Indica que el campo id es la clave primaria de la entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Usa autoincremental de la base de datos (IDENTITY)
    @Column(name = "id") // Nombre de la columna en la tabla (opcional, aquí solo lo explicitamos)
    private Long id; // Identificador único del articulo

    @Column(name = "nombre", nullable = false, length = 200) // Columna para el nombre, obligatorio, largo máximo 200
    private String nombre; // Nombre o descripción corta del artículo

    @Column(name = "precio", nullable = false) // Columna para el precio, obligatorio
    private Double precio; // Precio del artículo

    @Column(name = "imagen", nullable = true, length = 500) // Columna para la URL o ruta de la imagen (puede ser null)
    private String imagen; // URL o ruta de la imagen representativa del artículo

    /**
     * Constructor vacío requerido por JPA.
     * Es obligatorio para que el framework pueda instanciar la entidad.
     */
    public Articulo() {}

    /**
     * Constructor completo para crear instancias de Articulo fácilmente en el código.
     * No es usado por JPA directamente, pero es útil para nuestra lógica de negocio.
     */
    public Articulo(Long id, String nombre, Double precio, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
