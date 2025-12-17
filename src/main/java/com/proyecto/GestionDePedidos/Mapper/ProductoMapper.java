package com.proyecto.GestionDePedidos.Mapper;

import com.proyecto.GestionDePedidos.DTO.ProductoRequestDTO;
import com.proyecto.GestionDePedidos.DTO.ProductoResponseDTO;
import com.proyecto.GestionDePedidos.models.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cain
 */
public class ProductoMapper {
    
    public Producto toEntity(ProductoRequestDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        return producto;
    }

    
    public void updateEntity(ProductoRequestDTO productoDTO, Producto productoExistente) {
        productoExistente.setNombre(productoDTO.getNombre());
        productoExistente.setPrecio(productoDTO.getPrecio());
        productoExistente.setStock(productoDTO.getStock());
    }
    
    public ProductoResponseDTO toResponse(Producto producto) {
        ProductoResponseDTO productoResponse = new ProductoResponseDTO();
        productoResponse.setId(producto.getIdProducto());
        productoResponse.setNombre(producto.getNombre());
        productoResponse.setPrecio(producto.getPrecio());
        productoResponse.setStock(producto.getStock());
        return productoResponse;
    }
    
    public List<ProductoResponseDTO> toResponseList(List<Producto> listaDeProductos) {
        List<ProductoResponseDTO> listaResponse = new ArrayList<>();
        for (Producto producto : listaDeProductos) {
            listaResponse.add(toResponse(producto));
        }
        return listaResponse;
    }
}
    

