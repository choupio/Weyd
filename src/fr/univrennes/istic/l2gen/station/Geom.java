package fr.univrennes.istic.l2gen.station;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Cette classe représente les coordonnées géographiques d'une station.
 */
public class Geom {
    /**
     * Longitude de la station.
     */
    private double lon;

    /**
     * Latitude de la station.
     */
    private double lat;

    /**
     * Obtient la longitude de la station.
     * @return La longitude.
     */
    @JsonProperty("lon")
    public double getLon() {
        return lon;
    }

    /**
     * Définit la longitude de la station.
     * @param lon La longitude.
     */
    @JsonProperty("lon")
    public void setLon(double lon) {
        this.lon = lon;
    }

    /**
     * Obtient la latitude de la station.
     * @return La latitude.
     */
    @JsonProperty("lat")
    public double getLat() {
        return lat;
    }

    /**
     * Définit la latitude de la station.
     * @param lat La latitude.
     */
    @JsonProperty("lat")
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères des coordonnées géographiques.
     * @return Une chaîne de caractères représentant les coordonnées géographiques.
     */
    @Override
    public String toString() {
        return "Geometrie{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}