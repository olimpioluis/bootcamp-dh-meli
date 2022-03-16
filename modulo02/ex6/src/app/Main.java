package app;

import entities.Garage;
import entities.Vehicle;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando garagem
        Garage garage = new Garage();

        // Adicionando carros a garagem
        garage.getVehicles().add(new Vehicle("Fiesta", "Ford", BigDecimal.valueOf(1000)));
        garage.getVehicles().add(new Vehicle("Focus", "Ford", BigDecimal.valueOf(1200)));
        garage.getVehicles().add(new Vehicle("Explorer", "Ford", BigDecimal.valueOf(2500)));
        garage.getVehicles().add(new Vehicle("Uno", "Fiat", BigDecimal.valueOf(500)));
        garage.getVehicles().add(new Vehicle("Cronos", "Fiat", BigDecimal.valueOf(1000)));
        garage.getVehicles().add(new Vehicle("Torino", "Fiat", BigDecimal.valueOf(1250)));
        garage.getVehicles().add(new Vehicle("Aveo", "Chevrolet", BigDecimal.valueOf(1250)));
        garage.getVehicles().add(new Vehicle("Spin", "Chevrolet", BigDecimal.valueOf(2500)));
        garage.getVehicles().add(new Vehicle("Corola", "Toyota", BigDecimal.valueOf(1200)));
        garage.getVehicles().add(new Vehicle("Fortuner", "Toyota", BigDecimal.valueOf(3000)));
        garage.getVehicles().add(new Vehicle("Logan", "Renault", BigDecimal.valueOf(950)));

        // Ordenando por preço
        garage.orderByPrice();
        System.out.println("----------------------------");
        System.out.println("Ordenado por preco");
        garage.getVehicles().forEach(System.out::println);
        System.out.println("----------------------------");

        // Ordenado por marca
        garage.orderByBrand();
        System.out.println("----------------------------");
        System.out.println("Ordenado por marca");
        garage.getVehicles().forEach(System.out::println);
        System.out.println("----------------------------");

        // Obtendo e imprimindo lista de precos menores ou iguais a 1000
        System.out.println("----------------------------");
        System.out.println("Veiculos com precos menores que 1000");
        garage.getVehiclesPriceUpTo1000().forEach(System.out::println);
        System.out.println("----------------------------");

        // Obtendo e imprimindo lista de precos maiores ou iguais a 1000
        System.out.println("----------------------------");
        System.out.println("Veiculos com precos maiores ou iguais a 1000");
        garage.getVehiclesPriceFrom1000().forEach(System.out::println);
        System.out.println("----------------------------");

        // Obtendo e imprimindo a media de precos
        System.out.println("----------------------------");
        System.out.println("Media de precos");
        System.out.println(garage.getAverageVehiclePrice());
        System.out.println("----------------------------");
    }
}
