
package tiendita.com.tienda.pojo;


public class Collection {

    private String href;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Collection() {
    }

    /**
     * 
     * @param href
     */
    public Collection(String href) {
        super();
        this.href = href;
    }

    /**
     * 
     * @return
     *     The href
     */
    public String getHref() {
        return href;
    }

    /**
     * 
     * @param href
     *     The href
     */
    public void setHref(String href) {
        this.href = href;
    }

}
