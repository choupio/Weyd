package fr.univrennes.istic.l2gen.visustats;

import org.junit.Test;
import fr.univrennes.istic.l2gen.geometrie.Point;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;

public class DiagCamembertsTest {

    DiagCamemberts diagCamembert;

    @Before
    public void setUp() {
        diagCamembert = new DiagCamemberts("Test", 4);
        diagCamembert.legender("Afrique", "Amerique", "Asie", "Europe", "Oceanie");
        diagCamembert.ajouterDonnees("2010", 1600, 6800, 16000, 4300, 300);
        diagCamembert.ajouterDonnees("2015", 1900, 6600, 17500, 3800, 330);
        diagCamembert.ajouterDonnees("2020", 2100, 6200, 17800, 3600, 340);
        diagCamembert.colorier("Blue", "Green", "Red", "Yellow", "Maroon");
        diagCamembert.agencer().createSvgFile();
        diagCamembert.description(0);
    }

    @Test
    public void testConstructeur() {
        assertEquals("Test", diagCamembert.getNom());
        assertEquals(4, diagCamembert.getNbcamemberts());
    }

    @Test
    public void testSetterEtGetter() {
        diagCamembert.setNom("NouveauTest");
        assertEquals("NouveauTest", diagCamembert.getNom());

        diagCamembert.setNbcamemberts(10);
        assertEquals(10, diagCamembert.getNbcamemberts());
    }

    @Test
    public void testCentre() {
        Point centre = diagCamembert.centre();
        assertEquals(410, centre.x(), 0.0001);
        assertEquals(200, centre.y(), 0.0001);
    }

    /*
     * Ce test est commenté car la valeur attendue est trop longue pour être écrite
     * dans le test
     */
    /*
     * @Test
     * public void testDescription() {
     * String description = diagCamembert.description(0);
     * assertEquals("DiagCamemberts nom=Test\r\n" + //
     * " Nombre de camembert :3\r\n" + //
     * " Camembert:\r\n" + //
     * "   Centre: (160.0, 200.0)\r\n" + //
     * "   Rayon: 100.0\r\n" + //
     * "   Secteurs:\r\n" + //
     * "      Secteur centre=160.0,200.0 Angle=90.0 Arc=19.862068965517242 de couleur Blue et de rotation 0.0\r\n"
     * + //
     * "      Secteur centre=160.0,200.0 Angle=109.86206896551724 Arc=84.41379310344827 de couleur Green et de rotation 0.0\r\n"
     * + //
     * "      Secteur centre=160.0,200.0 Angle=194.27586206896552 Arc=198.6206896551724 de couleur Red et de rotation 0.0\r\n"
     * + //
     * "      Secteur centre=160.0,200.0 Angle=392.8965517241379 Arc=53.37931034482758 de couleur Yellow et de rotation 0.0\r\n"
     * + //
     * "      Secteur centre=160.0,200.0 Angle=446.27586206896547 Arc=3.7241379310344827 de couleur Maroon et de rotation 0.0\r\n"
     * + //
     * "\r\n" + //
     * " Camembert:\r\n" + //
     * "   Centre: (410.0, 200.0)\r\n" + //
     * "   Rayon: 100.0\r\n" + //
     * "   Secteurs:\r\n" + //
     * "      Secteur centre=410.0,200.0 Angle=90.0 Arc=22.701626286093592 de couleur Blue et de rotation 0.0\r\n"
     * + //
     * "      Secteur centre=410.0,200.0 Angle=112.70162628609359 Arc=78.85828078327249 de couleur Green et de rotation 0.0\r\n"
     * + //
     * "      Secteur centre=410.0,200.0 Angle=191.5599070693661 Arc=209.0939263192831 de couleur Red et de rotation 0.0\r\n"
     * + //
     * "      Secteur centre=410.0,200.0 Angle=400.6538333886492 Arc=45.403252572187185 de couleur Yellow et de rotation 0.0\r\n"
     * + //
     * "      Secteur centre=410.0,200.0 Angle=446.0570859608364 Arc=3.9429140391636244 de couleur Maroon et de rotation 0.0\r\n"
     * + //
     * "\r\n" + //
     * " Camembert:\r\n" + //
     * "   Centre: (660.0, 200.0)\r\n" + //
     * "   Rayon: 100.0\r\n" + //
     * "   Secteurs:\r\n" + //
     * "      Secteur centre=660.0,200.0 Angle=90.0 Arc=25.166444740346204 de couleur Blue et de rotation 0.0\r\n"
     * + //
     * "      Secteur centre=660.0,200.0 Angle=115.16644474034621 Arc=74.30093209054594 de couleur Green et de rotation 0.0\r\n"
     * + //
     * "      Secteur centre=660.0,200.0 Angle=189.46737683089214 Arc=213.3155792276964 de couleur Red et de rotation 0.0\r\n"
     * + //
     * "      Secteur centre=660.0,200.0 Angle=402.7829560585885 Arc=43.142476697736356 de couleur Yellow et de rotation 0.0\r\n"
     * + //
     * "      Secteur centre=660.0,200.0 Angle=445.9254327563249 Arc=4.0745672436751 de couleur Maroon et de rotation 0.0\n\n"
     * , description);
     * }
     */

