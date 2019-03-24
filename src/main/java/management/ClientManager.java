package management;

import data.Clientes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClientManager {
    HashMap<String, Clientes> listaclientes = new HashMap<>();
    List<Clientes> auxlistaclientes = new ArrayList<>();
    public void showclientes() {
        for(int i=0;i<auxlistaclientes.size();i++){
            System.out.println(auxlistaclientes.get(i).toString());
        }
        System.out.println();
    }
}
