package utilities;

public class Tarifa {
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
        return "utilities.Tarifa{" +
                "euromin=" + euromin +
                '}';
    }
}