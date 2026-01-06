/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.GestionDePedidos.testdata;

import com.proyecto.GestionDePedidos.DTO.DetallePedidoRequestDTO;

/**
 *
 * @author Cain
 */
public class DetallePedidoRequestTestBuilder {

    private Long idProducto;
    private Integer cantidad;

    private DetallePedidoRequestTestBuilder() {
        this.idProducto = 1L;
        this.cantidad = 1;
    }

    public static DetallePedidoRequestTestBuilder unDetallePedidoRequest() {
        return new DetallePedidoRequestTestBuilder();
    }

    public DetallePedidoRequestTestBuilder conIdProducto(Long idProducto) {
        this.idProducto = idProducto;
        return this;
    }

    public DetallePedidoRequestTestBuilder conCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public DetallePedidoRequestDTO build() {
        return new DetallePedidoRequestDTO(idProducto, cantidad);
    }
}