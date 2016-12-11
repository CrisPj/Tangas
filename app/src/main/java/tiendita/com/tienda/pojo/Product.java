
package tiendita.com.tienda.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Product {

    private String title;
    private Integer id;
    private String createdAt;
    private String updatedAt;
    private String type;
    private String status;
    private Boolean downloadable;
    private Boolean virtual;
    private String permalink;
    private String sku;
    private String price;
    private String regularPrice;
    private Object salePrice;
    private String priceHtml;
    private Boolean taxable;
    private String taxStatus;
    private String taxClass;
    private Boolean managingStock;
    private Integer stockQuantity;
    private Boolean inStock;
    private Boolean backordersAllowed;
    private Boolean backordered;
    private Boolean soldIndividually;
    private Boolean purchaseable;
    private Boolean featured;
    private Boolean visible;
    private String catalogVisibility;
    private Boolean onSale;
    private Object weight;
    private Dimensions dimensions;
    private Boolean shippingRequired;
    private Boolean shippingTaxable;
    private String shippingClass;
    private Object shippingClassId;
    private String description;
    private String shortDescription;
    private Boolean reviewsAllowed;
    private String averageRating;
    private Integer ratingCount;
    private List<Integer> relatedIds = null;
    private List<Object> upsellIds = null;
    private List<Object> crossSellIds = null;
    private Integer parentId;
    private List<String> categories = null;
    private List<Object> tags = null;
    private List<Image> images = null;
    private String featuredSrc;
    private List<Attribute> attributes = null;
    private List<Object> downloads = null;
    private Integer downloadLimit;
    private Integer downloadExpiry;
    private String downloadType;
    private String purchaseNote;
    private Integer totalSales;
    private List<Variation> variations = null;
    private List<Object> parent = null;
    private List<Object> groupedProducts = null;
    private Integer menuOrder;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

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
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
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
     *     The priceHtml
     */
    public String getPriceHtml() {
        return priceHtml;
    }

    /**
     * 
     * @param priceHtml
     *     The price_html
     */
    public void setPriceHtml(String priceHtml) {
        this.priceHtml = priceHtml;
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
     *     The backordersAllowed
     */
    public Boolean getBackordersAllowed() {
        return backordersAllowed;
    }

    /**
     * 
     * @param backordersAllowed
     *     The backorders_allowed
     */
    public void setBackordersAllowed(Boolean backordersAllowed) {
        this.backordersAllowed = backordersAllowed;
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
     *     The soldIndividually
     */
    public Boolean getSoldIndividually() {
        return soldIndividually;
    }

    /**
     * 
     * @param soldIndividually
     *     The sold_individually
     */
    public void setSoldIndividually(Boolean soldIndividually) {
        this.soldIndividually = soldIndividually;
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
     *     The featured
     */
    public Boolean getFeatured() {
        return featured;
    }

    /**
     * 
     * @param featured
     *     The featured
     */
    public void setFeatured(Boolean featured) {
        this.featured = featured;
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
     *     The catalogVisibility
     */
    public String getCatalogVisibility() {
        return catalogVisibility;
    }

    /**
     * 
     * @param catalogVisibility
     *     The catalog_visibility
     */
    public void setCatalogVisibility(String catalogVisibility) {
        this.catalogVisibility = catalogVisibility;
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
    public Dimensions getDimensions() {
        return dimensions;
    }

    /**
     * 
     * @param dimensions
     *     The dimensions
     */
    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    /**
     * 
     * @return
     *     The shippingRequired
     */
    public Boolean getShippingRequired() {
        return shippingRequired;
    }

    /**
     * 
     * @param shippingRequired
     *     The shipping_required
     */
    public void setShippingRequired(Boolean shippingRequired) {
        this.shippingRequired = shippingRequired;
    }

    /**
     * 
     * @return
     *     The shippingTaxable
     */
    public Boolean getShippingTaxable() {
        return shippingTaxable;
    }

    /**
     * 
     * @param shippingTaxable
     *     The shipping_taxable
     */
    public void setShippingTaxable(Boolean shippingTaxable) {
        this.shippingTaxable = shippingTaxable;
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
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * 
     * @param shortDescription
     *     The short_description
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * 
     * @return
     *     The reviewsAllowed
     */
    public Boolean getReviewsAllowed() {
        return reviewsAllowed;
    }

    /**
     * 
     * @param reviewsAllowed
     *     The reviews_allowed
     */
    public void setReviewsAllowed(Boolean reviewsAllowed) {
        this.reviewsAllowed = reviewsAllowed;
    }

    /**
     * 
     * @return
     *     The averageRating
     */
    public String getAverageRating() {
        return averageRating;
    }

    /**
     * 
     * @param averageRating
     *     The average_rating
     */
    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    /**
     * 
     * @return
     *     The ratingCount
     */
    public Integer getRatingCount() {
        return ratingCount;
    }

    /**
     * 
     * @param ratingCount
     *     The rating_count
     */
    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    /**
     * 
     * @return
     *     The relatedIds
     */
    public List<Integer> getRelatedIds() {
        return relatedIds;
    }

    /**
     * 
     * @param relatedIds
     *     The related_ids
     */
    public void setRelatedIds(List<Integer> relatedIds) {
        this.relatedIds = relatedIds;
    }

    /**
     * 
     * @return
     *     The upsellIds
     */
    public List<Object> getUpsellIds() {
        return upsellIds;
    }

    /**
     * 
     * @param upsellIds
     *     The upsell_ids
     */
    public void setUpsellIds(List<Object> upsellIds) {
        this.upsellIds = upsellIds;
    }

    /**
     * 
     * @return
     *     The crossSellIds
     */
    public List<Object> getCrossSellIds() {
        return crossSellIds;
    }

    /**
     * 
     * @param crossSellIds
     *     The cross_sell_ids
     */
    public void setCrossSellIds(List<Object> crossSellIds) {
        this.crossSellIds = crossSellIds;
    }

    /**
     * 
     * @return
     *     The parentId
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 
     * @param parentId
     *     The parent_id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 
     * @return
     *     The categories
     */
    public List<String> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The tags
     */
    public List<Object> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     * 
     * @return
     *     The featuredSrc
     */
    public String getFeaturedSrc() {
        return featuredSrc;
    }

    /**
     * 
     * @param featuredSrc
     *     The featured_src
     */
    public void setFeaturedSrc(String featuredSrc) {
        this.featuredSrc = featuredSrc;
    }

    /**
     * 
     * @return
     *     The attributes
     */
    public List<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    public void setAttributes(List<Attribute> attributes) {
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

    /**
     * 
     * @return
     *     The downloadType
     */
    public String getDownloadType() {
        return downloadType;
    }

    /**
     * 
     * @param downloadType
     *     The download_type
     */
    public void setDownloadType(String downloadType) {
        this.downloadType = downloadType;
    }

    /**
     * 
     * @return
     *     The purchaseNote
     */
    public String getPurchaseNote() {
        return purchaseNote;
    }

    /**
     * 
     * @param purchaseNote
     *     The purchase_note
     */
    public void setPurchaseNote(String purchaseNote) {
        this.purchaseNote = purchaseNote;
    }

    /**
     * 
     * @return
     *     The totalSales
     */
    public Integer getTotalSales() {
        return totalSales;
    }

    /**
     * 
     * @param totalSales
     *     The total_sales
     */
    public void setTotalSales(Integer totalSales) {
        this.totalSales = totalSales;
    }

    /**
     * 
     * @return
     *     The variations
     */
    public List<Variation> getVariations() {
        return variations;
    }

    /**
     * 
     * @param variations
     *     The variations
     */
    public void setVariations(List<Variation> variations) {
        this.variations = variations;
    }

    /**
     * 
     * @return
     *     The parent
     */
    public List<Object> getParent() {
        return parent;
    }

    /**
     * 
     * @param parent
     *     The parent
     */
    public void setParent(List<Object> parent) {
        this.parent = parent;
    }

    /**
     * 
     * @return
     *     The groupedProducts
     */
    public List<Object> getGroupedProducts() {
        return groupedProducts;
    }

    /**
     * 
     * @param groupedProducts
     *     The grouped_products
     */
    public void setGroupedProducts(List<Object> groupedProducts) {
        this.groupedProducts = groupedProducts;
    }

    /**
     * 
     * @return
     *     The menuOrder
     */
    public Integer getMenuOrder() {
        return menuOrder;
    }

    /**
     * 
     * @param menuOrder
     *     The menu_order
     */
    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
