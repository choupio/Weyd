package fr.univrennes.istic.l2gen.visustats;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import fr.univrennes.SVGFile;
import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Ligne;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;
import fr.univrennes.istic.l2gen.geometrie.Texte;

public class DiagColonnes implements IDataVisualiseur {
    Texte texteNom;
    String nom;
    List<String> legendes, couleurs;
    Groupe donnees, legendeGroupe, diagGroupe;
    double echelle_max;

    public DiagColonnes(String nom) {
        this.nom = nom;
        legendes = new ArrayList<>();
        couleurs = new ArrayList<>();
        donnees = new Groupe();
        diagGroupe = new Groupe();
        legendeGroupe = new Groupe();
    }

    /**
     * Retourne le centre du diagramme.
     */
    @Override
    public Point centre() {
        return diagGroupe.centre();
    }

    /**
     * Retourne une description du diagramme.
     * 
     * @param indentation L'indentation de la description.
     */
    @Override
    public String description(int indentation) {
        return diagGroupe.description(indentation);
    }

    /**
     * Retourne la hauteur du diagramme.
     */
    @Override
    public double hauteur() {
        return diagGroupe.hauteur();
    }

    /**
     * Retourne la largeur du diagramme.
     */
    @Override
    public double largeur() {
        return diagGroupe.largeur();
    }

    /**
     * Déplace le diagramme selon les valeurs spécifiées.
     * 
     * @param dx La distance de déplacement en x.
     * @param dy La distance de déplacement en y.
     */
    @Override
    public IForme deplacer(double dx, double dy) {
        diagGroupe.deplacer(dx, dy);
        return diagGroupe;
    }

    /**
     * Duplique le diagramme.
     */
    @Override
    public IForme dupliquer() {
        DiagColonnes nouvelleForme = new DiagColonnes(nom);
        nouvelleForme.legendes = this.legendes;
        nouvelleForme.couleurs = this.couleurs;
        nouvelleForme.donnees = this.donnees;
        nouvelleForme.diagGroupe = this.diagGroupe;
        nouvelleForme.legendeGroupe = this.legendeGroupe;
        return nouvelleForme;
    }

    /**
     * Redimensionne le diagramme.
     * 
     * @param h La nouvelle hauteur.
     * @param l La nouvelle largeur.
     */
    @Override
    public IForme redimmensioner(double h, double l) {
        return diagGroupe.redimmensioner(h, l);
    }

    /**
     * Convertit le diagramme en SVG.
     */
    @Override
    public String enSVG() {
        return diagGroupe.enSVG();
    }

