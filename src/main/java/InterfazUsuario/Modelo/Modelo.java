package InterfazUsuario.Modelo;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import Clientes.Cliente;
import Excepciones.*;
import Facturas.Factura;
import Llamadas.Llamada;
import Tarifas.Tarifa;

public interface Modelo {

    // Cliente
    boolean darDeAltaCliente(Cliente cliente) throws ExistingClientException;
    boolean borrarCliente(String nif) throws NonExistingClientException;
    boolean cambiarTarifa(String nif, Tarifa tarifa) throws NonExistingClientException ;
    Cliente recuperarDatosNIF(String nif) throws NonExistingClientException;
    HashMap<String, Cliente> recuperarListadoClientes() throws ListClientsNullExecption;
    Collection<Cliente> mostrarListadoClientesFechas(Calendar fechaInicio, Calendar fechaFin) throws IllegalPeriodException, ListClientsNullExecption;

    // Llamadas
    boolean darDeAltaLlamada(String nif, Llamada llamada) throws NonExistingClientException ;
    List<Llamada> listarLlamadasCliente(String nif) throws NonExistingClientException ;
    Collection<Llamada> mostrarListadoLlamadasFechas(String nif, Calendar fechaInicio, Calendar fechaFin) throws ListLlamadasNullExecption, IllegalPeriodException, NonExistingClientException;

    // Facturas
    Factura emitirFactura(String nif, Calendar fechaFacturacion) throws NonExistingClientException;
    Factura recuperarDatosFacturaCodigo(Integer codigo) throws NonExistingBillException;
    List<Factura> recuperarFacturas(String nif) throws NonExistingClientException, ListLlamadasNullExecption ;
    Collection<Factura> mostrarListadoFacturasFechas(String nif, Calendar fechaInicio, Calendar fechaFin) throws NonExistingClientException, ListLlamadasNullExecption, IllegalPeriodException ;

    // Datos
    void guardarDatos() ;
    void cargarDatos() ;
}