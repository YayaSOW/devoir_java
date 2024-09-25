package org.example;

import org.example.data.entities.Medecin;
import org.example.data.entities.Rv;
import org.example.services.MedecinService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MedecinService medecinService = new MedecinService();
        int choice;
        do {
            System.out.println("1- Create medecin");
            System.out.println("2- List medecin");
            System.out.println("3- Create RV");
            System.out.println("4- List RV");
            System.out.println("5- List RV's Medecin");
            System.out.println("6- Filtre RV Par Date");
            System.out.println("7- Quitter");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    Medecin medecin = new Medecin();
                    Rv rv = new Rv();
                    System.out.println("Entrer le nom:");
                    medecin.setNom(scanner.nextLine());
                    System.out.println("Entrer le Prenom:");
                    medecin.setPrenom(scanner.nextLine());
                    System.out.println("Enter la date du RV [DD-MM-YY]: ]");
                    rv.setDate(formatDate(scanner.nextLine()));
                    System.out.println("Entrer l'Heure HH:MN");
                    rv.setHeure(formatHeure(scanner.nextLine()));
                    rv.setMedecin(medecin);
                    medecin.add(rv);
                    medecinService.create(medecin);
                }
                case 2 -> {
                    List<Medecin> medecins = medecinService.findAll();
                    medecins.forEach(System.out::println);
                }
                case 3 -> {
                    Rv rv = new Rv();
                    System.out.println("Enter la date du RV [DD/MM/YY]: ]");
                    rv.setDate(formatDate(scanner.nextLine()));
                    System.out.println("Entrer l'Heure HH:MN");
                    rv.setHeure(formatHeure(scanner.nextLine()));

                }
                case 5->{
                    System.out.println("Entrer le nom du medecin:");
                    String name = scanner.nextLine();
                    Medecin medecin = medecinService.findByName(name);
                    if (medecin == null) {
                        System.out.println("Le client n'existe pas");
                    } else {
                        System.out.println(medecin);
                    }
                }
                default -> {
                }
            }
        } while (choice != 7);
    }

    public static LocalDate formatDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }

    public static LocalTime formatHeure(String heure){
        DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("HH:mm");
        return  LocalTime.parse(heure,formatter);
    }
}