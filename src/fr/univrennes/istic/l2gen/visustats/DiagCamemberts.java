package fr.univrennes.istic.l2gen.visustats;

import java.util.ArrayList;
import java.util.List;

import fr.univrennes.SVGFile;
import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;
import fr.univrennes.istic.l2gen.geometrie.Texte;

/**
 * Cette classe représente un diagramme en camembert.
 * Elle implémente l'interface IDataVisualiseur.
 */
public class DiagCamemberts implements IDataVisualiseur {

    Texte texteNom;
    String nom;
    double rayon = 100;
    Point centre = new Point(500, 500);
    List<String> couleurs;
    Groupe donnees, legendeGroupe, legendes, diagGroupe;

    /**
     * Constructeur de DiagCamemberts
     * 
     * @param nom une String représentant le nom du diagramme
     */

    public DiagCamemberts(String nom) {
        this.nom = nom;
        legendes = new Groupe();
        couleurs = new ArrayList<>();
        donnees = new Groupe();
        diagGroupe = new Groupe();
        legendeGroupe = new Groupe();
    }

    /**
     * Cette classe représente un point dans un système de coordonnées.
     */

    @Override
    public Point centre() {
        return centre;
    }

    /**
     * Renvoie la description de l'objet sous forme de chaîne de caractères.
     *
     * @param indentation Le niveau d'indentation pour la description.
     * @return La description de l'objet.
     */

    @Override
    public String description(int indentation) {
        return diagGroupe.description(indentation);
    }

    /**
     * Renvoie la hauteur du diagramme.
     *
     * @return La hauteur du diagramme.
     */

    @Override
    public double hauteur() {
        return diagGroupe.hauteur();
    }

    /**
     * Retourne la largeur du diagramme de groupe.
     *
     * @return la largeur du diagramme de groupe
     */

    @Override
    public double largeur() {
        return diagGroupe.largeur();
    }

    /**
     * L'interface IForme représente une forme géométrique.
     */

    @Override
    public IForme deplacer(double dx, double dy) {
        centre = new Point(centre.x() + dx, centre.y() + dy);
        return this;
    }

    /**
     * L'interface IForme représente une forme géométrique.
     */

    @Override
    public IForme dupliquer() {
        DiagCamemberts nouvelleForme = new DiagCamemberts(nom);
        nouvelleForme.legendes = this.legendes;
        nouvelleForme.couleurs = this.couleurs;
        nouvelleForme.donnees = this.donnees;
        nouvelleForme.diagGroupe = this.diagGroupe;
        nouvelleForme.legendeGroupe = this.legendeGroupe;
        return nouvelleForme;
    }

    /**
     * Redimensionne la forme en utilisant les dimensions spécifiées.
     *
     * @param h La hauteur de la forme.
     * @param l La largeur de la forme.
     * @return La forme redimensionnée.
     */

    @Override
    public IForme redimmensioner(double h, double l) {
        return diagGroupe.redimmensioner(h, l);
    }

    /**
     * Renvoie une représentation SVG de l'objet.
     *
     * @return une chaîne de caractères contenant le code SVG représentant l'objet.
     */

    @Override
    public String enSVG() {
        return diagGroupe.enSVG();
    }

    /**
     * Colorie la forme avec les couleurs spécifiées.
     * 
     * @param couleurs les couleurs à utiliser pour colorier la forme
     */

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

    /**
     * Effectue une rotation de la forme selon un angle donné.
     *
     * @param angle L'angle de rotation en degrés.
     * @return La forme résultante après la rotation.
     */

    @Override
    public IForme tourner(int angle) {
        return diagGroupe.tourner(angle);
    }

    /**
     * Aligne le diagramme de groupe selon l'alignement spécifié et la cible donnée.
     *
     * @param alignement L'alignement souhaité pour le diagramme de groupe.
     * @param cible      La valeur cible pour l'alignement.
     * @return Une instance de l'interface IForme représentant le diagramme de
     *         groupe aligné.
     */

    @Override
    public IForme aligner(Alignement alignement, double cible) {
        return diagGroupe.aligner(alignement, cible);
    }

