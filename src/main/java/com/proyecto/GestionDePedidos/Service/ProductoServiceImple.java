package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.models.Producto;
import java.util.List;

/**
 *
 * @author Cain
 */
public interface ProductoServiceImple {
    Producto createProducto(Producto entidad);
    Producto updateProducto(Long id, Producto entidad);
    void deleteProducto (Long id);  
    List<Producto> findAll();
    Producto findById(Long id);
}
