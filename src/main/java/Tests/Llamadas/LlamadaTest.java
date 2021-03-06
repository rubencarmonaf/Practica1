package Tests.Llamadas;

import static org.junit.Assert.*;

import Llamadas.Llamada;
import Tarifas.TarifaBasica;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;


import es.uji.www.GeneradorDatosINE;
import Excepciones.NonExistingClientException;
import Excepciones.ExistingClientException;
import InterfazUsuario.Modelo.ImplementacionModelo;

import java.util.Calendar;

import Clientes.Cliente;
import Clientes.Direccion;


public class LlamadaTest {
    private ImplementacionModelo gestion;
    private GeneradorDatosINE generador;
    private Cliente cliente;
    private Llamada llamada1;
    private Llamada llamada2;
    private Llamada llamada3;

    @Before
    public void init() throws ExistingClientException {
        gestion = new ImplementacionModelo();
        generador = new GeneradorDatosINE();
        cliente = new Cliente(generador.getNombre(), generador.getNIF(),
                new Direccion(12345, generador.getPoblacion(generador.getProvincia()), generador.getProvincia()),
                "empresa@empresa.com",Calendar.getInstance(),new TarifaBasica(5));
        llamada1 = new Llamada(666777888,Calendar.getInstance(),2);
        llamada2 = new Llamada(666777888,Calendar.getInstance(),6);
        llamada3 = new Llamada(777888999,Calendar.getInstance(),3);
        gestion.darDeAltaCliente(cliente);
    }

    @After
    public void finish() {
        gestion = null;
        generador = null;
        cliente = null;
        llamada1 = null;
        llamada2 = null;
        llamada3 = null;
    }

    @Test
    public void testDarDeAltaLlamada() throws NonExistingClientException {
        assertTrue(gestion.darDeAltaLlamada(cliente.getNIF(), llamada1));
        assertTrue(gestion.darDeAltaLlamada(cliente.getNIF(), llamada2));
        assertTrue(gestion.darDeAltaLlamada(cliente.getNIF(), llamada3));

    }

    @Test
    public void testListarLlamadasCliente() throws NonExistingClientException {
        gestion.darDeAltaLlamada(cliente.getNIF(), llamada1);
        gestion.darDeAltaLlamada(cliente.getNIF(), llamada2);
        gestion.darDeAltaLlamada(cliente.getNIF(), llamada3);

        assertNotNull(gestion.listarLlamadasCliente(cliente.getNIF()));
    }

}