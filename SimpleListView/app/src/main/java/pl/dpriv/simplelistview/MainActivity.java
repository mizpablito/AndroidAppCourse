package pl.dpriv.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lista;
    List<String> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lista = findViewById(R.id.listViewStudent);

        studentList = new ArrayList<>();
        studentList.add("Rafał");
        studentList.add("Paweł");
        studentList.add("Adam");
        studentList.add("Oskar");
        studentList.add("Krzysiu");
        studentList.add("Heniu");
        studentList.add("Michał");
        studentList.add("Kacper");
        studentList.add("Kamil");
        studentList.add("Dawid");
        studentList.add("Kuba");

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                studentList
        );

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String name = studentList.get(position);
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

        view.animate().rotationX(360).setDuration(2000).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }
}
