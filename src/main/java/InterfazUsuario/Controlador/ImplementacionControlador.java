package InterfazUsuario.Controlador;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import Clientes.Cliente;
import Clientes.ClienteFactory;
import Clientes.Direccion;
import Excepciones.*;
import Facturas.Factura;
import InterfazUsuario.Modelo.Modelo;
import Llamadas.Llamada;
import Tarifas.Tarifa;


public class ImplementacionControlador implements Controlador{

    private Modelo modelo;


    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public boolean creaCliente(int tipo, String nombre, String apellidos, String nif, Direccion dir, String correo, Calendar fecha, Tarifa tarifa) throws ExistingClientException {
        Cliente cliente = ClienteFactory.crearCliente(tipo, nombre, apellidos, nif, dir, correo, fecha, tarifa);
        return modelo.darDeAltaCliente(cliente);

    }

    public boolean borrarCliente(String nif) throws NonExistingClientException {
        return modelo.borrarCliente(nif);
    }

    public boolean cambiarTarifa(String nif, Tarifa tarifa) throws NonExistingClientException {
        return modelo.cambiarTarifa(nif, tarifa);
    }

    public Cliente recuperarDatosCliente(String nif) throws NonExistingClientException {
        return modelo.recuperarDatosNIF(nif);

    }

    public HashMap<String, Cliente> recuperaListadoClientes() throws ListClientsNullExecption {
        return modelo.recuperarListadoClientes();

    }

    public Collection<Cliente> recuperaListadoClientesEntreFechas(Calendar fechaInicio, Calendar fechaFin) throws ListClientsNullExecption, IllegalPeriodException{
        return modelo.mostrarListadoClientesFechas(fechaInicio, fechaFin);
    }

    public boolean darDeAltaLlamada(String nif, Llamada llamada) throws NonExistingClientException{
        return modelo.darDeAltaLlamada(nif, llamada);
    }

    public List<Llamada> listarLlamadasCliente(String nif) throws NonExistingClientException{
        return modelo.listarLlamadasCliente(nif);
    }

    public Collection<Llamada> mostrarListadoLlamadasFechas(String nif, Calendar fechaInicio, Calendar fechaFin) throws ListLlamadasNullExecption, IllegalPeriodException, NonExistingClientException{
        return modelo.mostrarListadoLlamadasFechas(nif, fechaInicio, fechaFin);
    }

    public Factura emitirFactura(String nif, Calendar fechaFacturacion) throws NonExistingClientException{
        return modelo.emitirFactura(nif, fechaFacturacion);
    }

    public Factura recuperarDatosFacturaCodigo(Integer codigo) throws NonExistingBillException {
        return modelo.recuperarDatosFacturaCodigo(codigo);
    }

    public List<Factura> recuperarFacturas(String nif) throws NonExistingClientException, ListLlamadasNullExecption{
        return modelo.recuperarFacturas(nif);
    }

    public Collection<Factura> mostrarListadoFacturasFechas(String nif, Calendar fechaInicio, Calendar fechaFin) throws NonExistingClientException, ListLlamadasNullExecption, IllegalPeriodException{
        return modelo.mostrarListadoFacturasFechas(nif, fechaInicio, fechaFin);
    }


}
