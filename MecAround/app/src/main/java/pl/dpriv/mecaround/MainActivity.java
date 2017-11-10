package pl.dpriv.mecaround;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    EditText email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        logo = findViewById(R.id.imageViewLogoApp);
        email = findViewById(R.id.editTextMail);
        pass = findViewById(R.id.editTextPass);


        Picasso.with(this)
                .load("http://www.miguelcamposrivera.com/mecaround/assets/img/logo_mecaround.png")
                .into(logo);
    }

    public void doLogin(View view) {

        final String em = email.getText().toString();
        String ps = pass.getText().toString();
        if(!em.isEmpty() && !ps.isEmpty()) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://miguelcamposrivera.com/mecaround/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            MecaroundServerInterface service = retrofit.create(MecaroundServerInterface.class);
            Call<LoginResponse> serverResponse = service.serverLogin(em, ps);

            serverResponse.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.code() == 200) {
                        String serverKey = response.body().getKey();

                        Intent i = new Intent(MainActivity.this, UserPrivateActivity.class);
                        i.putExtra("key", serverKey);
                        startActivity(i);
                    } else {
                        Toast.makeText(
                                MainActivity.this,
                                "Your email and/or password is wrong!",
                                Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                }
            });
        } else {
            Toast.makeText(this, "Wprowadź dane logowania!", Toast.LENGTH_SHORT).show();
        }
    }
}
