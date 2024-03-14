package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TriangleTest {
    private Triangle triangle;

    @Before
    public void setUp() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 0);
        Point point3 = new Point(0, 1);
        Triangle triangle = new Triangle(point1, point2, point3);
        this.triangle = triangle;
    }

    @Test
    public void testCentre() {
        Point centre = triangle.centre();
        assertEquals(1.0 / 3, centre.x(), 0.001);
        assertEquals(1.0 / 3, centre.y(), 0.001);
    }

    @Test
    public void testDescription() {
        String description = triangle.description(2);
        assertEquals("  Triangle 0.0,0.0 1.0,0.0 0.0,1.0 de couleur white angle=0", description);
    }

    @Test(expected = IllegalArgumentException.class) // Dans le cas où l'indentation est négative.
    public void testDescriptionIndentationNeg(){
        triangle.description(-1);
    }

    @Test
    public void testCote() {
        double cote = triangle.cote(new Point(0, 0), new Point(1, 1));
        assertEquals(Math.sqrt(2), cote, 0.001);
    }

    @Test
    public void testDeplacer() {
        triangle.deplacer(1, 1);
        assertEquals(1.0, triangle.point1.x(), 0.001);
        assertEquals(1.0, triangle.point1.y(), 0.001);
        assertEquals(2.0, triangle.point2.x(), 0.001);
        assertEquals(1.0, triangle.point2.y(), 0.001);
        assertEquals(1.0, triangle.point3.x(), 0.001);
        assertEquals(2.0, triangle.point3.y(), 0.001);
    }

    @Test
    public void testColorier() {
        triangle.colorier("red");
        assertEquals("red", triangle.couleur);
    }

    @Test
    public void testDupliquer() {
        Triangle copie = (Triangle) triangle.dupliquer();
        assertEquals(triangle.centre().x(), copie.centre().x(), 0.001);
        assertEquals(triangle.centre().y(), copie.centre().y(), 0.001);
    }

    // SVG pour un angle de 0
    @Test
    public void testEnSVG1() {
        String svg = triangle.enSVG();
        assertEquals(
                "<polygon points=\"0.0,0.0 1.0,0.0 0.0,1.0\" fill=\"white\" stroke=\"black\"/>",
                svg);
    }

    // SVG pour un angle différent de 0
    @Test
    public void testEnSVG2() {
        triangle.tourner(16);
        String svg = triangle.enSVG();
        assertEquals(
                "<polygon points=\"0.0,0.0 1.0,0.0 0.0,1.0\" fill=\"white\" stroke=\"black\" transform=\"rotate(16)\"/>",
                svg);
    }

    @Test
    public void testHauteur() {
        double hauteur = triangle.hauteur();
        assertEquals(1.0, hauteur, 0.001);
    }

    @Test
    public void testLargeur() {
        double largeur = triangle.largeur();
        assertEquals(1.0, largeur, 0.001);
    }

    @Test
    public void testRedimmensioner() {
        triangle.redimmensioner(2, 2);
        assertEquals(2.0, triangle.hauteur(), 0.001);
        assertEquals(2.0, triangle.largeur(), 0.001);
    }

    @Test
    public void testTourner() { // en modifiant l'angle
        triangle.tourner(38);
        assertEquals(" Triangle 0.0,0.0 1.0,0.0 0.0,1.0 de couleur white angle=38", triangle.description(1));
    }

    @Test
    public void testTournerPasModif() { // sans modifier l'angle
        triangle.tourner(0);
        assertEquals(" Triangle 0.0,0.0 1.0,0.0 0.0,1.0 de couleur white angle=0", triangle.description(1));
    }

    @Test(expected = IllegalArgumentException.class) // Dans le cas où l'angle est négatif
    public void testTournerNegatif(){
        triangle.tourner(-10);
    }

    // Pour le cas HAUT
    @Test
    public void testAlignerH() {
        triangle.aligner(Alignement.HAUT, 150);
        Triangle triangleRésultats = new Triangle(0, 150, 1, 150, 0, 151);
        assertEquals(triangleRésultats.point1.x(), triangle.point1.x(), 0.00001);
        assertEquals(triangleRésultats.point1.y(), triangle.point1.y(), 0.00001);
        assertEquals(triangleRésultats.point2.x(), triangle.point2.x(), 0.00001);
        assertEquals(triangleRésultats.point2.y(), triangle.point2.y(), 0.00001);
        assertEquals(triangleRésultats.point3.x(), triangle.point3.x(), 0.00001);
        assertEquals(triangleRésultats.point3.y(), triangle.point3.y(), 0.00001);
    }

    // Pour le cas BAS
    @Test
    public void testAlignerB() {
        triangle.aligner(Alignement.BAS, 250);
        Triangle triangleRésultats = new Triangle(0, 249, 1, 249, 0, 250);
        assertEquals(triangleRésultats.point1.x(), triangle.point1.x(), 0.00001);
        assertEquals(triangleRésultats.point1.y(), triangle.point1.y(), 0.00001);
        assertEquals(triangleRésultats.point2.x(), triangle.point2.x(), 0.00001);
        assertEquals(triangleRésultats.point2.y(), triangle.point2.y(), 0.00001);
        assertEquals(triangleRésultats.point3.x(), triangle.point3.x(), 0.00001);
        assertEquals(triangleRésultats.point3.y(), triangle.point3.y(), 0.00001);
    }

    // Pour le cas GAUCHE
    @Test
    public void testAlignerG() {
        triangle.aligner(Alignement.GAUCHE, 100);
        Triangle triangleRésultats = new Triangle(100, 0, 101, 0, 100, 1);
        assertEquals(triangleRésultats.point1.x(), triangle.point1.x(), 0.00001);
        assertEquals(triangleRésultats.point1.y(), triangle.point1.y(), 0.00001);
        assertEquals(triangleRésultats.point2.x(), triangle.point2.x(), 0.00001);
        assertEquals(triangleRésultats.point2.y(), triangle.point2.y(), 0.00001);
        assertEquals(triangleRésultats.point3.x(), triangle.point3.x(), 0.00001);
        assertEquals(triangleRésultats.point3.y(), triangle.point3.y(), 0.00001);
    }

    // Pour le cas DROITE
    @Test
    public void testAlignerD() {
        triangle.aligner(Alignement.DROITE, 175);
        Triangle triangleRésultats = new Triangle(174, 0, 175, 0, 174, 1);
        assertEquals(triangleRésultats.point1.x(), triangle.point1.x(), 0.00001);
        assertEquals(triangleRésultats.point1.y(), triangle.point1.y(), 0.00001);
        assertEquals(triangleRésultats.point2.x(), triangle.point2.x(), 0.00001);
        assertEquals(triangleRésultats.point2.y(), triangle.point2.y(), 0.00001);
        assertEquals(triangleRésultats.point3.x(), triangle.point3.x(), 0.00001);
        assertEquals(triangleRésultats.point3.y(), triangle.point3.y(), 0.00001);
    }
}
