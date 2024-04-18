package fr.univrennes.istic.l2gen.station;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente une station-service.
 */
public class Station {
    // Liste des services disponibles à la station
    private List<String> services_service;

    // Nom du département de la station
    private String nom_dep;

    // Nom de la ville de la station
    private String nom_ville;

    // Adresse de la station
    private String adresse;

    // Nom de la région de la station
    private String nom_reg;

    // Code du département de la station
    private String code_dep;

    // Code de la région de la station
    private String code_reg;

    // Liste des carburants disponibles à la station
    private List<Carburant> carburants;

    /**
     * Constructeur de la classe Station.
     * @param services_service La liste des services disponibles à la station.
     * @param nom_dep Le nom du département de la station.
     * @param nom_ville Le nom de la ville de la station.
     * @param adresse L'adresse de la station.
     * @param nom_reg Le nom de la région de la station.
     * @param code_dep Le code du département de la station.
     * @param code_reg Le code de la région de la station.
     */
    public Station(List<String> services_service, String nom_dep, String nom_ville, String adresse,
            String nom_reg, String code_dep, String code_reg) {
        this.services_service = services_service;
        this.nom_dep = nom_dep;
        this.nom_ville = nom_ville;
        this.adresse = adresse;
        this.nom_reg = nom_reg;
        this.code_dep = code_dep;
        this.code_reg = code_reg;
        this.carburants = new ArrayList<>();
    }

    /**
     * Méthode permettant d'ajouter un carburant à la station.
     * @param nom Le nom du carburant.
     * @param prix Le prix du carburant.
     */
    public void ajoutCarburant(String nom, Double prix) {
        carburants.add(new Carburant(nom, prix));
    }

    /**
     * Obtient la liste des carburants disponibles à la station.
     * @return La liste des carburants.
     */
    public List<Carburant> getCarburants() {
        return carburants;
    }

    /**
     * Obtient la liste des services disponibles à la station.
     * @return La liste des services.
     */
    public List<String> getServices_service() {
        return services_service;
    }

    /**
     * Obtient le nom du département de la station.
     * @return Le nom du département.
     */
    public String getNom_dep() {
        return nom_dep;
    }

    /**
     * Obtient le nom de la ville de la station.
     * @return Le nom de la ville.
     */
    public String getNom_ville() {
        return nom_ville;
    }

    /**
     * Obtient l'adresse de la station.
     * @return L'adresse.
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Obtient le nom de la région de la station.
     * @return Le nom de la région.
     */
    public String getNom_reg() {
        return nom_reg;
    }

    /**
     * Obtient le code du département de la station.
     * @return Le code du département.
     */
    public String getCode_dep() {
        return code_dep;
    }

    /**
     * Obtient le code de la région de la station.
     * @return Le code de la région.
     */
    public String getCode_reg() {
        return code_reg;
    }
}