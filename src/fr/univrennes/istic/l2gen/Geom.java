package fr.univrennes.istic.l2gen;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geom {
    private double lon;
    private double lat;

    @JsonProperty("lon")
    public double getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(double lon) {
        this.lon = lon;
    }

    @JsonProperty("lat")
    public double getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Geometrie{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
