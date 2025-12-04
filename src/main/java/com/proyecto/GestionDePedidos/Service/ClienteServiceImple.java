package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.models.Cliente;
import java.util.List;
/**
 *
 * @author Cain
 */
public interface ClienteServiceImple {
    Cliente createCliente(Cliente entidad);
    Cliente updateCliente(Long id, Cliente entidad);
    void deleteCliente (Long id);  
    List<Cliente> findAll();
    Cliente findById(Long id);
}
