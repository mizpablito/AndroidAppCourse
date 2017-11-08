package pl.dpriv.mecaround;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class UserPrivateActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment f = null;

            switch (item.getItemId()) {
                case R.id.navigation_awaria:
                    f = new AwariaItemFragment();
                    return true;
                case R.id.navigation_mechanik:

                    return true;
                case R.id.navigation_profil:

                    return true;
            }
            
            if(f!=null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_cointainer,f)
                        .commit();
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_private);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_cointainer, new AwariaItemFragment())
                .commit();
    }

}
