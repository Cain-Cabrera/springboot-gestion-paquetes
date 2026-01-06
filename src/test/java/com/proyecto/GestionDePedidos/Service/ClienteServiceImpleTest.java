package com.proyecto.GestionDePedidos.Service;

import com.proyecto.GestionDePedidos.DTO.ClienteRequestDTO;
import com.proyecto.GestionDePedidos.DTO.ClienteResponseDTO;
import com.proyecto.GestionDePedidos.Exception.ClienteNotFoundException;
import com.proyecto.GestionDePedidos.Exception.InvalidIdException;
import com.proyecto.GestionDePedidos.Mapper.ClienteMapper;
import com.proyecto.GestionDePedidos.Repository.ClienteRepository;
import com.proyecto.GestionDePedidos.models.Cliente;
import com.proyecto.GestionDePedidos.testdata.ClienteRequestTestBuilder;
import com.proyecto.GestionDePedidos.testdata.ClienteResponseTestBuilder;
import com.proyecto.GestionDePedidos.testdata.ClienteTestBuilder;
import com.proyecto.GestionDePedidos.validatorService.ClienteValidator;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Cain
 */
@ExtendWith(MockitoExtension.class)
public class ClienteServiceImpleTest {

    @Mock
    private ClienteRepository clienteRepository;

    @Mock
    private ClienteMapper clienteMapper;

    @Mock
    private ClienteValidator clienteValidator;

    @InjectMocks
    private ClienteServiceImple clienteServiceImple;

    @Test
    void creatCliente_clienteCreado_siEsValido() {
        Cliente cliente = ClienteTestBuilder.unCliente()
                .conNombre("Cabrera")
                .conApellido("Cabrera")
                .conDni("440206015")
                .conPedidos(null)
                .build();

        ClienteRequestDTO clienteRequest = ClienteRequestTestBuilder.unClienteRequest()
                .conNombre("Cain")
                .conApellido("Cabrera")
                .conDni("44206015")
                .build();

        ClienteResponseDTO clienteResponse = ClienteResponseTestBuilder.unClienteResponse()
                .conNombre("Cain")
                .conApellido("Cabrera")
                .conId(1L)
                .build();

        when(clienteMapper.mapperCreateEntidad(clienteRequest))
                .thenReturn(cliente);
        when(clienteMapper.toResponse(cliente))
                .thenReturn(clienteResponse);
        when(clienteRepository.save(cliente))
                .thenReturn(cliente);

        ClienteResponseDTO resultado = clienteServiceImple.createCliente(clienteRequest);

        assertNotNull(resultado);
        assertEquals("Cabrera", resultado.getApellido());
        assertEquals("Cain", resultado.getNombre());

        verify(clienteRepository).save(cliente);
    }

    @Test
    void creatCliente_clienteNoDadoDeAlta_siNoEsValido() {
        ClienteRequestDTO clienteRequest = ClienteRequestTestBuilder.unClienteRequest()
                .conNombre(null)
                .build();

        doThrow(new IllegalArgumentException("Nombre inválido"))
                .when(clienteValidator)
                .validarClienteDTO(any(ClienteRequestDTO.class));

        assertThrows(IllegalArgumentException.class, () -> {
            clienteServiceImple.createCliente(clienteRequest);
        });
    }

    @Test
    void updateCliente_clienteActualizado_siEsValidoIdyCliente() {
        Cliente cliente = ClienteTestBuilder.unCliente()
                .conId(1L)
                .conNombre("Cain")
                .conApellido("Cabrera")
                .conDni("440206015")
                .conPedidos(null)
                .build();

        ClienteRequestDTO clienteRequest = ClienteRequestTestBuilder.unClienteRequest()
                .conNombre("Oscar")
                .conApellido("Lopez")
                .conDni("44206015")
                .build();

        ClienteResponseDTO clienteResponse = ClienteResponseTestBuilder.unClienteResponse()
                .conNombre("Oscar")
                .conApellido("Lopez")
                .conId(1L)
                .build();

        when(clienteRepository.save(cliente))
                .thenReturn(cliente);
        when(clienteMapper.toResponse(cliente))
                .thenReturn(clienteResponse);
        when(clienteRepository.findById(1L))
                .thenReturn(Optional.of(cliente));

        ClienteResponseDTO respuesta = clienteServiceImple.updateCliente(1L, clienteRequest);

        assertNotNull(respuesta);
        assertEquals(1L, respuesta.getId());
        assertEquals("Oscar", respuesta.getNombre());
        assertEquals("Lopez", respuesta.getApellido());
    }

