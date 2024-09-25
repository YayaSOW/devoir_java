package org.example.data.repositories;

import org.example.core.Repository;
import org.example.data.entities.Medecin;

public interface MedecinRepository extends Repository<Medecin> {
    public Medecin selectByName(String name);
}
