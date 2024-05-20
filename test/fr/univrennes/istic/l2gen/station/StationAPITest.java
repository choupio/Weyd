package fr.univrennes.istic.l2gen.station;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

public class StationAPITest {
    StationAPI stationAPI;

    @Before
    public void SetUp() {
        stationAPI = new StationAPI();
    }

    @Test
    public void testGetPrixCarburants() {
        SetUp();
        assertEquals(0, stationAPI.getPrixCarburants().size());
    }

    @Test
    public void testGetNomsCarburants() {
        SetUp();
        assertEquals(6, stationAPI.getNomsCarburants().size());
    }

    @Test
    public void testGetNomsRegion() {
        SetUp();
        assertEquals(13, stationAPI.getNomsRegion().size());
    }

    @Test
    public void testGetNomsDepartement() {
        SetUp();
        assertEquals(96, stationAPI.getNomsDepartement().size());
    }

    @Test
    public void testGetNomsServices() {
        SetUp();
        assertEquals(27, stationAPI.getNomsServices().size());
    }  
}
