package fr.univrennes.istic.l2gen.station;

/**
 * Cette classe représente un type de carburant avec son nom et son prix.
 */
public class Carburant {
    /**
     * Nom du carburant.
     */
    private String nom;
    
    /**
     * Prix du carburant.
     */
    private Double prix;

    /**
     * Constructeur de la classe Carburant.
     * @param nom Nom du carburant.
     * @param prix Prix du carburant.
     */
    public Carburant(String nom, Double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    /**
     * Méthode pour obtenir le nom du carburant.
     * @return Le nom du carburant.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Méthode pour obtenir le prix du carburant.
     * @return Le prix du carburant.
     */
    public Double getPrix() {
        return prix;
    }
}