package org.example.data.repositories.impl;

import org.example.data.entities.Medecin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedecinRepositoryImpl {
    public void insert(Medecin medecin){
        Connection conn = null;
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ges_rv","root","");
        String req = "INSERT INTO `medecin` (`nom`, `prenom`) VALUES (?,?);";
        PreparedStatement stmt = conn.prepareStatement(req);
        stmt.setString(1, medecin.getNom());
        stmt.setString(2, medecin.getPrenom());
        stmt.executeUpdate();
        }catch (ClassNotFoundException e){
            System.out.println("Error: Driver not found");
        }catch (SQLException e){
            System.out.println("Error: SQL Exception");
        }
    }

    public List<Medecin> selectAll(){
        List<Medecin> list = new ArrayList<>();
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ges_rv", "root", "");
            String sql = "SELECT * FROM `medecin`";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Medecin medecin = new Medecin();
                medecin.setId(rs.getInt("id"));
                medecin.setNom(rs.getString("nom"));
                medecin.setPrenom(rs.getString("prenom"));
                list.add(medecin);
            }
            rs.close();
            stmt.close();
        }catch (ClassNotFoundException e){
            System.out.println("Error: Driver not found");
        }catch (SQLException e){
            System.out.println("Error: SQL Exception");
        }
        return list;
    }

    public Medecin selectByName(String name){
//
        Medecin medecin = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ges_rv", "root", "");
//            String sql = "SELECT * FROM `medecin` WHERE `nom` LIKE ?";
            String sql = String.format("SELECT * FROM `medecin` WHERE `nom` LIKE %s",name);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                medecin = new Medecin();
                medecin.setId(rs.getInt("id"));
                medecin.setNom(rs.getString("nom"));
                medecin.setPrenom(rs.getString("prenom"));
            }
            rs.close();
            stmt.close();
        }catch (ClassNotFoundException e){
            System.out.println("Error: Driver not found");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error: SQL Exception");
        }
        return medecin;
    }
}
