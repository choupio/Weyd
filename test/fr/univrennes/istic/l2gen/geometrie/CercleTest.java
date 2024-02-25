package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CercleTest {
    private Cercle cercleTest;
    private Point pointCerc;
    private double rayonCerc;
    private IForme cercRedim;

    @Before
    public void initCerc() {
        double rayonCerc = 25;
        Point pointCerc = new Point(50, 40);
        Cercle cercleTest = new Cercle(pointCerc, rayonCerc);
        this.cercleTest = cercleTest;
        this.pointCerc = pointCerc;
        this.rayonCerc = rayonCerc;

        IForme cercRedim = cercleTest.dupliquer();
        this.cercRedim = cercRedim;

    }

    @Test
    public void testCentre() {
        assertEquals(pointCerc, cercleTest.centre());
    }

    @Test
    public void testDeplacer() {
        double x = 5;
        double y = 10;
        cercleTest.deplacer(x, y);
        assertEquals(50.0, pointCerc.x(), 0.0001);
        assertEquals(40.0, pointCerc.y(), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class) // quand le X du cercle devient négatif
    public void testDeplacerXNeg(){
        cercleTest.deplacer(-51,3);
    }

    @Test(expected = IllegalArgumentException.class) //quand le Y du cercle devient négatif
    public void testDeplacerYNeg(){
        cercleTest.deplacer(10,-41);
    }

    @Test
    public void testDescription() {
        assertEquals("   Cercle centre= 50.0, 40.0 r= 25.0 de couleur black", cercleTest.description(3));
    }

    @Test(expected = IllegalArgumentException.class) // dans le cas où l'indentation est négative
    public void testDescriptionIndentationNeg(){
        cercleTest.description(-1);
    }

    @Test
    public void testDupliquer() {
        IForme cercleDup = cercleTest.dupliquer();
        // Utilisation de centre pour vérifier les valeurs du point
        assertEquals(cercleTest.centre(), cercleDup.centre());
        assertEquals(rayonCerc, cercleDup.largeur() / 2, 0.0001);
    }

    @Test
    public void testEnSVG() {
        // Pour des valeurs en double (donc bon);
        assertEquals("<circle cx=\"50.0\" cy=\"40.0\" r=\"25.0\"\n fill=\"black\" stroke=\"black\"/>",
                cercleTest.enSVG());
        // Pour des valeurs en int + mauvaise couleur (exemple de faux);
        assertNotEquals("<circle cx=\"50\" cy=\"40\" r=\"25\"\n fill=\"pink\" stroke=\"black\"/>", cercleTest.enSVG());
    }

    @Test
    public void testHauteur() {
        assertEquals(rayonCerc * 2, cercleTest.hauteur(), 0.00001);
    }

    @Test
    public void testLargeur() {
        assertEquals(rayonCerc * 2, cercleTest.largeur(), 0.00001);
    }

    @Test
    public void testRedimmensioner1() {
        // Pour i==j
        assertEquals((cercleTest.largeur() / 2) * 10, cercRedim.redimmensioner(10, 10).largeur() / 2, 0.00001);
    }

    @Test
    public void testRedimmensioner2() {
        // Pour i==0
        assertEquals((cercleTest.largeur() / 2) * 15, cercRedim.redimmensioner(0, 15).largeur() / 2, 0.00001);
    }

    @Test
    public void testRedimmensioner3() {
        // Pour j==0
        assertEquals((cercleTest.largeur() / 2) * 13, cercRedim.redimmensioner(13, 0).largeur() / 2, 0.00001);
    }

    @Test
    public void testRedimmensioner4() {
        // Pour else
        assertEquals((cercleTest.largeur() / 2) * 16 * 18, cercRedim.redimmensioner(16, 18).largeur() / 2, 0.00001);
    }

    @Test
    public void testRedimmensioner5() {
        // Pour else avec deux valeurs négatives
        assertEquals((cercleTest.largeur() / 2) * 8 * 12, cercRedim.redimmensioner(8, 12).largeur() / 2, 0.00001);
    }

    @Test
    public void testRedimmensioner6() {
        // Pour else avec une valeur négative (rayon négatif pas possible)
        assertNotEquals((cercleTest.largeur() / 4) * 8 * 14, cercRedim.redimmensioner(8, 14).largeur() / 2, 0.00001);
    }

    @Test
    public void testTourner() {
        cercleTest.tourner(180); // Rotation de 180 degrés
        assertEquals("   Cercle centre= 50.0, 40.0 r= 25.0 de couleur black angle=180", cercleTest.description(3));
    }
    @Test
    public void testTourner2() {
        cercleTest.tourner(0); // Rotation de 0 degrés
        assertEquals("   Cercle centre= 50.0, 40.0 r= 25.0 de couleur black", cercleTest.description(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTournerNegatif(){
        cercleTest.tourner(-2);
    }

    @Test
    public void testalignergauche() {
        IForme cercleA = cercleTest;
        IForme cercleTest = cercleA.aligner(Alignement.GAUCHE, 5.0);
        assertEquals(30, cercleTest.centre().x(), 0.001);
        assertEquals(40, cercleTest.centre().y(), 0.001);
    }

    @Test
    public void testalignerhaut() {        
        IForme cercleA = cercleTest;
        IForme cercleTest = cercleA.aligner(Alignement.HAUT, 5.0);
        assertEquals(50, cercleTest.centre().x(), 0.001);
        assertEquals(30, cercleTest.centre().y(), 0.001);
    }

    @Test
    public void testalignerdroite() {        
        IForme cercleA = cercleTest;
        IForme cercleTest = cercleA.aligner(Alignement.DROITE, 25.0);
        assertEquals(0, cercleTest.centre().x(), 0.001);
        assertEquals(40, cercleTest.centre().y(), 0.001);
    }

    @Test(expected = IllegalStateException.class) // si X devient négatif à la fin
    public void testAlignerDroiteNegatif(){
        cercleTest.aligner(Alignement.DROITE, 15.0);
    }


    @Test
    public void testalignerbas() {        
        IForme cercleA = cercleTest;
        IForme cercleTest = cercleA.aligner(Alignement.BAS, 25.0);
        assertEquals(50, cercleTest.centre().x(), 0.001);
        assertEquals(0, cercleTest.centre().y(), 0.001);
    }

    @Test(expected = IllegalStateException.class) // si Y devient négatif à la fin
    public void testAlignerBASNegatif(){
        cercleTest.aligner(Alignement.BAS, 15.0);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAlignerCibleNegative(){
        cercleTest.aligner(Alignement.BAS, -5.0);
    }

}
