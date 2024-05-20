package fr.univrennes.istic.l2gen.visustats;

import java.util.ArrayList;
import java.util.List;

import fr.univrennes.SVGFile;
import fr.univrennes.istic.l2gen.geometrie.Alignement;
import fr.univrennes.istic.l2gen.geometrie.Groupe;
import fr.univrennes.istic.l2gen.geometrie.IForme;
import fr.univrennes.istic.l2gen.geometrie.Point;
import fr.univrennes.istic.l2gen.geometrie.Rectangle;
import fr.univrennes.istic.l2gen.geometrie.Secteur;
import fr.univrennes.istic.l2gen.geometrie.Texte;

/**
 * Cette classe représente un diagramme en camembert.
 * Elle implémente l'interface IDataVisualiseur.
 */
public class DiagCamemberts implements IDataVisualiseur {

    // Attributs

    private String nom;
    private Point centre;
    private double hauteur;
    private double largeur;
    private int nbcamemberts;
    private int nbcourantcamembert;
    private ArrayList<Camembert> groupecamembert;
    private ArrayList<Rectangle> rectangles;
    private ArrayList<String> legendes;
    private Groupe diagrammeGroupe;
    private ArrayList<Texte> nomDonneesTexte;
    private String titre;
    private int nbsecteurs;
    private String[] couleurs;

    // Constructeur

    /**
     * Crée une instance de la classe DiagCamemberts avec le nom spécifié et le
     * nombre de camemberts.
     *
     * @param nom          Le nom du diagramme camembert.
     * @param nbcamemberts Le nombre de camemberts dans le diagramme.
     */
    public DiagCamemberts(String nom, int nbcamemberts) {
        this.nom = nom;
        this.nbcamemberts = nbcamemberts;
        this.groupecamembert = new ArrayList<>();
        this.rectangles = new ArrayList<>();
        this.legendes = new ArrayList<>();
        this.nomDonneesTexte = new ArrayList<>();
        this.diagrammeGroupe = new Groupe();
    }

    // Getters et Setters

    public int getNbcourantcamembert() {
        return nbcourantcamembert;
    }

    public void setNbcourantcamembert(int nbcourantcamembert) {
        this.nbcourantcamembert = nbcourantcamembert;
    }

    public String[] getCouleurs() {
        return couleurs;
    }

    public void setCouleurs(String[] couleurs) {
        this.couleurs = couleurs;
    }

    public ArrayList<Texte> getNomDonneesTexte() {
        return nomDonneesTexte;
    }

    public void setNomDonneesTexte(ArrayList<Texte> nomDonneesTexte) {
        this.nomDonneesTexte = nomDonneesTexte;
    }

    public ArrayList<Rectangle> getRectangles() {
        return rectangles;
    }

    public void setRectangles(ArrayList<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }

    public int getNbsecteurs() {
        return nbsecteurs;
    }

