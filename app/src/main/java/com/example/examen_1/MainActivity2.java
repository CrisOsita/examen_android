package com.example.examen_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView res;
    ImageView img;
    Mes mes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        res = findViewById(R.id.txtres);
        img = findViewById(R.id.imgmesres);
        mes = (Mes)getIntent().getSerializableExtra("dato");
        String cad ="Mes: " + mes.getMes();
        cad += "\n Venta: " + mes.getVenta();
        res.setText(cad);
        img.setImageResource(mes.getImagen());
    }

    public void onRetornar(View v){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
    }
}