    @Test
    void updateCliente_clienteNoActualizado_siEsInvalidoId() {
        ClienteRequestDTO clienteRequest = ClienteRequestTestBuilder.unClienteRequest()
                .conApellido("")
                .conDni("44206015")
                .build();

        when(clienteRepository.findById(-1L))
                .thenReturn(Optional.empty());

        assertThrows(ClienteNotFoundException.class, () -> {
            clienteServiceImple.updateCliente(-1L, clienteRequest);
        });

    }

    @Test
    void findbyId_ClienteEncontrado_siIdExiste() {
        Long idDeBusqueda = 1L;

        Cliente cliente = ClienteTestBuilder.unCliente()
                .conNombre("Cain")
                .conApellido("Cabrera")
                .conDni("44206015")
                .conId(1L)
                .conPedidos(null)
                .build();

        ClienteResponseDTO clienteResponse = ClienteResponseTestBuilder.unClienteResponse()
                .conNombre("Cain")
                .conApellido("Cabrera")
                .conId(1L)
                .build();

        when(clienteRepository.findById(1L))
                .thenReturn(Optional.of(cliente));

        when(clienteMapper.toResponse(cliente))
                .thenReturn(clienteResponse);

        ClienteResponseDTO respuesta = clienteServiceImple.findById(idDeBusqueda);

        assertNotNull(respuesta);
        assertEquals("Cain", respuesta.getNombre());

        verify(clienteRepository).findById(idDeBusqueda);
        verify(clienteMapper).toResponse(cliente);
    }

    @Test
    void findbyId_ClienteNoEncontrado_siIdNoExiste() {
        Long idDeBusqueda = 2L;

        when(clienteRepository.findById(2L))
                .thenReturn(Optional.empty());

        assertThrows(ClienteNotFoundException.class, () -> {
            clienteServiceImple.findById(idDeBusqueda);
        });

        verify(clienteRepository).findById(idDeBusqueda);
    }

    @Test
    void deleteCliente_ClienteBorrado_siIdExiste() {
        Long idDeBusqueda = 1L;

        Cliente cliente = ClienteTestBuilder.unCliente()
                .conNombre("Cain")
                .conApellido("Cabrera")
                .conDni("44206015")
                .conId(1L)
                .conPedidos(null)
                .build();

        when(clienteRepository.findById(idDeBusqueda))
                .thenReturn(Optional.of(cliente));

        clienteServiceImple.deleteCliente(idDeBusqueda);
        verify(clienteRepository).deleteById(idDeBusqueda);
    }

    @Test
    void deleteCliente_ClienteNoBorrado_siIdNoExiste() {
        Long idDeBusqueda = 1L;

        when(clienteRepository.findById(idDeBusqueda))
                .thenReturn(Optional.empty());

        assertThrows(ClienteNotFoundException.class, () -> {
            clienteServiceImple.deleteCliente(idDeBusqueda);
        });

        verify(clienteRepository).findById(idDeBusqueda);
    }

    @Test
    void deleteCliente_ClienteNoBorrado_siIdEsInvalido() {
        Long idDeBusqueda = -4L;
        assertThrows(InvalidIdException.class, () -> {
            clienteServiceImple.deleteCliente(idDeBusqueda);
        });
        verifyNoInteractions(clienteRepository);
    }

    @Test
    void findAll_ClientesEncontrados_devuelveListaDeClienteResponseDTO() {
        Cliente cliente1 = ClienteTestBuilder.unCliente()
                .conId(1L)
                .conNombre("Cain")
                .conApellido("Cabrera")
                .conDni("44206015")
                .build();

        Cliente cliente2 = ClienteTestBuilder.unCliente()
                .conId(2L)
                .conNombre("Oscar")
                .conApellido("Perez")
                .conDni("12345678")
                .build();

        List<Cliente> clientes = List.of(cliente1, cliente2);

        ClienteResponseDTO dto1 = ClienteResponseTestBuilder.unClienteResponse()
                .conId(1L)
                .conNombre("Cain")
                .conApellido("Cabrera")
                .build();

        ClienteResponseDTO dto2 = ClienteResponseTestBuilder.unClienteResponse()
                .conId(2L)
                .conNombre("Oscar")
                .conApellido("Perez")
                .build();

        List<ClienteResponseDTO> clientesDTO = List.of(dto1, dto2);

        when(clienteRepository.findAll())
                .thenReturn(clientes);

        when(clienteMapper.toResponseList(clientes))
                .thenReturn(clientesDTO);

        List<ClienteResponseDTO> respuesta = clienteServiceImple.findAll();

        assertNotNull(respuesta);
        assertEquals(2, respuesta.size());

        verify(clienteRepository).findAll();
        verify(clienteMapper).toResponseList(clientes);
    }
}
