package fr.univrennes.istic.l2gen.geometrie.visustats;

import java.util.ArrayList;
import java.util.List;

import fr.univrennes.SVGFile;
import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Texte;

public class DiagColonnes implements IDataVisualiseur {
    Texte texteNom;
    String nom;
    List<String> legendes, couleurs;
    List<Faisceau> donnees;

    public DiagColonnes(String nom) {
        this.nom = nom;
        legendes = new ArrayList<>();
        couleurs = new ArrayList<>();
        donnees = new ArrayList<>();
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
        String s = "";
        for (Faisceau f : donnees) {
            s += f.enSVG();
        }
        return s;
    }

    @Override
    public IForme colorier(String... couleurs) {
        int i = 0;
        for (IForme faisceau : donnees) {
            faisceau.colorier(couleurs);
            i++;
            if (i >= couleurs.length) {
                i = 0;
            }
        }
        return this;
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
        SVGFile.createSvgFile(this, "diagColonnes");
    }

    @Override
    public IDataVisualiseur agencer() {
        double axeX = 20;
        for (Faisceau faisceau : donnees) {
            faisceau.agencer(axeX, 500, 100, 0.01, false); // TODO il faut modifier axeX et lergeur
            axeX += 120;
        }
        texteNom = new Texte(100 / 2, 0, 0, nom);
        return this;
    }

    @Override
    public IDataVisualiseur ajouterDonnees(String str, double... doubles) {
        donnees.add(new Faisceau(str, doubles));
        return this;
    }

    @Override
    public IDataVisualiseur legender(String... strings) {
        for (String string : strings) {
            legendes.add(string);
        }
        return this;
    }

    @Override
    public IDataVisualiseur setOption(String... strings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOption'");
    }

}
