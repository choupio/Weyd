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

public class Camembert implements IForme {

    private Point centre;
    private double rayon;
    private List<Secteur> secteurs;
    private double angle;
    private String couleur = "white";

    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    public String getCouleurSecteur(int numeroSecteur) {
        if (numeroSecteur < 0 || numeroSecteur >= secteurs.size()) {
            throw new IllegalArgumentException("Numéro de secteur invalide");
        }
        return secteurs.get(numeroSecteur).couleur;
    }

    public Camembert(Point point, double a) {
        this.centre = point;
        this.rayon = a;
        this.secteurs = new ArrayList<>();
    }

    public Camembert(double x, double y, double rayon) {
        this(new Point(x, y), rayon);
    }

    public Camembert ajouterSecteur(String description, double proportion) {
        double angleDebut = angle;
        double angleFin = 360 * proportion;
        Secteur secteur = new Secteur(centre, rayon, angleDebut, angleFin);
        secteur.colorier();
        secteurs.add(secteur);
        angle = angleFin;
        return this;
    }

    @Override
    public Point centre() {
        return centre;
    }

    @Override
    public String description(int indentation) {
        String indent = "";
        for (int i = 0; i < indentation; i += 1) {
            indent += " ";
        }
        StringBuilder sb = new StringBuilder(indent + "Camembert:\n");
        sb.append(indent + "  Centre: ").append(centre.x() + "," + centre.y()).append("\n");
        sb.append(indent + "  Rayon: ").append(rayon).append("\n");
        sb.append(indent + "  Secteurs:\n");

        for (Secteur secteur : secteurs) {
            sb.append(secteur.description(indentation + 2) + "\n");
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
        throw new IllegalArgumentException("Les dimensions doivent être positives");
    }
         /*
        double facteur = Math.min(h / hauteur(), l / largeur());
        rayon *= facteur;
        for (Secteur secteur : secteurs) {
            secteur.redimmensioner(facteur);
        }
        return this;
    }*/ 

    

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

    public String enSVG() {
        StringBuilder svg = new StringBuilder();
        svg.append("<svg width=\"500\" height=\"500\" xmlns=\"http://www.w3.org/2000/svg\">\n");
        svg.append("  <circle cx=\"" + centre.x() + "\" cy=\"" + centre.y() + "\" r=\"" + rayon + "\" fill=\"lightblue\" />\n");
        svg.append("</svg>");
        return "<circle cx=\"" + centre.x() + "\" cy=\"" + centre.y() + "\" r=\"" + rayon + "\" fill=\"lightblue\" />\n";
    }

    public int getNombreSecteurs() {
        // Return the number of sectors in the Camembert object
        return secteurs.size();
    }

}
