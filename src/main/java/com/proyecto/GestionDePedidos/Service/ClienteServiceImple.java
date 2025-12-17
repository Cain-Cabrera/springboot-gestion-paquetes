package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.ClienteRequestDTO;
import com.proyecto.GestionDePedidos.DTO.ClienteResponseDTO;
import com.proyecto.GestionDePedidos.Mapper.ClienteMapper;
import com.proyecto.GestionDePedidos.Repository.ClienteRepository;
import com.proyecto.GestionDePedidos.validatorService.ClienteValidator;
import com.proyecto.GestionDePedidos.models.Cliente;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cain
 */
@Service
public class ClienteServiceImple implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteValidator clienteValidator;
    private final ClienteMapper clienteMapper;
    private static final Logger logger = LoggerFactory.getLogger(ClienteServiceImple.class);

    public ClienteServiceImple(ClienteRepository clienteRepository, ClienteValidator clienteValidator, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteValidator = clienteValidator;
        this.clienteMapper = clienteMapper;
    }
    
    private Cliente findByidEntity(Long id) {
        logger.trace("Se ejecuta implementacion privada para buscar entidad via id");
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado"));
    }
    
    @Override
    public ClienteResponseDTO createCliente(ClienteRequestDTO clienteDto) {
        logger.trace("Se ejecuta metodo createCliente para dar de alta una entidad Cliente");
        clienteValidator.validarClienteDTO(clienteDto);
        Cliente cliente = clienteMapper.mapperCreateEntidad(clienteDto);
        clienteRepository.save(cliente);
        logger.info("Cliente dado de alta con exito..");
        return clienteMapper.toResponse(cliente);
    }

    @Override
    public ClienteResponseDTO updateCliente(Long id, ClienteRequestDTO clienteDto) {
        logger.trace("Se ejecuta updateCliente para actualizar informacion del cliente..");
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado."));
        clienteValidator.validarClienteDTO(clienteDto);
        clienteMapper.mapperUpdateEntidad(clienteDto, clienteExistente);
        clienteRepository.save(clienteExistente);
        logger.info("Cliente con id {} actualizado con exito..", id );
        return clienteMapper.toResponse(clienteExistente);
    }

    @Override
    public void deleteCliente(Long id) {
        logger.trace("Se ejecuta deleteCliente para borrar Cliente..");
        if (id <= 0) {
            logger.error("ID inválido para borrar Cliente: {}" , id);
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        
        Cliente cliente = findByidEntity(id);
        clienteRepository.deleteById(id);
        logger.info("Cliente con id {} borrado con exito.. ", id);  
    }

    @Override
    public List<ClienteResponseDTO> findAll() {
        logger.trace("Se ejecuta findAll para mostrar todos los clientes");
        List<Cliente> listaDeClientes = clienteRepository.findAll();
        return clienteMapper.toResponseList(listaDeClientes);
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        logger.trace("Se ejecuta medoto findById para buscar un Cliente..");
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        logger.info("Cliente con id {} encontrado con exito", id);
        return clienteMapper.toResponse(cliente);
    }
}
