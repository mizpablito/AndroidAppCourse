package pl.dpriv.a06_uielements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkHobby(View view) {
        CheckBox c = (CheckBox)view;
        boolean checked = c.isChecked();
        int id = c.getId();

        String message = "";

        switch (id){
            case R.id.checkBoxVideoGames:
                if(checked){
                    message = "You like videogames!";
                }
                else
                {
                    message = "You don't like videogames!";
                }
                break;
            case R.id.checkBoxFilms:
                if(checked){
                    message = "You like view films!";
                }
                else
                {
                    message = "You don't like view films!";
                }
                break;

            case R.id.checkBoxSports:
                if(checked){
                    message = "You like sport!";
                }
                else
                {
                    message = "You don't like sport!";
                }
                break;
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}
