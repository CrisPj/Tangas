
package tiendita.com.tienda.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Products {

    private Product[] products = null;
       /**
     * @return The products
     */
    public Product[] getProducts() {
        return products;
    }

    /**
     * @param products The products
     */
    public void setProducts(Product[] products) {
        this.products = products;
    }

    public Product getProduct(int index) {
        return products[index];
    }

    public int getSize() {
        return products.length;
    }
}
