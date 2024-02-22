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
    
    public Camembert(Point point, double a){
        this.centre = centre;
        this.rayon = rayon;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'description'");
    }

    @Override
    public double hauteur() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hauteur'");
    }

    @Override
    public double largeur() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'largeur'");
    }

    @Override
    public IForme deplacer(double dx, double dy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deplacer'");
    }

    @Override
    public IForme dupliquer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dupliquer'");
    }

    @Override
    public IForme redimmensioner(double h, double l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'redimmensioner'");
    }

    @Override
    public String enSVG() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enSVG'");
    }

    @Override
    public IForme colorier(String... couleurs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorier'");
    }

    @Override
    public IForme tourner(int angle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tourner'");
    }

    @Override
    public IForme aligner(Alignement alignement, double cible) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aligner'");
    }

    @Override
    public void createSvgFile() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSvgFile'");
    }

    
}
