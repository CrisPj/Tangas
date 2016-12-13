
package tiendita.com.tienda.pojo;


public class Dimensions {

    private String length;
    private String width;
    private String height;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Dimensions() {
    }

    /**
     * 
     * @param height
     * @param width
     * @param length
     */
    public Dimensions(String length, String width, String height) {
        super();
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /**
     * 
     * @return
     *     The length
     */
    public String getLength() {
        return length;
    }

    /**
     * 
     * @param length
     *     The length
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * 
     * @return
     *     The width
     */
    public String getWidth() {
        return width;
    }

    /**
     * 
     * @param width
     *     The width
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * 
     * @return
     *     The height
     */
    public String getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    public void setHeight(String height) {
        this.height = height;
    }

}
