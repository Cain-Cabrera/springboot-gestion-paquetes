package com.proyecto.GestionDePedidos.Mapper;

import com.proyecto.GestionDePedidos.DTO.ClienteRequestDTO;
import com.proyecto.GestionDePedidos.DTO.ClienteResponseDTO;
import com.proyecto.GestionDePedidos.models.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
/**
 *
 * @author Cain
 */
@Component
public class ClienteMapper {
    
    public Cliente mapperCreateEntidad(ClienteRequestDTO clientedto) {
        Cliente clienteEntity = new Cliente();
        clienteEntity.setNombre(clientedto.getNombre());
        clienteEntity.setApellido(clientedto.getApellido());
        clienteEntity.setDni(clientedto.getDni());
        return clienteEntity;
    }
    
    public void mapperUpdateEntidad(ClienteRequestDTO dto, Cliente clienteExistente) {
        clienteExistente.setNombre(dto.getNombre());
        clienteExistente.setApellido(dto.getApellido());
        clienteExistente.setDni(dto.getDni());
    }
    
    public ClienteResponseDTO toResponse(Cliente cliente) {
        ClienteResponseDTO clienteReponse = new ClienteResponseDTO();
        clienteReponse.setId(cliente.getIdCliente());
        clienteReponse.setApellido(cliente.getApellido());
        clienteReponse.setNombre(cliente.getNombre());
        return clienteReponse;
    }
    
    public List<ClienteResponseDTO> toResponseList(List<Cliente> listaClientes) {
        List<ClienteResponseDTO> clientes = new ArrayList<>();
        for (Cliente cliente : listaClientes) {
            clientes.add(toResponse(cliente));
        }
        return clientes;
    }
}
