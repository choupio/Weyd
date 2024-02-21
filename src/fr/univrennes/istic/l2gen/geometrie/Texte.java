package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Texte implements IForme {
    private String couleur, texte;
    private double x;
    private double y;
    private double hauteur;
    private double largeur;
    private double taille;

    // Bloc d'initialisation
    {
        couleur = "white";
        hauteur = 20.0;
        largeur = 0.0;
    }

    public Texte(double x, double y, double taille, String texte) {
        this.x = x;
        this.y = y;
        this.taille = taille;
        this.texte = texte;
    }

    public Texte() {
        this(0, 0, 0, "");
    }

    @Override
    public Point centre() {
        return new Point(0, 0);
    }

    @Override
    public double hauteur() {
        return hauteur;
    }

    @Override
    public double largeur() {
        return largeur;
    }

    @Override
    public IForme deplacer(double dx, double dy) {
        // Logique pour déplacer le texte
        x += dx;
        y += dy;
        return new Texte().colorier(couleur); // Retourne la référence à la forme modifiée
    }

    @Override
    public IForme dupliquer() {
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        Texte nouvelleForme = new Texte();
        nouvelleForme.couleur = this.couleur;
        nouvelleForme.x = this.x;
        nouvelleForme.y = this.y;
        nouvelleForme.hauteur = this.hauteur;
        nouvelleForme.largeur = this.largeur;
        return nouvelleForme;
    }// Crée une nouvelle instance de la classe avec les mêmes propriétés

    @Override
    public String description(int indentation) {
        // Génère une description avec un certain niveau d'indentation
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indentation; i++) {
            sb.append("  ");
        }
        sb.append("Forme de couleur ").append(couleur);
        return sb.toString();
    }

    @Override
    public String enSVG() {
        // Génère la représentation SVG du texte avec les dimensions mises à jour
        return "<text x=\"" + x + "\" y=\"" + y +
                "\" font-size=\"" + taille + "\" text-anchor=\"middle\" fill=\"" + couleur
                + "\" stroke=\"black\">" + texte + "</text>";
    }

    public IForme colorier(String... couleurs) {
        couleur = couleurs[0];
        return this;
    }

    @Override
    public IForme redimmensioner(double h, double l) {
        hauteur = h;
        largeur = l;
        return this;

    }

    @Override
    public void createSvgFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.svg"))) {
            writer.write("<svg width=\"" + largeur + "\" height=\"" + hauteur + "\">\n");
            writer.write(enSVG() + "\n");
            writer.write("</svg>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
