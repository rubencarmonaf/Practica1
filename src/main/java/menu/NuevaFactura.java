package menu;

import data.Cartera;
import utilities.Facturas;
import utilities.Llamadas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import static data.Cartera.sc;


public class NuevaFactura implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
        double tiempo_tot = 0;
        double tarifa = Cartera.listaclientes.get(nif).tarifa.getEuromin();
        for (Llamadas llamadas : Cartera.listaclientes.get(nif).mostrarllamadas()) {
            tiempo_tot += llamadas.getDuracion_llamada();
        }
        double tot_factura = tiempo_tot * tarifa;
        System.out.print("Código Factura: ");
        int codigo =  sc.nextInt();
        LocalDate fecha_emision = LocalDate.now();
        //Cambiar fecha fin facturación
        LocalDateTime mes_ini = LocalDateTime.now();
        LocalDateTime mes_fin = LocalDateTime.now();
        LocalDateTime [] facturacion = {mes_ini, mes_fin};
        Facturas factura = new Facturas(codigo, Cartera.listaclientes.get(nif).tarifa, fecha_emision, facturacion, tot_factura);
        Cartera.listaclientes.get(nif).anadrifactura(codigo, factura);
        System.out.println();
    }
}
