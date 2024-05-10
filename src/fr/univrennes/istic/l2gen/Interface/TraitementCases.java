package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import fr.univrennes.istic.l2gen.station.StationAPI;
import fr.univrennes.istic.l2gen.visustats.DiagBarres;
import fr.univrennes.istic.l2gen.visustats.DiagCamemberts;
import fr.univrennes.istic.l2gen.visustats.DiagColonnes;
import fr.univrennes.istic.l2gen.visustats.IDataVisualiseur;

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

    public void traitement() {
        ArrayList<String> depListe = new ArrayList<>(isCheckedDept.entrySet().stream().filter(entry -> entry.getValue())
                .map(entry -> entry.getKey()).collect(Collectors.toList()));
        ArrayList<String> regListe = new ArrayList<>(isCheckedReg.entrySet().stream().filter(entry -> entry.getValue())
                .map(entry -> entry.getKey()).collect(Collectors.toList()));
        ArrayList<String> carbListe = new ArrayList<>(
                isCheckedCarb.entrySet().stream().filter(entry -> entry.getValue())
                        .map(entry -> entry.getKey()).collect(Collectors.toList()));
        ArrayList<String> servListe = new ArrayList<>(
                isCheckedServ.entrySet().stream().filter(entry -> entry.getValue())
                        .map(entry -> entry.getKey()).collect(Collectors.toList()));
        StationAPI api = new StationAPI();
        Boolean depOuReg = true; // TODO il faudrait mettre une variable qui dit si on a choisit département ou
                                 // région

        if (depOuReg) { // département
            api.filtreDep(depListe, carbListe, servListe);
        } else { // région
            api.filtreReg(regListe, carbListe, servListe);
        }

        // Génération des diagrammes de prix moyen, médians et minimum
        for (int i = 0; i < isCheckedDiag.length; i++) {
            HashMap<String, HashMap<String, Double>> donnes = new HashMap<>();
            if (i == 0 && isCheckedStat.get("Prix moyen")) { // Prix moyen
                donnes = api.getPrixMoyen();
            } else if (i == 1 && isCheckedStat.get("Prix médian")) { // Prix médian
                donnes = api.getPrixMedian();
            } else if (i == 3 && isCheckedStat.get("Prix minimum")) { // Prix min
                donnes = api.getPrixMin();
            }
            if (!donnes.isEmpty()) {
                for (String carburant : donnes.keySet()) {
                    IDataVisualiseur diagramme = new DiagBarres(null); // juste pour l'initialiser
                    for (String type_diag : isCheckedDiag[i].keySet()) {
                        if (isCheckedDiag[i].get(type_diag)) {
                            if (type_diag.equals("camembert")) {
                                diagramme = new DiagCamemberts("Titre"); // TODO changer le titre
                            } else if (type_diag.equals("barres")) {
                                diagramme = new DiagBarres("Titre"); // TODO changer le titre
                            } else if (type_diag.equals("colonnes")) {
                                diagramme = new DiagColonnes("Titre"); // TODO changer le titre
                            }
                        }
                    }
                    for (String granularite : donnes.get(carburant).keySet()) {
                        diagramme.legender(granularite);
                    }
                    diagramme.ajouterDonnees(carburant,
                            donnes.get(carburant).values().stream().mapToDouble(Double::doubleValue).toArray());
                    diagramme.createSvgFile(); // TODO faire en sorte que la fonction rende un string de SVG
                }
            }

        }
    }
}
