package com.example.voyaji;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DestinationsActivity extends AppCompatActivity {

    ArrayList<Destination> destinations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destinations);

        ListView listView = findViewById(R.id.listViewDest);

        destinations = new ArrayList<>();
        destinations.add(new Destination("Taghia", 1500, R.drawable.taghia));
        destinations.add(new Destination("Ait Bougmez", 2200, R.drawable.aitbougmez));
        destinations.add(new Destination("Jbel Toubkal", 1200, R.drawable.jbeltoubkal));
        destinations.add(new Destination("Imsfran", 1200, R.drawable.imsfran));
        destinations.add(new Destination("Ouirgane", 1200, R.drawable.ouirgane));

        DestinationAdapter adapter = new DestinationAdapter(this, destinations);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Destination d = destinations.get(position);

            Intent i = new Intent(DestinationsActivity.this, BookingActivity.class);
            i.putExtra("city", d.city);
            i.putExtra("price", d.price);
            i.putExtra("image", d.image);
            startActivity(i);
        });
    }
}
