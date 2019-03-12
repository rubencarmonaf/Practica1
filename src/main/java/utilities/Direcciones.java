package utilities;

public class Direcciones {

    private String codigo_postal;
    private String provincia;
    private String poblacion;

    public Direcciones(String codigo_postal, String provincia, String poblacion) {
        this.codigo_postal = codigo_postal;
        this.provincia = provincia;
        this.poblacion = poblacion;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "utilities.Direcciones{" +
                "codigo_postal='" + codigo_postal + '\'' +
                ", provincia='" + provincia + '\'' +
                ", poblacion='" + poblacion + '\'' +
                '}';
    }
}