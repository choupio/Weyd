package fr.univrennes.istic.l2gen.station;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StationTest {
    Station station;

    @Before
    public void SetUp() {
        List<String> services_service = new ArrayList<>();
        services_service.add("service1");
        services_service.add("service2");
        services_service.add("service3");
        station = new Station(services_service, "nom_dep", "nom_ville", "adresse", "nom_reg", "code_dep", "code_reg");
    }

    @Test
    public void testAjoutCarburant() {
        SetUp();
        station.ajoutCarburant("Gazole", 1.5);
        assertEquals(1, station.getCarburants().size());
        assertEquals("Gazole", station.getCarburants().get(0).getNom());
        assertEquals(1.5, station.getCarburants().get(0).getPrix(), 0.0001);
    }

    @Test
    public void testGetCarburant() {
        SetUp();
        assertEquals(0, station.getCarburants().size());
    }

    @Test
    public void testGetServices() {
        SetUp();
        assertEquals(3, station.getServices_service().size());
        assertEquals("service1", station.getServices_service().get(0));
        assertEquals("service2", station.getServices_service().get(1));
        assertEquals("service3", station.getServices_service().get(2));
    }

    @Test
    public void testGetNomDep() {
        SetUp();
        assertEquals("nom_dep", station.getNom_dep());
    }

    @Test
    public void testGetNomVille() {
        SetUp();
        assertEquals("nom_ville", station.getNom_ville());
    }

    @Test
    public void testGetAdresse() {
        SetUp();
        assertEquals("adresse", station.getAdresse());
    }

    @Test
    public void testGetNomReg() {
        SetUp();
        assertEquals("nom_reg", station.getNom_reg());
    }

    @Test
    public void testGetCodeDep() {
        SetUp();
        assertEquals("code_dep", station.getCode_dep());
    }

    @Test
    public void testGetCodeReg() {
        SetUp();
        assertEquals("code_reg", station.getCode_reg());
    }

}
