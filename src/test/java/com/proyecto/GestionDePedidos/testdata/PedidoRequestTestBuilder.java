/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.GestionDePedidos.testdata;

import com.proyecto.GestionDePedidos.DTO.DetallePedidoRequestDTO;
import com.proyecto.GestionDePedidos.DTO.PedidoRequestDTO;
import java.util.List;



/**
 *
 * @author Cain
 */
public class PedidoRequestTestBuilder {

    private Long idCliente;
    private List<DetallePedidoRequestDTO> detalles;

    private PedidoRequestTestBuilder() {
        this.idCliente = 1L;
        this.detalles = List.of(
                DetallePedidoRequestTestBuilder.unDetallePedidoRequest().build()
        );
    }

    public static PedidoRequestTestBuilder unPedidoRequest() {
        return new PedidoRequestTestBuilder();
    }

    public PedidoRequestTestBuilder conIdCliente(Long idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public PedidoRequestTestBuilder conDetalles(List<DetallePedidoRequestDTO> detalles) {
        this.detalles = detalles;
        return this;
    }

    public PedidoRequestDTO build() {
        PedidoRequestDTO dto = new PedidoRequestDTO();
        dto.setIdCliente(idCliente);
        dto.setDetalles(detalles);
        return dto;
    }
}
