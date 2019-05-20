package Menu;

import java.util.*;
import Clientes.Cartera;
import Excepciones.ExistingBillException;
import Excepciones.InvalidAnswerException;
import Excepciones.NonExistingClientException;
import Facturas.ConjuntoFacturas;
import Fechas.EntreFechas;
import InterfazUsuario.Controlador.ImplementacionControlador;
import InterfazUsuario.Modelo.ImplementacionModelo;
import InterfazUsuario.Vista.ImplementacionVista;

public class Menu {

    //private ImplementacionModelo gestion = new ImplementacionModelo();

    public static void main(String [ ] args) throws NonExistingClientException, ExistingBillException, InvalidAnswerException {
            ImplementacionControlador controlador = new ImplementacionControlador();
            ImplementacionVista vista = new ImplementacionVista();
            ImplementacionModelo modelo = new ImplementacionModelo();

            controlador.setModelo(modelo);
            vista.setModelo(modelo);
            vista.setControlador(controlador);
            modelo.cargarDatos();
            vista.creaGUI();
        /*gestion.cargarDatos();
        new Menu().ejecuta();
        gestion.guardarDatos();*/
    }

    /*private void ejecuta() throws NonExistingClientException {
        Scanner sc = new Scanner(System.in);
        Cartera cartera = new Cartera();
        MetodosAyuda metodosAyuda = new MetodosAyuda();
        ConjuntoFacturas ConjuntoFacturas = new ConjuntoFacturas();
        OpcionMenu opcionMenu;
        do {
            System.out.println(OpcionMenu.menu());
            System.out.print("Elige una opción: ");
            byte opcion = sc.nextByte();
            System.out.print("\n");
            opcionMenu = OpcionMenu.obtenerOpcion(opcion);

            switch (opcionMenu) {
                case DAR_DE_ALTA_CLIENTE:
                    cartera.darAltaCliente();
                    break;
                case BORRAR_CLIENTE:
                    cartera.borrarCliente();
                    break;
                case CAMBIAR_TARIFA:
                    cartera.cambiarTarifa();
                    break;
                case DATOS_CLIENTE:
                    cartera.datosCliente();
                    break;
                case BUSCAR_CLIENTE:
                    cartera.buscarCliente();
                    break;
                case NUEVA_LLAMADA:
                    cartera.darDeAltaLlamada();
                    break;
                case LISTADO_LLAMADAS:
                    cartera.mostrarLlamadas();
                    break;
                case NUEVA_FACTURA:
                    ConjuntoFacturas.emitirFactura();
                    break;
                case DATOS_FACTURA:
                    ConjuntoFacturas.recuperarDatosFactura();
                    break;
                case MOSTRAR_FACTURA:
                    ConjuntoFacturas.recuperarFacturas();
                    break;
                case BETWEEN_ALTA_CLIENTE:
                    EntreFechas.listadolista(cartera.between_alta_clientes(metodosAyuda.mes_ini(), metodosAyuda.mes_fin()));
                    break;
                case BETWEEN_LLAMADAS:
                    String codigo = metodosAyuda.getnif();
                    EntreFechas.listadolista(cartera.betweenllamadas(codigo, metodosAyuda.mes_ini(), metodosAyuda.mes_fin()));
                    break;
                case BETWEEN_FACTURAS:
                    String codigo2 = metodosAyuda.getnif();
                    EntreFechas.listadolista(cartera.betweenfacturas(codigo2, metodosAyuda.mes_ini(), metodosAyuda.mes_fin()));
                    break;
                case SALIR:
                    break;
            }
        } while(opcionMenu != OpcionMenu.SALIR);
    }*/
}
