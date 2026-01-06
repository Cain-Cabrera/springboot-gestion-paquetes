package com.proyecto.GestionDePedidos.testdata;

import com.proyecto.GestionDePedidos.models.DetalleDePedido;
import com.proyecto.GestionDePedidos.models.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cain
 */
public class ProductoTestBuilder {

    private Long idProducto;
    private String nombre;
    private Double precio;
    private int stock;
    private List<DetalleDePedido> detalles;

    private ProductoTestBuilder() {
        this.idProducto = 1L;
        this.nombre = "Producto Test";
        this.precio = 100.0;
        this.stock = 10;
        this.detalles = new ArrayList<>();
    }

    public static ProductoTestBuilder unProducto() {
        return new ProductoTestBuilder();
    }

    public ProductoTestBuilder conId(Long idProducto) {
        this.idProducto = idProducto;
        return this;
    }

    public ProductoTestBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoTestBuilder conPrecio(Double precio) {
        this.precio = precio;
        return this;
    }

    public ProductoTestBuilder conStock(int stock) {
        this.stock = stock;
        return this;
    }

    public ProductoTestBuilder conDetalles(List<DetalleDePedido> detalles) {
        this.detalles = detalles;
        return this;
    }

    public Producto build() {
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setDetalles(detalles);
        return producto;
    }
}

