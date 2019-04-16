package Clientes;


import Tarifas.Tarifa;

import java.io.Serializable;
import java.util.Calendar;

public class Empresa extends Cliente implements Serializable {

    private static final long serialVersionUID = 6917603621901901744L;

    public Empresa(String nombre, String NIF, Direccion direccion, String correo_electronico, Calendar fecha_alta, Tarifa tarifa) {
        super(nombre, NIF, direccion, correo_electronico, fecha_alta, tarifa);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", NIF='" + NIF + '\'' +
                ", direccion=" + direccion +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", fecha_alta=" + fecha_alta +
                ", tarifa=" + tarifa +
                '}';
    }
}


