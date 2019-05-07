package Excepciones;

public class ListFacturasNullExecption extends Exception {

    private static final long serialVersionUID = 7891655709576644092L;

    public ListFacturasNullExecption(){
        super("La lista de facturas está vacía.");
    }
}
