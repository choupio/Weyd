package fr.univrennes.istic.l2gen.geometrie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.univrennes.SVGFile;

/**
 * La classe Groupe représente un groupe de formes géométriques.
 */
public class Groupe implements IForme {

    protected List<IForme> listFormes; // Liste des formes dans le groupe

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
     * Retourne le centre du groupe, calculé comme le centre moyen de toutes les
     * formes dans le groupe.
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
        String description = "Groupe :";
        for (IForme forme : listFormes) {
            description +=  "\n"+forme.description(entier) ;
        }
        return description;
    }

    /**
     * Déplace toutes les formes du groupe selon les déplacements spécifiés.
     *
     * @param dx Le déplacement en abscisse.
     * @param dy Le déplacement en ordonnée.
     * @return Une référence à l'instance actuelle du groupe, pour permettre les
     *         opérations en chaîne.
     */
    @Override
    public IForme deplacer(double dx, double dy) {
        for (IForme iForme : listFormes) {
            iForme.deplacer(dx, dy);
        }
        return this;
    }
    /**
     * Tourne toutes les formes du groupe selon l'angle spécifié.
     *
     * @param angle L'angle de rotation.
     * @return Une référence à l'instance actuelle du groupe, pour permettre les
     *         opérations en chaîne.
     */
    @Override
    public IForme tourner(int angle) {
        for (IForme iForme : listFormes) {
            iForme.tourner(angle);
        }
        return this;
    }

    /**
     * Duplique toutes les formes du groupe.
     *
     * @return Un nouveau groupe contenant des copies de toutes les formes du groupe
     *         actuel.
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
     * @return Une référence à l'instance actuelle du groupe, pour permettre les
     *         opérations en chaîne.
     */
    @Override
    public IForme redimmensioner(double h, double l) {
        for (IForme iForme : listFormes) {
            iForme.redimmensioner(h, l);
        }
        return this;
    }

    /**
     * Retourne une représentation SVG de toutes les formes du groupe.
     *
     * @return Une chaîne de caractères représentant toutes les formes du groupe en
     *         format SVG.
     */
    @Override
    public String enSVG() {
        String s = "";
        for (IForme iForme : listFormes) {
            s += iForme.enSVG();
        }
        return s;
    }

    /**
     * Colorie chaque forme dans le groupe avec les couleurs spécifiées.
     *
     * @param couleurs Un tableau de couleurs à appliquer aux formes du groupe.
     * @return Une référence à l'instance actuelle du groupe, pour permettre les
     *         opérations en chaîne.
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
        SVGFile.createSvgFile(this, "Groupe");
    }
    /**
     * Aligne les formes du groupe selon l'alignement spécifié et la cible.
     *
     * @param alignement L'alignement à appliquer.
     * @param cible      La cible sur laquelle les formes doivent être alignées.
     * @return Une référence à l'instance actuelle du groupe, pour permettre les
     *         opérations en chaîne.
     */
    @Override
    public IForme aligner(Alignement alignement, double cible) {
        if (listFormes.isEmpty()) {
            return this;
        }
        double deviationX = 0;
        double deviationY = 0;
        switch (alignement) {
            case GAUCHE:
                deviationX = cible - largeur() / 2; // Align to the left
                break;
            case DROITE:
                deviationX = cible - largeur() / 2; // Align to the right
                break;
            case HAUT:
                deviationY = cible - hauteur() / 2; // Align to the top
                break;
            case BAS:
                deviationY = cible - hauteur() / 2; // Align to the bottom
                break;
            // Add additional cases for other alignments if needed
        }
        for (IForme forme : listFormes) {
            forme.deplacer(deviationX, deviationY);
        }
        return this;
    }
    /**
     * Retourne la liste des formes dans le groupe.
     *
     * @return La liste des formes dans le groupe.
     */
    public List<IForme> getListFormes() {
        return listFormes;
    }

    /**
     * Vide ce groupe de tous ses elements
     * 
     * @return IForme : ce groupe qui ne contient plus aucun element
     */
    public IForme vider() {
        listFormes.clear();
        return this;
    }

    /**
     * @param alignement direction HAUT, BAS, DROITE, GAUCHE etc.
     * @param cible      ligne horizontale ou verticale sur laquelle
     *                   doivent s’aligner chacun des elements du groupe
     * @return IForme
     */
    public IForme alignerElements(Alignement alignement, double cible) {
        listFormes.stream().forEach(x -> x.aligner(alignement, cible));
        return this;
    }

    /**
     * @param alignement direction HAUT, BAS, DROITE, GAUCHE etc.
     * @param cible      ligne horizontale ou verticale sur laquelle
     *                   doivent s’empiler chacun des elements du groupe
     * @param separation : distance entre chaque element empile
     * @return IForme
     */
    public IForme empilerElements(Alignement alignement, double cible, double separation) {
        double cibleForme = cible;
        for (IForme iForme : listFormes) {
            iForme.aligner(alignement, cibleForme);
            if(alignement == Alignement.GAUCHE){cibleForme += iForme.largeur() + separation;}
            else if(alignement == Alignement.DROITE){cibleForme -= iForme.largeur() + separation;}
            else if(alignement == Alignement.HAUT){cibleForme += iForme.hauteur() + separation;}
            else if(alignement == Alignement.BAS){cibleForme -= iForme.hauteur() + separation;}
        }

        return this;
    }
}