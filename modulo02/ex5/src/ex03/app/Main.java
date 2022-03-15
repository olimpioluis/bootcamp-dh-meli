package ex03.app;

import ex03.entities.Cat;
import ex03.entities.Cow;
import ex03.entities.Dog;

public class Main {
    public static void main(String[] args) {
        // Criando animais
        Cat cat = new Cat();
        Dog dog = new Dog();
        Cow cow = new Cow();

        // Alimentando animais
        System.out.println("-----------------------------------");
        System.out.println("ALIMENTANDO ANIMAIS");
        cat.eatMeat();
        dog.eatMeat();
        cow.eatPasture();

        // Emitindo sons
        System.out.println("-----------------------------------");
        System.out.println("EMITINDO SONS DOS ANIMAIS");
        cat.emitSound();
        dog.emitSound();
        cow.emitSound();
    }
}
