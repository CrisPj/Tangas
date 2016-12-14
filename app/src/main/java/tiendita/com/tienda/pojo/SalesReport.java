
package tiendita.com.tienda.pojo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesReport {

    private String totalSales;
    private String netSales;
    private String averageSales;
    private Integer totalOrders;
    private Integer totalItems;
    private String totalTax;
    private String totalShipping;
    private Integer totalRefunds;
    private String totalDiscount;
    private String totalsGroupedBy;
    private List<Total> totals = null;
    private Integer totalCustomers;
    private Links links;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public SalesReport(JSONObject jsonObject) {
        this.totalSales = jsonObject.optString("total_sales");
        this.totalShipping = jsonObject.optString("total_shipping");
        this.netSales = jsonObject.optString("net_sales");
        this.averageSales = jsonObject.optString("average_sales");
        this.totalTax = jsonObject.optString("total_tax");
        this.totalOrders = jsonObject.optInt("total_orders");
        this.totalItems = jsonObject.optInt("total_items");
        this.totalRefunds = jsonObject.optInt("total_refunds");
        this.totalDiscount = jsonObject.optString("total_discount");
        this.totalsGroupedBy = jsonObject.optString("totals_grouped_by");
        JSONArray jsonArray = jsonObject.optJSONArray("totals");
    }

    /**
     * @return The totalSales
     */
    public String getTotalSales() {
        return totalSales;
    }

    /**
     * @param totalSales The total_sales
     */
    public void setTotalSales(String totalSales) {
        this.totalSales = totalSales;
    }

    /**
     * @return The netSales
     */
    public String getNetSales() {
        return netSales;
    }

    /**
     * @param netSales The net_sales
     */
    public void setNetSales(String netSales) {
        this.netSales = netSales;
    }

    /**
     * @return The averageSales
     */
    public String getAverageSales() {
        return averageSales;
    }

    /**
     * @param averageSales The average_sales
     */
    public void setAverageSales(String averageSales) {
        this.averageSales = averageSales;
    }

    /**
     * @return The totalOrders
     */
    public Integer getTotalOrders() {
        return totalOrders;
    }

    /**
     * @param totalOrders The total_orders
     */
    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }

    /**
     * @return The totalItems
     */
    public Integer getTotalItems() {
        return totalItems;
    }

    /**
     * @param totalItems The total_items
     */
    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * @return The totalTax
     */
    public String getTotalTax() {
        return totalTax;
    }

    /**
     * @param totalTax The total_tax
     */
    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    /**
     * @return The totalShipping
     */
    public String getTotalShipping() {
        return totalShipping;
    }

    /**
     * @param totalShipping The total_shipping
     */
    public void setTotalShipping(String totalShipping) {
        this.totalShipping = totalShipping;
    }

    /**
     * @return The totalRefunds
     */
    public Integer getTotalRefunds() {
        return totalRefunds;
    }

    /**
     * @param totalRefunds The total_refunds
     */
    public void setTotalRefunds(Integer totalRefunds) {
        this.totalRefunds = totalRefunds;
    }

    /**
     * @return The totalDiscount
     */
    public String getTotalDiscount() {
        return totalDiscount;
    }

    /**
     * @param totalDiscount The total_discount
     */
    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    /**
     * @return The totalsGroupedBy
     */
    public String getTotalsGroupedBy() {
        return totalsGroupedBy;
    }

    /**
     * @param totalsGroupedBy The totals_grouped_by
     */
    public void setTotalsGroupedBy(String totalsGroupedBy) {
        this.totalsGroupedBy = totalsGroupedBy;
    }

    /**
     * @return The totals
     */
    public List<Total> getTotals() {
        return totals;
    }

    /**
     * @param totals The totals
     */
    public void setTotals(List<Total> totals) {
        this.totals = totals;
    }

    /**
     * @return The totalCustomers
     */
    public Integer getTotalCustomers() {
        return totalCustomers;
    }

    /**
     * @param totalCustomers The total_customers
     */
    public void setTotalCustomers(Integer totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    /**
     * @return The links
     */
    public Links getLinks() {
        return links;
    }

    /**
     * @param links The _links
     */
    public void setLinks(Links links) {
        this.links = links;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
