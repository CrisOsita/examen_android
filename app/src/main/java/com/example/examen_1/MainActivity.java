package com.example.examen_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    RecyclerView recy;
    List<Mes> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recy = findViewById(R.id.recy1);
        lista = new ArrayList<>();
        llena();
        for (Mes x: lista){
            if(x.getVenta() < 1000.0){
                x.setImagen(R.drawable.triste);
            }else if(x.getVenta() >= 1000.0 && x.getVenta() < 2500.0){
                x.setImagen(R.drawable.serio);
            }else if(x.getVenta() >= 2500.0){
                x.setImagen(R.drawable.feliz);
            }
        }
        recy.setLayoutManager(new LinearLayoutManager(this));
        System.out.println(lista);
        Adapta1 dp =new Adapta1(lista, this);
        recy.setAdapter(dp);
    }

    void llena(){
        lista.add(new Mes("Enero", 950.0));
        lista.add(new Mes("Febrero", 3000.0));
        lista.add(new Mes("Marzo", 850.0));
        lista.add(new Mes("Abril", 1100.0));
        lista.add(new Mes("Mayo", 1300.0));
        lista.add(new Mes("Junio", 2200.0));
        lista.add(new Mes("Julio", 500.0));
        lista.add(new Mes("Agosto", 1000.0));
        lista.add(new Mes("Septiembre", 750.0));
        lista.add(new Mes("Octubre", 2600.0));
        lista.add(new Mes("Noviembre", 2800.0));
        lista.add(new Mes("Diciembre", 1900.0));
    }
}