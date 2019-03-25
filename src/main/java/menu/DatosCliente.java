package menu;

import data.Cartera;

import static data.Cartera.sc;

public class DatosCliente implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
        System.out.println(Cartera.listaclientes.get(nif).toString());
        System.out.println();
    }
}
