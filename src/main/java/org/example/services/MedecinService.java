package org.example.services;

import org.example.data.entities.Medecin;
import org.example.data.repositories.impl.MedecinRepositoryImpl;

import java.util.List;

public class MedecinService {
    private MedecinRepositoryImpl medecinRepository = new MedecinRepositoryImpl();

//    public MedecinService(MedecinRepository medecinRepository) {
//        this.medecinRepository = medecinRepository;
//    }

    public void create(Medecin medecin) {
        medecinRepository.insert(medecin);
    }
    public List<Medecin> findAll() {
        return medecinRepository.selectAll();
    }
    public Medecin findByName(String name) {
        return medecinRepository.selectByName(name);
    }
}
