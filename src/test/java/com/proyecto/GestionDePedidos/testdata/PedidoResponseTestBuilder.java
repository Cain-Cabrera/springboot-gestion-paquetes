package com.proyecto.GestionDePedidos.testdata;

import com.proyecto.GestionDePedidos.DTO.PedidoResponseDTO;
import com.proyecto.GestionDePedidos.models.EstadoPedido;
import java.time.LocalDate;

/**
 *
 * @author Cain
 */
public class PedidoResponseTestBuilder {
    private Long idPedido;
    private Long idCliente;
    private LocalDate fecha;
    private EstadoPedido estado;

    private PedidoResponseTestBuilder() {
        this.idPedido = 1L;
        this.idCliente = 1L;
        this.fecha = LocalDate.now();
        this.estado = EstadoPedido.EN_PREPARACION;
    }

    public static PedidoResponseTestBuilder unPedidoResponse() {
        return new PedidoResponseTestBuilder();
    }

    public PedidoResponseTestBuilder conIdPedido(Long idPedido) {
        this.idPedido = idPedido;
        return this;
    }

    public PedidoResponseTestBuilder conIdCliente(Long idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public PedidoResponseTestBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public PedidoResponseTestBuilder conEstado(EstadoPedido estado) {
        this.estado = estado;
        return this;
    }

    public PedidoResponseDTO build() {
        PedidoResponseDTO dto = new PedidoResponseDTO();
        dto.setIdPedido(idPedido);
        dto.setIdCliente(idCliente);
        dto.setFecha(fecha);
        dto.setEstado(estado);
        return dto;
    }
}

