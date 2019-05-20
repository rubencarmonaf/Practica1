package Utilities;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class MetodosAyuda {

    Scanner sc = new Scanner(System.in);

    public String getnif(){
        System.out.print("Introduce el NIF del cliente: ");
        String nif = sc.nextLine();
        return nif;
    }

    public Calendar mes_ini() {
        System.out.print("Insertar dia facturacion: ");
        int day_start = sc.nextInt();
        System.out.print("Insertar mes facturacion:  ");
        int month_start = sc.nextInt();
        System.out.print("Insertar año facturacion: ");
        int year_start = sc.nextInt();
        Calendar mes_ini = new GregorianCalendar(year_start, month_start -1, day_start);
        return mes_ini;
    }

    public Calendar mes_fin() {
        System.out.print("Insertar dia fin facturacion: ");
        int day_end = sc.nextInt();
        System.out.print("Insertar mes fin facturacion: ");
        int month_end = sc.nextInt();
        System.out.print("Insertar año fin facturacion: ");
        int year_end = sc.nextInt();
        Calendar mes_fin = new GregorianCalendar(year_end, month_end - 1, day_end);
        return mes_fin;
    }
}
