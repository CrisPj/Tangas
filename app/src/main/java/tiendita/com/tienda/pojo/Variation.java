
package tiendita.com.tienda.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Variation {

    private Integer id;
    private String createdAt;
    private String updatedAt;
    private Boolean downloadable;
    private Boolean virtual;
    private String permalink;
    private String sku;
    private String price;
    private String regularPrice;
    private Object salePrice;
    private Boolean taxable;
    private String taxStatus;
    private String taxClass;
    private Boolean managingStock;
    private Integer stockQuantity;
    private Boolean inStock;
    private Boolean backordered;
    private Boolean purchaseable;
    private Boolean visible;
    private Boolean onSale;
    private Object weight;
    private Dimensions_ dimensions;
    private String shippingClass;
    private Object shippingClassId;
    private List<Image_> image = null;
    private List<Attribute_> attributes = null;
    private List<Object> downloads = null;
    private Integer downloadLimit;
    private Integer downloadExpiry;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 
     * @param createdAt
     *     The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 
     * @return
     *     The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 
     * @param updatedAt
     *     The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 
     * @return
     *     The downloadable
     */
    public Boolean getDownloadable() {
        return downloadable;
    }

    /**
     * 
     * @param downloadable
     *     The downloadable
     */
    public void setDownloadable(Boolean downloadable) {
        this.downloadable = downloadable;
    }

    /**
     * 
     * @return
     *     The virtual
     */
    public Boolean getVirtual() {
        return virtual;
    }

    /**
     * 
     * @param virtual
     *     The virtual
     */
    public void setVirtual(Boolean virtual) {
        this.virtual = virtual;
    }

    /**
     * 
     * @return
     *     The permalink
     */
    public String getPermalink() {
        return permalink;
    }

    /**
     * 
     * @param permalink
     *     The permalink
     */
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    /**
     * 
     * @return
     *     The sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * 
     * @param sku
     *     The sku
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * 
     * @return
     *     The price
     */
    public String getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The regularPrice
     */
    public String getRegularPrice() {
        return regularPrice;
    }

    /**
     * 
     * @param regularPrice
     *     The regular_price
     */
    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    /**
     * 
     * @return
     *     The salePrice
     */
    public Object getSalePrice() {
        return salePrice;
    }

    /**
     * 
     * @param salePrice
     *     The sale_price
     */
    public void setSalePrice(Object salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * 
     * @return
     *     The taxable
     */
    public Boolean getTaxable() {
        return taxable;
    }

    /**
     * 
     * @param taxable
     *     The taxable
     */
    public void setTaxable(Boolean taxable) {
        this.taxable = taxable;
    }

    /**
     * 
     * @return
     *     The taxStatus
     */
    public String getTaxStatus() {
        return taxStatus;
    }

    /**
     * 
     * @param taxStatus
     *     The tax_status
     */
    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }

    /**
     * 
     * @return
     *     The taxClass
     */
    public String getTaxClass() {
        return taxClass;
    }

    /**
     * 
     * @param taxClass
     *     The tax_class
     */
    public void setTaxClass(String taxClass) {
        this.taxClass = taxClass;
    }

    /**
     * 
     * @return
     *     The managingStock
     */
    public Boolean getManagingStock() {
        return managingStock;
    }

    /**
     * 
     * @param managingStock
     *     The managing_stock
     */
    public void setManagingStock(Boolean managingStock) {
        this.managingStock = managingStock;
    }

    /**
     * 
     * @return
     *     The stockQuantity
     */
    public Integer getStockQuantity() {
        return stockQuantity;
    }

    /**
     * 
     * @param stockQuantity
     *     The stock_quantity
     */
    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    /**
     * 
     * @return
     *     The inStock
     */
    public Boolean getInStock() {
        return inStock;
    }

    /**
     * 
     * @param inStock
     *     The in_stock
     */
    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    /**
     * 
     * @return
     *     The backordered
     */
    public Boolean getBackordered() {
        return backordered;
    }

    /**
     * 
     * @param backordered
     *     The backordered
     */
    public void setBackordered(Boolean backordered) {
        this.backordered = backordered;
    }

    /**
     * 
     * @return
     *     The purchaseable
     */
    public Boolean getPurchaseable() {
        return purchaseable;
    }

    /**
     * 
     * @param purchaseable
     *     The purchaseable
     */
    public void setPurchaseable(Boolean purchaseable) {
        this.purchaseable = purchaseable;
    }

    /**
     * 
     * @return
     *     The visible
     */
    public Boolean getVisible() {
        return visible;
    }

    /**
     * 
     * @param visible
     *     The visible
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * 
     * @return
     *     The onSale
     */
    public Boolean getOnSale() {
        return onSale;
    }

    /**
     * 
     * @param onSale
     *     The on_sale
     */
    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    /**
     * 
     * @return
     *     The weight
     */
    public Object getWeight() {
        return weight;
    }

    /**
     * 
     * @param weight
     *     The weight
     */
    public void setWeight(Object weight) {
        this.weight = weight;
    }

    /**
     * 
     * @return
     *     The dimensions
     */
    public Dimensions_ getDimensions() {
        return dimensions;
    }

    /**
     * 
     * @param dimensions
     *     The dimensions
     */
    public void setDimensions(Dimensions_ dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * 
     * @return
     *     The shippingClass
     */
    public String getShippingClass() {
        return shippingClass;
    }

    /**
     * 
     * @param shippingClass
     *     The shipping_class
     */
    public void setShippingClass(String shippingClass) {
        this.shippingClass = shippingClass;
    }

    /**
     * 
     * @return
     *     The shippingClassId
     */
    public Object getShippingClassId() {
        return shippingClassId;
    }

    /**
     * 
     * @param shippingClassId
     *     The shipping_class_id
     */
    public void setShippingClassId(Object shippingClassId) {
        this.shippingClassId = shippingClassId;
    }

    /**
     * 
     * @return
     *     The image
     */
    public List<Image_> getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(List<Image_> image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The attributes
     */
    public List<Attribute_> getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    public void setAttributes(List<Attribute_> attributes) {
        this.attributes = attributes;
    }

    /**
     * 
     * @return
     *     The downloads
     */
    public List<Object> getDownloads() {
        return downloads;
    }

    /**
     * 
     * @param downloads
     *     The downloads
     */
    public void setDownloads(List<Object> downloads) {
        this.downloads = downloads;
    }

    /**
     * 
     * @return
     *     The downloadLimit
     */
    public Integer getDownloadLimit() {
        return downloadLimit;
    }

    /**
     * 
     * @param downloadLimit
     *     The download_limit
     */
    public void setDownloadLimit(Integer downloadLimit) {
        this.downloadLimit = downloadLimit;
    }

    /**
     * 
     * @return
     *     The downloadExpiry
     */
    public Integer getDownloadExpiry() {
        return downloadExpiry;
    }

    /**
     * 
     * @param downloadExpiry
     *     The download_expiry
     */
    public void setDownloadExpiry(Integer downloadExpiry) {
        this.downloadExpiry = downloadExpiry;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
