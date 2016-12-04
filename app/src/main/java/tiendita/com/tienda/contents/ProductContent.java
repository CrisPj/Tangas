package tiendita.com.tienda.contents;

import android.content.Context;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
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
    public List<Product> ITEMS = new ArrayList<Product>();

    public ProductContent(Context context){
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


}
