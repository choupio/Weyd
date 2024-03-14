package fr.univrennes.istic.l2gen.visustats;

import fr.univrennes.istic.l2gen.geometrie.IForme;

/**
 * Interface qui complémente celle de IForme
 */
public interface IDataVisualiseur extends IForme {

    /**
     * Permet de mettre en forme le diagramme en question.
     * 
     * @return une instance du diagramme
     */
    public IDataVisualiseur agencer();

    /**
     * Permet de mettre en forme le diagramme en question.
     * 
     * @param str     une String qui caractérise les données ajoutées
     * @param doubles une liste de doubles qui représente des données
     * @requires doubles.length > 0
     * @return une instance du diagramme
     * @ensures l'ajout des données au diagramme en question
     */
    public IDataVisualiseur ajouterDonnees(String str, double... doubles);

    /**
     * Permet de légender les éléments du diagramm en question.
     * 
     * @param strings une liste de Strings caractérisant les éléments du diagramme.
     * @return une instance du diagramme
     * @ensures l'ajout d'une légende au diagramme en question
     */
    public IDataVisualiseur legender(String... strings);

    /**
     * Permet d'ajouter des options au diagramme en question.
     * 
     * @param strings une liste de Strings caractérisant des options à ajouter au
     *                diagramme
     * @return une instance du diagramme
     * @ensures l'ajout d'options au digramme en question
     */
    public IDataVisualiseur setOption(String... strings);
}
