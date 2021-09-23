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
public class Mes implements Serializable {
    String mes;
    Double venta;
    int imagen;

    public Mes(String mes, Double venta) {
        this.mes = mes;
        this.venta = venta;
    }
}
