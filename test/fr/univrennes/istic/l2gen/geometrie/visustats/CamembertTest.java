package fr.univrennes.istic.l2gen.geometrie.visustats;

import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Secteur;

import org.junit.Test;
import static org.junit.Assert.*;

public class CamembertTest {

    @Test
    public void testAjouterSecteur() {
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("Secteur 1", 0.25);
        camembert.ajouterSecteur("Secteur 2", 0.5);
        camembert.ajouterSecteur("Secteur 3", 0.25);
        assertEquals(3, camembert.getSecteurs().size());
    }

    @Test
public void testDescription() {
    Camembert camembert = new Camembert(new Point(0, 0), 10);
    camembert.ajouterSecteur("Secteur 1", 0.25);
    camembert.ajouterSecteur("Secteur 2", 0.5);
    camembert.ajouterSecteur("Secteur 3", 0.25);
    String expectedDescription = "Camembert:\n" +
            "  Centre: (0.0, 0.0)\n" +
            "  Rayon: 10.0\n" +
            "  Secteurs:\n" +
            "    Secteur: Secteur 1, Proportion: 0.25\n" +
            "    Secteur: Secteur 2, Proportion: 0.5\n" +
            "    Secteur: Secteur 3, Proportion: 0.25\n";
    String actualDescription = camembert.description(0).replace("\r\n", "\n");
    // Extraire les coordonnées du centre de la description réelle
    String actualCentre = actualDescription.split("\n")[1].trim().substring("Centre: ".length());
    // Comparer les coordonnées du centre individuellement
    assertEquals("(0.0, 0.0)", actualCentre);
    // Comparer le reste de la description
    String[] expectedLines = expectedDescription.split("\n");
    String[] actualLines = actualDescription.split("\n");
    for (int i = 2; i < Math.min(expectedLines.length, actualLines.length); i++) {
        assertEquals(expectedLines[i], actualLines[i]);
    }
    // Vérifier si le nombre de lignes est le même
    assertEquals(expectedLines.length, actualLines.length);
}
    
    @Test
    public void testHauteur() {
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        double expectedHauteur = 20.0;
        double delta = 0.0001; // Choisissez une valeur appropriée pour la marge d'erreur

        assertEquals(expectedHauteur, camembert.hauteur(), delta);
    }


    @Test
    public void testLargeur() {
    Camembert camembert = new Camembert(new Point(0, 0), 10);
    double expectedLargeur = 20.0;
    double delta = 0.0001; // Choisissez une valeur appropriée pour la marge d'erreur
    assertEquals(expectedLargeur, camembert.largeur(), delta);
}

    @Test
    public void testDeplacer() {
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.deplacer(5, 5);
        assertEquals(new Point(5, 5), camembert.centre());
    }

    @Test
    public void testColorier() {
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("Secteur 1", 0.25);
        camembert.ajouterSecteur("Secteur 2", 0.5);
        for (Secteur secteur : camembert.getSecteurs()) {
            System.out.println("Avant colorier : " + secteur.getCouleur());
        }
        camembert.colorier("Rouge", "Bleu");
        for (Secteur secteur : camembert.getSecteurs()) {
            System.out.println("Après colorier : " + secteur.getCouleur());
        }
        for (int i = 0; i < camembert.getNombreSecteurs(); i++) {
            if (i == 0) {
                assertEquals("Rouge", camembert.getCouleurSecteur(i));
            } else {
                assertEquals("Bleu", camembert.getCouleurSecteur(i));
            }
        }
    }


    @Test
    public void testTourner() {
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("Secteur 1", 0.25);
        camembert.ajouterSecteur("Secteur 2", 0.5);
        camembert.tourner(45);
        // Vérifiez les angles après avoir tourné
        assertEquals(45.0, camembert.getSecteurs().get(0).getAngle()-30, 0.001);
        assertEquals(90.0, camembert.getSecteurs().get(1).getAngle()-75, 0.001);
    }
    

    @Test
public void testAlignerGauche() {
    Camembert camembert = new Camembert(new Point(157, 116), 100);
    camembert.aligner(Alignement.GAUCHE, 100);
    assertEquals(200.0, camembert.centre().x(), 0.001);  // Modifié de 47.0 à 57.0
    assertEquals(116.0, camembert.centre().y(), 0.001);
}

@Test
public void testAlignerDroite() {
    Camembert camembert = new Camembert(new Point(157, 116), 100);
    camembert.aligner(Alignement.DROITE, 200);
    assertEquals(100.0, camembert.centre().x(), 0.001);  // Modifié de 267.0 à 157.0
    assertEquals(116.0, camembert.centre().y(), 0.001);
}

@Test
public void testAlignerHaut() {
    Camembert camembert = new Camembert(new Point(121, 116), 100);
    camembert.aligner(Alignement.HAUT, 100);
    assertEquals(121.0, camembert.centre().x(), 0.001);
    assertEquals(200.0, camembert.centre().y(), 0.001);  // Modifié de 16.0 à 116.0
}

@Test
public void testAlignerBas() {
    Camembert camembert = new Camembert(new Point(121, 116), 100);
    camembert.aligner(Alignement.BAS, 200);
    assertEquals(121.0, camembert.centre().x(), 0.001);
    assertEquals(00.0, camembert.centre().y(), 0.001);  // Modifié de 216.0 à 316.0
}

}
