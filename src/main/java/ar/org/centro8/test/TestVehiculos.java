package ar.org.centro8.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ar.org.centro8.entities.Auto;
import ar.org.centro8.entities.Moto;
import ar.org.centro8.entities.Vehiculo;

public class TestVehiculos {
    public static void main(String[] args) {
        List<Vehiculo>vehiculos=new ArrayList();
        agregaVehiculos(vehiculos);
        DecimalFormat df=new DecimalFormat("0.00");
        
        //Vehiculos
        vehiculos.stream().forEach(System.out::println);

        separador();

        //Vehiculo más caro
        Vehiculo vehiculoCaro=vehiculos
                .stream()
                .max(Comparator.comparing(Vehiculo::getPrecio))
                .get();

        System.out.println("Vehículo más caro: " + vehiculoCaro.getMarca() + " " + vehiculoCaro.getModelo());

        //Vehiculo más barato
        Vehiculo vehiculoBarato=vehiculos
                .stream()
                .min(Comparator.comparing(Vehiculo::getPrecio))
                .get();

        System.out.println("Vehículo más barato: " + vehiculoBarato.getMarca() + " " + vehiculoBarato.getModelo());

        //Vehiculo que contiene en el modelo la letra Y
        Vehiculo vehiculoConY = vehiculos
                .stream()
                .filter(vehiculo->vehiculo
                                        .getModelo()
                                        .contains("Y"))
                                        .findAny()
                                        .get();

        System.out.println("Vehículo que contiene en el modelo la letra 'Y': " + vehiculoConY.getMarca() + " " + vehiculoConY.getModelo() + " $" + df.format(vehiculoConY.getPrecio()));

        separador();

        //Vehiculos ordenados por precio de mayor a menor
        System.out.println("Vehículos ordenados por precio de mayor a menor:");
        
        vehiculos
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getPrecio).reversed())
                .forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo()));

        separador();

        //Vehiculos ordenados por orden natural
        System.out.println("Vehículos ordenados por orden natural (marca, modelo, precio):");
        
        vehiculos
                .stream()
                .sorted()
                .forEach(System.out::println);
        
    }

    private static void agregaVehiculos(List<Vehiculo> vehiculos) {
        vehiculos.add(new Auto("Peugeot", "206", 4, 200000));
        vehiculos.add(new Moto("Honda", "Titan", 125, 60000));
        vehiculos.add(new Auto("Peugeot", "208", 5, 250000));
        vehiculos.add(new Moto("Yamaha", "YBR", 160, 80500.50));
    }

    private static void separador(){
        System.out.println("=============================");
    }

}
