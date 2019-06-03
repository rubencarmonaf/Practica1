package Facturas;

import Fechas.EntreFechas;
import Tarifas.Tarifa;

import java.io.Serializable;
import java.util.Calendar;

public class Factura extends EntreFechas implements Serializable {

    private int codigo;
    private Tarifa tarifa;
    private Calendar fechaEmision;
    private double importe;

    public Factura() { }

    public Factura(int codigo, Tarifa tarifa, Calendar fechaEmision, double importe) {
        this.codigo = codigo;
        this.tarifa = tarifa;
        this.fechaEmision = fechaEmision;
        this.importe = importe;
    }

    public Calendar getFecha() {
        return fechaEmision;
    }

    public int getCodigo() {
        return codigo;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public double getImporte() {
        return importe;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public void setFecha_emision(Calendar fecha_emision) {
        this.fechaEmision = fecha_emision;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Facturas.Factura{" +
                "codigo=" + codigo +
                ", tarifa=" + tarifa +
                ", fecha_emision=" + fechaEmision +
                ", importe=" + importe +
                '}';
    }
}
