package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garage {
    private int id;
    private List<Vehicle> vehicles;

    private static int idCounter;

    public Garage() {
        this.id = idCounter++;
        this.vehicles = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void orderByPrice() {
        vehicles.sort((a, b) -> a.getPrice().compareTo(b.getPrice()));
    }

    public void orderByBrand() {
        vehicles.sort(Comparator.comparing(Vehicle::getBrand));
    }

    public List<Vehicle> getVehiclesPriceUpTo1000() {
        return vehicles.stream().filter(vehicle -> vehicle.getPrice().compareTo(BigDecimal.valueOf(1000)) <= 0).collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesPriceFrom1000() {
        return vehicles.stream().filter(vehicle -> vehicle.getPrice().compareTo(BigDecimal.valueOf(1000)) >= 0).collect(Collectors.toList());
    }

    public BigDecimal getAverageVehiclePrice() {
        return vehicles.stream().reduce(BigDecimal.valueOf(0), (acc, currentVehicle) -> acc.add(currentVehicle.getPrice()), BigDecimal::add).divide(BigDecimal.valueOf(vehicles.size()), 2, RoundingMode.HALF_UP);
        //BigDecimal.valueOf(vehicles.stream().mapToDouble(Vehicle::getPrice).average());
    }
}