    /**
     * Colorie le diagramme avec les couleurs spécifiées.
     * 
     * @param couleurs Les couleurs à appliquer.
     */
    @Override
    public IForme colorier(String... couleurs) {
        for (IForme faisceau : donnees.getListFormes()) {
            faisceau.colorier(couleurs);
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
     * Fait tourner le diagramme selon l'angle spécifié.
     * 
     * @param angle L'angle de rotation.
     */
    @Override
    public IForme tourner(int angle) {
        return diagGroupe.tourner(angle);
    }

    /**
     * Aligne le diagramme selon l'alignement et la cible spécifiés.
     * 
     * @param alignement L'alignement.
     * @param cible      La cible.
     */
    @Override
    public IForme aligner(Alignement alignement, double cible) {
        return diagGroupe.aligner(alignement, cible);
    }

    /**
     * Crée un fichier SVG pour le diagramme.
     */
    @Override
    public void createSvgFile() {
        SVGFile.createSvgFile(this, "diagColonnes");
    }

    /**
     * Agence le diagramme.
     * 
     * @return L'instance de IDataVisualiseur agencée.
     */
    @Override
    public IDataVisualiseur agencer() {
        // Titre
        texteNom = new Texte(0, 0, 20, nom);

        double axeY = donnees.getListFormes().get(0).hauteur() * 200 / echelle_max;
        for (IForme forme : donnees.getListFormes()) {
            if (axeY < forme.hauteur() * 200 / echelle_max) {
                axeY = forme.hauteur() * 200 / echelle_max;
            }
        }
        double axeX = 50;
        for (IForme faisceau : donnees.getListFormes()) {
            Faisceau f = (Faisceau) faisceau;
            f.agencer(axeX, axeY + texteNom.hauteur() * 2, legendes.size() * 30, 200 / echelle_max, false);
            axeX += legendes.size() * 30 + 40;

            // Ajout des noms des faisceaux
            Texte nomFaisceau = new Texte(f.centre().x(), f.centre().y() - f.hauteur() / 2 - 10, 10, f.getNom());
            diagGroupe.ajouter(nomFaisceau);
        }

        texteNom.deplacer(donnees.centre().x(),
                donnees.centre().y() - donnees.hauteur() / 2 - texteNom.hauteur());
        diagGroupe.ajouter(donnees);
        diagGroupe.ajouter(texteNom);

        // Groupe pour les légendes
        legendeGroupe.empilerElements(Alignement.GAUCHE, donnees.centre().x() - legendeGroupe.largeur(), 10);
        legendeGroupe.alignerElements(Alignement.BAS,
                donnees.centre().y() + donnees.hauteur() / 2 + legendeGroupe.hauteur() * 2);
        diagGroupe.ajouter(legendeGroupe);

        // Echelle
        // Barre horizontale
        diagGroupe.ajouter(new Ligne(donnees.centre().x() - donnees.largeur() / 2,
                donnees.centre().y() + donnees.hauteur() / 2,
                donnees.centre().x() + donnees.largeur() / 2,
                donnees.centre().y() + donnees.hauteur() / 2));
        // Barre verticale
        diagGroupe.ajouter(new Ligne(donnees.centre().x() - donnees.largeur() / 2,
                donnees.centre().y() - donnees.hauteur() / 2,
                donnees.centre().x() - donnees.largeur() / 2,
                donnees.centre().y() + donnees.hauteur() / 2));
        // Valeurs
        int tailleTxtLegende = 10;
        for (int i = 0; i <= 5; i++) {
            diagGroupe.ajouter(new Ligne(donnees.centre().x() - donnees.largeur() / 2 - 5,
                    donnees.centre().y() - donnees.hauteur() / 2 + donnees.hauteur() * i / 5,
                    donnees.centre().x() - donnees.largeur() / 2 + 5,
                    donnees.centre().y() - donnees.hauteur() / 2 + donnees.hauteur() * i / 5));
            DecimalFormat df = new DecimalFormat("#.##");
            Texte valeurTxt = new Texte(0, 0, tailleTxtLegende,
                    df.format(echelle_max * (5 - i) / 5));
            valeurTxt.deplacer(
                    donnees.centre().x() - donnees.largeur() / 2 - 5 - valeurTxt.largeur() / 2,
                    donnees.centre().y() - donnees.hauteur() / 2 + donnees.hauteur() * i / 5);
            diagGroupe.ajouter(valeurTxt);
        }

        return this;
    }

    /**
     * Ajoute des données au diagramme.
     * 
     * @param str     La chaîne de données.
     * @param doubles Les valeurs des données.
     * @return L'instance de IDataVisualiseur avec les données ajoutées.
     */
    @Override
    public IDataVisualiseur ajouterDonnees(String str, double... doubles) {
        donnees.ajouter(new Faisceau(str, doubles));
        double d_max = doubles[0];
        for (double d : doubles) {
            if (d > d_max) {
                d_max = d;
            }
        }
        if (d_max > echelle_max) {
            echelle_max = d_max;
        }
        return this;
    }

    /**
     * Ajoute une légende au diagramme.
     * 
     * @param strings Les éléments de la légende.
     * @return L'instance de IDataVisualiseur avec la légende ajoutée.
     */
    @Override
    public IDataVisualiseur legender(String... strings) {
        for (String string : strings) {
            legendeGroupe.ajouter(new Rectangle(0, 0, 20, 7));
            legendeGroupe.ajouter(new Texte(0, 0, 10, string));
            legendes.add(string);
        }

        return this;
    }

    /**
     * Définit des options pour le diagramme.
     * 
     * @param strings Les options à définir.
     * @return L'instance de IDataVisualiseur avec les options définies.
     */
    @Override
    public IDataVisualiseur setOption(String... options) {
        for (String option : options) {
            // Traitez chaque option individuellement
            if (option.equals("Colonne supplémentaire")) {
                // Ajouter une colonne supplémentaire avec une couleur et une taille spécifiques
                double[] valeurs = { 10, 20, 30 }; // Exemple de valeurs arbitraires pour la colonne supplémentaire
                donnees.ajouter(new Faisceau("Supplémentaire", valeurs)); // Ajout d'une colonne supplémentaire
            } else if (option.equals("Ajouter une légende supplémentaire à la colonne")) {
                // Ajouter une légende supplémentaire à la colonne
                legendeGroupe.ajouter(new Rectangle(0, 0, 20, 7));
                legendeGroupe.ajouter(new Texte(0, 0, 10, "Légende supplémentaire"));
            } else if (option.equals("Supprimer une colonne")) {
                // Supprimer la première colonne de la liste des données
                if (!donnees.getListFormes().isEmpty()) {
                    donnees.getListFormes().remove(0);
                }
            }
        }
        return this;
    }

}
