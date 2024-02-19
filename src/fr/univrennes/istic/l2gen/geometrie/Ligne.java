package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public IForme ajouterSommet(Point p) {
        Point[] temp = ligne;
        ligne = new Point[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            ligne[i] = temp[i];
        }
        ligne[ligne.length - 1] = p;
        return this;
    }

    public IForme ajouterSommet(double x, double y) {
        ajouterSommet(new Point(x, y));
        return this;
    }

    public Point centre() {
        return ligne[ligne.length - 1];
    }

    public String description(int identation) {
        String result ;
        String identa = "";
        for (int i = 0; i < identation; i++) {
            identa += "  ";
        }
        result= identa+"Ligne";
        for (int i = 0; i < ligne.length; i++) {
            result = result +" "+ ligne[i].x() + ',' + ligne[i].y() + " de couleur" + colorier(couleur);
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
        result = result + "\" fill=\"white\" stroke=\"" + couleur + "\"/>";
        return result;
    }

    @Override
    public IForme deplacer(double dx, double dy) {
        for (int i = 0; i < ligne.length; i++) {
            ligne[i] = new Point(ligne[i].x() + dx, ligne[i].y() + dy);
        }
        return this;
    }

    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        return this;
    }

    @Override
    public IForme redimmensioner(double h, double l) {
        for (int i = 1; i < ligne.length; i++) {
            ligne[i] = new Point(ligne[i].x() + h, ligne[i].y() + l);
        }
        return this;
    }
    @Override
    public IForme colorier(String... couleurs) {
        this.couleur=couleurs[0];
        return this;
    }
    public void createSvgFile() {
    String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";
    

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/l2gen_5_coupdumarteau/src/fr/univrennes/istic/l2gen/geometrie/Ligne.svg"))) {
            writer.write(svgContent);
            writer.write(enSVG());
            writer.write("</svg>");
            System.out.println("Fichier créé avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
        }
    }
}