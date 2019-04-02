package Facturas;

import Clientes.Cartera;
import Excepciones.ExistingBillException;
import Fechas.EntreFechas;
import Llamadas.Llamada;
import Utilities.MetodosAyuda;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;

import static Clientes.Cartera.sc;

public class ConjuntoFacturas extends EntreFechas implements Serializable {

    private static MetodosAyuda metodosAyuda;
    private HashMap<String, Factura> facturas;

    public ConjuntoFacturas() {
        this.facturas = new HashMap<>();
        metodosAyuda = new MetodosAyuda();
    }

    public static void addFactura() throws ExistingBillException {
        String nif = metodosAyuda.getnif();
        double tiempo_tot = 0;
        double tarifa = Cartera.listaclientes.get(nif).tarifa.getEuromin();
        for (Llamada llamada : Cartera.listaclientes.get(nif).mostrarllamadas()) {
            tiempo_tot += llamada.getDuracion_llamada();
        }
        double tot_factura = tiempo_tot * tarifa;
        System.out.print("Código Factura: ");
        String codigo =  sc.nextLine();
        if (Cartera.listaclientes.get(nif).Listafacturas.containsKey(codigo))
            throw new ExistingBillException();
        Calendar mes_ini = metodosAyuda.mes_ini();
        Calendar mes_fin = metodosAyuda.mes_fin();
        Calendar [] facturacion = {mes_ini, mes_fin};
        Factura factura = new Factura(codigo, Cartera.listaclientes.get(nif).tarifa, mes_ini, facturacion, tot_factura);
        Cartera.listaclientes.get(nif).anadrifactura(codigo, factura);
        System.out.println();
    }

    public static void mostrarFactura() {
        String nif = metodosAyuda.getnif();
        for (String codigo : Cartera.listaclientes.get(nif).mostrarfacturas().keySet()) {
            System.out.println(Cartera.listaclientes.get(nif).mostrarfacturas().get(codigo).toString());
        }
        System.out.println();
    }

    public static void datosFactura() {
        String nif = metodosAyuda.getnif();
        System.out.print("Código Factura: ");
        int codigo =  sc.nextInt();
        System.out.println(Cartera.listaclientes.get(nif).Listafacturas.get(codigo).toString());
        System.out.println();
    }

    public HashMap<String, Factura> listaFacturas() {
        return facturas;
    }

    public String toString(){
        StringBuilder facturas = new StringBuilder();
        for (Factura factura: this.facturas.values())
            facturas.append(factura.toString());
        return facturas.toString();
    }

}
