package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.ProductoRequestDTO;
import com.proyecto.GestionDePedidos.DTO.ProductoResponseDTO;
import com.proyecto.GestionDePedidos.Exception.ProductoNotFoundException;
import com.proyecto.GestionDePedidos.Mapper.ProductoMapper;
import com.proyecto.GestionDePedidos.Repository.ProductoRepository;
import com.proyecto.GestionDePedidos.models.Producto;
import com.proyecto.GestionDePedidos.validatorService.ProductoValidator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cain
 */
@Service
public class ProductoServiceImple implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoValidator productoValidator;
    private final ProductoMapper productoMapper;
    private static final Logger logger = LoggerFactory.getLogger(ProductoServiceImple.class);

    public ProductoServiceImple(ProductoRepository productoRepository, ProductoValidator productoValidator, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoValidator = productoValidator;
        this.productoMapper = productoMapper;
    }

    private Producto findByIdEntity(Long id) {
        logger.trace("Se ejecuta metodo findByIdEntity para implementar el metodo internamente y no exponer entidad");
        return productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
    }

    @Override
    public ProductoResponseDTO createProducto(ProductoRequestDTO productoDTO) {
        logger.trace("Se ejecuta createProducto..");
        productoValidator.validarAlta(productoDTO);
        Producto producto = productoMapper.toEntity(productoDTO);
        logger.info("Producto creado con exito..");
        productoRepository.save(producto);
        return productoMapper.toResponse(producto);
    }

    @Override
    public ProductoResponseDTO updateProducto(Long id, ProductoRequestDTO productoDTO) {
        logger.trace("Se ejecuta updateProducto para actualizar producto existente..");
        productoValidator.validarAlta(productoDTO);
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
        productoMapper.updateEntity(productoDTO, productoExistente);
        productoRepository.save(productoExistente);
        logger.info("Producto actualizado con exito..");
        return productoMapper.toResponse(productoExistente);
    }

    @Override
    public void deleteProducto(Long id) {
        logger.trace("Se ejecuta deleteProducto..");
        if (id == null || id <= 0) {
            logger.error("ID inválido para borrar Producto: {}", id);
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        Producto producto = findByIdEntity(id);
        productoRepository.delete(producto);
        logger.info("Producto con id {} borrado con éxito..", id);
    }

    @Override
    public List<ProductoResponseDTO> findAll() {
        logger.trace("Se ejecuta findAll para listar productos..");
        List<Producto> listaProductos = productoRepository.findAll();
        return productoMapper.toResponseList(listaProductos);
    }

    @Override
    public ProductoResponseDTO findById(Long id) {
        logger.trace("Se ejecuta findById para buscar producto..");
        if (id == null || id <= 0) {
            logger.error("ID inválido para buscar Producto: {}", id);
            throw new IllegalArgumentException("El id debe ser mayor a 0");
        }
        Producto producto = findByIdEntity(id);
        logger.info("Producto con id {} encontrado con exito..", id);
        return productoMapper.toResponse(producto);
    }

}
