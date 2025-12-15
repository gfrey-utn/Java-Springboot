package com.ejemplo.articulos.controller;

import com.ejemplo.articulos.model.Articulo;
import com.ejemplo.articulos.service.ArticuloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/articulos")
public class ArticuloController {

    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping
    public List<Articulo> listar() {
        return articuloService.listarArticulos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articulo> obtenerPorId(@PathVariable Long id) {
        return articuloService.obtenerArticuloPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Articulo crear(@RequestBody Articulo articulo) {
        return articuloService.guardarArticulo(articulo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Articulo> actualizar(@PathVariable Long id, @RequestBody Articulo articulo) {
        if (articuloService.obtenerArticuloPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Articulo actualizado = articuloService.actualizarArticulo(id, articulo);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (articuloService.obtenerArticuloPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        articuloService.eliminarArticulo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public List<Articulo> buscar(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Double minPrecio, 
            @RequestParam(required = false) Double maxPrecio
    ) {

        if (nombre != null && minPrecio != null && maxPrecio != null) {
            return articuloService.buscarPorNombreYPrecioEntre(nombre, minPrecio, maxPrecio);
        }

        if (nombre != null && minPrecio == null && maxPrecio == null) {
            return articuloService.buscarPorNombre(nombre);
        }

        if (nombre == null && minPrecio != null && maxPrecio != null) {
            return articuloService.buscarPorPrecioEntre(minPrecio, maxPrecio);
        }

        if (minPrecio != null && maxPrecio == null && nombre == null) {
            return articuloService.buscarPorPrecioMinimo(minPrecio);
        }

        if (maxPrecio != null && minPrecio == null && nombre == null) {
            return articuloService.buscarPorPrecioMaximo(maxPrecio);
        }

        return articuloService.listarArticulos();
    }
}