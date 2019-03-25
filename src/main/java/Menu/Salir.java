package Menu;

import Clientes.Cartera;

public class Salir implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        System.out.println("Adios");
    }
}
