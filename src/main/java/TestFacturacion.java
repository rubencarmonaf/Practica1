import java.util.*;

import es.uji.www.GeneradorDatosINE;

public class TestFacturacion {
    static HashMap<String, Clientes> listaclientes = new HashMap<>();
    static List<Clientes> auxlistaclientes = new ArrayList<>();

    static HashMap<String, Facturas> facturas = new HashMap<>();
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
                    break;
                case 10:
                    break;
                case 11:
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
    }

    public static void cambiartarifa() {
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
        System.out.print("Introduce la nueva tarifa: ");
        double tarifa = sc.nextDouble();
        listaclientes.get(nif).tarifa.setEuromin(tarifa);
    }

    public static void borrarcliente() {
        System.out.print("Introdcue el NIF del cliente: ");
        String nif = sc.nextLine();
        listaclientes.remove(nif);
        int index = -1;
        for (int i = 0; i < auxlistaclientes.size(); i++) {
            if (auxlistaclientes.get(i).getNIF().equals(nif)) {
                index = i;
                auxlistaclientes.remove(index);
                break;
            }
        }
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
        listaclientes.get(nif_cliente).añadirllamada(llamada);
    }

    public static void listadoallamadas() {
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
        for (Llamadas llamadas : listaclientes.get(nif).mostrarllamadas()) {
            System.out.println(llamadas.toString());
        }
    }

    public static void datoscliente() {
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
        listaclientes.get(nif).toString();
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
        System.out.println("1. Crear cliente Particular.");
        System.out.println("2. Crear cliente Empresa.");
        System.out.println("3. Borrar cliente.");
        System.out.println("4. Mostrar clietntes.");
        System.out.println("5. Datos clietntes.");
        System.out.println("6. Cambiar Tarifa.");
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
        return accion;
    }
}
