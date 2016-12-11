
package tiendita.com.tienda.pojo;

import java.util.HashMap;
import java.util.Map;

public class Customer {

    private Integer id;
    private String createdAt;
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private Integer lastOrderId;
    private String lastOrderDate;
    private Integer ordersCount;
    private String totalSpent;
    private String avatarUrl;
    private BillingAddress billingAddress;
    private ShippingAddress shippingAddress;
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
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The first_name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The lastOrderId
     */
    public Integer getLastOrderId() {
        return lastOrderId;
    }

    /**
     * 
     * @param lastOrderId
     *     The last_order_id
     */
    public void setLastOrderId(Integer lastOrderId) {
        this.lastOrderId = lastOrderId;
    }

    /**
     * 
     * @return
     *     The lastOrderDate
     */
    public String getLastOrderDate() {
        return lastOrderDate;
    }

    /**
     * 
     * @param lastOrderDate
     *     The last_order_date
     */
    public void setLastOrderDate(String lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    /**
     * 
     * @return
     *     The ordersCount
     */
    public Integer getOrdersCount() {
        return ordersCount;
    }

    /**
     * 
     * @param ordersCount
     *     The orders_count
     */
    public void setOrdersCount(Integer ordersCount) {
        this.ordersCount = ordersCount;
    }

    /**
     * 
     * @return
     *     The totalSpent
     */
    public String getTotalSpent() {
        return totalSpent;
    }

    /**
     * 
     * @param totalSpent
     *     The total_spent
     */
    public void setTotalSpent(String totalSpent) {
        this.totalSpent = totalSpent;
    }

    /**
     * 
     * @return
     *     The avatarUrl
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 
     * @param avatarUrl
     *     The avatar_url
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * 
     * @return
     *     The billingAddress
     */
    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    /**
     * 
     * @param billingAddress
     *     The billing_address
     */
    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * 
     * @return
     *     The shippingAddress
     */
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     * 
     * @param shippingAddress
     *     The shipping_address
     */
    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
