package tiendita.com.tienda.entities;
import org.json.JSONObject;
public class Image {
    private int id;
    private String src;
    private String name;
    public Image(JSONObject jsonObject) {
        this.id = jsonObject.optInt("id");
        this.src = jsonObject.optString("src");
        this.name = jsonObject.optString("name");
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getSrc() {
        return src;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
