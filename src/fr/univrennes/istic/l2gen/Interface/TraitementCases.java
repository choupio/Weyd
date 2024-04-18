package fr.univrennes.istic.l2gen.Interface;

import java.util.HashMap;

public class TraitementCases {
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
        isCheckedCarb.forEach((key, value) -> {
            isCheckedDiagPrixMoy.forEach((nom, checked) -> {
                if (nom.equals("Diag en camembert prix moyen") && checked == true) {
                    // faire le diag en camembert prix moyen
                } else if (nom.equals("Diag en barres prix moyen") && checked == true) {
                    // faire le diag en barres prix moyen
                } else if (nom.equals("Diag en colonne prix moyen") && checked == true) {
                    // faire le diag en colonne prix moyen
                }
            });
            isCheckedDiagPrixMed.forEach((nom, checked) -> {
                if (nom.equals("Diag en camembert prix médian") && checked == true) {
                    // faire le diag en camembert prix médian
                } else if (nom.equals("Diag en barres prix médian") && checked == true) {
                    // faire le diag en barres prix médian
                } else if (nom.equals("Diag en colonne prix médian") && checked == true) {
                    // faire le diag en colonne prix médian
                }
            });
            isCheckedDiagPrixMin.forEach((nom, checked) -> {
                if (nom.equals("Diag en camembert prix minimum") && checked == true) {
                    // faire le diag en camembert prix minimum
                } else if (nom.equals("Diag en barres prix minimum") && checked == true) {
                    // faire le diag en barres prix minimum
                } else if (nom.equals("Diag en colonne prix minimum") && checked == true) {
                    // faire le diag en colonne prix minimum
                }
            });
        });
    }
    // TODO par carb faire le graphique sélectionné, ajouter les calculs des stats

    // Traitement des statistiques cochées
    public void traitementStatistiques() {
        // appliquer le calcul des statistiques sélectionnée
    }

    // Traitement de position coché
    public void traitementPosition() {
        // afficher les position des stations
    }
}
