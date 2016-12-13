
package tiendita.com.tienda.pojo;


public class Image {

    private int id;
    private String dateCreated;
    private String dateModified;
    private String src;
    private String name;
    private String alt;
    private int position;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    /**
     * 
     * @param position
     * @param id
     * @param dateModified
     * @param alt
     * @param name
     * @param dateCreated
     * @param src
     */
    public Image(int id, String dateCreated, String dateModified, String src, String name, String alt, int position) {
        super();
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.src = src;
        this.name = name;
        this.alt = alt;
        this.position = position;
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
     *     The src
     */
    public String getSrc() {
        return src;
    }

    /**
     * 
     * @param src
     *     The src
     */
    public void setSrc(String src) {
        this.src = src;
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
     *     The alt
     */
    public String getAlt() {
        return alt;
    }

    /**
     * 
     * @param alt
     *     The alt
     */
    public void setAlt(String alt) {
        this.alt = alt;
    }

    /**
     * 
     * @return
     *     The position
     */
    public int getPosition() {
        return position;
    }

    /**
     * 
     * @param position
     *     The position
     */
    public void setPosition(int position) {
        this.position = position;
    }

}
