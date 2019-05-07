package Excepciones;

public class NonExistingBillException extends Exception {

    private static final long serialVersionUID = 789162709476644088L;

    public NonExistingBillException(){
        super("La factura no existe");
    }
}
