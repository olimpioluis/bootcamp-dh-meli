package ex03.entities;

import ex03.interfaces.Carnivorous;

public class Dog extends Animal implements Carnivorous {
    @Override
    public void emitSound() {
        System.out.println("Auau");
    }

    @Override
    public void eatMeat() {
        System.out.println("Cachorro comendo carne...");
    }
}
