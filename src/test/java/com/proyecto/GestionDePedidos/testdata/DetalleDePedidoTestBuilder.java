/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.GestionDePedidos.testdata;

import com.proyecto.GestionDePedidos.models.DetalleDePedido;
import com.proyecto.GestionDePedidos.models.Pedido;
import com.proyecto.GestionDePedidos.models.Producto;

/**
 *
 * @author Cain
 */
public class DetalleDePedidoTestBuilder {

    private Long id;
    private Integer cantidad;
    private Double precioUnitario;
    private Pedido pedido;
    private Producto producto;

    private DetalleDePedidoTestBuilder() {
        this.id = 1L;
        this.cantidad = 1;
        this.precioUnitario = 100.0;
        this.pedido = PedidoTestBuilder.unPedido().build();
        this.producto = ProductoTestBuilder.unProducto().build();
    }

    public static DetalleDePedidoTestBuilder unDetalleDePedido() {
        return new DetalleDePedidoTestBuilder();
    }

    public DetalleDePedidoTestBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public DetalleDePedidoTestBuilder conCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public DetalleDePedidoTestBuilder conPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
        return this;
    }

    public DetalleDePedidoTestBuilder conPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public DetalleDePedidoTestBuilder conProducto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public DetalleDePedido build() {
        DetalleDePedido detalle = new DetalleDePedido();
        detalle.setId(id);
        detalle.setCantidad(cantidad);
        detalle.setPrecioUnitario(precioUnitario);
        detalle.setPedido(pedido);
        detalle.setProducto(producto);
        return detalle;
    }
}
