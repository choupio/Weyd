package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Texte implements IForme{
    private String couleur;

    // Bloc d'initialisation
    {
        couleur = "white";
    }

    @Override
    public Point centre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'centre'");
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
        // Crée une nouvelle instance de la classe avec les mêmes propriétés
        Texte nouvelleForme = new Texte();
        nouvelleForme.couleur = this.couleur;  // Copie de la couleur, ajustez selon vos besoins
        return nouvelleForme;
    }

    @Override
    public String description(int indentation) {
        // Génère une description avec un certain niveau d'indentation
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indentation; i++) {
            sb.append("  ");  // Deux espaces par niveau d'indentation, ajustez selon vos préférences
        }
        sb.append("Forme de couleur ").append(couleur);  // Ajoutez d'autres détails au besoin
        return sb.toString();
    }

    @Override
    public IForme redimmensioner(double h, double l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'redimmensioner'");
    }

    @Override
    public String enSVG() {
        // Génère la représentation SVG du texte
        return "<text x=\"" + hauteur() + "\" y=\"" + largeur() + "\" font-size=\"64\" text-anchor=\"middle\" fill=\"black\" stroke=\"black\">Istic L2GEN</text>";
    }    

    public IForme colorier(String... couleurs) {
        couleur = couleurs[0];
        return this;
    }

    public void createSvgFile() {
        throw new UnsupportedOperationException("Unimplemented method 'createSvgFile'");
    }
}
