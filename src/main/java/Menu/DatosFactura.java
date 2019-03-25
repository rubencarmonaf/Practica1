package Menu;

import Clientes.Cartera;
import static Clientes.Cartera.sc;


public class DatosFactura implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
        System.out.print("Código Factura: ");
        int codigo =  sc.nextInt();
        System.out.println(Cartera.listaclientes.get(nif).Listafacturas.get(codigo).toString());
        System.out.println();
    }
}
