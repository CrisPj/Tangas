
package tiendita.com.tienda.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customers {

    private List<Customer> customers = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The customers
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * 
     * @param customers
     *     The customers
     */
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
