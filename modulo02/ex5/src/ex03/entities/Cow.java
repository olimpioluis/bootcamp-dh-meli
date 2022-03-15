package ex03.entities;

import ex03.interfaces.Herbivorous;

public class Cow extends Animal implements Herbivorous {
    @Override
    public void emitSound() {
        System.out.println("Mu");
    }

    @Override
    public void eatPasture() {
        System.out.println("Vaca comendo pasto...");
    }
}
