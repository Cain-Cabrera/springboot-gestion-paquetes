/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.GestionDePedidos.testdata;

import com.proyecto.GestionDePedidos.DTO.DetallePedidoReponseDTO;
import com.proyecto.GestionDePedidos.DTO.ProductoResponseDTO;

/**
 *
 * @author Cain
 */
public class DetallePedidoResponseTestBuilder {

    private ProductoResponseDTO producto;
    private Integer cantidad;
    private Double precioUnitario;

    private DetallePedidoResponseTestBuilder() {
        this.producto = ProductoResponseTestBuilder.unProductoResponse().build();
        this.cantidad = 1;
        this.precioUnitario = 100.0;
    }

    public static DetallePedidoResponseTestBuilder unDetallePedidoResponse() {
        return new DetallePedidoResponseTestBuilder();
    }

    public DetallePedidoResponseTestBuilder conProducto(ProductoResponseDTO producto) {
        this.producto = producto;
        return this;
    }

    public DetallePedidoResponseTestBuilder conCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public DetallePedidoResponseTestBuilder conPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
        return this;
    }

    public DetallePedidoReponseDTO build() {
        return new DetallePedidoReponseDTO(producto, cantidad, precioUnitario);
    }
}
