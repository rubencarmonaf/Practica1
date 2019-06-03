package InterfazUsuario.Modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import Clientes.Cliente;
import Excepciones.*;
import Facturas.Factura;
import Fechas.EntreFechas;
import Llamadas.Llamada;
import Tarifas.Tarifa;

public class ImplementacionModelo implements Modelo{

    private HashMap<String, Cliente> clientes;
    private HashMap<String, List<Factura>> facturas;
    private HashMap<Integer, Factura> facturasCodigo;
    private HashMap<String, List<Llamada>> llamadas;

    public ImplementacionModelo() {
        clientes = new HashMap<>();
        facturas = new HashMap<>();
        facturasCodigo = new HashMap<>();
        llamadas = new HashMap<>();
    }


    // OPERACIONES DEL CLIENTE

    public boolean darDeAltaCliente(Cliente cliente) throws ExistingClientException {
        String nif = cliente.getNIF();
        if (!this.clientes.containsKey(nif)) {
            this.clientes.put(nif, cliente);
            return true;
        }
        throw new ExistingClientException();
    }

    public boolean borrarCliente(String nif) throws NonExistingClientException {
        if (this.clientes.containsKey(nif)) {
            this.clientes.remove(nif);
            return true;
        }
        throw new NonExistingClientException();
    }

    public boolean cambiarTarifa(String nif, Tarifa tarifa) throws NonExistingClientException {
        if (this.clientes.containsKey(nif)) {
            this.clientes.get(nif).setTarifa(tarifa);
            return true;
        }
        throw new NonExistingClientException();
    }

    public Cliente recuperarDatosNIF(String nif) throws NonExistingClientException {
        if (this.clientes.containsKey(nif)) {
            return this.clientes.get(nif);
        }
        throw new NonExistingClientException();
    }

    public HashMap<String, Cliente> recuperarListadoClientes() throws ListClientsNullExecption{
        if(this.clientes.isEmpty())
            throw new ListClientsNullExecption();

        return this.clientes;
    }

    public Collection<Cliente> mostrarListadoClientesFechas(Calendar fechaInicio, Calendar fechaFin) throws IllegalPeriodException, ListClientsNullExecption{
        if(fechaInicio.after(fechaFin))
            throw new IllegalPeriodException();

        Collection<Cliente> clientes = this.clientes.values();
        clientes = EntreFechas.listentrefechas(clientes, fechaInicio, fechaFin);

        if(clientes.isEmpty())
            throw new ListClientsNullExecption();

        return clientes;
    }

    // OPERACIONES DE LAS LLAMADAS

    public boolean darDeAltaLlamada(String nif, Llamada llamada) throws NonExistingClientException {
        if(!this.clientes.containsKey(nif))
            throw new NonExistingClientException();

        if (!this.llamadas.containsKey(nif))
            this.llamadas.put(nif, new ArrayList<Llamada>());
        this.llamadas.get(nif).add(llamada);
        return true;
    }

    public List<Llamada> listarLlamadasCliente(String nif) throws NonExistingClientException {
        if (this.llamadas.containsKey(nif)) {
            return this.llamadas.get(nif);
        }
        throw new NonExistingClientException();
    }

    public Collection<Llamada> mostrarListadoLlamadasFechas(String nif, Calendar fechaInicio, Calendar fechaFin) throws ListLlamadasNullExecption, IllegalPeriodException, NonExistingClientException{
        if(fechaInicio.after(fechaFin))
            throw new IllegalPeriodException();

        if(!this.llamadas.containsKey(nif))
            throw new NonExistingClientException();

        Collection<Llamada> llamadas = this.llamadas.get(nif);
        llamadas = EntreFechas.listentrefechas(llamadas, fechaInicio, fechaFin);
        if(llamadas.isEmpty())
            throw new ListLlamadasNullExecption();

        return llamadas;
    }

    // OPERACIONES DE LAS FACTURAS

    public Factura emitirFactura(String nif, Calendar fechaFacturacion) throws NonExistingClientException{
        if(!this.clientes.containsKey(nif))
            throw new NonExistingClientException();

        int codigo = this.facturasCodigo.size();
        Tarifa tarifa = this.clientes.get(nif).getTarifa();
        Calendar fechaEmision = Calendar.getInstance();

        int duracionLlamadas = 0;
        List<Llamada> listaLlamadas = this.llamadas.get(nif);
        for (Llamada llamada : listaLlamadas) {
            if (llamada.getFecha().after(fechaFacturacion) && llamada.getFecha().before(fechaEmision))
                duracionLlamadas += llamada.getDuracion_llamada();
        }

        double importe = (tarifa.getEuromin() / 60) * duracionLlamadas;

        Factura factura = new Factura(codigo, tarifa, fechaEmision,importe);

        if (this.facturas.get(nif) == null)
            this.facturas.put(nif, new ArrayList<Factura>());

        this.facturas.get(nif).add(factura);
        this.facturasCodigo.put(codigo, factura);

        return factura;

    }

    public Factura recuperarDatosFacturaCodigo(Integer codigo) throws NonExistingBillException {
        if (this.facturasCodigo.containsKey(codigo))
            return this.facturasCodigo.get(codigo);

        throw new NonExistingBillException();
    }

    public List<Factura> recuperarFacturas(String nif) throws NonExistingClientException, ListLlamadasNullExecption {
        if (!this.facturas.containsKey(nif))
            throw new NonExistingClientException();

        List<Factura> listaFacturas = this.facturas.get(nif);
        if(listaFacturas.isEmpty())
            throw new ListLlamadasNullExecption();

        return listaFacturas;
    }

    public Collection<Factura> mostrarListadoFacturasFechas(String nif, Calendar fechaInicio, Calendar fechaFin) throws IllegalPeriodException, NonExistingClientException, ListLlamadasNullExecption {
        if(fechaInicio.after(fechaFin))
            throw new IllegalPeriodException();

        if(!this.facturas.containsKey(nif))
            throw new NonExistingClientException();

        Collection<Factura> facturas = this.facturas.get(nif);
        facturas = EntreFechas.listentrefechas(facturas, fechaInicio, fechaFin);

        if(facturas.isEmpty())
            throw new ListLlamadasNullExecption();

        return facturas;
    }

    // I/O

    public void guardarDatos() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("io/clientes.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(clientes);
            fos = new FileOutputStream("io/facturas.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(facturas);
            fos = new FileOutputStream("io/facturasCodigo.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(facturasCodigo);
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
            fis = new FileInputStream("io/facturasCodigo.bin");
            ois = new ObjectInputStream(fis);
            facturasCodigo= (HashMap<Integer, Factura>) ois.readObject();
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
    }

}
