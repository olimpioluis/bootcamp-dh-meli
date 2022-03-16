package entities;

public class Car extends Vehicle {
    private final static double WEIGHT_CAR_KG = 1000.0;
    private final static int NUMBER_OF_WHEELS = 4;

    public Car(double speed, double acceleration, double turningAngle, String plate) {
        super(speed, acceleration, turningAngle, plate, WEIGHT_CAR_KG, NUMBER_OF_WHEELS);
    }
}
