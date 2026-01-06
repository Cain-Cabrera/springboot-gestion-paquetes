/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.GestionDePedidos.testdata;

import com.proyecto.GestionDePedidos.models.Cliente;
import com.proyecto.GestionDePedidos.models.DetalleDePedido;
import com.proyecto.GestionDePedidos.models.EstadoPedido;
import com.proyecto.GestionDePedidos.models.Pedido;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cain
 */
public class PedidoTestBuilder {

    private Long idPedido;
    private LocalDate fecha;
    private EstadoPedido estado;
    private Cliente cliente;
    private List<DetalleDePedido> detalles;

    private PedidoTestBuilder() {
        this.idPedido = 1L;
        this.fecha = LocalDate.now();
        this.estado = EstadoPedido.EN_PREPARACION;
        this.cliente = ClienteTestBuilder.unCliente().build();
        this.detalles = new ArrayList<>();
    }

    public static PedidoTestBuilder unPedido() {
        return new PedidoTestBuilder();
    }

    public PedidoTestBuilder conIdPedido(Long idPedido) {
        this.idPedido = idPedido;
        return this;
    }

    public PedidoTestBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public PedidoTestBuilder conEstado(EstadoPedido estado) {
        this.estado = estado;
        return this;
    }

    public PedidoTestBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public PedidoTestBuilder conDetalles(List<DetalleDePedido> detalles) {
        this.detalles = detalles;
        return this;
    }

    public Pedido build() {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(idPedido);
        pedido.setFecha(fecha);
        pedido.setEstado(estado);
        pedido.setCliente(cliente);
        pedido.setDetalleDelPedido(detalles);
        return pedido;
    }
}
