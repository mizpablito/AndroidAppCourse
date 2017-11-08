package pl.dpriv.duckhunt;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
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

        //final Intent i = new Intent(this, FinishActivity.class);

        final Bundle extras = getIntent().getExtras();

        time = findViewById(R.id.textViewTime);
        nick = findViewById(R.id.textViewNickWin);
        points = findViewById(R.id.textViewPoints);

        //duck
        duck = findViewById(R.id.imageViewDuck);

        nick.setText(extras.getString("nick"));

        startCountDown();

    }

    private void startCountDown() {
        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText(millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                //time.setText("done!");

                // i.putExtra("nick", extras.getString("nick"));
                // i.putExtra("point", counter);

                // startActivity(i);
                showGameOverDialog();

            }
        }.start();
    }

    private void showGameOverDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title)
                .setCancelable(false);
        builder.setPositiveButton("Restart Game", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
//                Intent intent = getIntent();
//                finish();
//                startActivity(intent);

                counter = 0;
                moveDuck();
                startCountDown();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("End game", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //to destroy the GameActivity
                finish();
            }
        });
        AlertDialog dialog = builder.create();

        dialog.show();
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
