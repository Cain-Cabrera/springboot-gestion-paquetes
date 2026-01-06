package com.proyecto.GestionDePedidos.testdata;

import com.proyecto.GestionDePedidos.DTO.ProductoRequestDTO;

/**
 *
 * @author Cain
 */
public class ProductoRequestTestBuilder {

    private String nombre;
    private double precio;
    private int stock;

    private ProductoRequestTestBuilder() {
        this.nombre = "Producto Test";
        this.precio = 100.0;
        this.stock = 10;
    }

    public static ProductoRequestTestBuilder unProductoRequest() {
        return new ProductoRequestTestBuilder();
    }

    public ProductoRequestTestBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoRequestTestBuilder conPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoRequestTestBuilder conStock(int stock) {
        this.stock = stock;
        return this;
    }

    public ProductoRequestDTO build() {
        return new ProductoRequestDTO(nombre, precio, stock);
    }
}

