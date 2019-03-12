package data;

import utilities.*;
import java.util.Calendar;

public class Empresa extends Clientes {

    public Empresa(String nombre, String NIF, Direcciones direccion, String correo_electronico, Calendar fecha_alta, Tarifa tarifa) {
        super(nombre, NIF, direccion, correo_electronico, fecha_alta, tarifa);
    }

    @Override
    public String toString() {
        return "data.Empresa{" +
                "nombre='" + nombre + '\'' +
                ", NIF='" + NIF + '\'' +
                ", direccion=" + direccion +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", fecha_alta=" + fecha_alta +
                ", tarifa=" + tarifa +
                '}';
    }
}


