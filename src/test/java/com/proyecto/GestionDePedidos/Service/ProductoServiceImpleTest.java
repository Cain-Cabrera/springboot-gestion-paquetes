package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.ProductoRequestDTO;
import com.proyecto.GestionDePedidos.DTO.ProductoResponseDTO;
import com.proyecto.GestionDePedidos.Exception.ProductoNotFoundException;
import com.proyecto.GestionDePedidos.Mapper.ProductoMapper;
import com.proyecto.GestionDePedidos.Repository.ProductoRepository;
import com.proyecto.GestionDePedidos.models.Producto;
import com.proyecto.GestionDePedidos.testdata.ProductoRequestTestBuilder;
import com.proyecto.GestionDePedidos.testdata.ProductoTestBuilder;
import com.proyecto.GestionDePedidos.validatorService.ProductoValidator;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Cain
 */
@ExtendWith(MockitoExtension.class)
public class ProductoServiceImpleTest {

    @Mock
    private ProductoRepository productoRepository;

    @Mock
    private ProductoValidator productoValidator;

    @Mock
    private ProductoMapper productoMapper;

    @InjectMocks
    private ProductoServiceImple productoService;

    @Test
    void createProducto_productoValido_productoCreado() {
        ProductoRequestDTO request = ProductoRequestTestBuilder.unProductoRequest()
                .conNombre("Teclado")
                .conPrecio(1500.0)
                .conStock(5)
                .build();

        Producto producto = ProductoTestBuilder.unProducto()
                .conId(null)
                .conNombre("Teclado")
                .conPrecio(1500.0)
                .conStock(5)
                .build();

        ProductoResponseDTO response = new ProductoResponseDTO(
                "Teclado", 1500.0, 5
        );

        response.setId(1L);

        doNothing().when(productoValidator)
                .validarAlta(request);
        when(productoMapper.toEntity(request))
                .thenReturn(producto);
        when(productoRepository.save(producto))
                .thenReturn(producto);
        when(productoMapper.toResponse(producto))
                .thenReturn(response);

        ProductoResponseDTO resultado = productoService.createProducto(request);

        assertNotNull(resultado);
        assertEquals("Teclado", resultado.getNombre());

        verify(productoValidator).validarAlta(request);
        verify(productoRepository).save(producto);

    }

    @Test
    void createProducto_productoInvalido_lanzaExcepcion() {
        ProductoRequestDTO request = ProductoRequestTestBuilder.unProductoRequest()
                .conNombre("")
                .build();

        doThrow(new IllegalArgumentException("Error validación"))
                .when(productoValidator).validarAlta(request);

        assertThrows(IllegalArgumentException.class,
                () -> productoService.createProducto(request));

        verify(productoRepository, never()).save(any());
    }

    @Test
    void updateProducto_productoExistente_actualizadoCorrectamente() {
        Long id = 1L;

        ProductoRequestDTO request = ProductoRequestTestBuilder.unProductoRequest()
                .conNombre("Mouse")
                .conPrecio(2000.0)
                .conStock(3)
                .build();

        Producto productoExistente = ProductoTestBuilder.unProducto()
                .conId(id)
                .build();

        ProductoResponseDTO response = new ProductoResponseDTO(
                "Mouse", 2000.0, 3
        );
        response.setId(id);

        doNothing().when(productoValidator).validarAlta(request);
        when(productoRepository.findById(id))
                .thenReturn(Optional.of(productoExistente));
        doNothing().when(productoMapper).updateEntity(request, productoExistente);
        when(productoRepository.save(productoExistente))
                .thenReturn(productoExistente);
        when(productoMapper.toResponse(productoExistente))
                .thenReturn(response);

        ProductoResponseDTO resultado = productoService.updateProducto(id, request);

        assertEquals(id, resultado.getId());
        assertEquals("Mouse", resultado.getNombre());
    }

    @Test
    void updateProducto_productoNoExiste_lanzaExcepcion() {
        Long id = 99L;

        ProductoRequestDTO request = ProductoRequestTestBuilder.unProductoRequest().build();

        doNothing().when(productoValidator).validarAlta(request);
        when(productoRepository.findById(id))
                .thenReturn(Optional.empty());

        assertThrows(ProductoNotFoundException.class,
                () -> productoService.updateProducto(id, request));
    }

    @Test
    void findById_idValido_productoEncontrado() {
        Long id = 1L;

        Producto producto = ProductoTestBuilder.unProducto()
                .conId(id)
                .build();

        ProductoResponseDTO response = new ProductoResponseDTO();
        response.setId(id);

        when(productoRepository.findById(id))
                .thenReturn(Optional.of(producto));
        when(productoMapper.toResponse(producto))
                .thenReturn(response);

        ProductoResponseDTO resultado = productoService.findById(id);

        assertEquals(id, resultado.getId());
    }
    
    @Test
    void findById_idInvalido_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> productoService.findById(0L));

        verify(productoRepository, never()).findById(any());
    }

    @Test
    void findAll_devuelveListaProductos() {
    List<Producto> productos = List.of(
            ProductoTestBuilder.unProducto().build(),
            ProductoTestBuilder.unProducto().build()
    );

    List<ProductoResponseDTO> responses = List.of(
            new ProductoResponseDTO(),
            new ProductoResponseDTO()
    );

    when(productoRepository.findAll())
            .thenReturn(productos);
    when(productoMapper.toResponseList(productos))
            .thenReturn(responses);

    List<ProductoResponseDTO> resultado = productoService.findAll();

    assertEquals(2, resultado.size());
    }

    @Test
    void deleteProducto_productoExistente_eliminado() {
    Long id = 1L;

    Producto producto = ProductoTestBuilder.unProducto()
            .conId(id)
            .build();

    when(productoRepository.findById(id))
            .thenReturn(Optional.of(producto));

    productoService.deleteProducto(id);

    verify(productoRepository).delete(producto);
    }
    
    @Test
    void deleteProducto_idInvalido_lanzaExcepcion() {
    assertThrows(IllegalArgumentException.class,
            () -> productoService.deleteProducto(-1L));

    verify(productoRepository, never()).delete(any());
    }
}
