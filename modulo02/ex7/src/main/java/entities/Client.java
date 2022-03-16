package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {
    private Long ID;
    private String name;
    private String surname;

    public Client(Long ID, String name, String surname) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "ID: " + ID + " " + "Nome: " + name + " " + surname;
    }
}
