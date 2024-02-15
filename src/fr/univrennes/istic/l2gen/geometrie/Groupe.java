package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
        if (listFormes.isEmpty()) {
            return null;
        }
        double centreX = 0.0;
        double centreY = 0.0;
        for (IForme forme : listFormes) {
            Point centreForme = forme.centre();
            centreX += centreForme.x();
            centreY += centreForme.y();
        }
        centreX /= listFormes.size();
        centreY /= listFormes.size();
        Point centre = new Point(centreX, centreY);
        return centre;
    }

    @Override
    public double hauteur() {
        if (listFormes.size() == 0) {
            return 0;
        }
        double hauteurMax = listFormes.get(0).hauteur();
        for (IForme forme : listFormes) {
            double hauteurForme = forme.hauteur();
            if (hauteurForme > hauteurMax) {
                hauteurMax = hauteurForme;
            }
        }
        return hauteurMax;
    }

    @Override
    public double largeur() {
        if (listFormes.isEmpty()) {
            return 0;
        }
        double largeurMax = listFormes.get(0).hauteur();
        for (IForme forme : listFormes) {
            double largeurForme = forme.largeur();
            if (largeurForme > largeurMax) {
                largeurMax = largeurForme;
            }
        }
        return largeurMax;
    }

    @Override
    public String description(int entier) {
        if (listFormes.size() == 0) {
            return "Le groupe est vide.";
        }
        String description = "Groupe : \n";
        for (IForme forme : listFormes) {
            description += forme.description(entier) + "\n";
        }
        return description;
    }

    @Override
    public void deplacer(double dx, double dy) {
        for (IForme iForme : listFormes) {
            iForme.deplacer(dx, dy);
        }
    }

    @Override
    public IForme dupliquer() {
        Groupe groupe = new Groupe();
        for (IForme iForme : listFormes) {
            groupe.ajouter(iForme.dupliquer());
        }
        return groupe;
    }

    @Override
    public void redimmensioner(double h, double l) {
        listFormes.stream().forEach(x -> x.redimmensioner(h, l));
    }

    @Override
    public String enSVG() {
        String s = "";
        s += "<g>\n";
        for (IForme iForme : listFormes) {
            s += iForme.enSVG() + "\n";
        }
        s += "</g>";
        return s;
    }

    public void colorier(String... couleurs) {
        int i = 0;
        for (IForme forme : listFormes) {
            forme.colorier(couleurs[i]);
            i++;
            if(i>= listFormes.size()) {i=0;}
        }
    }
    public void createSvgFile() {
        String svgContent = "<svg xmlns=\"http://www.w3.org/2000/svg\">\n";
        
    
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Groupe.svg"))) {
                writer.write(svgContent);
                writer.write(enSVG());
                writer.write("</svg>");
                System.out.println("Fichier créé avec succès !");
            } catch (IOException e) {
                System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
            }
        }


}