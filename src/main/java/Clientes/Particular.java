package Clientes;

import Tarifas.Tarifa;

import java.util.Calendar;
import java.io.Serializable;

public class Particular extends Cliente implements Serializable{

    private String apellidos;

    public Particular(String nombre, String apellidos, String NIF, Direccion direccion, String correo_electronico, Calendar fecha_alta, Tarifa tarifa) {
        super(nombre, NIF, direccion, correo_electronico, fecha_alta, tarifa);
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Particular{" +
                "apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", NIF='" + NIF + '\'' +
                ", direccion=" + direccion +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", fecha_alta=" + fecha_alta +
                ", tarifa=" + tarifa +
                '}';
    }
}
