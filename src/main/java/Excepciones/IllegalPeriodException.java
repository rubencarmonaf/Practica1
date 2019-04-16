package Excepciones;

public class IllegalPeriodException extends Throwable {

    private static final long serialVersionUID = 7891655709356644088L;

    public IllegalPeriodException(){
        super("Fallo en el perido");
    }
}
