package tiendita.com.tienda.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cresh on 14/12/2016.
 */

public final class CarritoHax {

    private static List<LineItem> carrito = new ArrayList<>();

    public static void add2Carrito(LineItem nuevo)
    {
        carrito.add(nuevo);
    }

    public static int cantItems()
    {
        return carrito.size();
    }

    public static List<LineItem> getItems() {
        return carrito;
    }

    public static void remove() {
        carrito.clear();
    }
}
