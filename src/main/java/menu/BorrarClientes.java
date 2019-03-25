package menu;

import data.Cartera;

import static data.Cartera.sc;

public class BorrarClientes implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
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
}
