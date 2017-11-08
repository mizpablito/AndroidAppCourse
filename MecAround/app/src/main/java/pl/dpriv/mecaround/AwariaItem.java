package pl.dpriv.mecaround;

/**
 * Created by pablo on 08/11/2017.
 */

public class AwariaItem {
    private String title, description, carModel, photoUrl;

    public AwariaItem(String title, String description, String carModel, String photoUrl) {
        this.title = title;
        this.description = description;
        this.carModel = carModel;
        this.photoUrl = photoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
