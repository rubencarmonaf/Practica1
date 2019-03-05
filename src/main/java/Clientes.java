import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Clientes {

    protected String nombre;
    protected String NIF;
    protected Direcciones direccion;
    protected String correo_electronico;
    protected Calendar fecha_alta;
    protected Tarifa tarifa;
    protected List<Llamadas> Listallamadas = new ArrayList<>();
    protected List<Facturas> Listafacturas = new ArrayList<>();

    public Clientes(String nombre, String NIF, Direcciones direccion, String correo_electronico, Calendar fecha_alta, Tarifa tarifa) {
        this.nombre = nombre;
        this.NIF = NIF;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.fecha_alta = fecha_alta;
        this.tarifa = tarifa;
    }

    public void añadirllamada(Llamadas llamada) {
        Listallamadas.add(llamada);
    }

    public List<Llamadas> mostrarllamadas(){
        return Listallamadas;
    }

    public void añadrifactura(Facturas factura) {
        Listafacturas.add(factura);
    }

    public List<Facturas> mostrarfacturas(){
        return Listafacturas;
    }

    public Calendar getFecha() {
        return fecha_alta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public Direcciones getDireccion() {
        return direccion;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setDireccion(Direcciones direccion) {
        this.direccion = direccion;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public void setFecha_alta(Calendar fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nombre='" + nombre + '\'' +
                ", NIF='" + NIF + '\'' +
                ", direccion=" + direccion +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", fecha_alta=" + fecha_alta +
                ", tarifa=" + tarifa +
                '}';
    }
}
