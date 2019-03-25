package Tarifas;

import java.io.Serializable;

public class Tarifa implements Serializable {
    private double euromin;

    public Tarifa(double euromin) {
        this.euromin = euromin;
    }

    public double getEuromin() {
        return euromin;
    }

    public void setEuromin(double euromin) {
        this.euromin = euromin;
    }

    @Override
    public String toString() {
        return "Tarifas.Tarifa{" +
                "euromin=" + euromin +
                '}';
    }
}
