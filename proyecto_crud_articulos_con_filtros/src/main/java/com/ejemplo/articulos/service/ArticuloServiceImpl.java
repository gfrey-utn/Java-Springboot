package com.ejemplo.articulos.service;

import com.ejemplo.articulos.model.Articulo;
import com.ejemplo.articulos.repository.ArticuloRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ArticuloServiceImpl implements ArticuloService {

    private final ArticuloRepository articuloRepository;

    public ArticuloServiceImpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override
    public List<Articulo> listarArticulos() {
        return articuloRepository.findAll();
    }
    
    @Override
    public Optional<Articulo> obtenerArticuloPorId(Long id) {
        return articuloRepository.findById(id);
    }

    @Override
    public Articulo guardarArticulo(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public Articulo actualizarArticulo(Long id, Articulo articulo) {
        articulo.setId(id);
        return articuloRepository.save(articulo);
    }

    @Override
    public void eliminarArticulo(Long id) {
        articuloRepository.deleteById(id);
    }

    @Override
    public List<Articulo> buscarPorNombre(String nombre) {
        return articuloRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Articulo> buscarPorPrecioMinimo(Double precioMinimo) {
        return articuloRepository.findByPrecioGreaterThanEqual(precioMinimo);
    }

    @Override
    public List<Articulo> buscarPorPrecioMaximo(Double precioMaximo) {
        return articuloRepository.findByPrecioLessThanEqual(precioMaximo);
    }

    @Override
    public List<Articulo> buscarPorPrecioEntre(Double precioMinimo, Double precioMaximo) {
        return articuloRepository.findByPrecioBetween(precioMinimo, precioMaximo);
    }

    @Override
    public List<Articulo> buscarPorNombreYPrecioEntre(String nombre, Double precioMinimo, Double precioMaximo) {
        return articuloRepository.findByNombreContainingIgnoreCaseAndPrecioBetween(nombre, precioMinimo, precioMaximo);
    }
}