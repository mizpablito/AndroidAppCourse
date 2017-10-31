package pl.dpriv.loginpage;

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

    ImageView imgLogo;
    EditText email, pass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //logo
        imgLogo = findViewById(R.id.imageViewLogo);
        //Input
        email = findViewById(R.id.editTextEmail);
        pass = findViewById(R.id.editTextPassowrd);

        //button
        btnLogin = findViewById(R.id.buttonLogin);

        Picasso.with(this)
                .load("http://pngimg.com/uploads/apple_logo/apple_logo_PNG19692.png")
                .into(imgLogo);
    }

    public void doLogin(View view) {
        String e = email.getText().toString();
        String p = pass.getText().toString();

        if(e.equals("admin@admin.com") && p.equals("1234"))
        {
            /*Toast.makeText(
                    this,
                    "Me data this: \nEmail: " + e + "\n Password: " + p,
                    Toast.LENGTH_LONG).show();*/
            Intent intentPrivateScreen = new Intent();
        }
        else
        {
            Toast.makeText(
                    this,
                    "Sorry, your email or password is wrong!!",
                    Toast.LENGTH_LONG).show();
        }
    }
}
