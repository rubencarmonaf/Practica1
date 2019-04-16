package Tarifas;

import Llamadas.Llamada;

import java.io.Serializable;

public abstract class Tarifa implements Serializable {
    private static final long serialVersionUID = -3948344019451414987L;
    private double euromin;

    public Tarifa() {
        super();
    }

    public Tarifa(double euromin) {
        this.euromin = euromin;
    }

    public Tarifa(Tarifa tarifa){
        this.euromin = tarifa.euromin;
    }

    public double getEuromin() {
        return euromin;
    }

    public void setEuromin(double euromin) {
        this.euromin = euromin;
    }

    public abstract double calcularImporte(Llamada llamada);

    @Override
    public String toString() {
        return "Tarifas.Tarifa{" +
                "euromin=" + euromin +
                '}';
    }
}
