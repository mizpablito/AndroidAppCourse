package pl.dpriv.duckhunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {

    TextView nick, point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        getSupportActionBar().hide();

        Bundle extras = getIntent().getExtras();

        nick = findViewById(R.id.textViewNickWin);
        point = findViewById(R.id.textViewPointWin);

        nick.setText(extras.getString("nick"));
        point.setText(getString(R.string.prefix_win_point) + " "
                + extras.getInt("point") + " "
                + getString(R.string.sufix_win_point));
    }
}
