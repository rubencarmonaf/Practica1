package InterfazUsuario.Controlador;

import Clientes.Cliente;
import Clientes.Direccion;
import Excepciones.*;
import Facturas.Factura;
import Llamadas.Llamada;
import Tarifas.Tarifa;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface Controlador {
    boolean creaCliente(int tipo, String nombre, String apellidos, String nif, Direccion dir, String correo, Calendar fecha, Tarifa tarifa) throws ExistingClientException;
    boolean borrarCliente(String nif) throws NonExistingClientException;
    boolean cambiarTarifa(String nif, Tarifa tarifa) throws NonExistingClientException;
    Cliente recuperarDatosCliente(String nif) throws NonExistingClientException;
    HashMap<String, Cliente> recuperaListadoClientes() throws ListClientsNullExecption;
    Collection<Cliente> recuperaListadoClientesEntreFechas(Calendar fechaInicio, Calendar fechaFin) throws ListClientsNullExecption, IllegalPeriodException;
    boolean darDeAltaLlamada(String nif, Llamada llamada) throws NonExistingClientException;
    List<Llamada> listarLlamadasCliente(String nif) throws NonExistingClientException;
    Collection<Llamada> mostrarListadoLlamadasFechas(String nif, Calendar fechaInicio, Calendar fechaFin) throws ListLlamadasNullExecption, IllegalPeriodException, NonExistingClientException;
    Factura emitirFactura(String nif, Calendar fechaFacturacion) throws NonExistingClientException;
    Factura recuperarDatosFacturaCodigo(Integer codigo) throws NonExistingBillException;
    List<Factura> recuperarFacturas(String nif) throws NonExistingClientException, ListLlamadasNullExecption;
    Collection<Factura> mostrarListadoFacturasFechas(String nif, Calendar fechaInicio, Calendar fechaFin) throws NonExistingClientException, ListLlamadasNullExecption, IllegalPeriodException;
}
