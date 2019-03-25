package Clientes;

import es.uji.www.GeneradorDatosINE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Cartera {
    public static HashMap<String, Cliente> listaclientes;
    public static List<Cliente> auxlistaclientes;
    public static Scanner sc;
    public static GeneradorDatosINE generador;

    public Cartera() {
        super();
        listaclientes = new HashMap<>();
        auxlistaclientes = new ArrayList<>();
        sc = new Scanner(System.in);
        generador = new GeneradorDatosINE();
    }
}
