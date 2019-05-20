package Fechas;

import Excepciones.IllegalPeriodException;

import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;

public class EntreFechas {

    private Calendar fecha;

    public Calendar getFecha() {
        return this.fecha;
    }

    public static <T extends EntreFechas> Collection<T> listentrefechas(Collection<T> datos, Calendar fecha_inicio, Calendar fecha_fin) throws IllegalPeriodException {
        if(fecha_inicio.after(fecha_fin)) {
            throw new IllegalPeriodException();
        }
        Collection<T> res = new LinkedList<T>();
        for(T dato : datos) {
            if (fecha_inicio.before(dato.getFecha()) && fecha_fin.after(dato.getFecha())) {
                res.add(dato);
            }
        }
        return res;
    }
}
