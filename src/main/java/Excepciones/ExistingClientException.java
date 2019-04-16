package Excepciones;

public class ExistingClientException extends Exception {
    private static final long serialVersionUID = 7891655709476644098L;

    public ExistingClientException(){
        super("El cliente introducido ya está registrado");
    }
}
