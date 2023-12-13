package com.example.trabsub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.trabsub.controller.Controller;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btBuscas;

    private Button btVisualizarPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btBuscas = findViewById(R.id.btBuscas);
        btBuscas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller.getPaises(MainActivity.this);
            }
        });


        btVisualizarPais = findViewById(R.id.btVisualizarPais);

        btVisualizarPais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PaisActivity.class);

            }
        });
    }

}