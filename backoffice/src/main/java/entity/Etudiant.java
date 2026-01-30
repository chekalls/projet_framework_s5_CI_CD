package entity;

public class Etudiant {
    private String nom;
    private String prenom;

    public Etudiant(){}

    public Etudiant(String nom,String prenom){
        this.setNom(nom);
        this.setPrenom(prenom);
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

}
