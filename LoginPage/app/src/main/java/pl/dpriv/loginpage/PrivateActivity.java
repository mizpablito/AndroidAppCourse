package pl.dpriv.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PrivateActivity extends AppCompatActivity {

    TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private);

        //Get thr Intent Extra Information
        Bundle extras = getIntent().getExtras();
        String email = extras.getString("userEmail");
        int age = extras.getInt("userAge");

        textViewInfo = findViewById(R.id.textViewInfo);
        textViewInfo.setText("Email > " + email + "\nAge > " + age);
    }
}
