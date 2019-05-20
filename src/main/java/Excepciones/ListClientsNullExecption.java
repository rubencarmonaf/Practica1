package Excepciones;

public class ListClientsNullExecption extends Exception {

    private static final long serialVersionUID = 7891655709576678092L;

    public ListClientsNullExecption(){
        super("La lista de clientes está vacía.");
    }
}
