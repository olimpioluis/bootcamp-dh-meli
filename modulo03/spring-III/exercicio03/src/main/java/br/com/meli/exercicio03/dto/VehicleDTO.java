package br.com.meli.exercicio03.dto;

import br.com.meli.exercicio03.entity.Service;
import br.com.meli.exercicio03.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO implements Serializable {
    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;

    public VehicleDTO(int id, String brand, String model, String manufacturingDate, String numberOfKilometers, String doors, String price, String currency, String countOfOwners) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.countOfOwners = countOfOwners;
    }

    public Vehicle convert() {
        return new Vehicle(
                this.brand,
                this.model,
                LocalDate.parse(this.manufacturingDate),
                Double.parseDouble(this.numberOfKilometers),
                Integer.parseInt(this.doors),
                Double.parseDouble(this.price),
                this.currency,
                new ArrayList<>(services),
                Integer.parseInt(countOfOwners)
        );
    }

    public VehicleDTO convert(Vehicle vehicle) {
        return new VehicleDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate().toString(), String.valueOf(vehicle.getNumberOfKilometers()), String.valueOf(vehicle.getDoors()), String.valueOf(vehicle.getPrice()), vehicle.getCurrency(), String.valueOf(vehicle.getCountOfOwners()));
    }
}
