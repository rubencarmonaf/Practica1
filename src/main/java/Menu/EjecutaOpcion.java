package Menu;

import Clientes.Cartera;
import Excepciones.ExistingBillException;
import Excepciones.ExistingClientException;
import Excepciones.NonExistingClientException;

import java.io.PrintStream;
import java.util.Scanner;

public interface EjecutaOpcion {
    Scanner TECLADO = new Scanner(System.in);
    PrintStream CONSOLA =  System.out;
    void ejecuta(Cartera cartera) throws ExistingClientException, NonExistingClientException, ExistingBillException;
}
