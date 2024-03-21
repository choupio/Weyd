package fr.univrennes.istic.l2gen.station;

public class Carburant {
    private String nom;
    private Double prix;

    public Carburant(String nom, Double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public Double getPrix() {
        return prix;
    }

}
