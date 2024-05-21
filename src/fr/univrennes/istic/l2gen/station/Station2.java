package fr.univrennes.istic.l2gen.station;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Représente une station avec ses informations détaillées.
 */
public class Station2 {

    public Station2() {
        services_service = new ArrayList<>();
        geom = new Geom();
        rupture = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Station2 [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", cp=" + cp + ", pop="
                + pop + ", adresse=" + adresse + ", ville=" + ville + ", prix=" + prix + ", geom=" + geom
                + ", gazole_maj=" + gazole_maj + ", gazole_prix=" + gazole_prix + ", sp95_maj=" + sp95_maj
                + ", sp95_prix=" + sp95_prix + ", sp98_maj=" + sp98_maj + ", sp98_prix=" + sp98_prix
                + ", carburants_disponibles=" + carburants_disponibles + ", carburants_indisponibles="
                + carburants_indisponibles + ", horaires_automate_24_24=" + horaires_automate_24_24 + ", departement="
                + departement + ", code_departement=" + code_departement + ", region=" + region + ", code_region="
                + code_region + "]";
    }

    /**
     * les services de la station
     */
    private List<String> services_service;

    /**
     * Les services offerts par la station.
     */
    private Services services;

    /**
     * Les horaires de la station.
     */
    private String horaires;

    /**
     * L'identifiant unique de la station.
     */
    private int id;

    /**
     * La latitude de la station.
     */
    private String latitude;

    /**
     * La longitude de la station.
     */
    private String longitude;

    /**
     * Le code postal de la station.
     */
    private String cp;

    /**
     * La population de la station.
     */
    private String pop;

    /**
     * L'adresse de la station.
     */
    private String adresse;

    /**
     * La ville où se trouve la station.
     */
    private String ville;

    /**
     * La liste des prix des carburants à la station.
     */
    @JsonDeserialize(using = PrixListDeserializer.class)
    private List<Prix> prix;

    /**
     * Les coordonnées géographiques de la station.
     */
    private Geom geom;

    /**
     * Date de mise à jour du prix du gazole.
     */
    private String gazole_maj;

    /**
     * Prix du gazole.
     */
    private double gazole_prix;

    /**
     * Date de mise à jour du prix du SP95.
     */
    private String sp95_maj;

    /**
     * Prix du SP95.
     */
    private double sp95_prix;

    /**
     * Date de mise à jour du prix du SP98.
     */
    private String sp98_maj;

    /**
     * Prix du SP98.
     */
    private double sp98_prix;

    /**
     * Liste des carburants disponibles.
     */
    private List<String> carburants_disponibles;

    /**
     * Liste des carburants indisponibles.
     */
    private List<String> carburants_indisponibles;

    /**
     * Indique si l'automate 24/24 est disponible.
     */
    private String horaires_automate_24_24;

    /**
     * Le département où se trouve la station.
     */
    private String departement;

    /**
     * Le code du département où se trouve la station.
     */
    private String code_departement;

    /**
     * La région où se trouve la station.
     */
    private String region;

    /**
     * Le code de la région où se trouve la station.
     */
    private String code_region;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<Prix> getPrix() {
        return prix;
    }

    public void setPrix(List<Prix> prix) {
        this.prix = prix;
    }

    public Geom getGeom() {
        return geom;
    }

    public void setGeom(Geom geom) {
        this.geom = geom;
    }

    public String getGazole_maj() {
        return gazole_maj;
    }

    public void setGazole_maj(String gazole_maj) {
        this.gazole_maj = gazole_maj;
    }

    public double getGazole_prix() {
        return gazole_prix;
    }

    public void setGazole_prix(double gazole_prix) {
        this.gazole_prix = gazole_prix;
    }

    public String getSp95_maj() {
        return sp95_maj;
    }

    public void setSp95_maj(String sp95_maj) {
        this.sp95_maj = sp95_maj;
    }

    public double getSp95_prix() {
        return sp95_prix;
    }

    public void setSp95_prix(double sp95_prix) {
        this.sp95_prix = sp95_prix;
    }

    public String getSp98_maj() {
        return sp98_maj;
    }

    public void setSp98_maj(String sp98_maj) {
        this.sp98_maj = sp98_maj;
    }

    public double getSp98_prix() {
        return sp98_prix;
    }

    public void setSp98_prix(double sp98_prix) {
        this.sp98_prix = sp98_prix;
    }

    public List<String> getCarburants_disponibles() {
        return carburants_disponibles;
    }

    public void setCarburants_disponibles(List<String> carburants_disponibles) {
        this.carburants_disponibles = carburants_disponibles;
    }

    public List<String> getCarburants_indisponibles() {
        return carburants_indisponibles;
    }

    public void setCarburants_indisponibles(List<String> carburants_indisponibles) {
        this.carburants_indisponibles = carburants_indisponibles;
    }

    public String getHoraires_automate_24_24() {
        return horaires_automate_24_24;
    }

    public void setHoraires_automate_24_24(String horaires_automate_24_24) {
        this.horaires_automate_24_24 = horaires_automate_24_24;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getCode_departement() {
        return code_departement;
    }

    public void setCode_departement(String code_departement) {
        this.code_departement = code_departement;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCode_region() {
        return code_region;
    }

    public void setCode_region(String code_region) {
        this.code_region = code_region;
    }

    public String getHoraires() {
        return horaires;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    public List<String> getServices_service() {
        return services_service;
    }

    public void setServices_service(List<String> services_service) {
        this.services_service = services_service;
    }

    public Services getServices() {
        return services;
    }

    @JsonProperty("services")
    public void setServices(String servicesJson) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Désérialiser la chaîne JSON dans l'objet Services
            this.services = mapper.readValue(servicesJson, Services.class);
        } catch (Exception e) {
            // Gérer l'exception si nécessaire
            this.services = null;
        }
    }

    @JsonDeserialize(using = RuptureListDeserializer.class)
    private List<Rupture> rupture;

    // Getters et setters
    public List<Rupture> getRupture() {
        return rupture;
    }

    public void setRupture(List<Rupture> rupture) {
        this.rupture = rupture;
    }
}
