
package tiendita.com.tienda.pojo;

import java.util.List;

public class Links {

    private List<Self> self = null;
    private List<Collection> collection = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links() {
    }

    /**
     * 
     * @param self
     * @param collection
     */
    public Links(List<Self> self, List<Collection> collection) {
        super();
        this.self = self;
        this.collection = collection;
    }

    /**
     * 
     * @return
     *     The self
     */
    public List<Self> getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(List<Self> self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The collection
     */
    public List<Collection> getCollection() {
        return collection;
    }

    /**
     * 
     * @param collection
     *     The collection
     */
    public void setCollection(List<Collection> collection) {
        this.collection = collection;
    }

}
