package br.com.meli.exercicio03.dto;

import br.com.meli.exercicio03.entity.Service;
import br.com.meli.exercicio03.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleFilteredDTO {
    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;

    public static List<VehicleFilteredDTO> convert(List<Vehicle> vehicles) {
        return vehicles.stream().map(vehicle -> new VehicleFilteredDTO(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getManufacturingDate().toString(), String.valueOf(vehicle.getNumberOfKilometers()), String.valueOf(vehicle.getDoors()), String.valueOf(vehicle.getPrice()), vehicle.getCurrency(), String.valueOf(vehicle.getCountOfOwners()))).collect(Collectors.toList());
    }
}
