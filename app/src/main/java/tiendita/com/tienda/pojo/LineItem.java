package tiendita.com.tienda.pojo;

/**
 * Created by Cresh on 14/12/2016.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LineItem {

    @SerializedName("product_id")
    @Expose
    private int productId;
    @SerializedName("variation_id")
    @Expose
    private int variationId;
    @SerializedName("quantity")
    @Expose
    private int quantity;

    public LineItem(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    /**
     * @return The productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId The product_id
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return The variationId
     */
    public int getVariationId() {
        return variationId;
    }

    /**
     * @param variationId The variation_id
     */
    public void setVariationId(int variationId) {
        this.variationId = variationId;
    }

    /**
     * @return The quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity The quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}