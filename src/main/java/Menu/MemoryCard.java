package Menu;

import java.io.*;
import Clientes.Cartera;

public class MemoryCard {

    //Hay que modificarlo
    /*public static void guardarDatos(Cartera cartera) {
        Cartera micartera = cartera;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("io/clientes.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(cartera.getListaClientes());
            oos.writeObject(cartera.getAuxClientes());
            fos = new FileOutputStream("io/facturas.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(facturas);
            fos = new FileOutputStream("io/llamadas.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(llamadas);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void cargarDatos() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("io/clientes.bin");
            ois = new ObjectInputStream(fis);
            clientes = (HashMap<String, Cliente>) ois.readObject();
            fis = new FileInputStream("io/facturas.bin");
            ois = new ObjectInputStream(fis);
            facturas = (HashMap<String, List<Factura>>) ois.readObject();
            fis = new FileInputStream("io/llamadas.bin");
            ois = new ObjectInputStream(fis);
            llamadas = (HashMap<String, List<Llamada>>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}

//Otra opción
/*public class MemoryCard {
    public MemoryCard() {
    }

    public static String load() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Quieres cargar toda la información?(S/N): ");
        return scanner.next();
    }

    public static Cartera loading(Cartera cartera_clientes, String respuesta) throws InvalidAnswerException {
        if (respuesta.compareTo("S") != 0 && respuesta.compareTo("s") != 0) {
            if (respuesta.compareTo("S") != 0 && respuesta.compareTo("s") != 0 && respuesta.compareTo("N") != 0 && respuesta.compareTo("n") != 0) {
                throw new InvalidAnswerException();
            }
        } else {
            try {
                FileInputStream file = new FileInputStream("clientes.bin");
                ObjectInputStream ois = new ObjectInputStream(file);
                cartera_clientes = (Cartera)ois.readObject();
                ois.close();
            } catch (IOException var4) {
                System.out.println("Error al leer el fichero");
                loading(cartera_clientes, respuesta);
            } catch (ClassNotFoundException var5) {
                System.out.println("Error al cargar el fichero");
                loading(cartera_clientes, respuesta);
            }
        }

        return cartera_clientes;
    }

    public static ConjuntoFacturas loading(ConjuntoFacturas total_facturas, String respuesta) throws InvalidAnswerException {
        if (respuesta.compareTo("S") != 0 && respuesta.compareTo("s") != 0) {
            if (respuesta.compareTo("S") != 0 && respuesta.compareTo("s") != 0 && respuesta.compareTo("N") != 0 && respuesta.compareTo("n") != 0) {
                throw new InvalidAnswerException();
            }
        } else {
            try {
                FileInputStream file = new FileInputStream("facturas.bin");
                ObjectInputStream ois = new ObjectInputStream(file);
                total_facturas = (ConjuntoFacturas)ois.readObject();
                ois.close();
            } catch (IOException var4) {
                System.out.println("Error al leer el fichero");
                loading(total_facturas, respuesta);
            } catch (ClassNotFoundException var5) {
                System.out.println("Error al cargar el fichero");
                loading(total_facturas, respuesta);
            }
        }

        return total_facturas;
    }

    public static void save(ConjuntoFacturas total_facturas, Cartera cartera_clientes) throws InvalidAnswerException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Desea guardar la información actualizada?(S/N): ");
        String respuesta = scanner.next();
        if (respuesta.compareTo("S") != 0 && respuesta.compareTo("s") != 0) {
            if (respuesta.compareTo("S") != 0 && respuesta.compareTo("s") != 0 && respuesta.compareTo("N") != 0 && respuesta.compareTo("n") != 0) {
                throw new InvalidAnswerException();
            }
        } else {
            try {
                FileOutputStream filecli = new FileOutputStream("clientes.bin");
                ObjectOutputStream savecli = new ObjectOutputStream(filecli);
                savecli.writeObject(cartera_clientes);
                savecli.close();
                FileOutputStream filefac = new FileOutputStream("facturas.bin");
                ObjectOutputStream savefac = new ObjectOutputStream(filefac);
                savefac.writeObject(total_facturas);
                savefac.close();
            } catch (IOException var8) {
                System.out.println("Error al leer el fichero");
                save(total_facturas, cartera_clientes);
            }
        }

    }
}*/
