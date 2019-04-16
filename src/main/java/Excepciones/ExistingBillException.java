package Excepciones;

public class ExistingBillException extends Exception {

    private static final long serialVersionUID = 7891655709476644088L;

    public ExistingBillException(){
        super("La factura ya existe");
    }
}
