package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Vehicle {
    private double speed;
    private double acceleration;
    private double turningAngle;
    private String plate;
    private double weight;
    private int wheels;


}
