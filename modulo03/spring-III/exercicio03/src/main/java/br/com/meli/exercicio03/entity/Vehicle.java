package br.com.meli.exercicio03.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Data
@NoArgsConstructor
public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private double numberOfKilometers;
    private int doors;
    private Double price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;

    private static int idGenerator = 0;

    public Vehicle(String brand, String model, LocalDate manufacturingDate, Double numberOfKilometers, int doors, Double price, String currency, List<Service> services, int countOfOwners) {
        this.id = generateId();
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }

    private int generateId() {
        return idGenerator++;
    }
}
