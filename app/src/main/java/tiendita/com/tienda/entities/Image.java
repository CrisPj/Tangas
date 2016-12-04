package tiendita.com.tienda.entities;

import org.json.JSONObject;

/**
 * Created by zero_ on 04/12/2016.
 */

public class Image {

    private int id;
    private int position = 0;
    private String src;
    private String name;
    private String alt;

    public Image(JSONObject jsonObject) {
        this.id = jsonObject.optInt("id");
        this.position = jsonObject.optInt("position");
        this.src = jsonObject.optString("src");
        this.name = jsonObject.optString("name");
        this.alt = jsonObject.optString("alt");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
