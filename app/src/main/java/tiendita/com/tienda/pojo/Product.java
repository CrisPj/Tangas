
package tiendita.com.tienda.pojo;

import java.util.List;

public class Product {

    private int id;
    private String name;
    private String slug;
    private String permalink;
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
    private String dateOnSaleFrom;
    private String dateOnSaleTo;
    private String priceHtml;
    private boolean onSale;
    private boolean purchasable;
    private int totalSales;
    private boolean virtual;
    private boolean downloadable;
    private List<Object> downloads = null;
    private int downloadLimit;
    private int downloadExpiry;
    private String downloadType;
    private String externalUrl;
    private String buttonText;
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
    private Dimensions dimensions;
    private boolean shippingRequired;
    private boolean shippingTaxable;
    private String shippingClass;
    private int shippingClassId;
    private boolean reviewsAllowed;
    private String averageRating;
    private int ratingCount;
    private List<Integer> relatedIds = null;
    private List<Object> upsellIds = null;
    private List<Object> crossSellIds = null;
    private int parentId;
    private String purchaseNote;
    private List<Category> categories = null;
    private List<Tag> tags = null;
    private List<Image> images = null;
    private List<Object> attributes = null;
    private List<Object> defaultAttributes = null;
    private List<Object> variations = null;
    private List<Object> groupedProducts = null;
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
     * @param permalink
     * @param shortDescription
     * @param soldIndividually
     * @param images
     * @param salePrice
     * @param slug
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
    public Product(int id, String name, String slug, String permalink, String dateCreated, String dateModified, String type, String status, boolean featured, String catalogVisibility, String description, String shortDescription, String sku, String price, String regularPrice, String salePrice, String dateOnSaleFrom, String dateOnSaleTo, String priceHtml, boolean onSale, boolean purchasable, int totalSales, boolean virtual, boolean downloadable, List<Object> downloads, int downloadLimit, int downloadExpiry, String downloadType, String externalUrl, String buttonText, String taxStatus, String taxClass, boolean manageStock, Object stockQuantity, boolean inStock, String backorders, boolean backordersAllowed, boolean backordered, boolean soldIndividually, String weight, Dimensions dimensions, boolean shippingRequired, boolean shippingTaxable, String shippingClass, int shippingClassId, boolean reviewsAllowed, String averageRating, int ratingCount, List<Integer> relatedIds, List<Object> upsellIds, List<Object> crossSellIds, int parentId, String purchaseNote, List<Category> categories, List<Tag> tags, List<Image> images, List<Object> attributes, List<Object> defaultAttributes, List<Object> variations, List<Object> groupedProducts, int menuOrder, Links links) {
        super();
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.permalink = permalink;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.type = type;
        this.status = status;
        this.featured = featured;
        this.catalogVisibility = catalogVisibility;
        this.description = description;
        this.shortDescription = shortDescription;
        this.sku = sku;
        this.price = price;
        this.regularPrice = regularPrice;
        this.salePrice = salePrice;
        this.dateOnSaleFrom = dateOnSaleFrom;
        this.dateOnSaleTo = dateOnSaleTo;
        this.priceHtml = priceHtml;
        this.onSale = onSale;
        this.purchasable = purchasable;
        this.totalSales = totalSales;
        this.virtual = virtual;
        this.downloadable = downloadable;
        this.downloads = downloads;
        this.downloadLimit = downloadLimit;
        this.downloadExpiry = downloadExpiry;
        this.downloadType = downloadType;
        this.externalUrl = externalUrl;
        this.buttonText = buttonText;
        this.taxStatus = taxStatus;
        this.taxClass = taxClass;
        this.manageStock = manageStock;
        this.stockQuantity = stockQuantity;
        this.inStock = inStock;
        this.backorders = backorders;
        this.backordersAllowed = backordersAllowed;
        this.backordered = backordered;
        this.soldIndividually = soldIndividually;
        this.weight = weight;
        this.dimensions = dimensions;
        this.shippingRequired = shippingRequired;
        this.shippingTaxable = shippingTaxable;
        this.shippingClass = shippingClass;
        this.shippingClassId = shippingClassId;
        this.reviewsAllowed = reviewsAllowed;
        this.averageRating = averageRating;
        this.ratingCount = ratingCount;
        this.relatedIds = relatedIds;
        this.upsellIds = upsellIds;
        this.crossSellIds = crossSellIds;
        this.parentId = parentId;
        this.purchaseNote = purchaseNote;
        this.categories = categories;
        this.tags = tags;
        this.images = images;
        this.attributes = attributes;
        this.defaultAttributes = defaultAttributes;
        this.variations = variations;
        this.groupedProducts = groupedProducts;
        this.menuOrder = menuOrder;
        this.links = links;
    }

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
     *     The slug
     */
    public String getSlug() {
        return slug;
    }

