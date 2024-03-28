package fr.univrennes.istic.l2gen.station;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private List<String> services_service;
    private String nom_dep, nom_ville, adresse, nom_reg, code_dep, code_reg;
    private List<Carburant> carburants;

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

    public void ajoutCarburant(String nom, Double prix) {
        carburants.add(new Carburant(nom, prix));
    }

    public List<Carburant> getCarburants() {
        return carburants;
    }

    public List<String> getServices_service() {
        return services_service;
    }

    public String getNom_dep() {
        return nom_dep;
    }

    public String getNom_ville() {
        return nom_ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNom_reg() {
        return nom_reg;
    }

    public String getCode_dep() {
        return code_dep;
    }

    public String getCode_reg() {
        return code_reg;
    }
}
