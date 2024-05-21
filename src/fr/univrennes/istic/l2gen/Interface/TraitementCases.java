package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;

import fr.univrennes.SVGFile;
import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.station.Geom;
import fr.univrennes.istic.l2gen.station.Station2;
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
    private Boolean isCheckedPos = Onglet.getIsStationsAffichees();
    private HashMap<String, Boolean> isCheckedReg = Region.getIsCheckedReg();

    public TraitementCases() {

    }

    public ArrayList<String> traitement() {
        // Liste qui contiendra les chaine de caractère des différents svg
        ArrayList<String> svgContent = new ArrayList<>();

        ArrayList<String> depListe = new ArrayList<>(isCheckedDept.entrySet()
                .stream()
                .filter(entry -> entry.getValue())
                .map(entry -> entry.getKey())
                .collect(Collectors.toList()));

        ArrayList<String> regListe = new ArrayList<>(isCheckedReg.entrySet()
                .stream()
                .filter(entry -> entry.getValue())
                .map(entry -> entry.getKey())
                .collect(Collectors.toList()));

        ArrayList<String> carbListe = new ArrayList<>(isCheckedCarb.entrySet()
                .stream()
                .filter(entry -> entry.getValue())
                .map(entry -> entry.getKey()).collect(Collectors.toList()));

        ArrayList<String> servListe = new ArrayList<>(isCheckedServ.entrySet()
                .stream().filter(entry -> entry.getValue())
                .map(entry -> entry.getKey())
                .collect(Collectors.toList()));

        StationAPI api = new StationAPI();

        /**
         * Donne l'état de séléction entre département et région : true si départements,
         * false si régions.
         */
        Boolean depOuReg;
        depOuReg = Onglet.getGranChecked();

        if (depOuReg) { // département
            api.filtreDep(depListe, carbListe, servListe);
        } else { // région
            api.filtreReg(regListe, carbListe, servListe);
        }

        // Groupe pour accueuillir les statistiques
        Groupe statistiques = new Groupe();

        ArrayList<String> couleurs = new ArrayList<>();

        if (depOuReg) {
            couleurs = generationCouleur(depListe);
        } else {
            couleurs = generationCouleur(regListe);
        }

        // Génération des diagrammes de prix moyen, médians et minimum
        for (int i = 0; i < 5; i++) {
            HashMap<String, HashMap<String, Double>> donnes = new HashMap<>();

            // Initialisation du titre du diagramme
            String titre = "";

            // Pour ajouter ou non les positions des stations les moins chères
            Boolean stationMoinChere = false;

            // Bloc pour choisir les statistques à représenter
            if (i == 0 && isCheckedStat.get("Prix moyen")) { // Prix moyen
                donnes = api.getPrixMoyen();
                titre = "Prix moyen";
            } else if (i == 1 && isCheckedStat.get("Prix médian")) { // Prix médian
                donnes = api.getPrixMedian();
                titre = "Prix médian";
            } else if (i == 2 && isCheckedStat.get("Prix minimum")) { // Prix min
                donnes = api.getPrixMin();
                titre = "Prix minimum";
                stationMoinChere = Onglet.getIsStationsAffichees();
            } else if (i == 3 && isCheckedStat.get("Nombre de stations proposant ce carburant")) {
                donnes = api.getNbStationProposeCarb();
                titre = "Nombre de stations proposant ce carburant";
            } else if (i == 4 && isCheckedStat.get("Nombre de stations proposant ces services")) {
                donnes = api.getNbStationProposeServices();
                titre = "Nombre de stations proposant ces services";
            }

            if (!donnes.isEmpty()) {

                IDataVisualiseur diagramme = new DiagBarres(null); // juste pour l'initialiser
                for (String type_diag : isCheckedDiag[i].keySet()) {
                    if (isCheckedDiag[i].get(type_diag)) {
                        if (type_diag.equals("camembert")) {
                            diagramme = new DiagCamemberts(titre, donnes.size());
                        } else if (type_diag.equals("barres")) {
                            diagramme = new DiagBarres(titre);
                        } else if (type_diag.equals("colonnes")) {
                            diagramme = new DiagColonnes(titre);
                        }
                    }
                }

                HashSet<String> legendes = new HashSet<>();
                for (String string : donnes.keySet()) {
                    legendes.addAll(donnes.get(string).keySet());
                }
                diagramme.legender(legendes.toArray(new String[0]));

                for (String carburant : donnes.keySet()) {
                    diagramme.ajouterDonnees(carburant,
                            donnes.get(carburant).values().stream().mapToDouble(Double::doubleValue).toArray());
                }

                diagramme.colorier(couleurs.toArray(new String[0]));
                diagramme.agencer();
                statistiques.ajouter(diagramme);
                svgContent.add(SVGFile.contentSvgFile(diagramme));

                if (stationMoinChere) {
                    HashMap<String, HashMap<String, Station2>> adresseStationMoinsChere = api
                            .getAdresseStationMoinsChere();

                    String html = "";
                    for (String granu : adresseStationMoinsChere.keySet()) {
                        html += "<p>" + "dans " + granu + ":</p>";
                        https: // www.google.com/maps/search/4682826,556786/
                        for (String carburant : adresseStationMoinsChere.get(granu).keySet()) {
                            html += "<p>&nbsp;&nbsp;&nbsp;pour " + carburant + ":</p>";
                            Station2 station = adresseStationMoinsChere.get(granu).get(carburant);
                            String lien = "https://www.google.com/maps/search/"
                                    + String.valueOf(station.getGeom().getLat()) + ","
                                    + String.valueOf(station.getGeom().getLon());
                            String baliseLien = "<a href=\"" + lien + "\" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                    + station.getAdresse() + " "
                                    + station.getVille() + "</a></br>";
                            html += baliseLien;
                        }
                    }
                    svgContent.add(html);
                }
            }
        }

        return svgContent;
    }

    /**
     * Méthode pour savoir si le rapport peut être créé ou non.
     *
     * @param granularite les régions ou départements sélectionnés.
     * @return un ArrayList<String> couleurs par granularité.
     */
    private ArrayList<String> generationCouleur(ArrayList<String> granularite) {
        ArrayList<String> couleurs = new ArrayList<>();

        // Bloc pour ajouter les couleurs correspondant au carburant
        for (int i = 0; i < granularite.size(); i++) {
            // Génération de valeurs aléatoires pour les composantes R, G et B
            Random random = new Random();
            int red = random.nextInt(256); // Valeur entre 0 et 255
            int green = random.nextInt(256);
            int blue = random.nextInt(256);

            // Construction de la couleur hexadécimale
            String couleurHex = String.format("#%02x%02x%02x", red, green, blue);
            couleurs.add(couleurHex);
        }

        return couleurs;
    }

    /**
     * Méthode pour savoir si le rapport peut être créé ou non.
     *
     * @return un Booléen indiquant si on peut générer le rapport.
     */
    public boolean isAnyChecked() {
        Boolean depOuReg = Onglet.getGranChecked();
        if (isCheckedStat.values().stream().anyMatch(Boolean::booleanValue)) {
            if (isCheckedCarb.values().stream().anyMatch(Boolean::booleanValue)) {
                if (isCheckedDept.values().stream().anyMatch(Boolean::booleanValue)) {
                    if (depOuReg) {
                        return true;
                    }
                } else if (isCheckedReg.values().stream().anyMatch(Boolean::booleanValue)) {
                    if (!depOuReg) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
