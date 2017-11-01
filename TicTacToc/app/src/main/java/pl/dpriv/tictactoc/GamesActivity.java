package pl.dpriv.tictactoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GamesActivity extends AppCompatActivity {

    TextView NowPlay;
    ImageView cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        //change the toolbar text
        setTitle("Game");

        Bundle extras = getIntent().getExtras();
        String p1 = extras.getString("firstPlayer");
        String p2 = extras.getString("secondPlayer");

    }

    public void cellClick(View view) {
        ImageView imageView = (ImageView)view;
        imageView.setImageResource(R.drawable.ic_x);

    }
}
