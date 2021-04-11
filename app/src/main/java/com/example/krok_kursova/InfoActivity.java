package com.example.krok_kursova;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;


public class InfoActivity extends AppCompatActivity {

    TextView setBrand;
    TextView setModel;
    TextView setInfo;
    ImageView setImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        setBrand = (TextView) findViewById(R.id.brandText);
        setModel = (TextView) findViewById(R.id.modelText);
        setInfo = (TextView) findViewById(R.id.infoText);
        setImage = (ImageView) findViewById(R.id.imageView);
        setInfo.setMovementMethod(new ScrollingMovementMethod());


        Intent intent = getIntent();

        String brand = intent.getStringExtra("brand");
        String model = intent.getStringExtra("model");
        String info = intent.getStringExtra("info");
        String img = intent.getStringExtra("img");




        Picasso.with(this).load(img).into(setImage);
        setBrand.setText(brand);
        setModel.setText(model);
        setInfo.setText(info);


    }
}
