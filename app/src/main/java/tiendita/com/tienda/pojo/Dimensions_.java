
package tiendita.com.tienda.pojo;

import java.util.HashMap;
import java.util.Map;

public class Dimensions_ {

    private String length;
    private String width;
    private String height;
    private String unit;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    /**
     * 
     * @return
     *     The unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 
     * @param unit
     *     The unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
