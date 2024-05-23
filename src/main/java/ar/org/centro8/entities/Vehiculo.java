package ar.org.centro8.entities;

import java.text.DecimalFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Vehiculo implements Comparable<Vehiculo>{
    private String marca;
    private String modelo;
    private double precio;
    
    @Override
    public int compareTo(Vehiculo otroVehiculo) {
        int result = this.marca.compareTo(otroVehiculo.marca);
        if(result != 0){
            return result;
        }

        result = this.modelo.compareTo(otroVehiculo.modelo);
        if(result != 0){
            return result;
        }

        return Double.compare(this.precio, otroVehiculo.precio);
    }

    public static String DF(double nro){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(nro);
    }

}
