
package tiendita.com.tienda.pojo;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Total {

    private String sales;
    private Integer orders;
    private Integer items;
    private String tax;
    private String shipping;
    private String discount;
    private Integer customers;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private String date;

    public Total(JSONObject currentTotal, String date) {
        this.sales = currentTotal.optString("sales");
        this.orders = currentTotal.optInt("orders");
        this.items = currentTotal.optInt("items");
        this.tax = currentTotal.optString("tax");
        this.shipping = currentTotal.optString("shipping");
        this.customers = currentTotal.optInt("customers");
        this.date = date;
    }

    /**
     * @return The sales
     */
    public String getSales() {
        return sales;
    }

    /**
     * @param sales The sales
     */
    public void setSales(String sales) {
        this.sales = sales;
    }

    /**
     * @return The orders
     */
    public Integer getOrders() {
        return orders;
    }

    /**
     * @param orders The orders
     */
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    /**
     * @return The items
     */
    public Integer getItems() {
        return items;
    }

    /**
     * @param items The items
     */
    public void setItems(Integer items) {
        this.items = items;
    }

    /**
     * @return The tax
     */
    public String getTax() {
        return tax;
    }

    /**
     * @param tax The tax
     */
    public void setTax(String tax) {
        this.tax = tax;
    }

    /**
     * @return The shipping
     */
    public String getShipping() {
        return shipping;
    }

    /**
     * @param shipping The shipping
     */
    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    /**
     * @return The discount
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * @param discount The discount
     */
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    /**
     * @return The customers
     */
    public Integer getCustomers() {
        return customers;
    }

    /**
     * @param customers The customers
     */
    public void setCustomers(Integer customers) {
        this.customers = customers;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getDate() {
        return date;
    }
}
