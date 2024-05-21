package fr.univrennes.istic.l2gen.station;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rupture {
    @JsonProperty("@nom")
    private String nom;

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@debut")
    private String debut;

    @JsonProperty("@fin")
    private String fin;

    @JsonProperty("@type")
    private String type;
}
