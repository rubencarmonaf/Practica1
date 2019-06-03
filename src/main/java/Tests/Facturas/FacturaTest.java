package Tests.Facturas;

import static org.junit.Assert.*;

import Excepciones.*;
import Facturas.Factura;
import Llamadas.Llamada;
import Tarifas.TarifaBasica;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;


import es.uji.www.GeneradorDatosINE;
import InterfazUsuario.Modelo.ImplementacionModelo;

import java.util.Calendar;

import Clientes.Cliente;
import Clientes.Direccion;


public class FacturaTest {
    private ImplementacionModelo gestion;
    private GeneradorDatosINE generador;
    private Cliente cliente;
    private Llamada llamada1;
    private Llamada llamada2;
    private Llamada llamada3;
    private Factura factura;

    @Before
    public void init() throws ExistingClientException, NonExistingClientException {
        gestion = new ImplementacionModelo();
        generador = new GeneradorDatosINE();
        cliente = new Cliente(generador.getNombre(), generador.getNIF(),
                new Direccion(12345, generador.getPoblacion(generador.getProvincia()), generador.getProvincia()),
                "empresa@empresa.com",Calendar.getInstance(),new TarifaBasica(10));
        llamada1 = new Llamada(666777888, Calendar.getInstance(), 20);
        llamada2 = new Llamada(666777888, Calendar.getInstance(), 10);
        llamada3 = new Llamada(777888999, Calendar.getInstance(), 18);
        gestion.darDeAltaCliente(cliente);


        Calendar fechaFacturacion = Calendar.getInstance();
        fechaFacturacion.set(Calendar.MONTH, fechaFacturacion.get(Calendar.MONTH) - 1);
        factura = new Factura(0, new TarifaBasica(10), fechaFacturacion, 8);

        gestion.darDeAltaLlamada(cliente.getNIF(), llamada1);
        gestion.darDeAltaLlamada(cliente.getNIF(), llamada2);
        gestion.darDeAltaLlamada(cliente.getNIF(), llamada3);

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
    public void testEmitirFactura() throws NonExistingClientException {
        Calendar fechaFacturacion = Calendar.getInstance();
        fechaFacturacion.set(Calendar.MONTH, fechaFacturacion.get(Calendar.MONTH)-1);
        Factura aux = gestion.emitirFactura(cliente.getNIF(), fechaFacturacion);

        assertEquals(factura.getCodigo(),aux.getCodigo());
        assertEquals(factura.getTarifa().getEuromin(),aux.getTarifa().getEuromin(),1);
        assertEquals(factura.getImporte(),aux.getImporte(),1);
    }

    @Test
    public void testRecuperarDatosFacturaCodigo() throws NonExistingBillException, NonExistingClientException {
        try {
            gestion.recuperarDatosFacturaCodigo(0);
            fail();
        }catch(NonExistingBillException ex) {
            assertEquals(ex.getMessage(), "La factura con el código solicitado no existe");
        }

        Calendar fechaFacturacion = Calendar.getInstance();
        fechaFacturacion.set(Calendar.MONTH, fechaFacturacion.get(Calendar.MONTH)-1);
        gestion.emitirFactura(cliente.getNIF(), fechaFacturacion);

        assertNotNull(gestion.recuperarDatosFacturaCodigo(0));
    }

    @Test
    public void testRecuperarFacturas() throws NonExistingClientException, ListLlamadasNullExecption {
        try {
            gestion.recuperarFacturas(cliente.getNIF());
        }catch(NonExistingClientException ex) {
            assertEquals(ex.getMessage(), "El cliente no se ha encontrado");
        }

        Calendar fechaFacturacion = Calendar.getInstance();
        fechaFacturacion.set(Calendar.MONTH, fechaFacturacion.get(Calendar.MONTH)-1);
        gestion.emitirFactura(cliente.getNIF(), fechaFacturacion);

        assertNotNull(gestion.recuperarFacturas(cliente.getNIF()));
    }

}