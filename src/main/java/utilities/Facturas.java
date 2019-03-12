package utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Facturas {

    private int codigo;
    private Tarifa tarifa;
    private LocalDate fecha_emision;
    private LocalDateTime [] fecha_facturacion;
    private double importe;

    public Facturas(int codigo, Tarifa tarifa, LocalDate fecha_emision, LocalDateTime [] fecha_facturacion, double importe) {
        this.codigo = codigo;
        this.tarifa = tarifa;
        this.fecha_emision = fecha_emision;
        this.fecha_facturacion = fecha_facturacion;
        this.importe = importe;
    }

    public LocalDate getFecha() {
        return fecha_emision;
    }

    public int getCodigo() {
        return codigo;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public LocalDateTime [] getFecha_facturacion() {
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

    public void setFecha_emision(LocalDate fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public void setFecha_facturacion(LocalDateTime [] fecha_facturacion) {
        this.fecha_facturacion = fecha_facturacion;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "utilities.Facturas{" +
                "codigo=" + codigo +
                ", tarifa=" + tarifa +
                ", fecha_emision=" + fecha_emision +
                ", fecha_facturacion=" + fecha_facturacion +
                ", importe=" + importe +
                '}';
    }
}
