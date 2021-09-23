package com.example.examen_1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapta1 extends RecyclerView.Adapter<Adapta1.MyHolder>{

    List<Mes> lista;
    Context contexto;

    public Adapta1(List<Mes> lista, Context contexto) {
        this.lista = lista;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater infla= LayoutInflater.from(contexto);
        View vis=infla.inflate(R.layout.vista1,parent,false);
        return new Adapta1.MyHolder(vis);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        //enlazar los datos con los controles
        final Mes art = lista.get(position);
        holder.tmes.setText(art.getMes());
        holder.tpre.setText(""+art.getVenta());
        int color = art.getVenta() < 1000.0 ? Color.RED :
                art.getVenta() >= 1000.0 && art.getVenta() < 2500.0 ? Color.BLACK : Color.BLUE;
        holder.tpre.setTextColor(color);
        holder.imgm.setImageResource(art.getImagen());
        //al seleccionar un item llamar a la pantalla2
        holder.milayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(contexto, MainActivity2.class);
                it.putExtra("dato", art);
                contexto.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size(); //cantidad de elementos
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imgm;
        TextView tmes,tpre;
        ConstraintLayout milayout;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imgm=itemView.findViewById(R.id.imgmes);
            tmes=itemView.findViewById(R.id.txtmes);
            tpre=itemView.findViewById(R.id.txtpre);
            milayout=itemView.findViewById(R.id.milayout);

        }
    }
}
