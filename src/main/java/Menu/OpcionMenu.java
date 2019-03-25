package Menu;

import Clientes.Cartera;

public enum OpcionMenu {
    SALIR("Salir"),
    NUEVO_PARTICULAR("Nuevo particular"),
    NUEVA_EMPRESA("Nueva empresa"),
    NUEVA_LLAMADA("Nueva llamada"),
    NUEVA_FACTURA("Nueva Factura"),
    BORRAR_CLIENTE("Borrar cliente"),
    BUSCAR_CLIENTE("Buscar cliente"),
    DATOS_CLIENTE("Datos cliente"),
    CAMBIAR_TARIFA("Cambiar tarifa"),
    DATOS_FACTURA("Datos factura"),
    LISTADO_LLAMADAS("Listado llamadas"),
    MOSTRAR_FACTURA("Mostrar factura"),
    BETWEEN_ALTA_CLIENTE("Consultar  listado de clientes que fueron dados de alta entre dos fechas"),
    BETWEEN_LLAMADAS("Consultar listado de llamadas de un cliente que fueron realizadas entre dos fechas"),
    BETWEEN_FACTURAS("Consultar listado de facturas de un cliente emitidas entre dos fechas");

    private String descripcion;

    OpcionMenu(String descripcion) {
        this.descripcion = descripcion;
    }

    public static String menu() {
        StringBuffer sb = new StringBuffer();
        for(OpcionMenu opcion: OpcionMenu.values()) {
            sb.append(opcion.ordinal());
            sb.append(".- ");
            sb.append(opcion.descripcion);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static OpcionMenu obtenerOpcion(int posicion) {
        return values()[posicion - 1];
    }
}
