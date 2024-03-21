package fr.univrennes.istic.l2gen.geometrie;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
    Rectangle r;

    @Before
    public void setUp() {
        Point c = new Point(5, 6);
        r = new Rectangle(c, 5, 8);
    }

    @Test
    public void testCentre() {
        setUp();
        Point c = new Point(5, 6);
        Point centre = r.centre();
        assertEquals(c.x(), centre.x(), 0.0001);
        assertEquals(c.y(), centre.y(), 0.0001);
    }

    @Test
    public void testColorier() {
        r.colorier("rouge");
        assertEquals("<rect x=\"" + r.getCoin().x() + "\" y=\"" + r.getCoin().y() + "\" height=\"" + r.hauteur()
                + "\" width=\""
                + r.largeur()
                + "\"\n" + "\t" + "fill=\"" + "rouge" + "\"" + " stroke=\"black\"" + " transform=\"rotate(0)\"/>",
                r.enSVG());
    }

    @Test
    public void testDeplacer() {
        IForme rectangleDeplace = r.deplacer(8, 5);
        assertEquals(13, rectangleDeplace.centre().x(), 0.0001);
        assertEquals(11, rectangleDeplace.centre().y(), 0.0001);
    }

    @Test(expected = IllegalStateException.class) // On teste pour vérifier que la fonction renvoie
                                                  // IllegalArgumentException si x devient négatif
    public void testDeplacerXNeg() {
        r.deplacer(-15, 2);
    }

    @Test
    public void testDeplacerX() { // dans le cas où dx est négatif, mais que x ne descend pas en dessous de 0.
        IForme r2 = r.deplacer(-2, 2);
        assertEquals(3, r2.centre().x(), 0.0001);
    }

    @Test
    public void testDeplacerY() { // dans le cas où dy est négatif, mais que y ne descend pas en dessous de 0.
        IForme r2 = r.deplacer(2, -2);
        assertEquals(4, r2.centre().y(), 0.0001);
    }

    @Test(expected = IllegalStateException.class) // On teste pour vérifier que la fonction renvoie
                                                  // IllegalArgumentException si y devient négatif
    public void testDeplacerYNeg() {
        r.deplacer(2, -15);
    }

    @Test
    public void testDescription() {
        assertEquals(" Rectangle Centre=" + r.centre().x() + "," + r.centre().y() + " L=" + r.largeur() + " H="
                + r.hauteur() + " de couleur white" + " angle=0", r.description(1));
    }

    @Test(expected = IllegalArgumentException.class) // On teste pour vérifier que la fonction renvoie
                                                     // IllegalArgumentException si l'indentation est négative.
    public void testDescriptionIndentationNeg() {
        r.description(-1);
    }

    @Test
    public void testDupliquer() {
        setUp();
        Rectangle r2 = (Rectangle) r.dupliquer();
        assertEquals(r.centre(), r2.centre());
        assertEquals(r.hauteur(), r2.hauteur(), 0.0001);
        assertEquals(r.largeur(), r2.largeur(), 0.0001);
    }

    @Test
    public void testEnSVG() {
        assertEquals("<rect x=\"" + r.getCoin().x() + "\" y=\"" + r.getCoin().y() + "\" height=\"" + r.hauteur()
                + "\" width=\""
                + r.largeur()
                + "\"\n" + "\t" + "fill=\"" + "white" + "\"" + " stroke=\"black\"" + " transform=\"rotate(0)\"/>",
                r.enSVG());
    }

    @Test
    public void testHauteur() {
        assertEquals(8, r.hauteur(), 0.0001);
    }

    @Test
    public void testLargeur() {
        assertEquals(5, r.largeur(), 0.0001);
    }

    @Test
    public void testRedimmensioner() {
        Rectangle r3 = (Rectangle) r.redimmensioner(0.5, 2);
        assertEquals(r.centre(), r3.centre());
        assertEquals(r3.largeur(), 10, 0.0001);
        assertEquals(r.hauteur(), 4, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class) // Dans le cas où la hauteur de red. est à 0.
    public void testRedimmensionerHauteur0() {
        r.redimmensioner(0, 2);
    }

    @Test(expected = IllegalArgumentException.class) // Dans le cas où la hauteur de red. est négative.
    public void testRedimmensionerHauteurNeg() {
        r.redimmensioner(-2, 2);
    }

    @Test(expected = IllegalArgumentException.class) // Dans le cas où la largeur de red. est à 0.
    public void testRedimmensionerLargeur0() {
        r.redimmensioner(2, 0);
    }

    @Test(expected = IllegalArgumentException.class) // Dans le cas où la largeur de red. est négative.
    public void testRedimmensionerLargeurNeg() {
        r.redimmensioner(2, -2);
    }

    @Test
    public void testSetHauteur() {
        r.setHauteur(3);
        assertEquals(3, r.hauteur(), 0.0001);
    }

    @Test
    public void testSetLargeur() {
        r.setLargeur(3);
        assertEquals(3, r.largeur(), 0.0001);
    }

    @Test
    public void testTourner() { // en modifiant l'angle
        r.tourner(38);
        assertEquals(" Rectangle Centre=5.0,6.0 L=5.0 H=8.0 de couleur white angle=38", r.description(1));
    }

    @Test(expected = IllegalArgumentException.class) // pareil que le précédent mais quand l'angle est négatif
    public void testTournerNegatif() {
        r.tourner(-10);
    }

    @Test
    public void testTournerPasModif() { // sans modifier l'angle
        assertEquals(" Rectangle Centre=5.0,6.0 L=5.0 H=8.0 de couleur white angle=0", r.description(1));
    }

    @Test
    public void testAlignerHAUT() { // Dans le cas où on aligne par le haut.
        IForme rectangleTest = r.aligner(Alignement.HAUT, 4.0);
        assertEquals(5, rectangleTest.centre().x(), 0.0001);
        assertEquals(8, rectangleTest.centre().y(), 0.0001);
    }

    @Test
    public void testAlignerBAS() { // Dans le cas où on aligne par le bas.
        IForme rectangleTest = r.aligner(Alignement.BAS, 10.0);
        assertEquals(5, rectangleTest.centre().x(), 0.0001);
        assertEquals(6, rectangleTest.centre().y(), 0.0001);
    }

    @Test
    public void testAlignerDROITE() { // Dans le cas où on aligne par la droite.
        IForme rectangleTest = r.aligner(Alignement.DROITE, 8.0);
        assertEquals(5.5, rectangleTest.centre().x(), 0.0001);
        assertEquals(6, rectangleTest.centre().y(), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAlignerDROITENegatif() { // Dans le cas où on aligne par la droite, mais que Y devient négatif.
        r.aligner(Alignement.DROITE, 2.0);
    }

    @Test
    public void testAlignerGAUCHE() { // Dans le cas où on aligne par la gauche.
        IForme rectangleTest = r.aligner(Alignement.GAUCHE, 3.0);
        assertEquals(5.5, rectangleTest.centre().x(), 0.0001);
        assertEquals(6, rectangleTest.centre().y(), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAlignerNegatif() { // Dans le cas où on aligne, mais que la cible est négative.
        r.aligner(Alignement.BAS, -8.0);
    }

}
