package fr.univrennes.istic.l2gen.station;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StationAPI {
    private List<StationParCarb> stationsParCarb;
    private List<Station2> stationsParCarb2;
    private HashSet<String> Regions;
    private HashSet<String> Departements;
    private HashSet<String> carburants;
    private HashSet<String> services;
    private HashMap<String, HashMap<String, List<Double>>> filtre; // de la forme {Carburant : Granularité : List<Prix>}
    private HashMap<String, HashMap<String, Integer>> NbStationProposeServices;
    private HashMap<String, HashMap<String, Station2>> stationMoinsChere; // pour répertorier les stations les
                                                                          // moins chère de la forme {Granularité
                                                                          // : Carburant : stationParCarb}

    public StationAPI() {
        // Créez un ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();

        /*
         * try {
         * // URL de l'API
         * URL url = new URL(
         * "https://data.economie.gouv.fr/api/explore/v2.1/catalog/datasets/prix-des-carburants-en-france-flux-instantane-v2/exports/json?lang=fr&timezone=Europe%2FParis"
         * );
         * 
         * // Ouvrir une connexion HTTP
         * HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         * 
         * // Configurer la requête
         * conn.setRequestMethod("GET");
         * 
         * // Lire la réponse
         * BufferedReader rd = new BufferedReader(new
         * InputStreamReader(conn.getInputStream()));
         * StringBuilder response = new StringBuilder();
         * String line;
         * while ((line = rd.readLine()) != null) {
         * response.append(line);
         * }
         * rd.close();
         * 
         * // Traitement de la réponse (par exemple, affichage)
         * System.out.println(response.toString());
         * 
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         */

        // Spécifiez le chemin vers votre fichier JSON
        String cheminFichier = "ressources/prix-carburants-fichier-quotidien-test-ods.json";

        // Essayez d'ouvrir et de mapper le fichier JSON en un objet Java
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL(
                    "https://data.economie.gouv.fr/api/explore/v2.1/catalog/datasets/prix-des-carburants-en-france-flux-instantane-v2/exports/json?lang=fr&timezone=Europe%2FParis");

            // Utilisez la méthode readValue() de l'ObjectMapper pour mapper le fichier JSON
            // en un objet Java.
            // stationsParCarb = objectMapper.readValue(new File(cheminFichier),
            // new TypeReference<List<StationParCarb>>() {
            // });
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            stationsParCarb2 = objectMapper.readValue(url,
                    new TypeReference<List<Station2>>() {
                    });

            Departements = new HashSet<>();
            Regions = new HashSet<>();
            services = new HashSet<>();
            filtre = new HashMap<>();
            carburants = new HashSet<>();

            for (Station2 station : stationsParCarb2) {
                // Change le String unicode en normal
                station.setRegion(decodeUnicode(station.getRegion()));
                station.setDepartement(decodeUnicode(station.getDepartement()));
                station.setAdresse(decodeUnicode(station.getAdresse()));
                station.setVille(decodeUnicode(station.getVille()));
                if (station.getPrix() != null) {
                    for (Prix prix : station.getPrix()) {
                        Double prix_carb = 0.0;
                        try {
                            prix_carb = Double.parseDouble(prix.getValeur());
                        } catch (Exception e) {
                            // le prix n'est pas un double
                        }
                        prix.setValeurDouble(prix_carb);
                    }
                } else {
                    station.setPrix(new ArrayList<>());
                }

                // Ajout des régions
                if (station.getRegion() != "") {
                    Regions.add(station.getRegion());
                }

                // Ajout des départements
                if (station.getDepartement() != "") {
                    Departements.add(station.getDepartement());
                }

                // Ajout des carburants de la station à l'enseble des carburants existant
                if (station.getCarburants_disponibles() == null) {
                    station.setCarburants_disponibles(new ArrayList<>());
                }
                station.getCarburants_disponibles().stream().forEach(carb -> {
                    if (carb != "" && carb != null) {
                        carburants.add(carb);
                    }
                });
                if (station.getCarburants_indisponibles() == null) {
                    station.setCarburants_indisponibles(new ArrayList<>());
                }
                station.getCarburants_indisponibles().stream().forEach(carb -> {
                    if (carb != "" && carb != null) {
                        carburants.add(carb);
                    }
                });

                // Ajout des services proposé
                try {
                    if (!station.getServices_service().isEmpty()) {
                        services.addAll(station.getServices_service());

                    }
                } catch (Exception e) {
                    // erreur quand station.getServices_service() est vide
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
        ArrayList<String> nomsCarburants = new ArrayList<>(carburants);
        nomsCarburants.sort(null);
        return nomsCarburants;
    }

    /**
     * Renvoie une liste de String, chaque éléments est un nom de région
     * <p>
     * (La liste est triée)
     * 
     * @return liste de String
     */
    public ArrayList<String> getNomsRegion() {
        ArrayList<String> nomsRegion = new ArrayList<>(Regions);
        nomsRegion.sort(null);
        return nomsRegion;
    }

    /**
     * Renvoie une liste de String, chaque éléments est un nom de région
     * <p>
     * (La liste est triée)
     * 
     * @return liste de String
     */
    public ArrayList<String> getNomsDepartement() {
        ArrayList<String> nomsDep = new ArrayList<>(Departements);
        nomsDep.sort(null);
        return nomsDep;
    }

    public ArrayList<String> getNomsServices() {
        services.remove("");
        services.remove(null);
        ArrayList<String> nomsServices = new ArrayList<>(services);
        nomsServices.sort(null);
        return nomsServices;
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
     * Donne une hashMap pour avoir les adresses des stations qui propose le
     * carburant le moins chère par granularité.
     * 
     * @return une HashMap de la forme {Granularité : {carburant : adresse}}
     */
    public HashMap<String, HashMap<String, Station2>> getAdresseStationMoinsChere() {
        HashMap<String, HashMap<String, Station2>> adresseStationMoinsChere = new HashMap<>();
        for (String granu : stationMoinsChere.keySet()) {
            adresseStationMoinsChere.put(granu, new HashMap<>());
            for (String carburant : stationMoinsChere.get(granu).keySet()) {
                Station2 station = stationMoinsChere.get(granu).get(carburant);
                adresseStationMoinsChere.get(granu).put(carburant, station);
            }
        }
        return adresseStationMoinsChere;
    }

    /**
     * Rend le nombre de station qui proposes des services spécifques par carburant
     * et par granularité
     * 
     * @return hashmap de la forme {Granularité : {service :
     *         nombre_de_station_qui_propose_le_serice}}
     */
    public HashMap<String, HashMap<String, Double>> getNbStationProposeServices() {
        HashMap<String, HashMap<String, Double>> nouveau = new HashMap<>();
        for (String granularite : NbStationProposeServices.keySet()) {
            nouveau.put(granularite, new HashMap<>());
            for (String service : NbStationProposeServices.get(granularite).keySet()) {
                nouveau.get(granularite).put(service,
                        Double.valueOf(NbStationProposeServices.get(granularite).get(service)));
            }
        }
        return nouveau;
    }

    /**
     * donne le nombre de station qui propose un carburant par granularité
     * 
     * @return une HashMap de type {Carburant : {Granularité : nombre}}
     */
    public HashMap<String, HashMap<String, Double>> getNbStationProposeCarb() {
        HashMap<String, HashMap<String, Double>> nbStationProposeCarb = new HashMap<>();
        for (String carb : filtre.keySet()) {
            nbStationProposeCarb.put(carb, new HashMap<>());
            for (String granularite : filtre.get(carb).keySet()) {
                nbStationProposeCarb.get(carb).put(granularite,
                        Double.valueOf(filtre.get(carb).get(granularite).size()));
            }
        }
        return nbStationProposeCarb;
    }

    /**
     * filtre les stations selon les départements et selon les carburants
     *
     * @param departement
     * @param carburants
     * @return
     */
    public void filtreDep(List<String> departement, List<String> carburants,
            List<String> services) {

        NbStationProposeServices = new HashMap<>();
        stationMoinsChere = new HashMap<>();

        filtre = new HashMap<>();
        for (Station2 station : stationsParCarb2) {
            String nomDep = station.getDepartement();

            for (Prix prix : station.getPrix()) {
                Double prix_carb = prix.getValeurDouble();
                String nomCarb = prix.getNom();
                if (prix_carb != 0.0 && nomCarb != "" && nomCarb != null && nomDep != "" && nomDep != null
                        && carburants.contains(nomCarb)
                        && departement.contains(nomDep)) {
                    if (!filtre.keySet().contains(nomCarb)) {
                        filtre.put(nomCarb, new HashMap<>());
                    }

                    if (!filtre.get(nomCarb).keySet().contains(nomDep)) {
                        filtre.get(nomCarb).put(nomDep, new ArrayList<>());
                    }
                    if (!NbStationProposeServices.containsKey(nomDep)) {
                        NbStationProposeServices.put(nomDep, new HashMap<>());
                        services.stream().forEach(x -> NbStationProposeServices.get(nomDep).put(x, 0));

                        stationMoinsChere.put(nomDep, new HashMap<>());
                    }

                    if (!stationMoinsChere.get(nomDep).containsKey(nomCarb)) {
                        stationMoinsChere.get(nomDep).put(nomCarb, station);
                    }

                    // vérifie que la station qui à été ajouté comme la moins chères pour ce
                    // carburant est bien la moins chère
                    AtomicBoolean changerValeur = new AtomicBoolean(false);
                    stationMoinsChere.get(nomDep).get(nomCarb).getPrix().stream().forEach(elt -> {
                        if (elt.getNom().equals(nomCarb)) {
                            if (elt.getValeurDouble() > prix_carb) {
                                changerValeur.set(true);
                            }
                        }
                    });
                    if (changerValeur.get()) {
                        stationMoinsChere.get(nomDep).put(nomCarb, station);
                    }

                    filtre.get(nomCarb).get(nomDep).add(prix_carb);
                    try {
                        station.getServices_service().stream().forEach(service -> {
                            if (services.contains(service)) {
                                NbStationProposeServices
                                        .get(nomDep)
                                        .put(service, NbStationProposeServices
                                                .get(nomDep)
                                                .get(service) + 1);
                            }
                        });
                    } catch (Exception e) {
                        // (erreur sur station.getServices_service() quand vide)
                    }

                }
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

        NbStationProposeServices = new HashMap<>(); // initialisation
        stationMoinsChere = new HashMap<>();

        filtre = new HashMap<>();

        for (Station2 station : stationsParCarb2) {
            String nomReg = station.getRegion();

            for (Prix prix : station.getPrix()) {
                Double prix_carb = prix.getValeurDouble();
                String nomCarb = prix.getNom();

                if (prix_carb != 0.0 && nomCarb != "" && nomCarb != null && nomReg != "" && nomReg != null
                        && carburants.contains(nomCarb)
                        && region.contains(nomReg)) {
                    if (!filtre.keySet().contains(nomCarb)) {
                        filtre.put(nomCarb, new HashMap<>());
                    }

                    if (!NbStationProposeServices.containsKey(nomReg)) {
                        NbStationProposeServices.put(nomReg, new HashMap<>());
                        services.stream().forEach(x -> NbStationProposeServices.get(nomReg).put(x, 0));

                        stationMoinsChere.put(nomReg, new HashMap<>());
                    }

                    if (!stationMoinsChere.get(nomReg).containsKey(nomCarb)) {
                        stationMoinsChere.get(nomReg).put(nomCarb, station);
                    }

                    // vérifie que la station qui à été ajouté comme la moins chères pour ce
                    // carburant est bien la moins chère
                    AtomicBoolean changerValeur = new AtomicBoolean(false);
                    stationMoinsChere.get(nomReg).get(nomCarb).getPrix().stream().forEach(elt -> {
                        if (elt.getNom().equals(nomCarb)) {
                            if (elt.getValeurDouble() > prix_carb) {
                                changerValeur.set(true);
                            }
                        }
                    });
                    if (!filtre.get(nomCarb).keySet().contains(nomReg)) {
                        filtre.get(nomCarb).put(nomReg, new ArrayList<>());
                    }
                    filtre.get(nomCarb).get(nomReg).add(prix_carb);

                    try {
                        station.getServices_service().stream().forEach(service -> {
                            if (services.contains(service)) {
                                NbStationProposeServices
                                        .get(nomReg)
                                        .put(service, NbStationProposeServices
                                                .get(nomReg)
                                                .get(service) + 1);
                            }
                        });
                    } catch (Exception e) {
                        // (erreur sur station.getServices_service() quand vide)
                    }
                }
            }
        }

    }

}
