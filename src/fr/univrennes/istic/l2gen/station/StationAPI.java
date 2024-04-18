package fr.univrennes.istic.l2gen.station;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StationAPI {
    private HashMap<String, Station> stationsMap;
    private List<StationParCarb> stationsParCarb;
    private HashMap<String, List<Station>> stationsParReg;
    private HashMap<String, List<Station>> stationsParDep;
    private HashSet<String> services;
    private HashMap<String, HashMap<String, List<Double>>> filtre; /*
                                                                    * de la forme {Carburant : Granularité : List<Prix>}
                                                                    */
    private List<String> filtre_carb, filtre_serv;

    public StationAPI() {
        // Créez un ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        // Spécifiez le chemin vers votre fichier JSON
        String cheminFichier = "ressources/prix-carburants-fichier-quotidien-test-ods.json";

        // Essayez d'ouvrir et de mapper le fichier JSON en un objet Java
        try {
            // Utilisez la méthode readValue() de l'ObjectMapper pour mapper le fichier JSON
            // en un objet Java.
            stationsParCarb = objectMapper.readValue(new File(cheminFichier),
                    new TypeReference<List<StationParCarb>>() {
                    });

            stationsMap = new HashMap<>();
            stationsParDep = new HashMap<>();
            stationsParReg = new HashMap<>();
            services = new HashSet<>();
            filtre = new HashMap<>();
            filtre_carb = new ArrayList<>();

            for (StationParCarb station : stationsParCarb) {
                // Change le String unicode en normal
                station.setReg_name(decodeUnicode(station.getReg_name()));
                station.setDep_name(decodeUnicode(station.getDep_name()));

                if (!stationsMap.containsKey(station.getId())) {
                    stationsMap.put(station.getId(),
                            new Station(station.getServices_service(), station.getDep_name(), station.getVille(),
                                    station.getAdresse(),
                                    station.getReg_name(), station.getDep_code(), station.getReg_code()));
                }
                // Ajout des stations par région
                if (station.getReg_name() != "") {
                    if (!stationsParReg.containsKey(station.getReg_name())) {
                        stationsParReg.put(station.getReg_name(), new ArrayList<>());
                    }
                    stationsParReg.get(station.getReg_name()).add(stationsMap.get(station.getId()));
                }

                // Ajout des stations par département
                if (station.getDep_name() != "") {
                    if (!stationsParDep.containsKey(station.getDep_name())) {
                        stationsParDep.put(station.getDep_name(), new ArrayList<>());
                    }
                    stationsParDep.get(station.getDep_name()).add(stationsMap.get(station.getId()));
                }

                // Ajout des carburants de la station
                if (station.getPrix_nom() != "" || station.getPrix_nom() != null) {
                    stationsMap.get(station.getId()).ajoutCarburant(station.getPrix_nom(), station.getPrix_valeur());
                }

                // Ajout des services proposé
                try {
                    if (!station.getServices_service().isEmpty()) {
                        services.addAll(station.getServices_service());

                    }
                } catch (Exception e) {
                    // TODO modifer ça
                }

            }
        } catch (IOException e) {
            // Gérez les erreurs d'entrée/sortie ici
            e.printStackTrace();
        }

    }

    /**
     * Cette fonction permet de décodé les texte en unicode
     * 
     * @param texteEncodé
     * @return
     */
    private String decodeUnicode(String texteEncodé) {
        if (texteEncodé == null) {
            return ""; // ou toute autre valeur par défaut que vous voulez retourner
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < texteEncodé.length()) {
            if (texteEncodé.charAt(i) == '\\' && i + 1 < texteEncodé.length() && texteEncodé.charAt(i + 1) == 'u') {
                String codeHex = texteEncodé.substring(i + 2, i + 6);
                int codeDecimal = Integer.parseInt(codeHex, 16);
                builder.append((char) codeDecimal);
                i += 6;
            } else {
                builder.append(texteEncodé.charAt(i));
                i++;
            }
        }
        return builder.toString();
    }

    /**
     * Cette méthode permet de récupérer la liste des prix des carburants
     * sous la forme d'une Map où les clés sont les noms des régions/départements et
     * les valeurs
     * sont des Map : comme clé les noms des carburants et les valeurs sont les
     * listes des prix associé.
     * ex : {"Gazole" : {"Bretagne":[1.89,187]}}
     * 
     * 
     * @param carburants : liste des noms de carburants où l'on veut les prix
     */
    public HashMap<String, HashMap<String, List<Double>>> getPrixCarburants() {
        return filtre;
    }

    /**
     * Renvoie une liste de String, chaque élément est un nom de carburants
     * 
     * @return liste de String
     */
    public ArrayList<String> getNomsCarburants() {
        HashSet<String> nomsCarburant = new HashSet<>();
        for (StationParCarb station : stationsParCarb) {
            nomsCarburant.add(station.getPrix_nom());
        }
        nomsCarburant.remove(null);
        return new ArrayList<>(nomsCarburant);
    }

    /**
     * Renvoie une liste de String, chaque éléments est un nom de région
     * 
     * @return liste de String
     */
    public ArrayList<String> getNomsRegion() {
        return new ArrayList<>(stationsParReg.keySet());
    }

    /**
     * Renvoie une liste de String, chaque éléments est un nom de région
     * 
     * @return liste de String
     */
    public ArrayList<String> getNomsDepartement() {
        return new ArrayList<>(stationsParDep.keySet());
    }

    public ArrayList<String> getNomsServices() {
        services.remove("");
        services.remove(null);
        return new ArrayList<>(services);
    }

    /**
     * Rend les prix moyen par granularité et par carburant
     * 
     * @return une HashMap de la forme {carburant : {Granularité : prix_moyen}}
     */
    public HashMap<String, HashMap<String, Double>> getPrixMoyen() {
        HashMap<String, HashMap<String, Double>> prixMoyenParCarbParGranu = new HashMap<>();
        for (String carb : filtre.keySet()) {
            prixMoyenParCarbParGranu.put(carb, new HashMap<>());
            for (String granu : filtre.get(carb).keySet()) {
                prixMoyenParCarbParGranu.get(carb).put(granu,
                        filtre.get(carb).get(granu).stream().mapToDouble(Double::doubleValue).average().orElse(0.0));
            }
        }

        return prixMoyenParCarbParGranu;
    }

    /**
     * Rend les prix médian par granularité et par carburant
     * 
     * @return une HashMap de la forme {carburant : {Granularité : prix_médian}}
     */
    public HashMap<String, HashMap<String, Double>> getPrixMedian() {

        HashMap<String, HashMap<String, Double>> prixMedianParCarbParGranu = new HashMap<>();
        for (String carb : filtre.keySet()) {
            prixMedianParCarbParGranu.put(carb, new HashMap<>());
            for (String granu : filtre.get(carb).keySet()) {
                List<Double> prixList = filtre.get(carb).get(granu);
                int taille = prixList.size();
                Double prixMedian;
                Collections.sort(prixList);
                if (taille % 2 != 0) {
                    prixMedian = prixList.get(taille / 2);
                } else {
                    // Si la taille de la liste est paire, calculer la moyenne des deux valeurs au
                    // milieu
                    double valeur1 = prixList.get((taille - 1) / 2);
                    double valeur2 = prixList.get(taille / 2);
                    prixMedian = (valeur1 + valeur2) / 2.0;
                }
                prixMedianParCarbParGranu.get(carb).put(granu, prixMedian);
            }
        }
        return prixMedianParCarbParGranu;
    }

    /**
     * Rend les prix minimums par carburant et par granularité
     * 
     * @return une HashMap de la forme {carburant : {Granularité : prix_minimum}}
     */
    public HashMap<String, HashMap<String, Double>> getPrixMin() {
        HashMap<String, HashMap<String, Double>> prixMinParCarbParGranu = new HashMap<>();

        for (String carb : filtre.keySet()) {
            prixMinParCarbParGranu.put(carb, new HashMap<>());
            for (String granu : filtre.get(carb).keySet()) {
                prixMinParCarbParGranu.get(carb).put(granu,
                        filtre.get(carb).get(granu).stream().mapToDouble(Double::doubleValue).min().orElse(0.0));
            }
        }
        return prixMinParCarbParGranu;
    }

    /**
     * filtre les stations selon les départements et selon les carburants
     * Pour l'instant ne filtre pas les serivces.
     * 
     * @param departement
     * @param carburants
     * @return
     */
    public void filtreDep(List<String> departement, List<String> carburants,
            List<String> services) {
        filtre_carb = carburants;
        filtre_serv = services;

        filtre = new HashMap<>();
        for (StationParCarb station : stationsParCarb) {
            String nomCarb = station.getPrix_nom();
            String nomDep = station.getDep_name();
            if (nomCarb != "" && nomCarb != null && nomDep != "" && nomDep != null && carburants.contains(nomCarb)
                    && departement.contains(nomDep) && services.stream()
                            .map(x -> station.getServices_service().contains(x)).allMatch(Boolean::booleanValue)) {
                if (!filtre.keySet().contains(nomCarb)) {
                    filtre.put(nomCarb, new HashMap<>());
                }

                if (!filtre.get(nomCarb).keySet().contains(nomDep)) {
                    filtre.get(nomCarb).put(nomDep, new ArrayList<>());
                }
                filtre.get(nomCarb).get(nomDep).add(station.getPrix_valeur());
            }
        }

    }

    /**
     * filtre les stations selon les régions et selon les carburants
     * Pour l'instant ne filtre pas les serivces.
     * 
     * @param departement
     * @param carburants
     * @return
     */
    public void filtreReg(List<String> region, List<String> carburants,
            List<String> services) {
        filtre_carb = carburants;
        filtre_serv = services;

        filtre = new HashMap<>();
        for (StationParCarb station : stationsParCarb) {
            String nomCarb = station.getPrix_nom();
            String nomReg = station.getReg_name();
            if (nomCarb != "" && nomCarb != null && nomReg != "" && nomReg != null && carburants.contains(nomCarb)
                    && region.contains(nomReg) && services.stream().map(x -> station.getServices_service().contains(x))
                            .allMatch(Boolean::booleanValue)) {
                if (!filtre.keySet().contains(nomCarb)) {
                    filtre.put(nomCarb, new HashMap<>());
                }

                if (!filtre.get(nomCarb).keySet().contains(nomReg)) {
                    filtre.get(nomCarb).put(nomReg, new ArrayList<>());
                }
                filtre.get(nomCarb).get(nomReg).add(station.getPrix_valeur());
            }
        }

    }

}
