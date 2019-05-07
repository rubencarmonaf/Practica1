package Facturas;

import Clientes.Cartera;
import Excepciones.*;
import Fechas.EntreFechas;
import InterfazUsuario.Modelo.ImplementacionModelo;
import Llamadas.Llamada;
import Utilities.Consola;
import Utilities.MetodosAyuda;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import static Clientes.Cartera.sc;

public class ConjuntoFacturas extends EntreFechas implements Serializable {

    private static MetodosAyuda metodosAyuda;
    private Consola consola;
    private HashMap<String, Factura> facturas;
    private ImplementacionModelo gestion = new ImplementacionModelo();

    public ConjuntoFacturas() {
        this.facturas = new HashMap<>();
        metodosAyuda = new MetodosAyuda();
    }

    /*public static void addFactura() throws ExistingBillException {
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
    }*/

    public void emitirFactura() {
        String nif = metodosAyuda.getnif();
        consola.mostrarDato("Introduce fecha: \n");
        int año = Integer.parseInt(consola.pedirDato("	-Año: "));
        int mes = Integer.parseInt(consola.pedirDato("	-Mes (numérico): "));
        int dia = Integer.parseInt(consola.pedirDato("	-Día: "));
        Calendar fecha = Calendar.getInstance();
        fecha.set(año, mes, dia);
        try {
            gestion.emitirFactura(nif, fecha);
            consola.mostrarDato("\nFactura realizada \n\n");
        } catch (NonExistingClientException e) {
            consola.mostrarDato("\n"+ e.getMessage() + "\n\n");
        }
    }

    /*public static void mostrarFactura() {
        String nif = metodosAyuda.getnif();
        for (String codigo : Cartera.listaclientes.get(nif).mostrarfacturas().keySet()) {
            System.out.println(Cartera.listaclientes.get(nif).mostrarfacturas().get(codigo).toString());
        }
        System.out.println();
    }*/

    public void recuperarFacturas() {
        String nif = consola.pedirDato("Introduce NIF: ");
        try {
            List<Factura> facturas = gestion.recuperarFacturas(nif);
            for(Factura factura : facturas) {
                consola.mostrarDato(factura.toString());
                consola.mostrarDato("\n\n");
            }
        } catch (NonExistingClientException e) {
            consola.mostrarDato("\n"+ e.getMessage() + "\n\n");
        } catch (ListLlamadasNullExecption listLlamadasNullExecption) {
            listLlamadasNullExecption.printStackTrace();
        }
    }

    /*public static void datosFactura() {
        String nif = metodosAyuda.getnif();
        System.out.print("Código Factura: ");
        int codigo =  sc.nextInt();
        System.out.println(Cartera.listaclientes.get(nif).Listafacturas.get(codigo).toString());
        System.out.println();
    }

    public HashMap<String, Factura> listaFacturas() {
        return facturas;
    }*/

    public void recuperarDatosFactura() {
        int cod = Integer.parseInt(consola.pedirDato("Introduce código de factura: "));
        try {
            Factura factura = gestion.recuperarDatosFacturaCodigo(cod);
            consola.mostrarDato(factura.toString());
            consola.mostrarDato("\n\n");
        } catch (NonExistingBillException e) {
            consola.mostrarDato("\n"+ e.getMessage() + "\n\n");
        }
    }

    public String toString(){
        StringBuilder facturas = new StringBuilder();
        for (Factura factura: this.facturas.values())
            facturas.append(factura.toString());
        return facturas.toString();
    }

}
