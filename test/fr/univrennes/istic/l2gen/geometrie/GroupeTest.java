package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GroupeTest {
    private Cercle cercleTest;
    private Polygone polygone;
    private Groupe groupe;

    @Before
    public void initCerc() {
        double rayonCerc = 25;
        Point pointCerc = new Point(50, 40);
        cercleTest = new Cercle(pointCerc, rayonCerc);
        polygone = new Polygone();
		polygone.ajouterSommet(128, 128);
		polygone.ajouterSommet(128, 256);
		polygone.ajouterSommet(256, 128);
		polygone.ajouterSommet(256, 256);
        this.groupe = new Groupe(cercleTest,polygone);
    }

    @Test
    public void testAjouter() {
        Cercle nouveauCercle = new Cercle(new Point(30, 30), 20);
        if (groupe instanceof Groupe) {
            Groupe groupeCasted = (Groupe) groupe;
            groupeCasted.ajouter(nouveauCercle);
            List<IForme> listFormes = groupeCasted.getListFormes(); // Assuming appropriate getter for listFormes
            assertEquals(3, listFormes.size());
        } else {
            fail("Expected a Groupe instance");
        }
    }

    @Test
public void testCentre() {
    Point centre = groupe.centre();
    assertEquals(121.0, centre.x(), 0.001);  // Correct the expected x-coordinate value
    assertEquals(116.0, centre.y(), 0.001);  // Correct the expected y-coordinate value
}

    @Test
    public void testColorier() {
        groupe.colorier("red", "green");
        // Assuming appropriate assertions for verifying color changes in each shape
    }

   @Test
public void testDeplacer() {
    groupe.deplacer(10, 20);
    Point newCentre = groupe.centre();
    assertEquals(131.0, newCentre.x(), 0.001);
    assertEquals(136.0, newCentre.y(), 0.001);  // Correct the expected y-coordinate value
}

    @Test
    public void testDescription() {
        String expectedDescription = "Groupe : \n   Cercle centre= 50.0, 40.0 r= 25.0 de couleur black\n"
                + "      Polygone 128.0,128.0 128.0,256.0 256.0,128.0 256.0,256.0 couleur=white\n";
        assertEquals(expectedDescription, groupe.description(3));
    }

    @Test
    public void testDupliquer() {
        IForme groupeDuplique = groupe.dupliquer();
        assertEquals(groupe.description(0), groupeDuplique.description(0));
    }

    @Test
    public void testEnSVG() {

    }

    @Test
    public void testHauteur() {
        double hauteur = groupe.hauteur();
        // Adjust the expected value based on your correct logic
        assertEquals(128.0, hauteur, 0.001);
    }

    @Test
    public void testLargeur() {
        double largeur = groupe.largeur();
        assertEquals(128.0, largeur, 0.001);
    }

    @Test
    public void testRedimmensioner() {
        groupe.redimmensioner(2, 1);
        double newHauteur = groupe.hauteur();
        assertEquals(128.0, newHauteur, 0.001);  // Correct the expected height value
    }

    @Test
    public void testTourner() {
        assertEquals("Groupe : \n   Cercle centre= 50.0, 40.0 r= 25.0 de couleur black\n      Polygone 128.0,128.0 128.0,256.0 256.0,128.0 256.0,256.0 couleur=white\n", groupe.description(3));
    }
    @Test
    public void testTourner2() {
        groupe.tourner(180); // Rotation de 180 degrés
        assertEquals("Groupe : \n   Cercle centre= 50.0, 40.0 r= 25.0 de couleur black angle=180\n      Polygone 128.0,128.0 128.0,256.0 256.0,128.0 256.0,256.0 couleur=white angle=180\n", groupe.description(3));
    }
    @Test
    public void testAlignerGauche() {
        groupe.aligner(Alignement.GAUCHE, 100);
        Point centre = groupe.centre();
        System.out.println("Actual x-coordinate: " + centre.x());
        assertEquals(157.0, centre.x(), 0.001);  // Adjust the expected value
        assertEquals(116.0, centre.y(), 0.001);
    }

@Test
public void testAlignerDroite() {
    groupe.aligner(Alignement.DROITE, 200);
    assertEquals(257.0, groupe.centre().x(), 0.001);
    assertEquals(116.0, groupe.centre().y(), 0.001);
}

@Test
public void testAlignerHaut() {
    groupe.aligner(Alignement.HAUT, 100);
    assertEquals(121.0, groupe.centre().x(), 0.001);
    assertEquals(152.0, groupe.centre().y(), 0.001);
}

@Test
public void testAlignerBas() {
    groupe.aligner(Alignement.BAS, 200);
    assertEquals(121.0, groupe.centre().x(), 0.001);
    assertEquals(252.0, groupe.centre().y(), 0.001);
}

    @Test
    public void testVide(){
        assertEquals( null, groupe.vider());
    }

    @Test
    public void testAlignerElements(){
        groupe.alignerElements(Alignement.HAUT, 10);
        assertEquals(10.0, groupe.centre().y(),0.0001);
    }
    
    @Test
    public void testEmpilerElements(){
        
    } 
}