    /**
     * 
     * @param slug
     *     The slug
     */
    public void setSlug(String slug) {
        this.slug = slug;
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
     *     The dateOnSaleFrom
     */
    public String getDateOnSaleFrom() {
        return dateOnSaleFrom;
    }

    /**
     * 
     * @param dateOnSaleFrom
     *     The date_on_sale_from
     */
    public void setDateOnSaleFrom(String dateOnSaleFrom) {
        this.dateOnSaleFrom = dateOnSaleFrom;
    }

    /**
     * 
     * @return
     *     The dateOnSaleTo
     */
    public String getDateOnSaleTo() {
        return dateOnSaleTo;
    }

    /**
     * 
     * @param dateOnSaleTo
     *     The date_on_sale_to
     */
    public void setDateOnSaleTo(String dateOnSaleTo) {
        this.dateOnSaleTo = dateOnSaleTo;
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
     *     The virtual
     */
    public boolean isVirtual() {
        return virtual;
    }

    /**
     * 
     * @param virtual
     *     The virtual
     */
    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    /**
     * 
     * @return
     *     The downloadable
     */
    public boolean isDownloadable() {
        return downloadable;
    }

    /**
     * 
     * @param downloadable
     *     The downloadable
     */
    public void setDownloadable(boolean downloadable) {
        this.downloadable = downloadable;
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
    public int getDownloadLimit() {
        return downloadLimit;
    }

    /**
     * 
     * @param downloadLimit
     *     The download_limit
     */
    public void setDownloadLimit(int downloadLimit) {
        this.downloadLimit = downloadLimit;
    }

    /**
     * 
     * @return
     *     The downloadExpiry
     */
    public int getDownloadExpiry() {
        return downloadExpiry;
    }

    /**
     * 
     * @param downloadExpiry
     *     The download_expiry
     */
    public void setDownloadExpiry(int downloadExpiry) {
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
     *     The externalUrl
     */
    public String getExternalUrl() {
        return externalUrl;
    }

    /**
     * 
     * @param externalUrl
     *     The external_url
     */
    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    /**
     * 
     * @return
     *     The buttonText
     */
    public String getButtonText() {
        return buttonText;
    }

    /**
     * 
     * @param buttonText
     *     The button_text
     */
    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
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
    public boolean isShippingRequired() {
        return shippingRequired;
    }

    /**
     * 
     * @param shippingRequired
     *     The shipping_required
     */
    public void setShippingRequired(boolean shippingRequired) {
        this.shippingRequired = shippingRequired;
    }

    /**
     * 
     * @return
     *     The shippingTaxable
     */
    public boolean isShippingTaxable() {
        return shippingTaxable;
    }

    /**
     * 
     * @param shippingTaxable
     *     The shipping_taxable
     */
    public void setShippingTaxable(boolean shippingTaxable) {
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
    public int getShippingClassId() {
        return shippingClassId;
    }

    /**
     * 
     * @param shippingClassId
     *     The shipping_class_id
     */
    public void setShippingClassId(int shippingClassId) {
        this.shippingClassId = shippingClassId;
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
    public int getParentId() {
        return parentId;
    }

    /**
     * 
     * @param parentId
     *     The parent_id
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
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
     *     The tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(List<Tag> tags) {
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
     *     The attributes
     */
    public List<Object> getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    public void setAttributes(List<Object> attributes) {
        this.attributes = attributes;
    }

    /**
     * 
     * @return
     *     The defaultAttributes
     */
    public List<Object> getDefaultAttributes() {
        return defaultAttributes;
    }

    /**
     * 
     * @param defaultAttributes
     *     The default_attributes
     */
    public void setDefaultAttributes(List<Object> defaultAttributes) {
        this.defaultAttributes = defaultAttributes;
    }

    /**
     * 
     * @return
     *     The variations
     */
    public List<Object> getVariations() {
        return variations;
    }

    /**
     * 
     * @param variations
     *     The variations
     */
    public void setVariations(List<Object> variations) {
        this.variations = variations;
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
