package pl.dpriv.hotele;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    List<Hotel> hotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hola amigo ;)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        lista = findViewById(R.id.listOfHotels);

        hotelList = new ArrayList<>();
        hotelList.add(new Hotel(
                "Sevilla Tour",
                299,
                "WiFi Free",
                "$499 night price",
                "4,8 / 5 Outstanding",
                "https://x.cdrst.com/foto/hotel-sf/bf1/granderesp/hotel-sevilla-center-servicios-5583e6d.jpg"
        ));
        hotelList.add(new Hotel(
                "Sevilla Tour II",
                399,
                "Bilards",
                "$499 night price",
                "4,8 / 5 Outstanding",
                "https://x.cdrst.com/foto/hotel-sf/bf1/granderesp/hotel-sevilla-center-servicios-5583e6d.jpg"
        ));
        hotelList.add(new Hotel(
                "Sevilla Tour III",
                350,
                "Mobile exlusive",
                "$499 night price",
                "4,8 / 5 Outstanding",
                "https://x.cdrst.com/foto/hotel-sf/bf1/granderesp/hotel-sevilla-center-servicios-5583e6d.jpg"
        ));
        hotelList.add(new Hotel(
                "Sevilla Tour IV",
                578,
                "Golf",
                "$4199 night price",
                "4,8 / 5 Outstanding",
                "https://x.cdrst.com/foto/hotel-sf/bf1/granderesp/hotel-sevilla-center-servicios-5583e6d.jpg"
        ));
        hotelList.add(new Hotel(
                "Sevilla Tour V",
                500,
                "Swimming pool",
                "$2099 night price",
                "4,8 / 5 Outstanding",
                "https://x.cdrst.com/foto/hotel-sf/bf1/granderesp/hotel-sevilla-center-servicios-5583e6d.jpg"
        ));


        HotelViewAdapter adapter = new HotelViewAdapter(
                this,
                R.layout.hotel_item,
                hotelList
        );

        lista.setAdapter(adapter);
    }

}
