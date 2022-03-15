package ex03.entities;

import ex03.interfaces.Carnivorous;

public class Cat extends Animal implements Carnivorous {
    @Override
    public void emitSound() {
        System.out.println("Miau");
    }

    @Override
    public void eatMeat() {
        System.out.println("Gato comendo carne...");
    }

}
