package pl.dpriv.databasenotes.models;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;
import pl.dpriv.databasenotes.CategoryNoteDB;
import pl.dpriv.databasenotes.R;

public class NewCategoryActivity extends AppCompatActivity {
    EditText title, colorCode;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);

        title = findViewById(R.id.editTextTitleNote);
        colorCode = findViewById(R.id.editTextColor);

        setTitle("New Category");

        realm = Realm.getDefaultInstance();
    }

    public void saveCategory(View view) {

        //INSERT INTO...
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CategoryNoteDB newCategory = new CategoryNoteDB();
                newCategory.setTitle(title.getText().toString());
                newCategory.setColor(colorCode.getText().toString());

                //Insert the new object into the local database
                realm.copyToRealm(newCategory);

                //destroy thus screen, to return to the CategoryList screen
                finish();
            }
        });
    }
}