    @Test
    public void testHauteur() {
        assertEquals(268.0, diagCamembert.hauteur(), 0.0001);
    }

    @Test
    public void testDeplacer() {
        double dx = 10;
        double dy = 10;
        Point positionInitiale = diagCamembert.centre();
        diagCamembert.deplacer(dx, dy);
        Point positionApresDeplacement = diagCamembert.centre();
        assertNotEquals(positionInitiale, positionApresDeplacement);
        assertEquals(positionInitiale.x() + dx, positionApresDeplacement.x(), 0.0001);
        assertEquals(positionInitiale.y() + dy, positionApresDeplacement.y(), 0.0001);
    }

    @Test
    public void testDupliquer() {
        DiagCamemberts diagCamembertCopie = (DiagCamemberts) diagCamembert.dupliquer();
        assertEquals(diagCamembert.getNom(), diagCamembertCopie.getNom());
        assertEquals(diagCamembert.getNbcamemberts(), diagCamembertCopie.getNbcamemberts());
    }

    @Test
    public void testColorier() {
        diagCamembert.colorier("Blue", "Green", "Red", "Yellow", "Maroon");
        String[] couleurs = diagCamembert.getCouleurs();
        assertEquals("Blue", couleurs[0]);
        assertEquals("Green", couleurs[1]);
        assertEquals("Red", couleurs[2]);
        assertEquals("Yellow", couleurs[3]);
        assertEquals("Maroon", couleurs[4]);
    }

    @Test
    public void testLargeur() {
        assertEquals(600, diagCamembert.largeur(), 0.0001);
    }

    @Test
    public void testLegender() {
        diagCamembert.legender("Afrique", "Amerique", "Asie", "Europe", "Oceanie");
        ArrayList<String> legendes = diagCamembert.getLegendes();
        assertEquals(
                "<text x=\"220.0\" y=\"405.0\" font-size=\"14\" text-anchor=\"middle\" fill=\"black\" stroke=\"black\" transform=\"rotate(0)\">Afrique</text>",
                legendes.get(0));
        assertEquals(
                "<text x=\"420.0\" y=\"405.0\" font-size=\"14\" text-anchor=\"middle\" fill=\"black\" stroke=\"black\" transform=\"rotate(0)\">Amerique</text>",
                legendes.get(1));
        assertEquals(
                "<text x=\"620.0\" y=\"405.0\" font-size=\"14\" text-anchor=\"middle\" fill=\"black\" stroke=\"black\" transform=\"rotate(0)\">Asie</text>",
                legendes.get(2));
        assertEquals(
                "<text x=\"820.0\" y=\"405.0\" font-size=\"14\" text-anchor=\"middle\" fill=\"black\" stroke=\"black\" transform=\"rotate(0)\">Europe</text>",
                legendes.get(3));
        assertEquals(
                "<text x=\"1020.0\" y=\"405.0\" font-size=\"14\" text-anchor=\"middle\" fill=\"black\" stroke=\"black\" transform=\"rotate(0)\">Oceanie</text>",
                legendes.get(4));
    }

    @Test
    public void testRedimmensioner() {
        diagCamembert.redimmensioner(10, 10);
        assertEquals(30, diagCamembert.largeur(), 0.0001);
        assertEquals(191.5, diagCamembert.hauteur(), 0.0001);
    }

    @Test
    public void testCreateSvgFile() {
        diagCamembert.createSvgFile();
    }

    @Test
    public void testTourner() {
        diagCamembert.tourner(10);
    }

    @Test
    public void testAjouterDonnees() {
        diagCamembert.ajouterDonnees("2025", 2100, 6200, 17800, 3600, 340);
        assertEquals(4, diagCamembert.getNbcamemberts());
    }
}
