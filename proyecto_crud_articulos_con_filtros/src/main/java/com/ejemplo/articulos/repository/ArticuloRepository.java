package com.ejemplo.articulos.repository;

import com.ejemplo.articulos.model.Articulo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

    List<Articulo> findByNombreContainingIgnoreCase(String nombre);
    List<Articulo> findByPrecioGreaterThanEqual(Double precioMinimo);
    List<Articulo> findByPrecioLessThanEqual(Double precioMaximo);
    List<Articulo> findByPrecioBetween(Double precioMinimo, Double precioMaximo);

    List<Articulo> findByNombreContainingIgnoreCaseAndPrecioBetween(
            String nombre,
            Double precioMinimo,
            Double precioMaximo
    );
}