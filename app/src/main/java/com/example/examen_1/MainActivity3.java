package com.example.examen_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner sp;
    TextView tpre;
    EditText name, anios;
    ImageView img;
    ArtefactoAutos autos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        sp = findViewById(R.id.spinner2);
        ArrayAdapter ad = ArrayAdapter.createFromResource(this,
                R.array.autos,
                android.R.layout.simple_list_item_1);
        sp.setAdapter(ad);
        name =findViewById(R.id.txtname);
        img = findViewById(R.id.imgauto);
        tpre =findViewById(R.id.txtprec);
        anios =findViewById(R.id.txtanios);
        autos = new ArtefactoAutos();
        sp.setOnItemSelectedListener(this);
    }

    public void onCalcular(View v){
        //asociar el radiogroup con el mes
        int aniosx;
        double interes;
        String namex;
        aniosx = Integer.parseInt(anios.getText().toString());
        namex = name.getText().toString();
        autos.setAnios(aniosx);
        autos.setPersona(namex);
        interes = 0.10 * aniosx;
        autos.setInteres(interes);

        Intent it = new Intent(this, MainActivity4.class);
        it.putExtra("autos", autos); //al intent lo asocia la clase
        startActivity(it); // llamar a la actividad
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String nombre = sp.getSelectedItem().toString();
        autos.setAuto(nombre);
        //obtener la direccion de memoria
        int dir = getResources().getIdentifier("drawable/" + nombre,
                null,
                getPackageName());
        img.setImageResource(dir);
        autos.setImagen(dir);
        double v[] = {14900, 23000, 26000, 21000, 32000, 19000, 17000, 15000};
        autos.setPrecio(v[i]);
        tpre.setText("Precio: " + v[i]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}