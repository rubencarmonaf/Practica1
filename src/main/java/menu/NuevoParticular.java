package menu;

import data.Cartera;
import data.Particular;
import utilities.Direcciones;
import utilities.Tarifa;

import java.util.Calendar;

import static data.Cartera.generador;

public class NuevoParticular implements EjecutaOpcion {;
    @Override
    public void ejecuta(Cartera cartera) {
        Direcciones dir = new Direcciones("12540", generador.getProvincia(), generador.getPoblacion(generador.getProvincia()));
        Calendar today = Calendar.getInstance();
        Tarifa tar = new Tarifa(12);
        String nif = generador.getNIF();
        Particular newclient = new Particular(generador.getNombre(), generador.getApellido(), nif, dir, "prueba@uji.es", today, tar);
        Cartera.listaclientes.put(nif, newclient);
        Cartera.auxlistaclientes.add(newclient);
    }
}
