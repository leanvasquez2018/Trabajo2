package ar.org.centro8.entities;

import lombok.Getter;

@Getter
public class Moto extends Vehiculo{

    private int cilindrada;

    public Moto(String marca, String modelo, int cilindrada, double precio) {
        super(marca, modelo, precio);
        this.cilindrada=cilindrada;
    }

    @Override
    public String toString() {
        return "Marca: " + getMarca() + " // Modelo: " + getModelo() + " // Cilindrada: " + getCilindrada() + "c // Precio: $" + DF(getPrecio());
    }
 
}
