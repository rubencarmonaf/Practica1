package menu;

import Clientes.Cartera;
import Llamadas.Llamada;

import java.util.Calendar;
import java.util.Locale;

import static Clientes.Cartera.sc;

public class NuevaLlamada implements EjecutaOpcion {
    @Override
    public void ejecuta(Cartera cartera) {
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
}