package com.example.voyaji;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        ImageView img = findViewById(R.id.bookingImage);
        TextView txtCity = findViewById(R.id.bookingCity);
        TextView txtPrice = findViewById(R.id.bookingPrice);
        TextView txtDate = findViewById(R.id.bookingDate);
        Button btnPickDate = findViewById(R.id.btnPickDate);

        String city = getIntent().getStringExtra("city");
        int price = getIntent().getIntExtra("price", 0);
        int image = getIntent().getIntExtra("image", 0);

        img.setImageResource(image);
        txtCity.setText("الوجهة: " + city);
        txtPrice.setText("الثمن: " + price + " MAD");

        btnPickDate.setOnClickListener(v -> {
            Calendar c = Calendar.getInstance();
            new DatePickerDialog(
                    BookingActivity.this,
                    (datePicker, year, month, day) -> txtDate.setText(day + "/" + (month+1) + "/" + year),
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
            ).show();
        });
    }
}
