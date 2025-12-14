package com.ejemplo.articulos.service; // Paquete donde se define la capa de servicio

// Importamos la entidad Articulo que será manejada por el servicio
import com.ejemplo.articulos.model.Articulo;

import java.util.List;    // List se usa para devolver listas de artículos
import java.util.Optional; // Optional se usa para evitar null al buscar por ID

/**
 * Interfaz que define el contrato del servicio de Articulo.
 * Aquí solo declaramos qué operaciones ofrece la capa de negocio.
 */
public interface ArticuloService {

    // Métodos CRUD básicos

    List<Articulo> listarArticulos();

    /**
     * Busca un artículo por su identificador único.
     */
    Optional<Articulo> obtenerArticuloPorId(Long id); // Devuelve un Optional con el artículo si existe

    Articulo guardarArticulo(Articulo articulo);

    Articulo actualizarArticulo(Long id, Articulo articulo);

    void eliminarArticulo(Long id);

    // Métodos de búsqueda con filtros

    List<Articulo> buscarPorNombre(String nombre);

    List<Articulo> buscarPorPrecioMinimo(Double precioMinimo);
    List<Articulo> buscarPorPrecioMaximo(Double precioMaximo);
    List<Articulo> buscarPorPrecioEntre(Double precioMinimo, Double precioMaximo);

    List<Articulo> buscarPorNombreYPrecioEntre(String nombre, Double precioMinimo, Double precioMaximo);
}