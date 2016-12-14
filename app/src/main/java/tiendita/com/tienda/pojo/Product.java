
package tiendita.com.tienda.pojo;

import java.util.List;

public class Product {

    private int id;
    private String name;
    private String dateCreated;
    private String dateModified;
    private String type;
    private String status;
    private boolean featured;
    private String catalogVisibility;
    private String description;
    private String shortDescription;
    private String sku;
    private String price;
    private String regularPrice;
    private String salePrice;
    private boolean onSale;
    private boolean purchasable;
    private int totalSales;
    private String downloadType;
    private String taxStatus;
    private String taxClass;
    private boolean manageStock;
    private Object stockQuantity;
    private boolean inStock;
    private String backorders;
    private boolean backordersAllowed;
    private boolean backordered;
    private boolean soldIndividually;
    private String weight;
    private boolean reviewsAllowed;
    private String averageRating;
    private int ratingCount;
    private List<Category> categories = null;
    private List<Image> images = null;
    private int menuOrder;
    private Links links;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Product() {
    }

    /**
     * 
     * @param dateModified
     * @param manageStock
     * @param featured
     * @param crossSellIds
     * @param type
     * @param variations
     * @param upsellIds
     * @param downloadType
     * @param description
     * @param shippingRequired
     * @param shippingTaxable
     * @param totalSales
     * @param status
     * @param groupedProducts
     * @param sku
     * @param shippingClassId
     * @param shippingClass
     * @param price
     * @param shortDescription
     * @param soldIndividually
     * @param images
     * @param salePrice
     * @param regularPrice
     * @param buttonText
     * @param virtual
     * @param backordersAllowed
     * @param weight
     * @param averageRating
     * @param stockQuantity
     * @param purchasable
     * @param dateOnSaleFrom
     * @param menuOrder
     * @param downloads
     * @param downloadable
     * @param id
     * @param parentId
     * @param priceHtml
     * @param name
     * @param dimensions
     * @param relatedIds
     * @param downloadLimit
     * @param dateOnSaleTo
     * @param tags
     * @param onSale
     * @param taxStatus
     * @param ratingCount
     * @param links
     * @param downloadExpiry
     * @param backorders
     * @param catalogVisibility
     * @param taxClass
     * @param purchaseNote
     * @param reviewsAllowed
     * @param defaultAttributes
     * @param dateCreated
     * @param backordered
     * @param categories
     * @param attributes
     * @param externalUrl
     * @param inStock
     */

    /**
     * 
     * @return
     *     The id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * 
     * @return
     *     The dateCreated
     */
    public String getDateCreated() {
        return dateCreated;
    }

    /**
     * 
     * @param dateCreated
     *     The date_created
     */
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * 
     * @return
     *     The dateModified
     */
    public String getDateModified() {
        return dateModified;
    }

    /**
     * 
     * @param dateModified
     *     The date_modified
     */
    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
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
     *     The featured
     */
    public boolean isFeatured() {
        return featured;
    }

    /**
     * 
     * @param featured
     *     The featured
     */
    public void setFeatured(boolean featured) {
        this.featured = featured;
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
    public String getSalePrice() {
        return salePrice;
    }

    /**
     * 
     * @param salePrice
     *     The sale_price
     */
    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    /**
     * 
     * @return
     *     The onSale
     */
    public boolean isOnSale() {
        return onSale;
    }

    /**
     * 
     * @param onSale
     *     The on_sale
     */
    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    /**
     * 
     * @return
     *     The purchasable
     */
    public boolean isPurchasable() {
        return purchasable;
    }

    /**
     * 
     * @param purchasable
     *     The purchasable
     */
    public void setPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
    }

    /**
     * 
     * @return
     *     The totalSales
     */
    public int getTotalSales() {
        return totalSales;
    }

    /**
     * 
     * @param totalSales
     *     The total_sales
     */
    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
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
     *     The manageStock
     */
    public boolean isManageStock() {
        return manageStock;
    }

    /**
     * 
     * @param manageStock
     *     The manage_stock
     */
    public void setManageStock(boolean manageStock) {
        this.manageStock = manageStock;
    }

    /**
     * 
     * @return
     *     The stockQuantity
     */
    public Object getStockQuantity() {
        return stockQuantity;
    }

    /**
     * 
     * @param stockQuantity
     *     The stock_quantity
     */
    public void setStockQuantity(Object stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    /**
     * 
     * @return
     *     The inStock
     */
    public boolean isInStock() {
        return inStock;
    }

    /**
     * 
     * @param inStock
     *     The in_stock
     */
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    /**
     * 
     * @return
     *     The backorders
     */
    public String getBackorders() {
        return backorders;
    }

    /**
     * 
     * @param backorders
     *     The backorders
     */
    public void setBackorders(String backorders) {
        this.backorders = backorders;
    }

    /**
     * 
     * @return
     *     The backordersAllowed
     */
    public boolean isBackordersAllowed() {
        return backordersAllowed;
    }

    /**
     * 
     * @param backordersAllowed
     *     The backorders_allowed
     */
    public void setBackordersAllowed(boolean backordersAllowed) {
        this.backordersAllowed = backordersAllowed;
    }

    /**
     * 
     * @return
     *     The backordered
     */
    public boolean isBackordered() {
        return backordered;
    }

    /**
     * 
     * @param backordered
     *     The backordered
     */
    public void setBackordered(boolean backordered) {
        this.backordered = backordered;
    }

    /**
     * 
     * @return
     *     The soldIndividually
     */
    public boolean isSoldIndividually() {
        return soldIndividually;
    }

    /**
     * 
     * @param soldIndividually
     *     The sold_individually
     */
    public void setSoldIndividually(boolean soldIndividually) {
        this.soldIndividually = soldIndividually;
    }

    /**
     * 
     * @return
     *     The weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * 
     * @param weight
     *     The weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }
    /**
     * 
     * @return
     *     The reviewsAllowed
     */
    public boolean isReviewsAllowed() {
        return reviewsAllowed;
    }

    /**
     * 
     * @param reviewsAllowed
     *     The reviews_allowed
     */
    public void setReviewsAllowed(boolean reviewsAllowed) {
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
    public int getRatingCount() {
        return ratingCount;
    }

    /**
     * 
     * @param ratingCount
     *     The rating_count
     */
    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }


    /**
     * 
     * @return
     *     The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
     *     The menuOrder
     */
    public int getMenuOrder() {
        return menuOrder;
    }

    /**
     * 
     * @param menuOrder
     *     The menu_order
     */
    public void setMenuOrder(int menuOrder) {
        this.menuOrder = menuOrder;
    }

    /**
     * 
     * @return
     *     The links
     */
    public Links getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The _links
     */
    public void setLinks(Links links) {
        this.links = links;
    }

}
