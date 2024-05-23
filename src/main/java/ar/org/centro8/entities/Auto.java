package ar.org.centro8.entities;

import lombok.Getter;

@Getter
public class Auto extends Vehiculo{

    private int puertas;

    public Auto(String marca, String modelo, int puertas, double precio) {
        super(marca, modelo, precio);
        this.puertas=puertas;
    }

    @Override
    public String toString() {
        return "Marca: " + getMarca() + " // Modelo: " + getModelo() + " // Puertas: " + getPuertas() + " // Precio: $" + DF(getPrecio());
    }
 
}
