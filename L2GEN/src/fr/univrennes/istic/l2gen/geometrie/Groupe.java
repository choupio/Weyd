package fr.univrennes.istic.l2gen.geometrie;

import java.util.ArrayList;
import java.util.List;

public class Groupe implements IForme {
    private List<IForme> listFormes;

    public Groupe(IForme... listFormes) {
        this.listFormes = new ArrayList<>();
        for (IForme iForme : listFormes) {
            this.listFormes.add(iForme);
        }
    }

    public Groupe ajouter(IForme nouvelleForme) {
        listFormes.add(nouvelleForme);
        return this;
    }

    @Override
    public Point centre() {
        if (formes.length == 0) {
            return null;
        }
        double centreX = 0.0;
        double centreY = 0.0;
        for (IForme forme : formes) {
            Point centreForme = forme.centre();
            centreX += centreForme.x();
            centreY += centreForme.y();
        }
        centreX /= formes.length;
        centreY /= formes.length;
        return new Point(centreX, centreY);
    }

    @Override
    public double hauteur() {
        if (formes.length == 0) {
            return 0;
        }
        double hauteurMax = formes[0].hauteur();
        for (IForme forme : formes) {
            double hauteurForme = forme.hauteur();
            if (hauteurForme > hauteurMax) {
                hauteurMax = hauteurForme;
            }
        }
        return hauteurMax;
    }

    @Override
    public double largeur() {
        if (formes.length == 0) {
            return 0;
        }
        double largeurMax = formes[0].largeur();
        for (IForme forme : formes) {
            double largeurForme = forme.largeur();
            if (largeurForme > largeurMax) {
                largeurMax = largeurForme;
            }
        }
        return largeurMax;
    }

    @Override
    public String description(int entier) {
        if (listFormes.length == 0) {
            return "Groupe vide.";
        }
        String indentation = "";
        for (int i = 0; i < entier; i++) {
            indentation += " ";
        }
        String description = indentation + "Groupe :\n";
        for (IForme forme : listFormes) {
            description += forme.description(entier + 2) + "\n";
        }
        return description;
    }

    @Override
    public void deplacer(double dx, double dy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deplacer'");
    }

    @Override
    public IForme dupliquer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dupliquer'");
    }

    @Override
    public void redimmensioner(double h, double l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'redimmensioner'");
    }

    @Override
    public String enSVG() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enSVG'");
    }

}