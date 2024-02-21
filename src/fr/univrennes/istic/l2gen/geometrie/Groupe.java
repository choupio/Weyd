package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Groupe représente un groupe de formes géométriques.
 */
public class Groupe implements IForme {

    private List<IForme> listFormes; // Liste des formes dans le groupe

    /**
     * Constructeur de la classe Groupe prenant en paramètre un tableau de formes.
     *
     * @param listFormes Un tableau de formes à ajouter au groupe.
     */
    public Groupe(IForme... listFormes) {
        this.listFormes = new ArrayList<>();
        for (IForme iForme : listFormes) {
            this.listFormes.add(iForme);
        }
    }

    /**
     * Ajoute une nouvelle forme au groupe.
     *
     * @param nouvelleForme La forme à ajouter au groupe.
     * @return Le groupe avec la nouvelle forme ajoutée.
     */
    public Groupe ajouter(IForme nouvelleForme) {
        listFormes.add(nouvelleForme);
        return this;
    }

    /**
     * Retourne le centre du groupe, calculé comme le centre moyen de toutes les formes dans le groupe.
     *
     * @return Le centre du groupe.
     */
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

    /**
     * Retourne la hauteur maximale parmi toutes les formes du groupe.
     *
     * @return La hauteur maximale parmi toutes les formes du groupe.
     */
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

    /**
     * Retourne la largeur maximale parmi toutes les formes du groupe.
     *
     * @return La largeur maximale parmi toutes les formes du groupe.
     */
    @Override
    public double largeur() {
        if (listFormes.isEmpty()) {
            return 0;
        }
        double largeurMax = listFormes.get(0).largeur();
        for (IForme forme : listFormes) {
            double largeurForme = forme.largeur();
            if (largeurForme > largeurMax) {
                largeurMax = largeurForme;
            }
        }
        return largeurMax;
    }

    /**
     * Retourne une description du groupe.
     *
     * @param entier Le niveau d'indentation.
     * @return Une chaîne de caractères décrivant le groupe et ses formes.
     */
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

    /**
     * Déplace toutes les formes du groupe selon les déplacements spécifiés.
     *
     * @param dx Le déplacement en abscisse.
     * @param dy Le déplacement en ordonnée.
     * @return Une référence à l'instance actuelle du groupe, pour permettre les opérations en chaîne.
     */
    @Override
    public IForme deplacer(double dx, double dy) {
        for (IForme iForme : listFormes) {
            iForme.deplacer(dx, dy);
        }
        return this;
    }

    @Override
    public IForme tourner(int angle) {

        return this;
    }

    /**
     * Duplique toutes les formes du groupe.
     *
     * @return Un nouveau groupe contenant des copies de toutes les formes du groupe actuel.
     */
    @Override
    public IForme dupliquer() {
        Groupe groupe = new Groupe();
        for (IForme iForme : listFormes) {
            groupe.ajouter(iForme.dupliquer());
        }
        return groupe;
    }

    /**
     * Redimensionne toutes les formes du groupe.
     *
     * @param h La hauteur de redimensionnement.
     * @param l La largeur de redimensionnement.
     * @return Une référence à l'instance actuelle du groupe, pour permettre les opérations en chaîne.
     */
    @Override
    public IForme redimmensioner(double h, double l) {
        listFormes.forEach(x -> x.redimmensioner(h, l));
        return this;
    }

    /**
     * Retourne une représentation SVG de toutes les formes du groupe.
     *
     * @return Une chaîne de caractères représentant toutes les formes du groupe en format SVG.
     */
    @Override
    public String enSVG() {
        String s = "<g>\n";
        for (IForme iForme : listFormes) {
            s += iForme.enSVG() + "\n";
        }
        s += "</g>";
        return s;
    }

    /**
     * Colorie chaque forme dans le groupe avec les couleurs spécifiées.
     *
     * @param couleurs Un tableau de couleurs à appliquer aux formes du groupe.
     * @return Une référence à l'instance actuelle du groupe, pour permettre les opérations en chaîne.
     */
    public IForme colorier(String... couleurs) {
        int i = 0;
        for (IForme forme : listFormes) {
            forme.colorier(couleurs[i]);
            i++;
            if (i >= listFormes.size()) {
                i = 0;
            }
        }
        return this;
    }

    /**
     * Crée un fichier SVG représentant toutes les formes du groupe.
     */
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