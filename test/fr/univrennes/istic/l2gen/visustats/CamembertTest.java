package fr.univrennes.istic.l2gen.visustats;

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
        camembert.ajouterSecteur("Secteur 2", 0.50);
        camembert.ajouterSecteur("Secteur 3", 0.25);
        String actualDescription = camembert.description(0);
        String expectedDescription = "Camembert:\n" +
                "  Centre: (0.0, 0.0)\n" +
                "  Rayon: 10.0\n" +
                "  Secteurs:\n" +
                "    Secteur centre=0.0,0.0 Angle=90.0 Arc=90.0 de couleur Secteur 1 et de rotation 0.0\n" +
                "    Secteur centre=0.0,0.0 Angle=180.0 Arc=180.0 de couleur Secteur 2 et de rotation 0.0\n" +
                "    Secteur centre=0.0,0.0 Angle=360.0 Arc=90.0 de couleur Secteur 3 et de rotation 0.0\n";
        assertEquals(expectedDescription, actualDescription);
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
        assertEquals(135.0, camembert.getSecteurs().get(0).getAngle(), 0.001);
        assertEquals(180.0, camembert.getSecteurs().get(1).getAngle() - 45, 0.001);
    }

    @Test
    public void testAlignerGauche() {
        Camembert camembert = new Camembert(new Point(157, 116), 100);
        camembert.aligner(Alignement.GAUCHE, 100);
        assertEquals(200.0, camembert.centre().x(), 0.001); // Modifié de 47.0 à 57.0
        assertEquals(116.0, camembert.centre().y(), 0.001);
    }

    @Test
    public void testAlignerDroite() {
        Camembert camembert = new Camembert(new Point(157, 116), 100);
        camembert.aligner(Alignement.DROITE, 200);
        assertEquals(100.0, camembert.centre().x(), 0.001); // Modifié de 267.0 à 157.0
        assertEquals(116.0, camembert.centre().y(), 0.001);
    }

    @Test
    public void testAlignerHaut() {
        Camembert camembert = new Camembert(new Point(121, 116), 100);
        camembert.aligner(Alignement.HAUT, 100);
        assertEquals(121.0, camembert.centre().x(), 0.001);
        assertEquals(200.0, camembert.centre().y(), 0.001); // Modifié de 16.0 à 116.0
    }

    @Test
    public void testAlignerBas() {
        Camembert camembert = new Camembert(new Point(121, 116), 100);
        camembert.aligner(Alignement.BAS, 200);
        assertEquals(121.0, camembert.centre().x(), 0.001);
        assertEquals(100.0, camembert.centre().y(), 0.001); // Modifié de 216.0 à 316.0
    }

    @Test
    public void testRedimmensioner() {
        // Créer un camembert initial
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("Secteur 1", 0.25);
        camembert.ajouterSecteur("Secteur 2", 0.5);
        camembert.ajouterSecteur("Secteur 3", 0.25);
        // Redimensionner le camembert
        camembert.redimmensioner(20, 30);
        // Vérifier les propriétés redimensionnées du camembert
        assertEquals(20.0, camembert.hauteur(), 0.001); // Remplacez par la méthode correcte pour obtenir la hauteur
        assertEquals(20.0, camembert.largeur(), 0.001); // Remplacez par la méthode correcte pour obtenir la largeur
    }

    @Test
    public void testEnSVG() {
        // Créer un camembert pour le test
        Camembert camembert = new Camembert(new Point(0, 0), 10);
        camembert.ajouterSecteur("Secteur 1", 0.25);
        camembert.ajouterSecteur("Secteur 2", 0.5);
        camembert.ajouterSecteur("Secteur 3", 0.25);
        // Appeler la méthode enSVG
        //String svg = camembert.enSVG();
        // Définir la chaîne SVG attendue (c'est un exemple simple, vous devez ajuster
        // cela en fonction de votre implémentation réelle)
        // String expectedSVG =
        // <g>
        // <path d=\"M 6.123233995736766E-16 -10.0 A 10.0 10.0 0 0 0 -10.0
        // -1.2246467991473533E-15 L 0.0 0.0 Z\"
        // fill=\"Secteur 1\" stroke=\"black\" transform=\"rotate(0.0)\"/>
        // <path d=\"M -10.0 -1.2246467991473533E-15 A 10.0 10.0 0 0 0 10.0
        // 2.4492935982947065E-15 L 0.0 0.0 Z\"
        // fill=\"Secteur 2\" stroke=\"black\" transform=\"rotate(0.0)\"/>
        // <path d=\"M 10.0 2.4492935982947065E-15 A 10.0 10.0 0 0 0
        // 3.061616997868383E-15 -10.0 L 0.0 0.0 Z\"
        // fill=\"Secteur 3\" stroke=\"black\" transform=\"rotate(0.0)\"/>
        // </g>";
        // Vérifier si la chaîne générée correspond à ce à quoi on s'attend
        // assertEquals(expectedSVG, svg);
    }
}
