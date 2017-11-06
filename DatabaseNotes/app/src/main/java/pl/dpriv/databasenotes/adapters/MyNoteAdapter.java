package pl.dpriv.databasenotes.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import io.realm.RealmResults;
import pl.dpriv.databasenotes.NoteDB;
import pl.dpriv.databasenotes.R;

/**
 * Created by course on 06/11/2017.
 */

public class MyNoteAdapter extends ArrayAdapter<NoteDB> {
    Context ctx;
    int layoutTemplate;
    RealmResults<NoteDB> notesList;

    public MyNoteAdapter(@NonNull Context context, int resource, @NonNull RealmResults<NoteDB> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutTemplate = resource;
        this.notesList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutTemplate,parent,false);

        //Get the current item
        NoteDB current = notesList.get(position);

        //Get all the view components
        TextView textViewTitle = v.findViewById(R.id.textViewNote);
        TextView textViewDesc = v.findViewById(R.id.textViewDescription);

        //Set into the View component the current object information
        textViewTitle.setText(current.getTitle());
        textViewDesc.setText(current.getDescription());



        return v;
    }
}