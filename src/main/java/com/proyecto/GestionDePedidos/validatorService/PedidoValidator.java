package com.proyecto.GestionDePedidos.validatorService;

import com.proyecto.GestionDePedidos.DTO.PedidoRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author Cain
 */
@Component
public class PedidoValidator {
    private static final Logger logger = LoggerFactory.getLogger(PedidoValidator.class);
    
    public void validarAltaPedido(PedidoRequestDTO pedidoDto) {
        if (pedidoDto.getEstado() == null) {
            logger.error("El estado del pedido llego vacio.");
            throw new IllegalArgumentException("El estado del pedido no puede venir vacio..");
        }
        
        if (pedidoDto.getFecha() == null) {
            logger.error("La fecha del pedido llego vacia.");
            throw new IllegalArgumentException("La fecha del pedido no puede venir vacia..");
        }
        
        if (pedidoDto.getIdCliente() <= 0) {
            logger.error("El ID llego incorrecto..");
            throw new IllegalArgumentException("El id no puede ser negativo..");
        }
    }
}
