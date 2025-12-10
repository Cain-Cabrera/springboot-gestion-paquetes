package com.proyecto.GestionDePedidos.Mapper;

import com.proyecto.GestionDePedidos.DTO.PedidoRequestDTO;
import com.proyecto.GestionDePedidos.models.Cliente;
import com.proyecto.GestionDePedidos.models.Pedido;
import org.springframework.stereotype.Component;

/**
 *
 * @author Cain
 */
@Component
public class PedidoMapper {
    
    public Pedido toEntity(PedidoRequestDTO pedidoDto, Cliente cliente) {
        Pedido pedidoEntity = new Pedido();
        pedidoEntity.setFecha(pedidoDto.getFecha());
        pedidoEntity.setEstado(pedidoDto.getEstado());
        pedidoEntity.setCliente(cliente);
        return pedidoEntity;
    }
    
    public void updateEntity(Pedido pedidoExistente, PedidoRequestDTO pedidoDto) {
        pedidoExistente.setEstado(pedidoDto.getEstado());
        pedidoExistente.setFecha(pedidoDto.getFecha());
    }
}
