package fr.univrennes.istic.l2gen.station;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testgetCom_arm_name() {
        SetUp();
        stationParCarb.setCom_arm_name("comArmName");
        assertEquals("comArmName", stationParCarb.getCom_arm_name());
    }

    @Test
    public void testGetEpci_code() {
        SetUp();
        stationParCarb.setEpci_code("epciCode");
        assertEquals("epciCode", stationParCarb.getEpci_code());
    }

    @Test
    public void testGetEpci_name() {
        SetUp();
        stationParCarb.setEpci_name("epciName");
        assertEquals("epciName", stationParCarb.getEpci_name());
    }

    @Test
    public void testGetDep_code() {
        SetUp();
        stationParCarb.setDep_code("depCode");
        assertEquals("depCode", stationParCarb.getDep_code());
    }

    @Test
    public void testGetDep_name() {
        SetUp();
        stationParCarb.setDep_name("depName");
        assertEquals("depName", stationParCarb.getDep_name());
    }

    @Test
    public void testGetReg_code() {
        SetUp();
        stationParCarb.setReg_code("regCode");
        assertEquals("regCode", stationParCarb.getReg_code());
    }

    @Test
    public void testGetReg_name() {
        SetUp();
        stationParCarb.setReg_name("regName");
        assertEquals("regName", stationParCarb.getReg_name());
    }

    @Test
    public void testGetRupture_nom() {
        SetUp();
        stationParCarb.setRupture_nom("ruptureNom");
        assertEquals("ruptureNom", stationParCarb.getRupture_nom());
    }

    @Test
    public void testGetRupture_debut() {
        SetUp();
        stationParCarb.setRupture_debut("ruptureDebut");
        assertEquals("ruptureDebut", stationParCarb.getRupture_debut());
    }

    @Test
    public void testGetRupture_fin() {
        SetUp();
        stationParCarb.setRupture_fin("ruptureFin");
        assertEquals("ruptureFin", stationParCarb.getRupture_fin());
    }

    @Test
    public void testgetHoraires_automate_24_24() {
        SetUp();
        stationParCarb.setHoraires_automate_24_24("horairesAutomate24_24");
        assertEquals("horairesAutomate24_24", stationParCarb.getHoraires_automate_24_24());
    }

    @Test
    public void testGetPrix_valeur() {
        SetUp();
        stationParCarb.setPrix_valeur(1.5);
        assertEquals(1.5, stationParCarb.getPrix_valeur(), 0.0001);
    }

    @Test
    public void testGetServices_service() {
        SetUp();
        List<String> services = new ArrayList<>();
        services.add("service1");
        services.add("service2");
        services.add("service3");
        stationParCarb.setServices_service(services);
        assertEquals(3, stationParCarb.getServices_service().size());
        assertEquals("service1", stationParCarb.getServices_service().get(0));
        assertEquals("service2", stationParCarb.getServices_service().get(1));
        assertEquals("service3", stationParCarb.getServices_service().get(2));
    }


}
