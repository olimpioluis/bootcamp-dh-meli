package ex02.entities;

import ex02.interfaces.Printable;

public class ResumeFile implements Printable {
    private Person person;

    public ResumeFile(Person person) {
        this.person = person;
    }

    @Override
    public void print() {
        System.out.println("Imprimindo curriculo do " + person.getName() + "...");
    }
}
