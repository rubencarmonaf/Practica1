package management;

import data.Clientes;
import es.uji.www.GeneradorDatosINE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static menu.Menu.getnif;

public class ClientManager {
    HashMap<String, Clientes> listaclientes = new HashMap<>();
    List<Clientes> auxlistaclientes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    GeneradorDatosINE generador = new GeneradorDatosINE();

    public void showclientes() {
        for(int i=0;i<auxlistaclientes.size();i++){
            System.out.println(auxlistaclientes.get(i).toString());
        }
        System.out.println();
    }
    public void borrarcliente() {
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
    public void cambiartarifa() {
        String nif = getnif();
        System.out.print("Introduce la nueva tarifa: ");
        double tarifa = sc.nextDouble();
        listaclientes.get(nif).tarifa.setEuromin(tarifa);
    }
    public void datoscliente() {
        String nif = getnif();
        System.out.println(listaclientes.get(nif).toString());
        System.out.println();
    }
}
