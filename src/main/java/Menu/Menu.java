package Menu;

import java.util.*;
import Clientes.Cartera;
import Clientes.Cliente;
import Facturas.ConjuntoFacturas;
import Excepciones.ExistingBillException;
import Excepciones.ExistingClientException;
import Excepciones.InvalidAnswerException;
import Excepciones.NonExistingClientException;
import Utilities.MetodosAyuda;

public class Menu {

    public static void main(String [ ] args) throws ExistingClientException, NonExistingClientException, ExistingBillException, InvalidAnswerException {
        new Menu().ejecuta();
    }

    private void ejecuta() throws ExistingClientException, NonExistingClientException, ExistingBillException, InvalidAnswerException {
        Scanner sc = new Scanner(System.in);
        Cartera cartera = new Cartera();
        MetodosAyuda metodosAyuda = new MetodosAyuda();
        OpcionMenu opcionMenu;
        ConjuntoFacturas conjunto_facturas  = new ConjuntoFacturas();
        Cartera cartera_clientes = new Cartera();
        String load = MemoryCard.load();
        cartera_clientes = MemoryCard.loading(cartera_clientes, load);
        conjunto_facturas = MemoryCard.loading(conjunto_facturas, load);
        do {
            System.out.println(OpcionMenu.menu());
            System.out.print("Elige una opción: ");
            byte opcion = sc.nextByte();
            System.out.print("\n");
            opcionMenu = OpcionMenu.obtenerOpcion(opcion);

            switch (opcionMenu) {
                case NUEVO_PARTICULAR:
                    cartera.darDeAltaParticular();
                    break;
                case NUEVA_EMPRESA:
                    cartera.darDeAltaEmpresa();
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
                    cartera.darDeAltaFactura();
                    break;
                case DATOS_FACTURA:
                    cartera.datosFactura();
                    break;
                case MOSTRAR_FACTURA:
                    cartera.mostrarFactura();
                    break;
                case BETWEEN_ALTA_CLIENTE:
                    HashSet<Cliente> clientes = cartera.between_alta_clientes(metodosAyuda.mes_ini(), metodosAyuda.mes_fin());
                    break;
                case BETWEEN_LLAMADAS:
                    String codigo = metodosAyuda.getnif();
                    cartera.betweenllamadas(codigo, metodosAyuda.mes_ini(), metodosAyuda.mes_fin());
                    break;
                case BETWEEN_FACTURAS:
                    String codigo2 = metodosAyuda.getnif();
                    cartera.betweenfacturas(codigo2, metodosAyuda.mes_ini(), metodosAyuda.mes_fin());
                    break;
                case SALIR:
                    MemoryCard.save(conjunto_facturas, cartera_clientes);
                    break;
            }
        } while(opcionMenu != OpcionMenu.SALIR);
    }
}
