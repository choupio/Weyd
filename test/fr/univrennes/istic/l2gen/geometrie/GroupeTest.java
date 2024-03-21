package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
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
        this.groupe = new Groupe(cercleTest, polygone);
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
        assertEquals(140.5, centre.x(), 0.001); // Correct the expected x-coordinate value
        assertEquals(135.5, centre.y(), 0.001); // Correct the expected y-coordinate value
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
        assertEquals(150.5, newCentre.x(), 0.001);
        assertEquals(155.5, newCentre.y(), 0.001); // Correct the expected y-coordinate value
    }

    @Test
    public void testDescription() {
        String expectedDescription = "Groupe :\n   Cercle centre= 50.0, 40.0 r= 25.0 de couleur black\n"
                + "      Polygone 128.0,128.0 128.0,256.0 256.0,128.0 256.0,256.0 couleur=white";
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
        assertEquals(241.0, hauteur, 0.001);
    }

    @Test
    public void testLargeur() {
        double largeur = groupe.largeur();
        assertEquals(231.0, largeur, 0.001);
    }

    @Test
    public void testRedimmensioner() {
        groupe.redimmensioner(2, 1);
        double newHauteur = groupe.hauteur();
        assertEquals(266.0, newHauteur, 0.001); // Correct the expected height value
    }

    @Test
    public void testTourner() {
        assertEquals(
                "Groupe :\n   Cercle centre= 50.0, 40.0 r= 25.0 de couleur black\n      Polygone 128.0,128.0 128.0,256.0 256.0,128.0 256.0,256.0 couleur=white",
                groupe.description(3));
    }

    @Test
    public void testTourner2() {
        groupe.tourner(180); // Rotation de 180 degrés
        assertEquals(
                "Groupe :\n   Cercle centre= 50.0, 40.0 r= 25.0 de couleur black angle=180\n      Polygone 128.0,128.0 128.0,256.0 256.0,128.0 256.0,256.0 couleur=white angle=180",
                groupe.description(3));
    }

    @Test
    public void testAlignerGauche() {
        groupe.aligner(Alignement.GAUCHE, 100);
        Point centre = groupe.centre();
        System.out.println("Actual x-coordinate: " + centre.x());
        assertEquals(125.0, centre.x(), 0.001); // Adjust the expected value
        assertEquals(135.5, centre.y(), 0.001);
    }

    @Test
    public void testAlignerDroite() {
        groupe.aligner(Alignement.DROITE, 200);
        assertEquals(225.0, groupe.centre().x(), 0.001);
        assertEquals(135.5, groupe.centre().y(), 0.001);
    }

    @Test
    public void testAlignerHaut() {
        groupe.aligner(Alignement.HAUT, 100);
        assertEquals(140.5, groupe.centre().x(), 0.001);
        assertEquals(115.0, groupe.centre().y(), 0.001);
    }

    @Test
    public void testAlignerBas() {
        groupe.aligner(Alignement.BAS, 200);
        assertEquals(140.5, groupe.centre().x(), 0.001);
        assertEquals(215.0, groupe.centre().y(), 0.001);
    }

    @Test
    public void testVide() {
        groupe.vider();
        List<IForme> LstVide = new ArrayList<IForme>();
        assertEquals(LstVide, groupe.getListFormes());
    }

    // Pour alignement HAUT
    @Test
    public void testAlignerElementsH() {
        groupe.alignerElements(Alignement.HAUT, 150);
        assertEquals(175.0, groupe.getListFormes().get(0).centre().y(), 0.0001);
        // Expected = le y du centre car il est calculé à partir de tous les points
        // (= on voit si les y sont bons)
        assertEquals(214.0, groupe.getListFormes().get(1).centre().y(), 0.0001);
    }

    // Pour alignement BAS
    @Test
    public void testAlignerElementsB() {
        groupe.alignerElements(Alignement.BAS, 300);
        assertEquals(275.0, groupe.getListFormes().get(0).centre().y(), 0.0001);
        // Expected = le y du centre car il est calculé à partir de tous les points
        // (= on voit si les y sont bons)
        assertEquals(236.0, groupe.getListFormes().get(1).centre().y(), 0.0001);
    }

    // Pour alignement GAUCHE
    @Test
    public void testAlignerElementsG() {
        groupe.alignerElements(Alignement.GAUCHE, 220);
        assertEquals(245.0, groupe.getListFormes().get(0).centre().x(), 0.0001);
        // Expected = le x du centre car il est calculé à partir de tous les points
        // (= on voit si les x sont bons)
        assertEquals(284.0, groupe.getListFormes().get(1).centre().x(), 0.0001);
    }

    // Pour alignement DROITE
    @Test
    public void testAlignerElementsD() {
        groupe.alignerElements(Alignement.DROITE, 180);
        assertEquals(155.0, groupe.getListFormes().get(0).centre().x(), 0.0001);
        // Expected = le x du centre car il est calculé à partir de tous les points
        // (= on voit si les x sont bons)
        assertEquals(116.0, groupe.getListFormes().get(1).centre().x(), 0.0001);
    }

    // Pour alignement HAUT + sépraration de 20
    @Test
    public void testEmpilerElementsH() {
        groupe.empilerElements(Alignement.HAUT, 150, 20);
        assertEquals(50, groupe.getListFormes().get(0).centre().x(), 0.0001);
        assertEquals(175.0, groupe.getListFormes().get(0).centre().y(), 0.0001);
        // Expected = les x,y du centre car ils sont calculés à partir de tous les
        // points (= on voit si les x,y sont bons)
        assertEquals(192.0, groupe.getListFormes().get(1).centre().x(), 0.0001);
        assertEquals(284, groupe.getListFormes().get(1).centre().y(), 0.0001);
    }

    // Pour alignement BAS + sépraration de 40
    @Test
    public void testEmpilerElementsB() {
        groupe.empilerElements(Alignement.BAS, 220, 40);
        assertEquals(50.0, groupe.getListFormes().get(0).centre().x(), 0.0001);
        assertEquals(195.0, groupe.getListFormes().get(0).centre().y(), 0.0001);
        // Expected = les x,y du centre car ils sont calculés à partir de tous les
        // points (= on voit si les x,y sont bons)
        assertEquals(192.0, groupe.getListFormes().get(1).centre().x(), 0.0001);
        assertEquals(66.0, groupe.getListFormes().get(1).centre().y(), 0.0001);
    }

    // Pour alignement GAUCHE + sépraration de 60
    @Test
    public void testEmpilerElementsG() {
        groupe.empilerElements(Alignement.GAUCHE, 220, 60);
        assertEquals(245.0, groupe.getListFormes().get(0).centre().x(), 0.0001);
        assertEquals(40.0, groupe.getListFormes().get(0).centre().y(), 0.0001);
        // Expected = les x,y du centre car ils sont calculés à partir de tous les
        // points (= on voit si les x,y sont bons)
        assertEquals(394.0, groupe.getListFormes().get(1).centre().x(), 0.0001);
        assertEquals(192.0, groupe.getListFormes().get(1).centre().y(), 0.0001);
    }

    // Pour alignement DROITE + sépraration de 80
    @Test
    public void testEmpilerElementsD() {
        groupe.empilerElements(Alignement.DROITE, 260, 80);
        assertEquals(235.0, groupe.getListFormes().get(0).centre().x(), 0.0001);
        assertEquals(40.0, groupe.getListFormes().get(0).centre().y(), 0.0001);
        // Expected = les x,y du centre car ils sont calculés à partir de tous les
        // points (= on voit si les x,y sont bons)
        assertEquals(66.0, groupe.getListFormes().get(1).centre().x(), 0.0001);
        assertEquals(192.0, groupe.getListFormes().get(1).centre().y(), 0.0001);
    }
}
