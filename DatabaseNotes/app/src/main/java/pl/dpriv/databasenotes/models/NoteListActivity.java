package pl.dpriv.databasenotes.models;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;
import pl.dpriv.databasenotes.NoteDB;
import pl.dpriv.databasenotes.R;
import pl.dpriv.databasenotes.adapters.MyNoteAdapter;

public class NoteListActivity extends AppCompatActivity {

    ListView lista;
    RealmResults<NoteDB> noteDBList;
    Realm realm;
    long idCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);

        //1. ListView component
        lista = findViewById(R.id.listViewNotes);

        //2. Get the elements to show in the list

        //2.1. Connection to the Database
        realm = Realm.getDefaultInstance();

        //Get the categoryID wher user clicked
        Bundle extras = getIntent().getExtras();
        idCategory = extras.getLong("categoryID");
        noteDBList = realm.where(NoteDB.class).equalTo("idCategory",idCategory).findAll();

        //3. Adapter
        MyNoteAdapter adapter = new MyNoteAdapter(
                this,
                R.layout.note_main,
                noteDBList
        );

        lista.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu_notess, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_add_note:
                Intent i = new Intent(this, NewNoteActivity.class);
                i.putExtra("idCat", idCategory);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
