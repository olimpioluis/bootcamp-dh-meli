package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Race {
    private double distance;
    private BigDecimal prizeInDollars;
    private String name;
    private int amountVehiclesAllowed;
    private List<Vehicle> vehicles;

    private AmbulanceForCar carRescuer = new AmbulanceForCar();
    private AmbulanceForMotorcycle motorcycleRescuer = new AmbulanceForMotorcycle();

    public Race(double distance, BigDecimal prizeInDollars, String name, int amountVehiclesAllowed) {
        this.vehicles = new ArrayList<>();
        this.distance = distance;
        this.prizeInDollars = prizeInDollars;
        this.name = name;
        this.amountVehiclesAllowed = amountVehiclesAllowed;
    }

    public void addCar(Car car) {
        if (vehicles.size() <= amountVehiclesAllowed) {
            vehicles.add(car);
            return;
        }

        System.out.println("Corrida esgotada!");
    }

    public void addMotorcycle(Motorcycle motorcycle) {
        if (vehicles.size() <= amountVehiclesAllowed) {
            vehicles.add(motorcycle);
            return;
        }

        System.out.println("Corrida esgotada");
    }

    public void showAll() {
        System.out.println("===== VEICULOS INSCRITOS =====");
        vehicles.forEach(vehicle -> System.out.println(vehicle.getPlate()));
    }

    public void deleteVehicle(Vehicle vehicle) {
        boolean response = vehicles.remove(vehicle);

        if (response) {
            System.out.println("Veiculo com placa " + vehicle.getPlate() + " foi removido");
            return;
        }

        System.out.println("Veiculo nao encontrado");

    }

    public void deleteVehicleByPlate(String plate) {
        boolean response = vehicles.removeIf(vehicle -> vehicle.getPlate().equals(plate));

        if (response) {
            System.out.println("Veiculo com placa " + plate + " foi removido");
            return;
        }

        System.out.println("Veiculo nao encontrado");
    }

    public double checkPerformance(Vehicle vehicle) {
        return vehicle.getSpeed() * vehicle.getAcceleration() / 2 / (vehicle.getTurningAngle() * (vehicle.getWeight() - vehicle.getWheels() * 100));
    }

    public Optional<Vehicle> findRaceWinner() {
        return vehicles.stream().max(Comparator.comparing(this::checkPerformance));
    }

    public void rescueCar(Car car) {
        Optional<Vehicle> carFound = vehicles.stream().filter(vehicle -> vehicle.getPlate().equals(car.getPlate()) && vehicle instanceof Car).findAny();

        if (carFound.isPresent()) {
            carRescuer.rescue(car);
            return;
        }

        System.out.println("Carro nao encontrado na corrida para o socorro");
    }

    public void rescueMotorcycle(Motorcycle motorcycle) {
        Optional<Vehicle> motorcycleFound = vehicles.stream().filter(vehicle -> vehicle.getPlate().equals(motorcycle.getPlate()) && vehicle instanceof Motorcycle).findAny();

        if (motorcycleFound.isPresent()) {
            motorcycleRescuer.rescue(motorcycle);
            return;
        }

        System.out.println("Carro nao encontrado na corrida para o socorro");
    }
}
