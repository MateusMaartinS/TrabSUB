package com.example.trabsub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.trabsub.adapter.PaisListAdapter;
import com.example.trabsub.controller.Controller;
import com.example.trabsub.model.Pais;

import java.util.ArrayList;

public class PaisActivity extends AppCompatActivity {

    private RecyclerView rvPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais);


        rvPais = findViewById(R.id.rvPais);

        carregarPaises();

    }

    private void carregarPaises() {

        ArrayList<Pais> lista = Controller.retornaPaises(this);
        PaisListAdapter adapter = new PaisListAdapter(lista, this);
        rvPais.setLayoutManager(new LinearLayoutManager(this));
        rvPais.setAdapter(adapter);

    }


}