    public void setNbsecteurs(int nbsecteurs) {
        this.nbsecteurs = nbsecteurs;
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public ArrayList<String> getLegendes() {
        return legendes;
    }

    public void setLegendes(ArrayList<String> legendes) {
        this.legendes = legendes;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public int getNbcamemberts() {
        return nbcamemberts;
    }

    public void setNbcamemberts(int nbcamemberts) {
        this.nbcamemberts = nbcamemberts;
    }

    public ArrayList<Camembert> getGroupecamembert() {
        return groupecamembert;
    }

    public void setGroupecamembert(ArrayList<Camembert> groupecamembert) {
        this.groupecamembert = groupecamembert;
    }

    // Méthodes

    /**
     * Calcule le centre géométrique du groupe de camemberts.
     * 
     * @return Le point représentant les coordonnées du centre géométrique du groupe
     *         de camemberts.
     *         Retourne null si le groupe de camemberts est vide.
     */
    @Override
    public Point centre() {
        if (groupecamembert.isEmpty()) {
            return null;
        }
        double coordonnesX = 0;
        double coordonnesY = 0;
        for (Camembert camembert : groupecamembert) {
            coordonnesX += camembert.centre().x();
            coordonnesY += camembert.centre().y();
        }
        return new Point(coordonnesX / groupecamembert.size(), coordonnesY / groupecamembert.size());
    }

    /**
     * Renvoie une description détaillée de l'objet DiagCamemberts.
     *
     * @param indentation L'indentation à appliquer à la description.
     * @return La description de l'objet DiagCamemberts.
     */
    @Override
    public String description(int indentation) {
        String espace = "";
        for (int i = 0; i < indentation; i++) {
            espace += "  ";
        }
        String description = espace + "DiagCamemberts nom=" + nom + "\n" + espace + " Nombre de camembert :"
                + groupecamembert.size() + "\n";
        for (int i = 0; i < groupecamembert.size(); i++) {
            description += groupecamembert.get(i).description(indentation + 1) + "\n";
        }
        return description;
    }

    /**
     * Renvoie la hauteur du diagramme maximale parmi les camemberts.
     *
     * @return La hauteur du diagramme.
     */

    @Override
    public double hauteur() {
        Groupe groupe = new Groupe(); // initialisation du groupe

        // Ajout des camemberts dans groupe
        for (Camembert camembert : groupecamembert) {
            groupe.ajouter(camembert);
        }

        // Ajout des légendes
        Texte legende = new Texte(390 + 20, 200 + 15, 14, "test");
        groupe.ajouter(legende);
        Rectangle rectangle = new Rectangle(200 - 40, 390 - 10, 20, 10);
        groupe.ajouter(rectangle);

        // Ajout du titre
        double titley = 50;
        double titlex = this.centre().x();
        Texte titre = new Texte(titlex, titley, 30, getNom());
        groupe.ajouter(titre);
        return groupe.hauteur() + 110;
    }

    /**
     * Retourne la largeur du diagramme de groupe.
     *
     * @return la largeur du diagramme de groupe
     */

    @Override
    public double largeur() {
        Groupe groupe = new Groupe(); // initialisation du groupe

        // Ajout des légendes
        for (IForme forme : diagrammeGroupe.getListFormes()) {
            groupe.ajouter(forme);
        }

        // Ajout des camemberts dans groupe
        for (Camembert camembert : groupecamembert) {
            groupe.ajouter(camembert);
        }

        // Ajout du titre
        double titley = 50;
        double titlex = this.centre().x();
        Texte titre = new Texte(titlex, titley, 30, getNom());
        groupe.ajouter(titre);

        return groupe.largeur() + 110;
    }

    /**
     * Deplace le diagramme et ces camemberts selon les valeurs spécifiées.
     */

    @Override
    public IForme deplacer(double dx, double dy) {
        for (Camembert camembert : groupecamembert) {
            camembert.deplacer(dx, dy);
        }
        return this;
    }

    /**
     * Duplique le diagramme et tous ces camemberts
     */

    @Override
    public IForme dupliquer() {
        DiagCamemberts diagCamemberts = new DiagCamemberts(nom, nbcamemberts);
        groupecamembert.stream().map(camembert -> (Camembert) camembert.dupliquer())
                .forEach(dup -> diagCamemberts.getGroupecamembert().add(dup));
        return diagCamemberts;
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
        for (Camembert camembert : groupecamembert) {
            camembert.redimmensioner(h, l);
        }
        return this;
    }

    /**
     * Génère une représentation SVG de l'objet DiagCamemberts.
     * Cette méthode parcourt tous les camemberts du groupe et génère leur
     * représentation SVG.
     * Elle ajoute également le titre du diagramme et les légendes.
     * 
     * @return Une chaîne de caractères représentant le contenu SVG du diagramme.
     */
    @Override
    public String enSVG() {
        double titley = 50;
        double titlex = this.centre().x();
        Texte titre = new Texte(titlex, titley, 30, getNom());
        StringBuilder svg = new StringBuilder();
        for (Camembert camembert : groupecamembert) {
            svg.append(camembert.enSVG());
        }
        for (String legende : legendes) {
            svg.append(legende);
        }
        svg.append(titre.enSVG());

        return svg.toString();
    }

    /**
     * Crée un fichier SVG pour le diagramme en camembert.
     */

    @Override
    public void createSvgFile() {
        SVGFile.createSvgFile(this, "diagCamenberts");
    }

    /**
     * Colorie les secteurs d'un camembert avec les couleurs spécifiées.
     * 
     * @param couleurs Les couleurs à utiliser pour colorier les secteurs.
     * @return Une instance de l'interface IForme.
     */
    @Override
    public IForme colorier(String... couleurs) {

        String[] stockeCouleurs = couleurs;
        setCouleurs(stockeCouleurs);

        for (Camembert camembert : getGroupecamembert()) {
            List<Secteur> secteurs = camembert.getSecteurs();
            for (int i = 0; i < secteurs.size(); i++) {
                secteurs.get(i).colorier(couleurs[i]);
            }
        }
        for (int i = 0; i < couleurs.length; i++) {
            getRectangles().get(i).colorier(couleurs[i]);
            getLegendes().add(getRectangles().get(i).enSVG());
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
        for (Camembert camembert : getGroupecamembert()) {
            camembert.tourner(angle);
        }
        return this;
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
        for (Camembert camembert : getGroupecamembert()) {
            camembert.aligner(alignement, cible);
        }
        return this;
    }

    /**
     * Agence les camemberts dans la visualisation des données.
     * Cette méthode déplace les camemberts horizontalement en les espaçant et
     * ajuste la position des légendes.
     * 
     * @return Une instance de IDataVisualiseur représentant la visualisation des
     *         données agencée.
     */
    @Override
    public IDataVisualiseur agencer() {
        double axeX = 50; // Position de l'axe X
        double espacement = 50; // Espacement entre les camemberts
        int i = 0; // Compteur pour les camemberts
        for (Camembert camembert : getGroupecamembert()) {
            camembert.deplacer(axeX, 0);
            axeX += camembert.largeur() + espacement;
            getNomDonneesTexte().get(i).setCentre((new Point(camembert.getCentre().x(),
                    getNomDonneesTexte().get(i).centre().y() + (getNbcamemberts() * 1.2))));

            getLegendes().add(getNomDonneesTexte().get(i).enSVG());
            i++;
        }
        return this;
    }

    /**
     * Ajoute des données pour visualisation.
     * 
     * @param str     le texte associé aux données
     * @param doubles les valeurs numériques des données
     * @return l'objet IDataVisualiseur mis à jour
     * @throws IllegalArgumentException si le nombre maximum de camemberts est
     *                                  atteint
     */
    @Override
    public IDataVisualiseur ajouterDonnees(String str, double... doubles) {
        setNbsecteurs(doubles.length);
        double somme = 0;
        for (int i = 0; i < doubles.length; i++) {
            somme += doubles[i];
        }
        if (getNbcourantcamembert() >= getNbcamemberts()) {
            throw new IllegalArgumentException("Nombre de camemberts atteint");
        }
        Camembert cam = new Camembert(new Point(110, 200), 100);
        for (int i = 0; i < doubles.length; i++) {
            cam.ajouterSecteur("white", doubles[i] / somme);
        }
        Texte texte = new Texte(cam.centre().x(), cam.centre().y() + (cam.getRayon() * 1.2), 15, str);
        getNomDonneesTexte().add(texte);
        getGroupecamembert().add(cam);
        setNbcourantcamembert(getNbcourantcamembert() + 1);
        return this;
    }

    /**
     * Ajoute des légendes à la visualisation des données.
     * Les légendes sont affichées à côté des graphiques pour expliquer leur
     * signification.
     *
     * @param strings Les légendes à ajouter.
     * @return Une instance de IDataVisualiseur avec les légendes ajoutées.
     */
    @Override
    public IDataVisualiseur legender(String... strings) {
        double axeY = 390;
        double axeX = 200;
        for (int i = 0; i < strings.length; i++) {
            Texte texte = new Texte(axeX + 20, axeY + 15, 14, strings[i]);
            Rectangle rectangle = new Rectangle(axeX - 40, axeY - 10, 20, 10);
            getLegendes().add(texte.enSVG());
            getRectangles().add(rectangle);
            // axeY += 50; // afficher les légendes de façon verticale si l'on veut être
            // originale
            axeX += 200;

            diagrammeGroupe.ajouter(rectangle);
            diagrammeGroupe.ajouter(texte);
        }
        return this;
    }

    /**
     * Définit les options pour la visualisation des données.
     * 
     * @param options les options à définir
     * @return une instance de IDataVisualiseur avec les options définies
     */
    @Override
    public IDataVisualiseur setOption(String... options) {
        for (String option : options) {
            switch (option) {
                case "agencer":
                    agencer();
                    break;
                case "legender":
                    legender("Paris", "Barcelone", "Croatie", "Danemark");
                    break;
                case "colorier":
                    colorier("magenta", "bluelight", "pink", "grey");
                    break;
                default:
                    break;
            }
        }
        return this;
    }

}