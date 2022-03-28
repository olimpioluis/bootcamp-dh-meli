package br.com.meli.exercicio03.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private String date;
    private String  kilometers;
    private String description;
    private int vehicleId;
}
