package fr.univrennes.istic.l2gen.geometrie.visustats;

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

    @Override
    public Point centre() {
        return centre;
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
        secteurs.add(new Secteur(description, proportion));
        return this;
    }

    @Override
    public String description(int indentation) {
        String indent = " ".repeat(indentation);
        StringBuilder sb = new StringBuilder(indent + "Camembert:\n");
        sb.append(indent + "  Centre: " + centre + "\n");
        sb.append(indent + "  Rayon: " + rayon + "\n");
        sb.append(indent + "  Secteurs:\n");
        for (Secteur secteur : secteurs) {
            sb.append(secteur.description(indentation + 2));
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'redimmensioner'");
    }

    @Override
    public String enSVG() {
        StringBuilder svg = new StringBuilder();
        svg.append(String.format("<circle cx=\"%f\" cy=\"%f\" r=\"%f\" />\n", centre.x(), centre.y(), rayon));

        double angleDebut = 0;
        for (Secteur secteur : secteurs) {
            double angleFin = angleDebut + (secteur.proportion * 360);
            svg.append(String.format("<path d=\"%s\" />\n", secteur.enSVG()));
            angleDebut = angleFin;
        }

        return svg.toString();
    }

    @Override
    public IForme colorier(String... couleurs) {
        // Supposons que chaque secteur doit être colorié avec une couleur différente
        for (int i = 0; i < secteurs.size() && i < couleurs.length; i++) {
            secteurs.get(i).setCouleur(couleurs[i]);
        }
        return this;
    }

    public IForme tourner(int angle) {
        for (Secteur secteur : secteurs) {
            secteur.setRotation(secteur.getRotation() + angle);
        }
        return this;
    }

    @Override
    public IForme aligner(Alignement alignement, double cible) {
        switch (alignement) {
            case HAUT:
                centre = new Point(centre.x(), cible + rayon);
                break;
            case BAS:
                centre = new Point(centre.x(), cible - rayon);
                break;
            case DROITE:
                centre = new Point(cible + rayon, centre.y());
                break;
            case GAUCHE:
                centre = new Point(cible - rayon, centre.y());
                break;
        }
        return this;
    }

    @Override
    public void createSvgFile() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSvgFile'");
    }

}
