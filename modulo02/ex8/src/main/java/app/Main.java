package app;

import entities.Car;
import entities.Motorcycle;
import entities.Race;
import entities.Vehicle;

import java.math.BigDecimal;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Race raceOne = new Race(56, BigDecimal.valueOf(60000), "Race One", 5);

        Car car1 = new Car(300, 4, 60, "111");
        Car car2 = new Car(150, 4, 30, "222");
        Motorcycle motorcycle = new Motorcycle(120, 4, 30, "333");
        Car car4 = new Car(200, 4, 45, "444");
        Car car5 = new Car(250, 4, 45, "555");

        raceOne.addCar(car1);
        raceOne.addCar(car2);
        raceOne.addMotorcycle(motorcycle);
        raceOne.addCar(car4);
        raceOne.addCar(car5);


        Optional<Vehicle> vehicle = raceOne.findRaceWinner();

        if (vehicle.isPresent())
            System.out.println("PLACA DO VENCEDOR: " + vehicle.get().getPlate() + " PREMIO: " + raceOne.getPrizeInDollars() + " EM DOLARES");


        raceOne.deleteVehicle(car2);

        raceOne.showAll();

        raceOne.deleteVehicleByPlate("555");

        raceOne.showAll();

        raceOne.rescueCar(car1);
        raceOne.rescueMotorcycle(motorcycle);

    }
}
