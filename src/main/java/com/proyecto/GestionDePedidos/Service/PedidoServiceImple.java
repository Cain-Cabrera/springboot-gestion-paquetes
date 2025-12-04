package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.models.Pedido;
import java.util.List;

/**
 *
 * @author Cain
 */
public interface PedidoServiceImple {
    Pedido createPedido(Pedido entidad);
    List<Pedido> findAll();
    Pedido findById(Long id);
    Pedido updatePedido(Pedido entidad);
    void deletePedido(Long id);  
}
