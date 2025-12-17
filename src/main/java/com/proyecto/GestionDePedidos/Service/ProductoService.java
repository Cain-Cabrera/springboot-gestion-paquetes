package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.ProductoRequestDTO;
import com.proyecto.GestionDePedidos.DTO.ProductoResponseDTO;
import java.util.List;

/**
 *
 * @author Cain
 */
public interface ProductoService {
    ProductoResponseDTO createProducto(ProductoRequestDTO entidad);
    ProductoResponseDTO updateProducto(Long id, ProductoRequestDTO entidad);
    void deleteProducto (Long id);  
    List<ProductoResponseDTO> findAll();
    ProductoResponseDTO findById(Long id);
}
