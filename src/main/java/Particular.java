import java.util.Calendar;

public class Particular extends Clientes {

    private String apellidos;

    public Particular(String nombre, String apellidos, String NIF, Direcciones direccion, String correo_electronico, Calendar fecha_alta, Tarifa tarifa) {
        super(nombre, NIF, direccion, correo_electronico, fecha_alta, tarifa);
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Particular{" +
                "apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", NIF='" + NIF + '\'' +
                ", direccion=" + direccion +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", fecha_alta=" + fecha_alta +
                ", tarifa=" + tarifa +
                '}';
    }
}
