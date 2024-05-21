package fr.univrennes.istic.l2gen.station;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prix {
    /**
     * Le nom du carburant.
     */
    @JsonProperty("@nom")
    private String nom;

    /**
     * L'identifiant du carburant.
     */
    @JsonProperty("@id")
    private String id;

    /**
     * La date de mise à jour du prix du carburant.
     */
    @JsonProperty("@maj")
    private String maj;

    /**
     * La valeur du prix du carburant.
     */
    @JsonProperty("@valeur")
    private String valeur;

    private Double valeurDouble;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaj() {
        return maj;
    }

    public void setMaj(String maj) {
        this.maj = maj;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Prix [nom=" + nom + ", id=" + id + ", maj=" + maj + ", valeur=" + valeur + ", getNom()=" + getNom()
                + ", getId()=" + getId() + ", getMaj()=" + getMaj() + ", getValeur()=" + getValeur() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    public Double getValeurDouble() {
        return valeurDouble;
    }

    public void setValeurDouble(Double valeurDouble) {
        this.valeurDouble = valeurDouble;
    }

    // Getters et setters
}
