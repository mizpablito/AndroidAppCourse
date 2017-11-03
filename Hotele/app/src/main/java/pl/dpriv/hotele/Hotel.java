package pl.dpriv.hotele;

/**
 * Created by course on 03/11/2017.
 */

public class Hotel {
    private String name;
    private int cost;
    private String costInfo;
    private String oldCost;
    private String ratingInfo;
    private String photoUrl;

    public Hotel(String name, int cost, String costInfo, String oldCost, String ratingInfo, String photoUrl) {
        this.name = name;
        this.cost = cost;
        this.costInfo = costInfo;
        this.oldCost = oldCost;
        this.ratingInfo = ratingInfo;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCostInfo() {
        return costInfo;
    }

    public void setCostInfo(String costInfo) {
        this.costInfo = costInfo;
    }

    public String getOldCost() {
        return oldCost;
    }

    public void setOldCost(String oldCost) {
        this.oldCost = oldCost;
    }

    public String getRatingInfo() {
        return ratingInfo;
    }

    public void setRatingInfo(String ratingInfo) {
        this.ratingInfo = ratingInfo;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
