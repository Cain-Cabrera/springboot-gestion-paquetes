package com.proyecto.GestionDePedidos.Service;


import com.proyecto.GestionDePedidos.DTO.ClienteRequestDTO;
import com.proyecto.GestionDePedidos.DTO.ClienteResponseDTO;
import java.util.List;

/**
 *
 * @author Cain
 */
public interface ClienteService {
    ClienteResponseDTO createCliente(ClienteRequestDTO entidad);
    ClienteResponseDTO updateCliente(Long id, ClienteRequestDTO entidad);
    void deleteCliente (Long id);  
    List<ClienteResponseDTO> findAll();
    ClienteResponseDTO findById(Long id);
}