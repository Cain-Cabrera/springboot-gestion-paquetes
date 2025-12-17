package com.proyecto.GestionDePedidos.Mapper;

import com.proyecto.GestionDePedidos.DTO.PedidoRequestDTO;
import com.proyecto.GestionDePedidos.DTO.PedidoResponseDTO;
import com.proyecto.GestionDePedidos.models.Cliente;
import com.proyecto.GestionDePedidos.models.Pedido;
import java.util.ArrayList;
import java.util.List;
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
    
    public PedidoResponseDTO toResponse(Pedido pedido) {
        PedidoResponseDTO pedidoResponse = new PedidoResponseDTO();
        pedidoResponse.setIdPedido(pedido.getIdPedido());
        pedidoResponse.setEstado(pedido.getEstado());
        pedidoResponse.setFecha(pedido.getFecha());
        pedidoResponse.setIdCliente(pedido.getCliente().getIdCliente());
        return pedidoResponse;
    }
    
    public void updateEntity(Pedido pedidoExistente, PedidoRequestDTO pedidoDto) {
        pedidoExistente.setEstado(pedidoDto.getEstado());
        pedidoExistente.setFecha(pedidoDto.getFecha());
    }
    
    public List<PedidoResponseDTO> toResponseList(List<Pedido> listaDePedidos) {
        List<PedidoResponseDTO> listaResponse = new ArrayList<>();
        for (Pedido pedido : listaDePedidos) {
            listaResponse.add(toResponse(pedido));
        }
        return listaResponse;
    }
    
}
