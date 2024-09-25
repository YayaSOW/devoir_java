package org.example.data.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Medecin {
    private int id;
    private String nom;
    private String prenom;
    private static int nbreMedecin;

    private List<Rv> rvList = new ArrayList();

    public Medecin() {
        id = ++nbreMedecin;
    }
    public void add(Rv rv) {
        rvList.add(rv);
    }
}
