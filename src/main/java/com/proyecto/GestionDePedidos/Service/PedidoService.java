package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.PedidoRequestDTO;
import com.proyecto.GestionDePedidos.DTO.PedidoResponseDTO;
import java.util.List;

/**
 *
 * @author Cain
 */
public interface PedidoService {
    PedidoResponseDTO createPedido(PedidoRequestDTO pedidoDto);
    List<PedidoResponseDTO> findAll();
    PedidoResponseDTO findById(Long id);
    PedidoResponseDTO updatePedido(PedidoRequestDTO pedidoDto);
    void deletePedido(Long id);
}