    /**
     * Crée un fichier SVG pour le diagramme en camembert.
     */

    @Override
    public void createSvgFile() {
        SVGFile.createSvgFile(this, "diagCamenberts");
    }

    /**
     * Cette interface représente un visualiseur de données.
     * Un visualiseur de données est responsable de l'agencement et de l'affichage
     * des données.
     */

    @Override
    public IDataVisualiseur agencer() {

        // Titre
        texteNom = new Texte(0, 0, 12, nom);
        double axeY = donnees.getListFormes().get(0).centre().y() * 0.01;
        double axeX = donnees.getListFormes().get(0).centre().x() * 0.01;
        for (IForme forme : donnees.getListFormes()) {
            forme.deplacer(axeX, axeY);
            axeX += 250; // pour espacer les camemberts
        }
        System.out.println(donnees.getListFormes().get(0).centre().x());
        texteNom.deplacer(donnees.centre().x() - texteNom.largeur() / 2, // pour la position du titre du diagramme
                donnees.centre().y() - donnees.hauteur() / 2 - texteNom.hauteur());
        diagGroupe.ajouter(donnees);
        diagGroupe.ajouter(texteNom);
        legendeGroupe.empilerElements(Alignement.GAUCHE, donnees.centre().x() - donnees.largeur(), 10); // pour
        // l'espacement
        // entre les
        // légende de
        // couleurs
        legendeGroupe.alignerElements(Alignement.BAS,
                centre.y() + donnees.hauteur() / 2 + legendeGroupe.hauteur() * 2 + 40); // pour mettre la légende des
                                                                                        // couleurs en bas
        diagGroupe.ajouter(legendeGroupe);
        legendes.empilerElements(Alignement.GAUCHE, donnees.centre().x() - donnees.largeur(), 225); // pour espacer les
        // années
        legendes.alignerElements(Alignement.BAS,
                centre.y() + donnees.hauteur() / 2 + legendes.hauteur() * 2 + 10); // pour la position des années (en
                                                                                   // bas)
        diagGroupe.ajouter(legendes);

        return this;
    }

    /**
     * Ajoute des données à visualiser.
     *
     * @param str     Le texte associé aux données.
     * @param doubles Les valeurs numériques à visualiser.
     * @return Une instance de IDataVisualiseur mise à jour.
     */

    @Override
    public IDataVisualiseur ajouterDonnees(String str, double... doubles) {
        double somme = 0;
        for (int i = 0; i < doubles.length; i++) {
            somme += doubles[i];
        }
        Camembert cam = new Camembert(centre, rayon);
        for (int i = 0; i < doubles.length; i++) {
            cam.ajouterSecteur("white", doubles[i] / somme);
        }
        legendes.ajouter(new Texte(0, 0, 10, str));
        donnees.ajouter(cam);
        return this;
    }

    /**
     * Ajoute une légende à la visualisation.
     * 
     * @param strings Les chaînes de caractères représentant les légendes à ajouter.
     * @return Une instance de IDataVisualiseur avec la légende ajoutée.
     */
    @Override
    public IDataVisualiseur legender(String... strings) {
        for (String string : strings) {
            legendeGroupe.ajouter(new Rectangle(0, 0, 20, 7));
            legendeGroupe.ajouter(new Texte(0, 0, 10, string));
        }

        return this;
    }

    /**
     * L'interface IDataVisualiseur définit les méthodes nécessaires pour visualiser
     * les données.
     */
    @Override
    public IDataVisualiseur setOption(String... options) {

        for (String option : options) {
            // Traitez chaque option individuellement
            if (option.equals("Camembert supplémentaire")) {
                Camembert cam2 = new Camembert(centre, rayon);
                cam2.ajouterSecteur("blue", 0.2);
                donnees.ajouter(cam2);
            } else if (option.equals("Ajouter une légende supplémentaire au camembert")) {
                legendeGroupe.ajouter(new Rectangle(0, 0, 20, 7));
                legendeGroupe.ajouter(new Texte(0, 0, 10, "Légende supplémentaire"));
            } else if (option.equals("Supprimer un camembert")) {
                donnees.getListFormes().remove(0);
            }
        }

        return this;
    }

}