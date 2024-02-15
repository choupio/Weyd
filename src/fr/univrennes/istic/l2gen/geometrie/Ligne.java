package fr.univrennes.istic.l2gen.geometrie;

import java.io.File;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Ligne implements IForme {
    private Point[] ligne;
    private String couleur;

    // Bloc d'initialisation
    {
        couleur = "black";
    }

    public Ligne(double... l) {
        ligne = new Point[l.length / 2];
        int j = 0;
        for (int i = 0; i < l.length; i = i + 2) {
            ligne[j] = new Point(l[i], l[i + 1]);
            j++;
        }
    }

    public void ajouterSommet(Point p) {
        Point[] temp = ligne;
        ligne = new Point[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            ligne[i] = temp[i];
        }
        ligne[ligne.length - 1] = p;
    }

    public void ajouterSommet(double x, double y) {
        ajouterSommet(new Point(x, y));
    }

    public Point centre() {
        return ligne[ligne.length - 1];
    }

    public String description(int identation) {
        String result = "Ligne";
        String identa = "";
        for (int i = 0; i < identation; i++) {
            identa = identa + " ";
        }
        for (int i = 0; i < ligne.length; i++) {
            result = result + identa + ligne[i].x() + ',' + ligne[i].y();
        }
        return result;
    }

    public List<Double> getSommets() {
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < ligne.length; i++) {
            result.add(ligne[i].x());
            result.add(ligne[i].y());
        }
        return result;
    }

    public double hauteur() {
        return ligne[ligne.length - 1].y() - ligne[0].y();
    }

    public double largeur() {
        return ligne[ligne.length - 1].x() - ligne[0].x();
    }

    public String enSVG() {
        String result = "<polyline points=\"";
        result = result + ligne[0].x() + ' ' + ligne[0].y() + ' ';
        for (int i = 1; i < ligne.length; i++) {
            result = result + ligne[i].y() + ' ' + ligne[i].y() + ' ';
        }
        result = result + "\" fill=\"white\" stroke=\"" + couleur + "\"";
        return result;
    }

    @Override
    public void deplacer(double dx, double dy) {
        for (int i = 0; i < ligne.length; i++) {
            ligne[i] = new Point(ligne[i].x() + dx, ligne[i].y() + dy);
        }
    }

    @Override
    public IForme dupliquer() {
        List <Double> li = this.getSommets();
        Ligne l2=new Ligne(li.getFirst(),li.get(1));
        while(!li.isEmpty()){
            
        }

        return l2;
    }

    @Override
    public void redimmensioner(double h, double l) {
        for (int i = 0; i < ligne.length; i++) {
            ligne[i] = new Point(ligne[i].x() * h, ligne[i].y() * l);
        }
    }
    @Override
    public void colorier(String... couleurs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'colorier'");
    }
}