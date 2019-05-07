package Facturas;

import Fechas.EntreFechas;
import Tarifas.Tarifa;

import java.io.Serializable;
import java.util.Calendar;

public class Factura extends EntreFechas implements Serializable {

    private int codigo;
    private Tarifa tarifa;
    private Calendar fecha_emision;
    private Calendar fecha_facturacion;
    private double importe;

    public Factura() { }

    public Factura(int codigo, Tarifa tarifa, Calendar fecha_emision, Calendar fecha_facturacion, double importe) {
        this.codigo = codigo;
        this.tarifa = tarifa;
        this.fecha_emision = fecha_emision;
        this.fecha_facturacion = fecha_facturacion;
        this.importe = importe;
    }

    public Calendar getFecha() {
        return fecha_emision;
    }

    public int getCodigo() {
        return codigo;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public Calendar getFecha_facturacion() {
        return fecha_facturacion;
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
        this.fecha_emision = fecha_emision;
    }

    public void setFecha_facturacion(Calendar fecha_facturacion) {
        this.fecha_facturacion = fecha_facturacion;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Facturas.Factura{" +
                "codigo=" + codigo +
                ", tarifa=" + tarifa +
                ", fecha_emision=" + fecha_emision +
                ", fecha_facturacion=" + fecha_facturacion +
                ", importe=" + importe +
                '}';
    }
}
