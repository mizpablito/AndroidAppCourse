package pl.dpriv.databasenotes.models;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;
import pl.dpriv.databasenotes.NoteDB;
import pl.dpriv.databasenotes.R;

public class NewNoteActivity extends AppCompatActivity {
    EditText title, desc;
    Realm realm;
    long idCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        title = findViewById(R.id.editTextTitleNote);
        desc = findViewById(R.id.editTextDesc);
        Bundle extras = getIntent().getExtras();
        idCat = extras.getLong("idCat");

        setTitle("New Note");

        realm = Realm.getDefaultInstance();


    }

    public void saveNote(View view) {
        //INSERT INTO...
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                NoteDB newNote = new NoteDB();

                newNote.setTitle(title.getText().toString());
                newNote.setDescription(desc.getText().toString());
                newNote.setIdCategory(idCat);
                //Insert the new object into the local database
                realm.copyToRealm(newNote);

                //destroy thus screen, to return to the CategoryList screen
                finish();
            }
        });
    }
}
