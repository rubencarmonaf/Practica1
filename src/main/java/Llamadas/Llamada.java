package Llamadas;

import Fechas.EntreFechas;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Llamada extends EntreFechas implements Serializable {

    private static final long serialVersionUID = -3233202990795471243L;
    private int numero_llamado;
    private Calendar fecha_llamada;
    private Date hora_llamada;
    private int duracion_llamada;

    public Llamada(int numero_llamado, Calendar fecha_llamada, Date hora_llamada, int duracion_llamada) {
        this.numero_llamado = numero_llamado;
        this.fecha_llamada = fecha_llamada;
        this.hora_llamada = hora_llamada;
        this.duracion_llamada = duracion_llamada;
    }

    public Calendar getFecha() {
        return fecha_llamada;
    }

    public int getNumero_llamado() {
        return numero_llamado;
    }

    public Date getHora_llamada() {
        return hora_llamada;
    }

    public double getDuracion_llamada() {
        return duracion_llamada;
    }

    public void setNumero_llamado(int numero_llamado) {
        this.numero_llamado = numero_llamado;
    }

    public void setFecha_llamada(Calendar fecha_llamada) {
        this.fecha_llamada = fecha_llamada;
    }

    public void setHora_llamada(Date hora_llamada) {
        this.hora_llamada = hora_llamada;
    }

    public void setDuracion_llamada(int duracion_llamada) {
        this.duracion_llamada = duracion_llamada;
    }

    @Override
    public String toString() {
        return "Llamadas.Llamada{" +
                "numero_llamado='" + numero_llamado + '\'' +
                ", fecha_llamada=" + fecha_llamada +
                ", hora_llamada='" + hora_llamada + '\'' +
                ", duracion_llamada=" + duracion_llamada +
                '}';
    }
}