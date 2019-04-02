package Menu;

import Clientes.Cartera;
import Facturas.ConjuntoFacturas;
import Excepciones.InvalidAnswerException;

import java.io.*;
import java.util.Scanner;

public class MemoryCard {

    public static String load() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Desea cargar la información guardada?(Y/N): ");
        return scanner.next();
    }

    public static Cartera loading(Cartera cartera_clientes, String respuesta) throws InvalidAnswerException {
        if (respuesta.compareTo("Y") == 0 || respuesta.compareTo("y") == 0) {
            try {

                FileInputStream file = new FileInputStream("clientes.bin");
                ObjectInputStream ois = new ObjectInputStream(file);
                cartera_clientes = (Cartera) ois.readObject();
                ois.close();
            } catch (IOException e) {
                System.out.println("Error al leer el fichero");
                loading(cartera_clientes, respuesta);
            } catch (ClassNotFoundException c) {
                System.out.println("Error al cargar el fichero");
                loading(cartera_clientes, respuesta);
            }
        }
        else
        if (respuesta.compareTo("Y") != 0 && respuesta.compareTo("y") != 0 && respuesta.compareTo("N") != 0 && respuesta.compareTo("n") != 0)
            throw new InvalidAnswerException();
        return cartera_clientes;
    }

    public static ConjuntoFacturas loading(ConjuntoFacturas total_facturas, String respuesta) throws InvalidAnswerException {
        if (respuesta.compareTo("Y") == 0 || respuesta.compareTo("y") == 0) {
            try {

                FileInputStream file = new FileInputStream("facturas.bin");
                ObjectInputStream ois = new ObjectInputStream(file);
                total_facturas = (ConjuntoFacturas) ois.readObject();
                ois.close();
            } catch (IOException e) {
                System.out.println("Error al leer el fichero");
                loading(total_facturas, respuesta);
            } catch (ClassNotFoundException c) {
                System.out.println("Error al cargar el fichero");
                loading(total_facturas, respuesta);
            }
        }
        else
        if (respuesta.compareTo("Y") != 0 && respuesta.compareTo("y") != 0 && respuesta.compareTo("N") != 0 && respuesta.compareTo("n") != 0)
            throw new InvalidAnswerException();
        return total_facturas;
    }

    public static void save(ConjuntoFacturas total_facturas, Cartera cartera_clientes) throws InvalidAnswerException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Desea guardar la información actualizada?(Y/N): ");
        String respuesta = scanner.next();
        if (respuesta.compareTo("Y") == 0 || respuesta.compareTo("y") == 0) {
            try {
                FileOutputStream filecli = new FileOutputStream("clientes.bin");
                ObjectOutputStream savecli = new ObjectOutputStream(filecli);
                savecli.writeObject(cartera_clientes);
                savecli.close();
                FileOutputStream filefac = new FileOutputStream("facturas.bin");
                ObjectOutputStream savefac = new ObjectOutputStream(filefac);
                savefac.writeObject(total_facturas);
                savefac.close();
            } catch (IOException e) {
                System.out.println("Error al leer el fichero");
                save(total_facturas, cartera_clientes);
            }
        }
        else
        if (respuesta.compareTo("Y") != 0 && respuesta.compareTo("y") != 0 && respuesta.compareTo("N") != 0 && respuesta.compareTo("n") != 0)
            throw new InvalidAnswerException();
    }
}
