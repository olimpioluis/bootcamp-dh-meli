package br.com.meli.exercicio02.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private String name;
    private String surname;
    private int age;
}
