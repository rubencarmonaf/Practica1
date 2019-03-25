package menu;

import data.Cartera;
import utilities.Llamadas;

import static data.Cartera.sc;

public class ListadoLlamadas implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
        for (Llamadas llamadas : Cartera.listaclientes.get(nif).mostrarllamadas()) {
            System.out.println(llamadas.toString());
        }
        System.out.println();
    }
}
