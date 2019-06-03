package Facturas;

import Excepciones.*;
import Fechas.EntreFechas;
import InterfazUsuario.Modelo.ImplementacionModelo;
import Utilities.Consola;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class ConjuntoFacturas extends EntreFechas implements Serializable {

    private Consola consola;
    private HashMap<String, Factura> facturas;
    private ImplementacionModelo gestion = new ImplementacionModelo();

    public ConjuntoFacturas() {
        this.facturas = new HashMap<>();
    }

    public void emitirFactura() {
        String nif = consola.pedirDato("Introduce NIF: ");
        consola.mostrarDato("Introduce fecha: \n");
        int ano = Integer.parseInt(consola.pedirDato("	-Año: "));
        int mes = Integer.parseInt(consola.pedirDato("	-Mes (numérico): "));
        int dia = Integer.parseInt(consola.pedirDato("	-Día: "));
        Calendar fecha = Calendar.getInstance();
        fecha.set(ano, mes, dia);
        try {
            gestion.emitirFactura(nif, fecha);
            consola.mostrarDato("\nFactura realizada \n\n");
        } catch (NonExistingClientException e) {
            consola.mostrarDato("\n"+ e.getMessage() + "\n\n");
        }
    }

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
