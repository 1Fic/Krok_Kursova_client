package com.example.krok_kursova;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.example.krok_kursova.pojo.Auto;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    myAdapter adapter;
    TextView textView;
    String brand;
    String model;


    ArrayList<String> autos = new ArrayList<>();

    Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;


        listView = findViewById(R.id.containerList);
        editText = findViewById(R.id.editText);


        int id = 1;
        while (id < 5) {
            getAutoWitId(id);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            id++;
        }


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s.toString());
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                long res = id + 1;
                System.out.println(res);
                info(res);
            }
        });
    }


    public void getAutoWitId(int id) {
        NetworkServiceAuto.getInstance()
                .getJSONApi()
                .getAutoWithID(id)
                .enqueue(new Callback<Auto>() {
                    @Override
                    public void onResponse(@NonNull Call<Auto> call, @NonNull Response<Auto> response) {
                        Auto auto = response.body();
                        brand = "" + auto.getBrand();
                        model = " " + auto.getModel();
                        autos.add(brand + model);
                        adapter = new myAdapter(activity, autos);
                        listView.setAdapter(adapter);
                    }
                    @Override
                    public void onFailure(@NonNull Call<Auto> call, @NonNull Throwable t) {
                        textView.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
    }

    public void info(long id) {
        Intent intent = new Intent(this, InfoActivity.class);
        NetworkServiceAuto.getInstance()
                .getJSONApi()
                .getAutoWithID(id)
                .enqueue(new Callback<Auto>() {
                    @Override
                    public void onResponse(@NonNull Call<Auto> call, @NonNull Response<Auto> response) {
                        Auto auto = response.body();
                        intent.putExtra("brand", auto.getBrand());
                        intent.putExtra("model", auto.getModel());
                        intent.putExtra("info", auto.getInfo());
                        intent.putExtra("img", auto.getImgUrl());
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(@NonNull Call<Auto> call, @NonNull Throwable t) {
                        t.printStackTrace();
                    }
                });
    }


}