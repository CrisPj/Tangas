
package tiendita.com.tienda.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Products {

    private List<Product> products = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @param products The products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Product getProduct(int index) {
        return products.get(index);
    }

    public int getSize() {
        return products.size();
    }
}
