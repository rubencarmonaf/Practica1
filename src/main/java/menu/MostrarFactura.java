package menu;

import Clientes.Cartera;

import static Clientes.Cartera.sc;

public class MostrarFactura implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
        for (int codigo : Cartera.listaclientes.get(nif).mostrarfacturas().keySet()) {
            System.out.println(Cartera.listaclientes.get(nif).mostrarfacturas().get(codigo).toString());
        }
        System.out.println();
    }
}
