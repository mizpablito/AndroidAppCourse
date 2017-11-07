package pl.dpriv.duckhunt;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView time, nick, points;
    int counter = 0;
    ImageView duck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //hide actionBar
        getSupportActionBar().hide();

        final Intent i = new Intent(this, FinishActivity.class);

        final Bundle extras = getIntent().getExtras();

        time = findViewById(R.id.textViewTime);
        nick = findViewById(R.id.textViewNickWin);
        points = findViewById(R.id.textViewPoints);

        //duck
        duck = findViewById(R.id.imageViewDuck);

        nick.setText(extras.getString("nick"));

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText(millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                //time.setText("done!");

                i.putExtra("nick", extras.getString("nick"));
                i.putExtra("point", counter);

                startActivity(i);

            }
        }.start();

    }

    public void killDuck(View view) {
        counter++;
        points.setText(String.valueOf(counter));


        //move the duck
        moveDuck();
    }

    private void moveDuck() {
        Random rand = new Random();
        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int duckWidth = duck.getWidth();
        int duckHeight = duck.getHeight();
        int maxX = metrics.widthPixels - duckWidth;
        int maxY = metrics.heightPixels - duckHeight;
        int min = 0;

        int randomX = rand.nextInt((maxX - min) + 1) + min;
        int randomY = rand.nextInt((maxY - min) + 1) + min;

        //Apply the new random pos to the duck imgView
        duck.setX(randomX);
        duck.setY(randomY);
    }
}
