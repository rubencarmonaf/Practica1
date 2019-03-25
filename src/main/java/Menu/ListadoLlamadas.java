package Menu;

import Clientes.Cartera;
import Llamadas.Llamada;

import static Clientes.Cartera.sc;

public class ListadoLlamadas implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
        for (Llamada llamada : Cartera.listaclientes.get(nif).mostrarllamadas()) {
            System.out.println(llamada.toString());
        }
        System.out.println();
    }
}
