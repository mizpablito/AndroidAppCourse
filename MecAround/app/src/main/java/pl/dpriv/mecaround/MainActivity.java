package pl.dpriv.mecaround;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    EditText email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        logo = findViewById(R.id.imageViewLogoApp);


        Picasso.with(this)
                .load("http://www.miguelcamposrivera.com/mecaround/assets/img/logo_mecaround.png")
                .into(logo);
    }

    public void doLogin(View view) {
        Intent i = new Intent(this, UserPrivateActivity.class);
        startActivity(i);
    }
}
