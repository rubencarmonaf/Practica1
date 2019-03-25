package menu;

import java.util.*;
import data.Cartera;

public class Menu {
    private Cartera cartera = new Cartera();

    public static void main(String [ ] args) {
        new Menu().ejecuta();
    }

    private void ejecuta() {
        Scanner scanner = new Scanner(System.in);
        OpcionMenu opcionMenu;
        do {
            System.out.println(OpcionMenu.menu());
            System.out.print("Introduce una opción:");
            opcionMenu = OpcionMenu.filtraOpcion(scanner.nextInt());
            opcionMenu.ejecuta(cartera);
        } while(opcionMenu != OpcionMenu.SALIR);
    }
}
