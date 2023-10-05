package learn.fan_site.models;

public class RoomStyle {
    private int styleId;
    private String styleName;

    public RoomStyle(int styleId, String styleName) {
        this.styleId = styleId;
        this.styleName = styleName;
    }

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    // Override equals and hashCode
}
