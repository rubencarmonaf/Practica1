package menu;

import data.Cartera;

public enum OpcionMenu {
    SALIR("Salir", new Salir()),
    NUEVO_PARTICULAR("Nuevo particular", new NuevoParticular()),
    NUEVA_EMPRESA("Nueva empresa", new NuevaEmpresa()),
    NUEVA_LLAMADA("Nueva llamada", new NuevaLlamada()),
    NUEVA_FACTURA("Nueva Factura", new NuevaFactura()),
    BORRAR_CLIENTE("Borrar cliente", new BorrarClientes()),
    BUSCAR_CLIENTE("Buscar cliente", new BuscarClientes()),
    DATOS_CLIENE("Datos cliente", new DatosCliente()),
    CAMBIAR_TARIFA("Cambiar tarifa", new CambiarTarifa()),
    DATOS_FACTURA("Datos factura", new DatosFactura()),
    LISTADO_LLAMADAS("Listado llamadas", new ListadoLlamadas()),
    MOSTRAR_FACTURA("Mostrar factura", new MostrarFactura());

    private String descripcion;
    private EjecutaOpcion ejecutaOpcion;

    OpcionMenu(String descripcion, EjecutaOpcion ejecutaOpcion) {
        this.descripcion = descripcion;
        this.ejecutaOpcion = ejecutaOpcion;
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

    public static OpcionMenu filtraOpcion(int posicion) {
        return values()[posicion];
    }

    public void ejecuta(Cartera cartera) {
        ejecutaOpcion.ejecuta(cartera);
    }
}
