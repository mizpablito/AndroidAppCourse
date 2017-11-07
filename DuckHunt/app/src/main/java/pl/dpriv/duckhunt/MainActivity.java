package pl.dpriv.duckhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    EditText name;
    Button startGameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.imageViewLogo);
        name = findViewById(R.id.editTextNick);
        startGameBtn = findViewById(R.id.buttonStartGame);

        //logo
        Picasso.with(this)
                .load(R.drawable.title)
                .into(logo);

    }

    public void startGame(View view) {
        String nick = name.getText().toString();

        if(!nick.isEmpty()){
            Intent i = new Intent(this, GameActivity.class);

            i.putExtra("nick", nick);
            startActivity(i);
        } else {
            Toast.makeText(this, getString(R.string.info_write_nick), Toast.LENGTH_SHORT).show();
            name.setError(getString(R.string.error_req_nick));
        }
    }
}
