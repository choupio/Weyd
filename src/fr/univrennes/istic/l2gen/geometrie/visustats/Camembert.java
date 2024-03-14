package fr.univrennes.istic.l2gen.geometrie.visustats;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Secteur;

/**
 * La classe Camembert représente un camembert défini par un centre, un rayon et
 * des secteurs.
 */
public class Camembert implements IForme {

    private Point centre;
    private double rayon;
    private List<Secteur> secteurs;
    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    private String description;
    public double proportion;

    @Override
    public Point centre() {
        return centre;
    public double getRayon() {
        return rayon;
    }

    private List<Secteur> secteurs;
    private double cmptAngle = 0;
    private String couleur = "white";

    public String getCouleur() {
        return couleur;
    }


    /**
     * Constructeur de la classe Camembert
     * 
     * @param point un Point représentant le centre du Camembert
     * @param a     un double représentant le rayon du Camembert
     */
    public Camembert(Point point, double a) {
        if (point.x() < 0 || point.y() < 0) {
            throw new IllegalArgumentException(
                    "Le centre (point) et le rayon (a) doivent avoir des coordonnées strictement positives.");
        } else {
            this.centre = point;
            this.rayon = a;
        }
        this.secteurs = new ArrayList<>();
    }

    /**
     * Constructeur de la classe Camembert
     * 
     * @param x     un double représentant la coordonée X du centre du Camembert
     * @param y     un double représentant la coordonée Y du centre du Camembert
     * @param rayon un double représentant le rayon du Camembert
     */
    public Camembert(double x, double y, double rayon) {
        this(new Point(x, y), rayon);
    }

    /**
     * Getteur de la liste des secteurs du Camembert
     * 
     * @return secteurs, la liste des différents secteurs
     */
    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    /**
     * Setteur de la liste des secteurs du Camembert
     * 
     * @param secteurs une liste de Secteurs
     */
    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    /**
     * 
     * @param numeroSecteur un entier représentant le secteur dont on veut récupérer
     *                      la couleur
     * @throws IllegalArgumentException si le numéro de secteur n'existe pas
     * @return la couleur correspondant au numéro du secteur entré en paramètres
     */
    public String getCouleurSecteur(int numeroSecteur) {
        if (numeroSecteur < 0 || numeroSecteur >= secteurs.size()) {
            throw new IllegalArgumentException("Numéro de secteur invalide");
        }
        return secteurs.get(numeroSecteur).couleur;
    }

    /**
     * Ajoute un secteur au Camembert
     * 
     * @param description une String représentant la couleur du secteur à ajouter
     * @param proportion  un double représentant la proportion que prendra le
     *                    secteur dans le Camembert
     * @throws IllegalArgumentException si la proportion est <= 0
     * @return Une référence à l'instance de la forme géométrique, pour permettre
     *         les opérations en chaîne.
     */
    public Camembert ajouterSecteur(String description, double proportion) {
<<<<<<< HEAD
        secteurs.add(new Secteur(centre,rayon,angle,arc));
=======
        if (proportion <= 0 || proportion >1) {
            throw new IllegalArgumentException("La proportion doit être strictement supérieure à 0 et inférieur ou égale à 1.");
        } else {
            double angleSecteur = 360 * proportion;
            Secteur secteur = new Secteur(centre, rayon, cmptAngle, angleSecteur);
            secteur.colorier(description);
            secteurs.add(secteur);
            cmptAngle += angleSecteur;
        }
>>>>>>> b9332462b45fabd54185b061cd71880f6096c8c6
        return this;
    }

    @Override
    public Point centre() {
        if (centre.x() < 0 || centre.y() < 0) {
            throw new IllegalArgumentException("Centre ne peut pas avoir de coordonnées négatives.");
        } else {
            return centre;
        }
    }

    @Override
    public String description(int indentation) {
        String indent = "";
        for (int i = 0; i < indentation; i += 1) {
            indent += " ";
        }
        StringBuilder sb = new StringBuilder(indent + "Camembert:\n");
        sb.append(indent + "  Centre: ").append("(" + centre.x() + ", " + centre.y() + ")").append("\n");
        sb.append(indent + "  Rayon: ").append(rayon).append("\n");
        sb.append(indent + "  Secteurs:\n");
        int i = 1;
        for (Secteur secteur : secteurs) {
            String nomSecteur = "Secteur " + i;
            String formatProportion = String.format("%.2f", secteur.getArc()/(double)360);
            sb.append(indent + "    Secteur: ").append(nomSecteur).append(", Proportion: " + formatProportion).append("\n");
            i++;
        }
        return sb.toString();
    }

    @Override
    public double hauteur() {
        return rayon * 2;
    }

    @Override
    public double largeur() {
        return rayon * 2;
    }

    @Override
    public IForme deplacer(double dx, double dy) {
        this.centre.plus(dx, dy);
        return this;
    }

    @Override
    public IForme dupliquer() {
        Camembert camembertNouveau = new Camembert(centre.x(), centre.y(), rayon);
        ArrayList<Secteur> lstSecteurs = new ArrayList<>();
        for (Secteur secteur : secteurs) {
            lstSecteurs.add((Secteur) secteur.dupliquer());
        }
        camembertNouveau.secteurs = lstSecteurs;
        return camembertNouveau;
    }

    @Override
    public IForme redimmensioner(double h, double l) {
        if (h <= 0 || l <= 0) {
            throw new IllegalArgumentException("Les dimensions doivent être positives");
        }
        double facteur = Math.min(h / (2 * rayon), l / (2 * rayon));
        rayon *= facteur;
        for (Secteur secteur : secteurs) {
            secteur.redimmensioner(facteur, l);
        }
        return this;
    }

    @Override
    public IForme colorier(String... couleurs) {
        // Supposons que chaque secteur doit être colorié avec une couleur différente
        for (int i = 0; i < secteurs.size() && i < couleurs.length; i++) {
            secteurs.get(i).setCouleur(couleurs[i]);
        }
        return this;
    }

    @Override
    public IForme tourner(int angle) {
        for (Secteur secteur : secteurs) {
            secteur.setAngle(secteur.getAngle() + angle);
        }
        return this;
    }

    @Override
    public IForme aligner(Alignement alignement, double cible) {
        switch (alignement) {
            case HAUT:
                centre.plus(0, cible - centre.y() + rayon);
                break;
            case BAS:
                centre.plus(0, cible - centre.y() - rayon);
                break;
            case DROITE:
                centre.plus(cible - centre.x() - rayon, 0);
                break;
            case GAUCHE:
                centre.plus(cible - centre.x() + rayon, 0);
                break;
        }
        return this;
    }

    public void createSvgFile() {
        String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Camembert.svg"))) {
            writer.write(svgContent);
            writer.write(enSVG()); // Ajout de titres, légendes et styles
            writer.write("</svg>");
            System.out.println("Fichier créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }
    @Override
    public String enSVG() {
        StringBuilder svg = new StringBuilder();
        svg.append("<svg width=\"500\" height=\"500\" xmlns=\"http://www.w3.org/2000/svg\">\n");
        svg.append("  <circle cx=\"" + centre.x() + "\" cy=\"" + centre.y() + "\" r=\"" + rayon
                + "\" fill=\"lightblue\" />\n");
        svg.append("</svg>");
        return svg.toString();
    }

    public int getNombreSecteurs() {
        // Return the number of sectors in the Camembert object
        return secteurs.size();
    }

}