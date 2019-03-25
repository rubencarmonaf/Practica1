package Menu;

import Clientes.Cartera;

import static Clientes.Cartera.sc;

public class CambiarTarifa implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
        System.out.print("Introduce la nueva tarifa: ");
        double tarifa = sc.nextDouble();
        Cartera.listaclientes.get(nif).tarifa.setEuromin(tarifa);
    }
}
