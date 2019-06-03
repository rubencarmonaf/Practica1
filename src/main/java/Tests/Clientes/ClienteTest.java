package Tests.Clientes;

import static org.junit.Assert.*;

import Clientes.Cliente;
import Clientes.Direccion;
import Clientes.Empresa;
import Clientes.Particular;
import Tarifas.TarifaBasica;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.uji.www.GeneradorDatosINE;
import Excepciones.NonExistingClientException;
import Excepciones.ExistingClientException;
import Excepciones.ListClientsNullExecption;
import InterfazUsuario.Modelo.ImplementacionModelo;

import java.util.Calendar;


public class ClienteTest {
    private ImplementacionModelo gestion;
    private GeneradorDatosINE generador;
    private Cliente empresa;
    private Cliente particular;
    private Cliente hombre;
    private Cliente mujer;

    @Before
    public void init() {
        gestion = new ImplementacionModelo();
        generador = new GeneradorDatosINE();
        empresa = new Empresa(generador.getNombre(), generador.getNIF(),
                new Direccion(12345, generador.getPoblacion(generador.getProvincia()), generador.getProvincia()),
                "empresa@empresa.com",Calendar.getInstance(),new TarifaBasica(5));
        particular = new Particular(generador.getNombre(),generador.getApellido(), generador.getNIF(),
                new Direccion(23456, generador.getPoblacion(generador.getProvincia()), generador.getProvincia()),
                "particular@particular.com",Calendar.getInstance(),new TarifaBasica(10));
        hombre = new Particular(generador.getNombreHombre(),generador.getApellido(), generador.getNIF(),
                new Direccion(34567, generador.getPoblacion(generador.getProvincia()), generador.getProvincia()),
                "hombre@hombre.com",Calendar.getInstance(),new TarifaBasica(7));
        mujer =new Particular(generador.getNombreMujer(),generador.getApellido(), generador.getNIF(),
                new Direccion(45678, generador.getPoblacion(generador.getProvincia()), generador.getProvincia()),
                "mujer@mujer.com",Calendar.getInstance(),new TarifaBasica(8));
    }

    @After
    public void finish() {
        gestion=null;
        generador=null;
        empresa=null;
        particular=null;
        hombre=null;
        mujer=null;
    }

    @Test
    public void testDarDeAltaCliente() throws ExistingClientException {
        assertTrue(gestion.darDeAltaCliente(empresa));
        assertTrue(gestion.darDeAltaCliente(particular));
        assertTrue(gestion.darDeAltaCliente(hombre));
        assertTrue(gestion.darDeAltaCliente(mujer));
    }

    @Test
    public void testBorrarCliente() throws ExistingClientException, NonExistingClientException {
        gestion.darDeAltaCliente(empresa);
        gestion.darDeAltaCliente(particular);
        gestion.darDeAltaCliente(hombre);
        gestion.darDeAltaCliente(mujer);

        assertTrue(gestion.borrarCliente(empresa.getNIF()));
        assertTrue(gestion.borrarCliente(particular.getNIF()));
        assertTrue(gestion.borrarCliente(hombre.getNIF()));
        assertTrue(gestion.borrarCliente(mujer.getNIF()));
    }

    @Test
    public void testCambiarTarifa() throws ExistingClientException, NonExistingClientException {
        gestion.darDeAltaCliente(empresa);
        gestion.darDeAltaCliente(particular);
        gestion.darDeAltaCliente(hombre);
        gestion.darDeAltaCliente(mujer);

        assertTrue(gestion.cambiarTarifa(empresa.getNIF(), new TarifaBasica(1)));
        assertTrue(gestion.cambiarTarifa(particular.getNIF(), new TarifaBasica(1)));
        assertTrue(gestion.cambiarTarifa(hombre.getNIF(), new TarifaBasica(1)));
        assertTrue(gestion.cambiarTarifa(mujer.getNIF(), new TarifaBasica(1)));
    }

    @Test
    public void testRecuperarDatosNIF() throws ExistingClientException, NonExistingClientException {
        gestion.darDeAltaCliente(empresa);
        gestion.darDeAltaCliente(particular);
        gestion.darDeAltaCliente(hombre);
        gestion.darDeAltaCliente(mujer);

        assertNotNull(gestion.recuperarDatosNIF(empresa.getNIF()));
        assertNotNull(gestion.recuperarDatosNIF(particular.getNIF()));
        assertNotNull(gestion.recuperarDatosNIF(hombre.getNIF()));
        assertNotNull(gestion.recuperarDatosNIF(mujer.getNIF()));

    }

    @Test
    public void testRecuperarListadoClientes() throws ExistingClientException, ListClientsNullExecption {
        gestion.darDeAltaCliente(empresa);
        gestion.darDeAltaCliente(particular);
        gestion.darDeAltaCliente(hombre);
        gestion.darDeAltaCliente(mujer);

        assertNotNull(gestion.recuperarListadoClientes());
    }

}