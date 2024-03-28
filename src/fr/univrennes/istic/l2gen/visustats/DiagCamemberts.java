package fr.univrennes.istic.l2gen.visustats;

import java.util.ArrayList;
import java.util.List;

import fr.univrennes.SVGFile;
import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Ligne;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;
import fr.univrennes.istic.l2gen.geometrie.Secteur;
import fr.univrennes.istic.l2gen.geometrie.Texte;

/**
 * Cette classe représente un diagramme en camembert.
 * Elle implémente l'interface IDataVisualiseur.
 */
public class DiagCamemberts implements IDataVisualiseur {
    Texte texteNom;
    String nom;
    double rayon = 300;
    Point centre = new Point(100,100);
    List<String> legendes, couleurs;
    Groupe donnees, legendeGroupe, diagGroupe;

    /**
     * Constructeur de DiagCamemberts
     * 
     * @param nom    une String représentant le nom du diagramme
     */
    public DiagCamemberts(String nom) {
        this.nom = nom;
        legendes = new ArrayList<>();
        couleurs = new ArrayList<>();
        donnees = new Groupe();
        diagGroupe = new Groupe();
        legendeGroupe = new Groupe();
    }

    @Override
    public Point centre() {
        return centre;
    }

    @Override
    public String description(int indentation) {
        return diagGroupe.description(indentation);
    }

    @Override
    public double hauteur() {
        return diagGroupe.hauteur();
    }

    @Override
    public double largeur() {
        return diagGroupe.largeur();
    }

    @Override
    public IForme deplacer(double dx, double dy) {
        diagGroupe.deplacer(dx, dy);
        return diagGroupe;
    }

    @Override
    public IForme dupliquer() {
        return diagGroupe.dupliquer();
    }

    @Override
    public IForme redimmensioner(double h, double l) {
        return diagGroupe.redimmensioner(h, l);
    }

    @Override
    public String enSVG() {
        return diagGroupe.enSVG();
    }

    @Override
    public IForme colorier(String... couleurs) {
        for (IForme secteur : donnees.getListFormes()) {
            secteur.colorier(couleurs);
        }

        int i = 0;
        for (IForme forme : legendeGroupe.getListFormes()) {
            if (forme instanceof Rectangle) {
                forme.colorier(couleurs[i]);
                i++;
                if (i >= couleurs.length) {
                    i = 0;
                }
            }

        }

        return this;
    }

    @Override
    public IForme tourner(int angle) {
        return diagGroupe.tourner(angle);
    }

    @Override
    public IForme aligner(Alignement alignement, double cible) {
        return diagGroupe.aligner(alignement, cible);
    }

    @Override
    public void createSvgFile() {
        SVGFile.createSvgFile(this, "diagCamenberts");
    }

    @Override
    public IDataVisualiseur agencer() {
        // Titre
        texteNom = new Texte(0, 0, 20, nom);

        double axeY = donnees.getListFormes().get(0).centre().y() * 0.01;
        double axeX = donnees.getListFormes().get(0).centre().x() * 0.01;
        for (IForme forme : donnees.getListFormes()) {
<<<<<<< HEAD
            forme.deplacer(axeX, axeY);
            axeX += 20;
        }

        texteNom.deplacer(centre.x(),
                centre.y() - donnees.hauteur() / 2 - texteNom.hauteur());
=======
            if (axeY < forme.hauteur() * 0.01) {
                axeY = forme.hauteur() * 0.01;
            }
        }
        double axeX = 20;
        for (IForme camembert : donnees.getListFormes()) {
            Secteur f = (Secteur) secteur;
            s.agencer(axeX, axeY + texteNom.hauteur() * 2, 100, 0.01, false);
            axeX += 120;
        }

        texteNom.deplacer(donnees.centre().x(),
                donnees.centre().y() - donnees.hauteur() / 2 - texteNom.hauteur());
>>>>>>> 7d6cc66cc83fa6dfcb1fcfec8fa24d8123a92a70
        diagGroupe.ajouter(donnees);
        diagGroupe.ajouter(texteNom);

        // Groupe pour les légendes
        legendeGroupe.empilerElements(Alignement.GAUCHE, centre.x() - legendeGroupe.largeur(), 10);
        legendeGroupe.alignerElements(Alignement.BAS,
                centre.y() + donnees.hauteur() / 2 + legendeGroupe.hauteur() * 2);
        diagGroupe.ajouter(legendeGroupe);
<<<<<<< HEAD
        System.out.println(centre.y()-donnees.hauteur()/2);
        // Echelle
=======
        System.out.println(donnees.centre().y() - donnees.hauteur() / 2);
        // Echelle
        diagGroupe.ajouter(new Ligne(donnees.centre().x() - donnees.largeur() / 2,
                donnees.centre().y() + donnees.hauteur() / 2,
                donnees.centre().x() + donnees.largeur() / 2,
                donnees.centre().y() + donnees.hauteur() / 2));
>>>>>>> 7d6cc66cc83fa6dfcb1fcfec8fa24d8123a92a70

        return this;
    }

    @Override
    public IDataVisualiseur ajouterDonnees(String str, double... doubles) {
        double somme = 0;
        for (int i = 0; i < doubles.length; i++) {
            somme += doubles[i];
        }
<<<<<<< HEAD
        Camembert cam = new Camembert(centre, rayon);
        for(int i = 0;i<doubles.length;i++){
            cam.ajouterSecteur("white", doubles[i]/somme);
        }        
        donnees.ajouter(cam);
=======
        Camembert cam = new Camembert(centre(), rayon);
        for (int i = 0; i < doubles.length; i++) {
            cam.ajouterSecteur("white", doubles[i] / somme);
        }
        donnees.ajouter(cam);

>>>>>>> 7d6cc66cc83fa6dfcb1fcfec8fa24d8123a92a70
        return this;
    }

    @Override
    public IDataVisualiseur legender(String... strings) {
        for (String string : strings) {
            legendeGroupe.ajouter(new Rectangle(0, 0, 20, 7));
            legendeGroupe.ajouter(new Texte(0, 0, 10, string));
        }

        return this;
    }

    @Override
    public IDataVisualiseur setOption(String... strings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOption'");
    }

}