package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ser.impl.StringArraySerializer;

import fr.univrennes.istic.l2gen.station.StationAPI;
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
        ArrayList<String> depListe = new ArrayList<>(isCheckedDept.entrySet().stream().filter(Map.Entry::getValue)
                .map(Map.Entry::getKey).collect(Collectors.toList()));
        ArrayList<String> regListe = new ArrayList<>(isCheckedReg.entrySet().stream().filter(Map.Entry::getValue)
                .map(Map.Entry::getKey).collect(Collectors.toList()));
        ArrayList<String> carbListe = new ArrayList<>(isCheckedCarb.entrySet().stream().filter(Map.Entry::getValue)
                .map(Map.Entry::getKey).collect(Collectors.toList()));
        ArrayList<String> servListe = new ArrayList<>(isCheckedServ.entrySet().stream().filter(Map.Entry::getValue)
                .map(Map.Entry::getKey).collect(Collectors.toList()));
        StationAPI api = new StationAPI();
        Boolean depOuReg = true; // TODO il faudrait mettre une variable qui dit si on a choisit département ou
                                 // région

        if (depOuReg) { // département
            api.filtreDep(depListe, carbListe, servListe);
        } else { // région
            api.filtreReg(regListe, carbListe, servListe);
        }

        for (int i = 0; i < isCheckedDiag.length; i++) {
            HashMap<String, HashMap<String, Double>> donnes;
            if (i == 0) { // Prix moyen
                donnes = api.getPrixMoyen();
            } else if (i == 1) { // Prix médian
                donnes = api.getPrixMedian();
            } else { // Prix min
                donnes = api.getPrixMin();
            }
            for (String carburant : donnes.keySet()) {
                IDataVisualiseur diagramme = new DiagColonnes("Titre"); // TODO créer le bon diagramme
                for (String granularite : donnes.get(carburant).keySet()) {
                    diagramme.legender(granularite);
                }
                diagramme.ajouterDonnees(carburant,
                        donnes.get(carburant).values().stream().mapToDouble(Double::doubleValue).toArray());
                diagramme.createSvgFile();
            }
        }
    }
}
