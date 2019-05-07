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
    public boolean darDeAltaCliente(Cliente cliente) throws ExistingClientException;
    public boolean borrarCliente(String nif) throws NonExistingClientException;
    public boolean cambiarTarifa(String nif, Tarifa tarifa) throws NonExistingClientException ;
    public Cliente recuperarDatosNIF(String nif) throws NonExistingClientException;
    public HashMap<String, Cliente> recuperarListadoClientes() throws ListLlamadasNullExecption;
    public Collection<Cliente> mostrarListadoClientesFechas(Calendar fechaInicio, Calendar fechaFin) throws IllegalPeriodException, ListLlamadasNullExecption;


    public boolean darDeAltaLlamada(String nif, Llamada llamada) throws NonExistingClientException ;
    public List<Llamada> listarLlamadasCliente(String nif) throws NonExistingClientException ;
    public Collection<Llamada> mostrarListadoLlamadasFechas(String nif, Calendar fechaInicio, Calendar fechaFin) throws ListLlamadasNullExecption, IllegalPeriodException, NonExistingClientException;


    public Factura emitirFactura(String nif, Calendar fechaFacturacion) throws NonExistingClientException;
    public Factura recuperarDatosFacturaCodigo(Integer codigo) throws NonExistingBillException;
    public List<Factura> recuperarFacturas(String nif) throws NonExistingClientException, ListLlamadasNullExecption ;
    public Collection<Factura> mostrarListadoFacturasFechas(String nif, Calendar fechaInicio, Calendar fechaFin) throws NonExistingClientException, ListLlamadasNullExecption, IllegalPeriodException ;


    public void guardarDatos() ;
    public void cargarDatos() ;

}