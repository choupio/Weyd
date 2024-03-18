package fr.univrennes.istic.l2gen.visustats;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Le nom du diagramme en camembert.
     */
    private String nom;


    /**
     * Un entier représentant le nombre associée au diagramme de camembert.
     */
    private int entier;


    /**
     * Le groupe de formes qui compose le diagramme en camembert.
     */
    Groupe groupeCamembert;

    List<String> legendes, couleurs;

    /**
     * Constructeur de DiagCamemberts
     * 
     * @param nom    une String représentant le nom du diagramme
     * @param entier
     */
    public DiagCamemberts(String nom, int entier) {
        this.nom = nom;
        this.entier = entier;
        groupeCamembert = new Groupe();
        legendes = new ArrayList<>();
        couleurs = new ArrayList<>();
    }


    /**
     * Retourne le centre du groupe, calculé comme le centre moyen de toutes les
     * formes dans le diag.
     *
     * @return Le centre du diag.
     */
    @Override
    public Point centre() {
        return this.groupeCamembert.centre();
    }


    /**
     * Retourne le nom du diag.
     *
     * @return Le nom du diag.
     */
    public String getNom() {
        return nom;
    }


    /**
     * Renvoie la description de l'objet sous forme de chaîne de caractères.
     *
     * @param indentation Le niveau d'indentation à appliquer à la description.
     * @return La description de l'objet.
     */
    @Override
    public String description(int indentation) {
      return groupeCamembert.description(indentation);
    }  


    /**
     * Renvoie la hauteur du diagramme en camemberts.
     *
     * @return La hauteur du diagramme en camemberts.
     */
    @Override
    public double hauteur() {
        return this.groupeCamembert.hauteur();
    }


    /**
     * Retourne la largeur du groupe de camemberts.
     *
     * @return la largeur du groupe de camemberts
     */
    @Override
    public double largeur() {
        return this.groupeCamembert.largeur();
    }


    /**
     * Déplace l'objet de la classe qui implémente l'interface IForme selon les coordonnées spécifiées.
     *
     * @param dx le déplacement horizontal
     * @param dy le déplacement vertical
     * @return l'objet déplacé
     */
    @Override
    public IForme deplacer(double dx, double dy) {
        return this.groupeCamembert.deplacer(dx, dy);
    }


    /**
     * Cette méthode permet de dupliquer l'objet courant et de retourner une nouvelle instance de IForme.
     *
     * @return Une nouvelle instance de IForme qui est une copie de l'objet courant.
     */
    @Override
    public IForme dupliquer() {
        return this.groupeCamembert.dupliquer();
    }


    /**
     * Redimensionne la forme selon les dimensions spécifiées.
     * 
     * @param h la hauteur de la forme
     * @param l la largeur de la forme
     * @return la forme redimensionnée
     * @throws IllegalArgumentException si la hauteur ou la largeur est négative
     */
    @Override
    public IForme redimmensioner(double h, double l) {
        if (h < 0 || l < 0) {
            throw new IllegalArgumentException("Hauteur et Largeur doivent être positifs.");
        }
        groupeCamembert.redimmensioner(h, l);
        return this;
    }


    /**
     * Renvoie la représentation SVG de l'objet sous forme de chaîne de caractères.
     *
     * @return la représentation SVG de l'objet en tant que chaîne de caractères
     */
    @Override
    public String enSVG() {
        return groupeCamembert.enSVG();
    }

        
    /**
     * Colorie la forme avec les couleurs spécifiées.
     * 
     * @param couleurs les couleurs à utiliser pour colorier la forme
     * @return la forme coloriée
     */
    @Override
    public IForme colorier(String... couleurs) {
        for (IForme forme : groupeCamembert.getListFormes()) {
            if (forme instanceof Camembert) {
                Camembert camembert = (Camembert) forme;
                for (int i = 0; i < camembert.getSecteurs().size(); i++) {
                    camembert.getSecteurs().get(i).setCouleur(couleurs[i % couleurs.length]);
                }
            }
        }
        return this;
    }


    /**
     * Tourne la forme selon un angle spécifié.
     * 
     * @param angle l'angle de rotation en degrés
     * @return la forme après rotation
     * @throws IllegalArgumentException si l'angle est négatif
     */
    @Override
    public IForme tourner(int angle) {
        if (angle < 0) {
            throw new IllegalArgumentException("L'angle doit être positif.");
        }
        groupeCamembert.tourner(angle);
        return this;
    }


    /**
     * Aligne le diagramme en camembert selon un alignement spécifié et une cible donnée.
     * 
     * @param alignement L'alignement souhaité pour le diagramme en camembert.
     * @param cible La valeur cible pour l'alignement.
     * @return Une instance de l'interface IForme.
     * @throws IllegalArgumentException Si la cible est inférieure à zéro.
     */
    @Override
    public IForme aligner(Alignement alignement, double cible) {
        if (cible < 0) {
            throw new IllegalArgumentException("La cible doit être positive.");
        }
        groupeCamembert.aligner(alignement, cible);
        return this;
    }


    /**
     * Crée un fichier SVG en utilisant le groupe de camemberts.
     */
    @Override
    public void createSvgFile() {
        groupeCamembert.createSvgFile();
    }


    /**
     * Cette méthode est chargée d'agencer les données pour la visualisation.
     * 
     * @return L'objet IDataVisualiseur contenant les données agencées.
     */
    @Override
    public IDataVisualiseur agencer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agencer'");
    }


    /**
     * Ajoute les données spécifiées à l'objet IDataVisualiseur.
     * 
     * @param str le texte à afficher pour chaque secteur du camembert
     * @param doubles les valeurs numériques pour chaque secteur du camembert
     * @return l'objet IDataVisualiseur mis à jour avec les nouvelles données
     */
    @Override
    public IDataVisualiseur ajouterDonnees(String str, double... doubles) {

        double total = 0;
        for (double value : doubles) {
            total += value;
        }

        for (int i = 0; i < entier; i++) {
            Camembert camembert = new Camembert(new Point(256 + i * 250, 256), 100); 

            double sum = 0;
            for (double value : doubles) {
                sum += value / total;
            }

            for (int j = 0; j < 5; j++) {
                double proportion = (doubles[j % doubles.length] / total) / sum;
                
                camembert.ajouterSecteur(str + j, proportion);
            }
            groupeCamembert.ajouter(camembert);
        }
        
        return this;   
    }


    /**
     * Cette méthode permet de légender les éléments d'un visualiseur de données.
     * 
     * @param strings les légendes à afficher pour chaque élément
     * @return une instance de IDataVisualiseur avec les éléments légendés
     */
    @Override
    public IDataVisualiseur legender(String... strings) {

        legendes.clear();

        for (int i = 0; i < strings.length; i++) {
            Rectangle rectangle = new Rectangle(256 + i * 250, 256 + 110 + 50, 50, 15);

            // Obtenez la couleur du secteur correspondant du camembert
            String couleur = null;
            for (IForme forme : groupeCamembert.getListFormes()) {
                if (forme instanceof Camembert) {
                    Camembert camembert = (Camembert) forme;
                    if (i < camembert.getSecteurs().size()) {
                        couleur = camembert.getSecteurs().get(i).getCouleur();
                        break;
                    }
                }
            }

            // Coloriez le rectangle avec la couleur obtenue
            if (couleur != null) {
                rectangle.colorier(couleur);
            }

            groupeCamembert.ajouter(rectangle);
            groupeCamembert.ajouter(new Texte(rectangle.centre().x(), rectangle.centre().y(), 20, strings[i]));

            // Ajouter la légende à la liste
            legendes.add(strings[i]);
        }

        return this;
    }
    

    /**
     * Définit une méthode pour définir les options d'un visualiseur de données.
     *
     * @param strings Les options à définir.
     * @return Une instance de IDataVisualiseur avec les options définies.
     * @throws UnsupportedOperationException si la méthode n'est pas implémentée.
     */
    @Override
    public IDataVisualiseur setOption(String... strings) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOption'");
    }

}
