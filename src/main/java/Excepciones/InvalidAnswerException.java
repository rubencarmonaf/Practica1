package Excepciones;

public class InvalidAnswerException extends Exception {

    private static final long serialVersionUID = 1234655709356644088L;

    public InvalidAnswerException(){
        super("Respuesta no valida.");
    }
}
