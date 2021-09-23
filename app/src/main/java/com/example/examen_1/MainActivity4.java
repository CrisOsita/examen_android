package com.example.examen_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView res;
    ImageView image;
    ArtefactoAutos auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        res = findViewById(R.id.txtresauto);
        image = findViewById(R.id.imgautofinal);

        auto = (ArtefactoAutos) getIntent().getSerializableExtra("autos");
        String cad = "Comprador: " + auto.getPersona();
        cad += "\n Auto: " + auto.getAuto();
        cad += "\n Años: " + auto.getAnios();
        cad += "\n Interes: " + auto.getInteres();
        cad += "\n Cuota Inicial: " + auto.cuotaInitial();
        cad += "\n Saldo: " + auto.saldoFinal();
        cad += "\n Cuota Mensual: " + auto.cuotaMensual();
        res.setText(cad);
        image.setImageResource(auto.getImagen());

    }

    public void onRetornar(View v){
        Intent it = new Intent(this, MainActivity3.class);
        startActivity(it);
    }
}