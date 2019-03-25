package Menu;

import Clientes.Cartera;

import java.io.PrintStream;
import java.util.Scanner;

public interface EjecutaOpcion {
    Scanner TECLADO = new Scanner(System.in);
    PrintStream CONSOLA =  System.out;
    void ejecuta(Cartera cartera);
}
