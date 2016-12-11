package tiendita.com.tienda.contents;

import android.content.Context;

import org.json.JSONException;

import java.util.concurrent.ExecutionException;

import tiendita.com.tienda.api.WooCommerceAPI;
import tiendita.com.tienda.entities.Product;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class ProductContent {

    /**
     * An array of sample (dummy) items.
     */
    public Product[] ITEMS = new Product[0];

    public ProductContent(Context context) {
        WooCommerceAPI wapi = new WooCommerceAPI(context);
        try {
            this.ITEMS = wapi.fetchAllProducts();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public boolean addmora(Context context) {
        WooCommerceAPI wapi = new WooCommerceAPI(context);
        Product[] nProducts = new Product[0];
        try {
            nProducts = wapi.fetchProducts(ITEMS.length);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (nProducts.length > 0) {
            ITEMS = concat(ITEMS, nProducts);
            return true;
        } else
            return false;
    }


    private Product[] concat(Product[] a, Product[] b) {
        int aLen = a.length;
        int bLen = b.length;
        Product[] c = new Product[aLen + bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }
}
