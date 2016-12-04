package tiendita.com.tienda.entities;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by zero_ on 04/12/2016.
 */

public class Product {

    private int id = -1;
    private int totalSales = 0;
    private int stockQuantity = 0;
    private int ratingCount = 0;

    private String name = "";
    private String slug = "";
    private String permalink = "";
    private String type = "";
    private String status = "";
    private String description = "";
    private String shortDescription = "";
    private String sku = "";
    private String price = "";
    private String regularPrice = "";
    private String salePrice = "";
    private String averageRating = "";

    private boolean onSale = false;
    private boolean purchasable = false;
    private boolean featured = false;
    private boolean virtual = false;
    private boolean downloadable = false;
    private boolean inStock = false;
    private boolean reviewsAllowed = false;

    private Image[] images = {};

    public Product(JSONObject jsonObject) {
        this.id = jsonObject.optInt("id");
        this.totalSales = jsonObject.optInt("total_sales");
        this.stockQuantity = jsonObject.optInt("stock_quantity");
        this.ratingCount = jsonObject.optInt("rating_count");
        this.name = jsonObject.optString("name");
        this.slug = jsonObject.optString("slug");
        this.permalink = jsonObject.optString("permalink");
        this.type = jsonObject.optString("type");
        this.status = jsonObject.optString("status");
        this.description = jsonObject.optString("description");
        this.shortDescription = jsonObject.optString("short_description");
        this.sku = jsonObject.optString("sku");
        this.price = jsonObject.optString("price");
        this.regularPrice = jsonObject.optString("regular_price");
        this.salePrice = jsonObject.optString("regular_price");
        this.averageRating = jsonObject.optString("average_rating");
        this.onSale = jsonObject.optBoolean("on_sale");
        this.purchasable = jsonObject.optBoolean("purchasable");
        this.featured = jsonObject.optBoolean("featured");
        this.virtual = jsonObject.optBoolean("virtual");
        this.downloadable = jsonObject.optBoolean("downloadable");
        this.inStock = jsonObject.optBoolean("in_stock");
        this.reviewsAllowed = jsonObject.optBoolean("reviews_allowed");
        // If there are pictures available, create them
        if (jsonObject.optJSONArray("images").length() <= 0)
            return;
        JSONArray imageArray = jsonObject.optJSONArray("images");
        this.images = new Image[imageArray.length()];
        for (int i = 0; i < imageArray.length(); i++)
            this.images[i] = new Image(imageArray.optJSONObject(i));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public boolean isPurchasable() {
        return purchasable;
    }

    public void setPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public boolean isVirtual() {
        return virtual;
    }

    public void setVirtual(boolean virtual) {
        this.virtual = virtual;
    }

    public boolean isDownloadable() {
        return downloadable;
    }

    public void setDownloadable(boolean downloadable) {
        this.downloadable = downloadable;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public boolean isReviewsAllowed() {
        return reviewsAllowed;
    }

    public void setReviewsAllowed(boolean reviewsAllowed) {
        this.reviewsAllowed = reviewsAllowed;
    }

    public Image[] getImages() {
        return images;
    }

    public void setImages(Image[] images) {
        this.images = images;
    }
}
