package pl.dpriv.tictactoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewLogo;
    EditText p1, p2;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LOGO
        imageViewLogo = findViewById(R.id.imageViewLogo);
        Picasso.with(this)
                .load("https://4.bp.blogspot.com/-UGd-nOoMK5g/WBd6ICqoumI/AAAAAAAAHXI/_6oeNhPtdHUqi6iUStCLvUvDUGV1S82VQCLcB/s1600/tttmarqlrg.gif")
                .into(imageViewLogo);

        //BTN
        btnStart = findViewById(R.id.buttonStartGame);

        //PLAYERS
        p1 = findViewById(R.id.editTextPlayerFirst);
        p2 = findViewById(R.id.editTextPlayerSecond);



    }

    public void startGame(View view) {
        String play1 = p1.getText().toString();
        String play2 = p2.getText().toString();

        if(!play1.isEmpty() && !play2.isEmpty()) {
            Intent i = new Intent(this, GamesActivity.class);


            i.putExtra("firstPlayer", play1);
            i.putExtra("secondPlayer", play2);

            startActivity(i);
        }
        else if(play1.isEmpty())
        {
            p1.setError("Enter name first player");
        }
        else
        {
            p2.setError("Enter name second player");
        }
    }
}
