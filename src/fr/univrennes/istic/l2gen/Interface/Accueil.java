package fr.univrennes.istic.l2gen.Interface;

import fr.univrennes.istic.l2gen.station.StationAPI;
import java.awt.*;

import javax.swing.UIManager;

/**
 * Cette classe représente l'interface d'accueil de l'application.
 * Elle permet de gérer l'interface utilisateur principale de l'application.
 */
public class Accueil {

     /**
     * Instance de StationAPI utilisée pour récupérer des données sur les stations.
     */
    private static StationAPI recup = new StationAPI();

     /**
     * Constructeur de la classe Accueil.
     * Ce constructeur initialise l'interface d'accueil de l'application.
     * Il configure la police de tous les composants de l'interface et crée une fenêtre avec des onglets.
     * La taille de la fenêtre est définie pour occuper tout l'écran.
     * Un onglet "Accueil" est ajouté à la fenêtre avec une image.
     */
    public Accueil() {

        ///////// Création police de toute l'interface /////////
        Font style1 = new Font("SansSerif", Font.PLAIN, 18);
        Font style2 = new Font("SansSerif", Font.BOLD, 18);
        // Changement de la police pour tous les composants
        UIManager.put("Button.font", style2);
        UIManager.put("Label.font", style2);
        UIManager.put("CheckBox.font", style1);
        UIManager.put("RadioButton.font", style2);
        UIManager.put("ComboBox.font", style1);
        UIManager.put("TextField.font", style2);
        UIManager.put("TextArea.font", style2);
        UIManager.put("List.font", style2);
        UIManager.put("Table.font", style2);
        UIManager.put("TabbedPane.font", style2);
        UIManager.put("MenuBar.font", style2);
        UIManager.put("Menu.font", style2);
        UIManager.put("MenuItem.font", style2);
        UIManager.put("PopupMenu.font", style2);
        UIManager.put("OptionPane.font", style2);

        ///////// Création de la fenêtre /////////
        CreationFenetre fenetre = new CreationFenetre("LES COURS DU CARBURANT EN FRANCE");

        ///////// Taille de la fenêtre /////////
        // On récupère la taille de l'écran
        GraphicsEnvironment tailleEcran = GraphicsEnvironment.getLocalGraphicsEnvironment();
        // On créer le rectangle de la bonne taille
        Rectangle tailleUtilisable = tailleEcran.getMaximumWindowBounds();
        fenetre.getFenetre().setSize((int) tailleUtilisable.getWidth(), (int) tailleUtilisable.getHeight());

        ///////// Ajout Onglets /////////
        Onglet onglets = new Onglet("Accueil", "Statistiques", (int) tailleUtilisable.getWidth(),
                (int) tailleUtilisable.getHeight());
        fenetre.getFenetre().add(onglets.GetPanel());

        ///////// Ajout Image /////////
        fenetre.ajouterImage(onglets.GetOnglet1(), "ressources/ImagesInterface/ImageTest.png",
                1000, 743);

        fenetre.getFenetre().pack();
        fenetre.getFenetre().setVisible(true);
    }

    /**
     * Méthode statique pour récupérer l'instance de StationAPI utilisée par l'interface d'accueil.
     *
     * @return L'instance de StationAPI utilisée par l'interface d'accueil.
     */
    public static StationAPI getRecup() {
        return recup;
    }

}
