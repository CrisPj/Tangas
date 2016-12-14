
package tiendita.com.tienda.pojo;

import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
        JSONObject jsonTotals = jsonObject.optJSONObject("totals");
        // Init totals
        this.totals = new ArrayList<>();
        // Build totals
        Iterator<?> keys = jsonTotals.keys();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            JSONObject currentTotal = jsonTotals.optJSONObject(key);
            if (currentTotal instanceof JSONObject)
                this.totals.add(new Total(currentTotal, key));
        }
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

    public BarDataSet getSalesDataset(String label) {
        // Create List of Entries
        List<BarEntry> entries = new ArrayList<>(totals.size());
        int i = 0;
        for (Total total : totals) {
            BarEntry entry = new BarEntry(i, Float.parseFloat(total.getSales()), total.getDate());
            entries.add(entry);
            i++;
        }
        BarDataSet dataset = new BarDataSet(entries, "Ventas");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        return dataset;
    }

    public PieDataSet getPieSalesDataset() {
        // Create List of Entries
        List<PieEntry> entries = new ArrayList<>(totals.size());
        int i = 0;
        for (Total total : totals) {
            PieEntry entry = new PieEntry(Float.parseFloat(total.getSales()), total.getDate());
            entries.add(entry);
            i++;
        }
        PieDataSet dataset = new PieDataSet(entries, "Ventas");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        return dataset;
    }

    public BarDataSet getItemsDataset(String label) {
        // Create List of Entries
        List<BarEntry> entries = new ArrayList<>(totals.size());
        int i = 0;
        for (Total total : totals) {
            BarEntry entry = new BarEntry(i, total.getItems(), total.getDate());
            entries.add(entry);
            i++;
        }
        BarDataSet dataset = new BarDataSet(entries, "Artículos");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        return dataset;
    }

    public PieDataSet getPieItemsDataset() {
        // Create List of Entries
        List<PieEntry> entries = new ArrayList<>(totals.size());
        int i = 0;
        for (Total total : totals) {
            PieEntry entry = new PieEntry(total.getItems(), total.getDate());
            entries.add(entry);
            i++;
        }
        PieDataSet dataset = new PieDataSet(entries, "Artículos");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        return dataset;
    }

    public BarDataSet getOrdersDataset(String period) {
        // Create List of Entries
        List<BarEntry> entries = new ArrayList<>(totals.size());
        int i = 0;
        for (Total total : totals) {
            BarEntry entry = new BarEntry(i, total.getOrders(), total.getDate());
            entries.add(entry);
            i++;
        }
        BarDataSet dataset = new BarDataSet(entries, "Órdenes");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        return dataset;
    }

    public PieDataSet getPieOrdersDataset() {
        // Create List of Entries
        List<PieEntry> entries = new ArrayList<>(totals.size());
        int i = 0;
        for (Total total : totals) {
            PieEntry entry = new PieEntry(total.getOrders(), total.getDate());
            entries.add(entry);
            i++;
        }
        PieDataSet dataset = new PieDataSet(entries, "Órdenes");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        return dataset;
    }

    public IBarDataSet getAverageDataset(String period) {
        // Create List of Entries
        List<BarEntry> entries = new ArrayList<>(totals.size());
        int i = 0;
        for (Total total : totals) {
            BarEntry entry = new BarEntry(i, Float.parseFloat(total.getShipping()), total.getDate());
            entries.add(entry);
            i++;
        }
        BarDataSet dataset = new BarDataSet(entries, "Promedio");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        return dataset;
    }

    public PieDataSet getPieAverageDataset() {
        // Create List of Entries
        List<PieEntry> entries = new ArrayList<>(totals.size());
        int i = 0;
        for (Total total : totals) {
            PieEntry entry = new PieEntry(Float.parseFloat(total.getShipping()), total.getDate());
            entries.add(entry);
            i++;
        }
        PieDataSet dataset = new PieDataSet(entries, "Promedio");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        return dataset;
    }

    public BarDataSet getTaxDataset(String period) {
        // Create List of Entries
        List<BarEntry> entries = new ArrayList<>(totals.size());
        int i = 0;
        for (Total total : totals) {
            BarEntry entry = new BarEntry(i, Float.parseFloat(total.getTax()), total.getDate());
            entries.add(entry);
            i++;
        }
        BarDataSet dataset = new BarDataSet(entries, "Impuestos");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        return dataset;
    }

    public PieDataSet getPieTaxDataset() {
        // Create List of Entries
        List<PieEntry> entries = new ArrayList<>(totals.size());
        int i = 0;
        for (Total total : totals) {
            PieEntry entry = new PieEntry(Float.parseFloat(total.getTax()), total.getDate());
            entries.add(entry);
            i++;
        }
        PieDataSet dataset = new PieDataSet(entries, "Impuestos");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        return dataset;
    }
}
