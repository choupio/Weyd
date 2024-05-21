package fr.univrennes.istic.l2gen.station;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Services {

    @JsonProperty("service")
    private List<String> serviceList;

    // Getters et setters
    public List<String> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<String> serviceList) {
        this.serviceList = serviceList;
    }
}
