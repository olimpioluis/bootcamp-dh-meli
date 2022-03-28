package br.com.meli.exercicio03.repository;

import br.com.meli.exercicio03.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class VehicleRepository {
    private static List<Vehicle> vehicles = new ArrayList<>();

    public Vehicle save(Vehicle vehicle) {
        vehicles.add(vehicle);
        return vehicle;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<Vehicle> getVehiclesByManufacturingDate(String since, String to) {
        LocalDate convertedSince = since != null ? LocalDate.parse(since) : null;
        LocalDate convertedTo = to != null ? LocalDate.parse(to) : null;

        if (convertedSince != null && convertedTo != null) {
            return vehicles.stream().filter(vehicle -> vehicle.getManufacturingDate().isAfter(convertedSince) && vehicle.getManufacturingDate().isBefore(convertedTo)).collect(Collectors.toList());
        } else  if (convertedSince != null) {
            return vehicles.stream().filter(vehicle -> vehicle.getManufacturingDate().isAfter(convertedSince)).collect(Collectors.toList());
        } else if (convertedTo != null) {
            return vehicles.stream().filter(vehicle -> vehicle.getManufacturingDate().isBefore(convertedTo)).collect(Collectors.toList());
        }

        return vehicles;
    }

    public List<Vehicle> getVehiclesByPrice(Double since, Double to) {
        if (since != null && to != null) {
            return vehicles.stream().filter(vehicle -> vehicle.getPrice() > since && vehicle.getPrice() < to).collect(Collectors.toList());
        } else if (since != null) {
            return vehicles.stream().filter(vehicle -> vehicle.getPrice() > since).collect(Collectors.toList());
        } else if (to != null) {
            return vehicles.stream().filter(vehicle -> vehicle.getPrice() < to).collect(Collectors.toList());
        }

        return vehicles;
    }

    public Vehicle getVehicleById(int id) {
        return vehicles.stream().filter(vehicle -> vehicle.getId() == id).findFirst().orElse(new Vehicle());
    }
}
