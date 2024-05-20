package fr.univrennes.istic.l2gen.station;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StationParCarbTest {
    StationParCarb stationParCarb;

    @Before
    public void SetUp() {
        stationParCarb = new StationParCarb();
    }

    @Test
    public void testGetId() {
        SetUp();
        stationParCarb.setId("id");
        assertEquals("id", stationParCarb.getId());
    }

    @Test
    public void testGetCp() {
        SetUp();
        stationParCarb.setCp("cp");
        assertEquals("cp", stationParCarb.getCp());
    }

    @Test
    public void testGetPop() {
        SetUp();
        stationParCarb.setPop("pop");
        assertEquals("pop", stationParCarb.getPop());
    }

    @Test
    public void testGetAdresse() {
        SetUp();
        stationParCarb.setAdresse("adresse");
        assertEquals("adresse", stationParCarb.getAdresse());
    }

    @Test
    public void testGetVille() {
        SetUp();
        stationParCarb.setVille("ville");
        assertEquals("ville", stationParCarb.getVille());
    }

    @Test
    public void testGetHoraires() {
        SetUp();
        stationParCarb.setHoraires("horaires");
        assertEquals("horaires", stationParCarb.getHoraires());
    }

    @Test
    public void testGetRupture() {
        SetUp();
        stationParCarb.setRupture("rupture");
        assertEquals("rupture", stationParCarb.getRupture());
    }

    @Test
    public void testGetFermeture() {
        SetUp();
        stationParCarb.setFermeture("fermeture");
        assertEquals("fermeture", stationParCarb.getFermeture());
    }

    @Test
    public void testGetPrix_maj() {
        SetUp();
        stationParCarb.setPrix_maj("prixMaj");
        assertEquals("prixMaj", stationParCarb.getPrix_maj());
    }

    @Test
    public void testGetPrix_id() {
        SetUp();
        stationParCarb.setPrix_id("prixId");
        assertEquals("prixId", stationParCarb.getPrix_id());
    }

    @Test
    public void testGetPrix_nom() {
        SetUp();
        stationParCarb.setPrix_nom("prixNom");
        assertEquals("prixNom", stationParCarb.getPrix_nom());
    }

    @Test
    public void testgetCom_arm_code() {
        SetUp();
        stationParCarb.setCom_arm_code("comArmCode");
        assertEquals("comArmCode", stationParCarb.getCom_arm_code());
    }
}
