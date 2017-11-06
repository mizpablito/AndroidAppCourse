package pl.dpriv.databasenotes;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;
import pl.dpriv.databasenotes.app.MyApplication;

/**
 * Created by pablo on 06/11/2017.
 */
public class NoteDB extends RealmObject {
    @PrimaryKey
    private long id;
    @Required
    private String title;
    private String description;
    private long idCategory;

    public NoteDB() {
        this.id = MyApplication.NoteID.incrementAndGet();
    }

    public NoteDB(String title, String description, long idCategory) {
        this.title = title;
        this.description = description;
        this.idCategory = idCategory;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }
}
