package tiendita.com.tienda.pojo;
/**
 * Created by Cresh on 14/12/2016.
 */

public final class CarritoHax {

    private static LineItem[] carrito = new LineItem[0];

    public static void add2Carrito(LineItem nuevo)
    {
        int aLen = carrito.length;
        LineItem[] c = new LineItem[aLen+1];
        System.arraycopy(carrito, 0, c, 0, aLen);
        c[aLen] = nuevo;
        carrito = c;
    }

    public static int cantItems()
    {
        return carrito.length;
    }

    public static LineItem[] getItems() {
        return carrito;
    }
}
