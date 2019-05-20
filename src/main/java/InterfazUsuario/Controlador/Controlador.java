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
    public boolean creaCliente(int tipo, String nombre, String apellidos, String nif, Direccion dir, String correo, Calendar fecha, Tarifa tarifa) throws ExistingClientException;
    public boolean borrarCliente(String nif) throws NonExistingClientException;
    public boolean cambiarTarifa(String nif, Tarifa tarifa) throws NonExistingClientException;
    public Cliente recuperarDatosCliente(String nif) throws NonExistingClientException;
    public HashMap<String, Cliente> recuperaListadoClientes() throws ListClientsNullExecption;
    public Collection<Cliente> recuperaListadoClientesEntreFechas(Calendar fechaInicio, Calendar fechaFin) throws ListClientsNullExecption, IllegalPeriodException;
    public boolean darDeAltaLlamada(String nif, Llamada llamada) throws NonExistingClientException;
    public List<Llamada> listarLlamadasCliente(String nif) throws NonExistingClientException;
    public Collection<Llamada> mostrarListadoLlamadasFechas(String nif, Calendar fechaInicio, Calendar fechaFin) throws ListLlamadasNullExecption, IllegalPeriodException, NonExistingClientException;
    public Factura emitirFactura(String nif, Calendar fechaFacturacion) throws NonExistingClientException;
    public Factura recuperarDatosFacturaCodigo(Integer codigo) throws NonExistingBillException;
    public List<Factura> recuperarFacturas(String nif) throws NonExistingClientException, ListLlamadasNullExecption;
    public Collection<Factura> mostrarListadoFacturasFechas(String nif, Calendar fechaInicio, Calendar fechaFin) throws NonExistingClientException, ListLlamadasNullExecption, IllegalPeriodException;
}
