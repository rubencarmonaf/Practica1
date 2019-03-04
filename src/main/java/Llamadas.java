import java.util.Calendar;
import java.util.Date;

public class Llamadas {

    private String numero_llamado;
    private Calendar fecha_llamada;
    private Date hora_llamada;
    private double duracion_llamada;

    public Llamadas(String numero_llamado, Calendar fecha_llamada, Date hora_llamada, double duracion_llamada) {
        this.numero_llamado = numero_llamado;
        this.fecha_llamada = fecha_llamada;
        this.hora_llamada = hora_llamada;
        this.duracion_llamada = duracion_llamada;
    }

    public Calendar getFecha() {
        return fecha_llamada;
    }

    public String getNumero_llamado() {
        return numero_llamado;
    }

    public Date getHora_llamada() {
        return hora_llamada;
    }

    public double getDuracion_llamada() {
        return duracion_llamada;
    }

    public void setNumero_llamado(String numero_llamado) {
        this.numero_llamado = numero_llamado;
    }

    public void setFecha_llamada(Calendar fecha_llamada) {
        this.fecha_llamada = fecha_llamada;
    }

    public void setHora_llamada(Date hora_llamada) {
        this.hora_llamada = hora_llamada;
    }

    public void setDuracion_llamada(double duracion_llamada) {
        this.duracion_llamada = duracion_llamada;
    }

    @Override
    public String toString() {
        return "Llamadas{" +
                "numero_llamado='" + numero_llamado + '\'' +
                ", fecha_llamada=" + fecha_llamada +
                ", hora_llamada='" + hora_llamada + '\'' +
                ", duracion_llamada=" + duracion_llamada +
                '}';
    }
}