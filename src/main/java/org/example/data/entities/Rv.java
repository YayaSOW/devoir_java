package org.example.data.entities;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class Rv {
    private int id;
    private LocalDate date;
    private LocalTime heure;
    private static int nbreRV;

    private Medecin medecin;

    public Rv() {
        id = ++nbreRV;
    }
}
