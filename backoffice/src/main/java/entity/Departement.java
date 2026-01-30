package entity;

import java.util.ArrayList;

public class Departement {
    private String nom;
    private String addresse;
    private ArrayList<String> matieres;
    private ArrayList<Etudiant> etudiant;
    
    public Departement(){}

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAddresse() {
        return addresse;
    }
    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }
    public ArrayList<String> getMatieres() {
        return matieres;
    }
    public void setMatieres(ArrayList<String> matieres) {
        this.matieres = matieres;
    }

    public ArrayList<Etudiant> getEtudiants() {
        return etudiant;
    }

    public void setEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiant = etudiants;
    }
}
