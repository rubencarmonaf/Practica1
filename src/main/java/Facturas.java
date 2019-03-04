import java.util.Calendar;

public class Facturas {

    private int codigo;
    private Tarifa tarifa;
    private Calendar fecha_emision;
    private Calendar fecha_facturacion;
    private int importe;

    public Facturas(int codigo, Tarifa tarifa, Calendar fecha_emision, Calendar fecha_facturacion, int importe) {
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

    public int getImporte() {
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

    public void setImporte(int importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Facturas{" +
                "codigo=" + codigo +
                ", tarifa=" + tarifa +
                ", fecha_emision=" + fecha_emision +
                ", fecha_facturacion=" + fecha_facturacion +
                ", importe=" + importe +
                '}';
    }
}
