
package tiendita.com.tienda.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Attribute {

    private String name;
    private String slug;
    private Integer position;
    private Boolean visible;
    private Boolean variation;
    private List<String> options = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * 
     * @param position
     *     The position
     */
    public void setPosition(Integer position) {
        this.position = position;
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
     *     The variation
     */
    public Boolean getVariation() {
        return variation;
    }

    /**
     * 
     * @param variation
     *     The variation
     */
    public void setVariation(Boolean variation) {
        this.variation = variation;
    }

    /**
     * 
     * @return
     *     The options
     */
    public List<String> getOptions() {
        return options;
    }

    /**
     * 
     * @param options
     *     The options
     */
    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
