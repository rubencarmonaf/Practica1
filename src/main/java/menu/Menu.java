package menu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import data.Clientes;
import data.Empresa;
import data.Particular;
import es.uji.www.GeneradorDatosINE;
import utilities.Direcciones;
import utilities.Facturas;
import utilities.Llamadas;
import utilities.Tarifa;

public class Menu {
    static HashMap<String, Clientes> listaclientes = new HashMap<>();
    static List<Clientes> auxlistaclientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static GeneradorDatosINE generador = new GeneradorDatosINE();

    public static void main(String [ ] args){

        boolean salir = false;

        while (salir != true) {
            showmenu();
            int accion = askoption();
            switch (accion) {
                case 1:
                    crearParticular();
                    break;
                case 2:
                    crearEmpresa();
                    break;
                case 3:
                    borrarcliente();
                    break;
                case 4:
                    showclientes();
                    break;
                case 5:
                    datoscliente();
                    break;
                case 6:
                    cambiartarifa();
                    break;
                case 7:
                    dardealtallamada();
                    break;
                case 8:
                    listadoallamadas();
                    break;
                case 9:
                    emitirfactura();
                    break;
                case 10:
                    datosfactura();
                    break;
                case 11:
                    mostrarfacturas();
                    break;
                case 12:
                    salir = true;
                    break;
            }
        }
    }

    public static void showclientes() {
        for(int i=0;i<auxlistaclientes.size();i++){
            System.out.println(auxlistaclientes.get(i).toString());
        }
        System.out.println();
    }

    public static void cambiartarifa() {
        String nif = getnif();
        System.out.print("Introduce la nueva tarifa: ");
        double tarifa = sc.nextDouble();
        listaclientes.get(nif).tarifa.setEuromin(tarifa);
    }

    public static void emitirfactura() {
        String nif = getnif();
        double tiempo_tot = 0;
        double tarifa = listaclientes.get(nif).tarifa.getEuromin();
        for (Llamadas llamadas : listaclientes.get(nif).mostrarllamadas()) {
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
        Facturas factura = new Facturas(codigo, listaclientes.get(nif).tarifa, fecha_emision, facturacion, tot_factura);
        listaclientes.get(nif).anadrifactura(codigo, factura);
        System.out.println();
    }

    public static void datosfactura() {
        String nif = getnif();
        System.out.print("Código Factura: ");
        int codigo =  sc.nextInt();
        System.out.println(listaclientes.get(nif).Listafacturas.get(codigo).toString());
        System.out.println();
    }

    public static void mostrarfacturas() {
        String nif = getnif();
        for (int codigo : listaclientes.get(nif).mostrarfacturas().keySet()) {
            System.out.println(listaclientes.get(nif).mostrarfacturas().get(codigo).toString());
        }
        System.out.println();
    }

    public static void borrarcliente() {
        String nif = getnif();
        listaclientes.remove(nif);
        int index = -1;
        for (int i = 0; i < auxlistaclientes.size(); i++) {
            if (auxlistaclientes.get(i).getNIF().equals(nif)) {
                index = i;
                auxlistaclientes.remove(index);
                break;
            }
        }
        System.out.println();
    }

    public static void dardealtallamada() {
        System.out.print("Numero llamado: ");
        String num_llamado = sc.nextLine();
        Calendar fecha = Calendar.getInstance(Locale.getDefault());
        System.out.print("Introducir tiempo llamada: ");
        double tiempo_llamada = sc.nextDouble();
        Llamadas llamada = new Llamadas(num_llamado, fecha, fecha.getTime(), tiempo_llamada);
        sc.nextLine();
        System.out.print("Cliente que ha realizado la llamada (Introducir NIF): ");
        String nif_cliente = sc.nextLine();
        listaclientes.get(nif_cliente).anadirllamada(llamada);
        System.out.println();
    }

    public static void listadoallamadas() {
        String nif = getnif();
        for (Llamadas llamadas : listaclientes.get(nif).mostrarllamadas()) {
            System.out.println(llamadas.toString());
        }
        System.out.println();
    }

    public static void datoscliente() {
        String nif = getnif();
        System.out.println(listaclientes.get(nif).toString());
        System.out.println();
    }

    public static void crearParticular() {
        Direcciones dir = new Direcciones("12540", generador.getProvincia(), generador.getPoblacion(generador.getProvincia()));
        Calendar today = Calendar.getInstance();
        Tarifa tar = new Tarifa(12);
        String nif = generador.getNIF();
        Particular newclient = new Particular(generador.getNombre(), generador.getApellido(), nif, dir, "prueba@uji.es", today, tar);
        listaclientes.put(nif, newclient);
        auxlistaclientes.add(newclient);
    }

    public static void crearEmpresa() {
        Direcciones dir = new Direcciones("12540", generador.getProvincia(), generador.getPoblacion(generador.getProvincia()));
        Calendar today = Calendar.getInstance();
        Tarifa tar = new Tarifa(12);
        String nif = generador.getNIF();
        Empresa newclient = new Empresa(generador.getNombre(), nif, dir, "prueba@uji.es", today, tar);
        listaclientes.put(nif, newclient);
        auxlistaclientes.add(newclient);
    }

    public static void showmenu() {
        System.out.println("1. Crear cliente data.Particular.");
        System.out.println("2. Crear cliente data.Empresa.");
        System.out.println("3. Borrar cliente.");
        System.out.println("4. Mostrar clietntes.");
        System.out.println("5. Datos clietnte.");
        System.out.println("6. Cambiar utilities.Tarifa.");
        System.out.println("7. Dar de alta llamada.");
        System.out.println("8. Listado de llamadas de un cliente.");
        System.out.println("9. Emitir factura.");
        System.out.println("10. Recuperar datos de una factura.");
        System.out.println("11. Recuperar facturas cliente.");
        System.out.println("12. Salir.");
    }

    public static int askoption() {
        System.out.print("Que acción quieres realizar: ");
        int accion = sc.nextInt();
        sc.nextLine();
        System.out.println();
        return accion;
    }

    public static String getnif(){
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
        return nif;
    }
}