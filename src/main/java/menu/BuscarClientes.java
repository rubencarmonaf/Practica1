package menu;

import data.Cartera;

public class BuscarClientes implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
        for(int i=0;i<Cartera.auxlistaclientes.size();i++){
            System.out.println(Cartera.auxlistaclientes.get(i).toString());
        }
        System.out.println();
    }
}
