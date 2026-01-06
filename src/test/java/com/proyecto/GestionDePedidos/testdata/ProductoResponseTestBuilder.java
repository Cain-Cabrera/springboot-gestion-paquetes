package com.proyecto.GestionDePedidos.testdata;

import com.proyecto.GestionDePedidos.DTO.ProductoResponseDTO;

/**
 *
 * @author Cain
 */
public class ProductoResponseTestBuilder {

    private Long id;
    private String nombre;
    private Double precio;
    private int stock;

    private ProductoResponseTestBuilder() {
        this.id = 1L;
        this.nombre = "Producto Test";
        this.precio = 100.0;
        this.stock = 10;
    }

    public static ProductoResponseTestBuilder unProductoResponse() {
        return new ProductoResponseTestBuilder();
    }

    public ProductoResponseTestBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ProductoResponseTestBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoResponseTestBuilder conPrecio(Double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoResponseTestBuilder conStock(int stock) {
        this.stock = stock;
        return this;
    }

    public ProductoResponseDTO build() {
        ProductoResponseDTO dto = new ProductoResponseDTO(nombre, precio, stock);
        dto.setId(id);
        return dto;
    }
}
