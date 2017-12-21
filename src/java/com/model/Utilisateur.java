/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.google.gson.Gson;


/**
 *
 * @author judith
 */
public class Utilisateur {
    
    private String nom;
    private String prenom;
    private String login;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String login) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "nom=" + nom + ", prenom=" + prenom + ", login=" + login + '}';
    }
    
    public String toJsonObject(){
        
        Gson gson = new Gson();   
        String json = gson.toJson(this);
        
        
        return json;
    }
    
}
