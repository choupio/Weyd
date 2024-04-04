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
    private HashMap<String, List<Station>> stationsParReg;
    private HashMap<String, List<Station>> stationsParDep;
    private HashSet<String> services;
    private HashMap<String, List<Station>> filtre;
    private List<String> filtre_dep, filtre_reg, filtre_carb, filtre_serv;

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
                if (!station.getServices_service().isEmpty()) {
                    services.addAll(station.getServices_service());

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
     * Cette méthode permet de récupérer la liste des prix des carburants, mis en
     * paramètre,
     * sous la forme d'une Map où les clés sont les noms des régions/départements et
     * les valeurs
     * sont des Map : comme clé les noms des carburants et les valeurs sont les
     * listes des prix associé.
     * ex : {"Bretagne" : {"Gazole":[1.89,187]}}
     * 
     * 
     * @param carburants : liste des noms de carburants où l'on veut les prix
     */
    public HashMap<String, HashMap<String, List<Double>>> getPrixCarburants() {
        HashMap<String, HashMap<String, List<Double>>> carburantsParGranularite = new HashMap<>();
        if(filtre.isEmpty()){throw new IllegalStateException("le filtre est vide, appellez filtre()");}
        for (String string : filtre.keySet()) {
            carburantsParGranularite.put(string, new HashMap<>());
            carburantsParGranularite.get(string).putAll(null);
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
     * 
     * @param stationsParGranu soit stationParDep soit StatioParReg
     * @param granuList        liste des départements ou régions
     * @return soit stationParDep soit StatioParReg avec le filtre granuList
     */
    private HashMap<String, List<Station>> filtreGranu(HashMap<String, List<Station>> stationsParGranu,
            List<String> granuList) {
        HashMap<String, List<Station>> filtre = new HashMap<>();
        for (String granu : granuList) {
            filtre.put(granu, stationsParGranu.get(granu));
        }
        return filtre;
    }

    /**
     * Filtre toute les stations qui ne propose pas un des carburant dans la listes
     * entrée en paramètre
     * 
     * @param stationsParGranu soit stationParDep soit StatioParReg
     * @param carburantList    liste des carburant
     * @return
     */
    private HashMap<String, List<Station>> filtreCarb(HashMap<String, List<Station>> stationsParGranu,
            List<String> carburantList) {
        HashMap<String, List<Station>> filtre = new HashMap<>();
        for (String granu : stationsParGranu.keySet()) {
            List<Station> stationsFiltre = new ArrayList<>(stationsParGranu.get(granu)).stream().filter(x -> {
                for (String carb : carburantList) {
                    if (x.getCarburants() != null) {
                        if (x.getCarburants().stream().map(y -> y.getNom()).collect(Collectors.toList())
                                .contains(carb)) {
                            return true;
                        }
                    }

                }
                return false;
            }).collect(Collectors.toList());
            filtre.put(granu, stationsFiltre);
        }
        return filtre;
    }

    /**
     * filtre les stations selon les départements et selon les carburants
     * Pour l'instant ne filtre pas les serivces.
     * 
     * @param departement
     * @param carburants
     * @return
     */
    public HashMap<String, List<Station>> filtre(List<String> departement, List<String> carburants,
            List<String> services) {
        filtre = filtreGranu(stationsParDep, departement);
        if (filtre.isEmpty()) {
            return filtre;
        }
        filtre = filtreCarb(filtre, carburants);
        return filtre;
    }

}
