package Clientes;

import Excepciones.ExistingClientException;
import Excepciones.IllegalPeriodException;
import Excepciones.NonExistingClientException;
import Facturas.Factura;
import Llamadas.Llamada;
import Fechas.EntreFechas;
import Tarifas.Tarifa;
import Utilities.MetodosAyuda;
import es.uji.www.GeneradorDatosINE;

import java.io.Serializable;
import java.util.*;

public class Cartera extends EntreFechas implements Serializable {
    public static HashMap<String, Cliente> listaclientes;
    public static List<Cliente> auxlistaclientes;
    public static Scanner sc;
    public static GeneradorDatosINE generador;
    MetodosAyuda metodosAyuda;

    public Cartera() {
        listaclientes = new HashMap<>();
        auxlistaclientes = new ArrayList<>();
        sc = new Scanner(System.in);
        generador = new GeneradorDatosINE();
        metodosAyuda = new MetodosAyuda();
    }

    public void darDeAltaParticular() throws ExistingClientException{
        String nif = generador.getNIF();
        if (Cartera.listaclientes.containsKey(nif))
            throw new ExistingClientException();
        Direccion dir = new Direccion("12540", generador.getProvincia(), generador.getPoblacion(generador.getProvincia()));
        Calendar today = Calendar.getInstance();
        Tarifa tar = new Tarifa(12);
        Particular newclient = new Particular(generador.getNombre(), generador.getApellido(), nif, dir, "prueba@uji.es", today, tar);
        Cartera.listaclientes.put(nif, newclient);
        Cartera.auxlistaclientes.add(newclient);
    }

    public void darDeAltaEmpresa() throws ExistingClientException {
        String nif = generador.getNIF();
        if (Cartera.listaclientes.containsKey(nif))
            throw new ExistingClientException();
        Direccion dir = new Direccion("12540", generador.getProvincia(), generador.getPoblacion(generador.getProvincia()));
        Calendar today = Calendar.getInstance();
        Tarifa tar = new Tarifa(12);
        Empresa newclient = new Empresa(generador.getNombre(), nif, dir, "prueba@uji.es", today, tar);
        Cartera.listaclientes.put(nif, newclient);
        Cartera.auxlistaclientes.add(newclient);
    }

    public void darDeAltaLlamada() {
        System.out.print("Numero llamado: ");
        String num_llamado = sc.nextLine();
        Calendar fecha = Calendar.getInstance(Locale.getDefault());
        System.out.print("Introducir tiempo llamada: ");
        double tiempo_llamada = sc.nextDouble();
        Llamada llamada = new Llamada(num_llamado, fecha, fecha.getTime(), tiempo_llamada);
        sc.nextLine();
        System.out.print("Cliente que ha realizado la llamada (Introducir NIF): ");
        String nif_cliente = sc.nextLine();
        Cartera.listaclientes.get(nif_cliente).anadirllamada(llamada);
        System.out.println();
    }

    public void mostrarLlamadas() {
        String nif = metodosAyuda.getnif();
        for (Llamada llamada : Cartera.listaclientes.get(nif).mostrarllamadas()) {
            System.out.println(llamada.toString());
        }
        System.out.println();
    }

    public void datosCliente() {
        String nif = metodosAyuda.getnif();
        System.out.println(Cartera.listaclientes.get(nif).toString());
        System.out.println();
    }

    public void cambiarTarifa() {
        String nif = metodosAyuda.getnif();
        System.out.print("Introduce la nueva tarifa: ");
        double tarifa = sc.nextDouble();
        Cartera.listaclientes.get(nif).tarifa.setEuromin(tarifa);
    }

    public void borrarCliente() throws NonExistingClientException {
        MetodosAyuda getnif = new MetodosAyuda();
        String nif = getnif.getnif();
        if (!Cartera.listaclientes.containsKey(nif))
            throw new NonExistingClientException();
        Cartera.listaclientes.remove(nif);
        int index = -1;
        for (int i = 0; i < Cartera.auxlistaclientes.size(); i++) {
            if (Cartera.auxlistaclientes.get(i).getNIF().equals(nif)) {
                index = i;
                Cartera.auxlistaclientes.remove(index);
                break;
            }
        }
        System.out.println();
    }

    public void buscarCliente() {
        for(int i=0;i<Cartera.auxlistaclientes.size();i++){
            System.out.println(Cartera.auxlistaclientes.get(i).toString());
        }
        System.out.println();
    }

    public String toString(){
        StringBuilder clientes = new StringBuilder();
        for (Cliente cliente: listaclientes.values())
            clientes.append(cliente.toString());
        clientes.append("\n");
        return clientes.toString();
    }

    public HashSet<Cliente> between_alta_clientes(Calendar fecha_inicio, Calendar fecha_fin) {
        try {
            return listentrefechas(listaclientes.values(), fecha_inicio, fecha_fin);
        }
        catch (IllegalPeriodException e) {
            System.out.println("Periodo de fechas no válido.");
        }
        return new HashSet<>();
    }

    public HashSet<Llamada> betweenllamadas(String codigo, Calendar fecha_inicio, Calendar fecha_fin){
        try {
            Collection<Llamada> c = listaclientes.get(codigo).listallamadas;
            return listentrefechas(c, fecha_inicio, fecha_fin);
        }
        catch (IllegalPeriodException p) {
            System.out.println("Periodo de fechas no válido.");
        }
        return new HashSet<>();
    }

    public HashSet<Factura> betweenfacturas(String codigo, Calendar fecha_inicio, Calendar fecha_fin) {
        try {
            return listentrefechas(listaclientes.get(codigo).Listafacturas.values(), fecha_inicio, fecha_fin);
        }
        catch (IllegalPeriodException p) {
            System.out.println("Periodo de fechas no válido.");
        }
        return new HashSet<>();
    }
}
