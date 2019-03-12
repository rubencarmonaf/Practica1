package data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import utilities.*;

public class Clientes {

    public String nombre;
    public String NIF;
    public Direcciones direccion;
    public String correo_electronico;
    public Calendar fecha_alta;
    public Tarifa tarifa;
    public List<Llamadas> Listallamadas = new ArrayList<>();
    public HashMap<Integer, Facturas> Listafacturas = new HashMap<>();

    public Clientes(String nombre, String NIF, Direcciones direccion, String correo_electronico, Calendar fecha_alta, Tarifa tarifa) {
        this.nombre = nombre;
        this.NIF = NIF;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.fecha_alta = fecha_alta;
        this.tarifa = tarifa;
    }

    public void anadirllamada(Llamadas llamada) {
        Listallamadas.add(llamada);
    }

    public List<Llamadas> mostrarllamadas(){
        return Listallamadas;
    }

    public void anadrifactura(int codigo, Facturas factura) {
        Listafacturas.put(codigo, factura);
    }

    public HashMap<Integer, Facturas> mostrarfacturas(){
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

    public Direcciones getDireccion() {
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

    public void setDireccion(Direcciones direccion) {
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
        return "data.Clientes{" +
                "nombre='" + nombre + '\'' +
                ", NIF='" + NIF + '\'' +
                ", direccion=" + direccion +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", fecha_alta=" + fecha_alta +
                ", tarifa=" + tarifa +
                '}';
    }
}
