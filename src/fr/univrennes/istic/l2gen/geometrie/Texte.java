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
