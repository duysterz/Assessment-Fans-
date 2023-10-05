package learn.fan_site.models;

public class Room {
    private int roomId;
    private int typeId;
    private int styleId;
    private int colorId;

    public Room(int roomId, int typeId, int styleId, int colorId) {
        this.roomId = roomId;
        this.typeId = typeId;
        this.styleId = styleId;
        this.colorId = colorId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getStyleId() {
        return styleId;
    }

    public void setStyleId(int styleId) {
        this.styleId = styleId;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }
}
