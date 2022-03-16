package entities;

public class Motorcycle extends Vehicle {
    private final static double WEIGHT_MOTORCYCLE_KG = 1000.0;
    private final static int NUMBER_OF_WHEELS = 4;

    public Motorcycle(double speed, double acceleration, double turningAngle, String plate) {
        super(speed, acceleration, turningAngle, plate, WEIGHT_MOTORCYCLE_KG, NUMBER_OF_WHEELS);
    }
}
