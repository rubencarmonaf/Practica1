package Menu;

import Clientes.Cartera;
import Clientes.Direccion;
import Clientes.Empresa;
import Excepciones.ExistingClientException;
import Tarifas.Tarifa;

import java.util.Calendar;

import static Clientes.Cartera.generador;

public class NuevaEmpresa implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) throws ExistingClientException {
        String nif = generador.getNIF();
        if (Cartera.listaclientes.containsKey(nif))
            throw new ExistingClientException();
        Direccion dir = new Direccion("12540", generador.getProvincia(), generador.getPoblacion(generador.getProvincia()));
        Calendar today = Calendar.getInstance();
        Tarifa tar = new Tarifa(12);
        Empresa newclient = new Empresa(generador.getNombre(), nif, dir, "prueba@uji.es", today, tar);
        Cartera.listaclientes.put(nif, newclient);
        Cartera.auxlistaclientes.add(newclient);
    }
}
