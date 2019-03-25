package Menu;

import Clientes.Cartera;
import Excepciones.ExistingBillException;
import Facturas.Factura;
import Llamadas.Llamada;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static Clientes.Cartera.sc;


public class NuevaFactura implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) throws ExistingBillException {
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
        double tiempo_tot = 0;
        double tarifa = Cartera.listaclientes.get(nif).tarifa.getEuromin();
        for (Llamada llamada : Cartera.listaclientes.get(nif).mostrarllamadas()) {
            tiempo_tot += llamada.getDuracion_llamada();
        }
        double tot_factura = tiempo_tot * tarifa;
        System.out.print("Código Factura: ");
        int codigo =  sc.nextInt();
        if (Cartera.listaclientes.get(nif).Listafacturas.containsKey(codigo))
            throw new ExistingBillException();
        System.out.print("Insertar dia facturacion: ");
        int day_start = sc.nextInt();
        System.out.print("Insertar mes facturacion:  ");
        int month_start = sc.nextInt();
        System.out.print("Insertar año facturacion: ");
        int year_start = sc.nextInt();
        Calendar mes_ini = new GregorianCalendar(year_start, month_start -1, day_start);
        System.out.print("Insertar dia fin facturacion: ");
        int day_end = sc.nextInt();
        System.out.print("Insertar mes fin facturacion: ");
        int month_end = sc.nextInt();
        System.out.print("Insertar año fin facturacion: ");
        int year_end = sc.nextInt();
        Calendar mes_fin = new GregorianCalendar(year_end, month_end - 1, day_end);
        Calendar [] facturacion = {mes_ini, mes_fin};
        Factura factura = new Factura(codigo, Cartera.listaclientes.get(nif).tarifa, mes_ini, facturacion, tot_factura);
        Cartera.listaclientes.get(nif).anadrifactura(codigo, factura);
        System.out.println();
    }
}
