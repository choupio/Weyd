package fr.univrennes.istic.l2gen.Interface;

import java.util.HashMap;

import fr.univrennes.istic.l2gen.station.StationAPI;

public class TraitementCases {
    private StationAPI json = Accueil.getRecup();
    private HashMap<String, Boolean> isCheckedServ = Services.getIsCheckedServ();
    private HashMap<String, Boolean> isCheckedDept = Departement.getIsCheckedDept();
    private HashMap<String, Boolean> isCheckedCarb = Carburant.getIsCheckedCarb();
    private HashMap<String, Boolean> isCheckedStat = Statistique.getIsCheckedStat();
    private HashMap<String, Boolean>[] isCheckedDiag = Diag.getIsCheckedDiag();
    private HashMap<String, Boolean> isCheckedDiagPrixMoy = isCheckedDiag[0];
    private HashMap<String, Boolean> isCheckedDiagPrixMed = isCheckedDiag[1];
    private HashMap<String, Boolean> isCheckedDiagPrixMin = isCheckedDiag[2];
    private Boolean isCheckedPos = Onglet.getIsSationsAffichees();
    private HashMap<String, Boolean> isCheckedReg = Region.getIsCheckedReg();

    public TraitementCases() {
        json.
        // Traitement des cases cochées
        traitementRegions();
        traitementDepartements();
        traitementCarburants();
        traitementStatistiques();
        traitementServices();
        traitementPosition();
        // TODO comment on fait pour les couleurs?
    }

    // Traitement des regions cochées
    public void traitementRegions() {
        // filtrer les stations par région
    }

    // Traitement des départements cochées
    public void traitementDepartements() {
        // filtrer les stations par département
    }

    // Traitement des services cochées
    public void traitementServices() {
        // filtrer les stations par services
    }

    // Traitement des carburants cochées et voir le diag qui va avec
    public void traitementCarburants() {
        // regarder quel carburant est coché et quel est son diagramme
    }

    // Traitement des statistiques cochées
    public void traitementStatistiques() {
        // appliquer le calcul des statistiques sélectionnée
    }

    // Traitement de position coché
    public void traitementPosition() {
        // afficher les position des stations
    }
}
