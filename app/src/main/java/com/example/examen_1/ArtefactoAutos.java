package com.example.examen_1;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArtefactoAutos implements Serializable {
    String auto;
    String persona;
    double precio;
    double interes;
    int anios;
    int imagen;

    public double cuotaInitial(){
        return precio * 0.10;
    }

    public double saldoFinal(){
        return precio - cuotaInitial();
    }

    public double cuotaMensual(){
        return (precio + interes) / (12 * anios);
    }
}
