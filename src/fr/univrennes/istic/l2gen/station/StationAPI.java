package fr.univrennes.istic.l2gen.station;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StationAPI {
    private HashMap<String, Station> stationsMap;
    private List<StationParCarb> stationsParCarb;

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
            for (StationParCarb station : stationsParCarb) {
                if (!stationsMap.containsKey(station.getId())) {
                    stationsMap.put(station.getId(),
                            new Station(station.getServices_service(), station.getDep_name(), station.getVille(),
                                    station.getAdresse(),
                                    station.getReg_name(), station.getDep_code(), station.getReg_code()));
                }

                stationsMap.get(station.getId()).ajoutCarburant(station.getPrix_nom(), station.getPrix_valeur());
            }

        } catch (IOException e) {
            // Gérez les erreurs d'entrée/sortie ici
            e.printStackTrace();
        }
    }

    /**
     * Cette méthode permet de récupérer la liste des prix des carburants, mis en
     * paramètre,
     * sous la forme d'une Map ou les clés sont les noms des carburants et les
     * valeurs sont les listes des prix associé.
     * <p>
     * exemple pour faire une moyenne :
     * this.getPrixCarburants("Gazole").get("Gazole").stream().mapToDouble(Double::doubleValue)
     * .average()
     * <p>
     * 
     * @param carburants : liste des noms de carburants où l'on veut les prix
     */
    public HashMap<String, HashMap<String, List<Double>>> getPrixCarburants(List<String> carburants,
            List<String> granularite) {
        HashMap<String, HashMap<String, List<Double>>> carburantsParGranularite = new HashMap<>();
        // ajout de toute les granularité demandé dans la Map
        granularite.stream().forEach(x -> carburantsParGranularite.put(x, new HashMap<>()));
        // Initialisation des listes
        for (String granu : carburantsParGranularite.keySet()) {
            carburants.stream().forEach(x -> carburantsParGranularite.get(granu).put(x, new ArrayList<>()));
        }

        for (StationParCarb station : stationsParCarb) {
            if (granularite.contains(station.getDep_name())) {
                HashMap<String, List<Double>> granu = carburantsParGranularite.get(station.getDep_name());
                if (carburants.contains(station.getPrix_nom())) {
                    granu.get(station.getPrix_nom()).add(station.getPrix_valeur());
                }
            }
            if (granularite.contains(station.getReg_name())) {
                HashMap<String, List<Double>> granu = carburantsParGranularite.get(station.getReg_name());
                if (carburants.contains(station.getPrix_nom())) {
                    granu.get(station.getPrix_nom()).add(station.getPrix_valeur());
                }
            }
        }

        return carburantsParGranularite;
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
        return new ArrayList<>(nomsCarburant);
    }

    /**
     * Renvoie une liste de String, chaque éléments est un nom de région
     * 
     * @return liste de String
     */
    public ArrayList<String> getNomsRegion() {
        HashSet<String> nomsRegion = new HashSet<>();
        for (StationParCarb station : stationsParCarb) {
            nomsRegion.add(station.getReg_name());
        }
        return new ArrayList<>(nomsRegion);
    }

    /**
     * Renvoie une liste de String, chaque éléments est un nom de région
     * 
     * @return liste de String
     */
    public ArrayList<String> getNomsDepartement() {
        HashSet<String> nomsDepartement = new HashSet<>();
        for (StationParCarb station : stationsParCarb) {
            nomsDepartement.add(station.getDep_name());
        }
        return new ArrayList<>(nomsDepartement);
    }

}
