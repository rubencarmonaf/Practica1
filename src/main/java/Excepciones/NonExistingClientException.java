package Excepciones;

public class NonExistingClientException extends Exception {
    private static final long serialVersionUID = 7891655709476644088L;

    public NonExistingClientException(){
        super("El cliente no exite");
    }
}
