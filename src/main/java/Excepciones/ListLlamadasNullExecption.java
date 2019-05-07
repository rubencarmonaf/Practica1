package Excepciones;

public class ListLlamadasNullExecption extends Exception {

    private static final long serialVersionUID = 7891655709476644092L;

    public ListLlamadasNullExecption(){
        super("La lista de llamadas está vacía.");
    }
}
