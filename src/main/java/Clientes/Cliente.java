package Clientes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import Facturas.Factura;
import Fechas.EntreFechas;
import Llamadas.Llamada;
import Tarifas.Tarifa;

public class Cliente extends EntreFechas implements Serializable {

    private static final long serialVersionUID = 4886706257783637148L;
    public String nombre;
    public String NIF;
    public Direccion direccion;
    public String correo_electronico;
    public Calendar fecha_alta;
    public Tarifa tarifa;
    public List<Llamada> listallamadas;
    public HashMap<String, Factura> Listafacturas;

    public Cliente(String nombre, String NIF, Direccion direccion, String correo_electronico, Calendar fecha_alta, Tarifa tarifa) {
        this.nombre = nombre;
        this.NIF = NIF;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.fecha_alta = fecha_alta;
        this.tarifa = tarifa;
        this.listallamadas = new ArrayList<>();
        this.Listafacturas = new HashMap<>();
    }

    public void anadirllamada(Llamada llamada) {
        listallamadas.add(llamada);
    }

    public List<Llamada> mostrarllamadas(){
        return listallamadas;
    }

    public void anadrifactura(String codigo, Factura factura) {
        Listafacturas.put(codigo, factura);
    }

    public HashMap<String, Factura> mostrarfacturas(){
        return Listafacturas;
    }

    public Calendar getFecha() {
        return fecha_alta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public void setFecha_alta(Calendar fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", NIF='" + NIF + '\'' +
                ", direccion=" + direccion +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", fecha_alta=" + fecha_alta +
                ", tarifa=" + tarifa +
                '}';
    }
}
