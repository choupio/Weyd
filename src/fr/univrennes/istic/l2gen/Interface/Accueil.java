package fr.univrennes.istic.l2gen.Interface;

import fr.univrennes.istic.l2gen.station.StationAPI;
import java.awt.*;

import javax.swing.UIManager;

public class Accueil {
    private static StationAPI recup = new StationAPI();

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
        // fenetre.ajouterImage(onglets.GetOnglet1(),
        ///////// "ressources/ImagesInterface/ImageTest.png",
        // 1000, 743);

        fenetre.getFenetre().pack();
        fenetre.getFenetre().setVisible(true);
    }

    public static StationAPI getRecup() {
        return recup;
    }

}
