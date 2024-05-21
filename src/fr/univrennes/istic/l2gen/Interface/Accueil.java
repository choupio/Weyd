package fr.univrennes.istic.l2gen.Interface;

import fr.univrennes.istic.l2gen.station.StationAPI;
import java.awt.event.*;
import java.awt.*;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

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
     * Il configure la police de tous les composants de l'interface et crée une
     * fenêtre avec des onglets.
     * La taille de la fenêtre est définie pour occuper tout l'écran.
     * Un onglet "Accueil" est ajouté à la fenêtre avec une image.
     */
    public Accueil() {

        FlatLightLaf.setup();

        try {
            UIManager.setLookAndFeel("com.formdev.flatlaf.themes.FlatMacDarkLaf");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        ///////// Création police de l'accueil /////////
        Font style1 = new Font("SansSerif", Font.BOLD, 25);
        Font style2 = new Font("SansSerif", Font.BOLD, 30);
        // Changement de la police pour les composants
        UIManager.put("Button.font", style1);
        UIManager.put("Label.font", style2);

        ///////// Création de la fenêtre /////////
        CreationFenetre fenetre = new CreationFenetre("Weyd Accueil");

        ///////// Taille de la fenêtre /////////
        // On récupère la taille de l'écran
        GraphicsEnvironment tailleEcran = GraphicsEnvironment.getLocalGraphicsEnvironment();
        // On créer le rectangle de la bonne taille
        Rectangle tailleUtilisable = tailleEcran.getMaximumWindowBounds();
        fenetre.getFenetre().setSize((int) tailleUtilisable.getWidth(), (int) tailleUtilisable.getHeight());

        ///////// Ajout d'image à l'Accueil /////////
        JPanel accueil = new JPanel();
        CreationFenetre.ajouterImage(accueil,
                "ressources/ImagesInterface/imaccueil.jpg",
                (int) tailleUtilisable.getWidth(), (int) tailleUtilisable.getHeight());
        accueil.setBounds(0, 0, (int) tailleUtilisable.getWidth(), (int) tailleUtilisable.getHeight());

        ///////// Bouton qui créer les onglets Statistique et Exemples /////////
        JButton commencer = new JButton("Commencer");
        commencer.setPreferredSize(new Dimension(300, 100));
        commencer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ouerture d'une nouvelle fenêtre
                CreationFenetre appli = new CreationFenetre("Weyd");
                // Fermeture de la fenêtre d'accueil
                fenetre.getFenetre().dispose();
                // Taille de la fenêtre
                appli.getFenetre().setSize((int) tailleUtilisable.getWidth(), (int) tailleUtilisable.getHeight());
                // Ajout Onglets
                Onglet onglets = new Onglet("Statistiques", "Exemples", (int) tailleUtilisable.getWidth(),
                        (int) tailleUtilisable.getHeight());

                appli.getFenetre().add(onglets.GetPanel());

                ///////// Ajout Image /////////
                // Création d'un GridLayout avec deux colonnes
                GridLayout gridLayout = new GridLayout(2, 2);
                onglets.GetOnglet2().setLayout(gridLayout);

                CreationFenetre.ajouterImage(onglets.GetOnglet2(), "ressources/ImagesInterface/Exemple1.png",
                        329, (int) 632);

                CreationFenetre.ajouterImage(onglets.GetOnglet2(), "ressources/ImagesInterface/Exemple2.png",
                        326, (int) 654);

                CreationFenetre.ajouterImage(onglets.GetOnglet2(), "ressources/ImagesInterface/Exemple3.png",
                        491, (int) 619);

                CreationFenetre.ajouterImage(onglets.GetOnglet2(), "ressources/ImagesInterface/Exemple4.png",
                        608, (int) 540);

                /*
                 * fenetre.ajouterImage(onglets.GetPanelPrevi(), "prévisua.png",
                 * onglets.GetPanelPrevi().getWidth(),
                 * onglets.GetPanelPrevi().getHeight());
                 */
            }
        });

        // Message d'accueil
        JLabel txtAccueil = new JLabel(
                "<html><div style='text-align: center;'>Bienvenue sur l'application Weyd. <br> Vous pouvez choisir les données qui vous intéressent dès maintenant en cliquant sur \"Commencer\".</div></html>");
        txtAccueil.setPreferredSize(new Dimension(700, 200));

        // Création du panneau pour le texte et le bouton
        JPanel panelTexteBouton = new JPanel(new BorderLayout());
        // Créer un autre JPanel avec FlowLayout pour centrer horizontalement le JLabel
        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        textPanel.add(txtAccueil);
        textPanel.setPreferredSize(new Dimension(700, 200));
        // Ajouter le topPanel à la position nord du panel principal
        panelTexteBouton.add(textPanel, BorderLayout.NORTH);
        JPanel commencerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        commencerPanel.add(commencer);
        commencerPanel.setPreferredSize(new Dimension(300, 50));
        panelTexteBouton.add(commencerPanel, BorderLayout.CENTER);
        // Ajout d'un fond semi-transparent au panneau
        panelTexteBouton.setBackground(new Color(0, 0, 0, 0));
        commencerPanel.setBackground(new Color(0, 0, 0, 0));
        textPanel.setBackground(new Color(0, 0, 0, 0));

        // Centrage du panneau dans l'écran
        panelTexteBouton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelTexteBouton.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Création du JLayeredPane pour superposer le panneau sur l'image
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension((int) tailleUtilisable.getWidth(),
                (int) tailleUtilisable.getHeight()));

        // Définition des limites du panneau de texte et de bouton
        int panelWidth = 1000;
        int panelHeight = 850;
        int panelX = ((int) tailleUtilisable.getWidth() - panelWidth) / 2;
        int panelY = ((int) tailleUtilisable.getHeight() - panelHeight) / 2;
        panelTexteBouton.setBounds(panelX, panelY, panelWidth, panelHeight);

        // Ajout de l'image et du panneau au JLayeredPane
        layeredPane.add(accueil, Integer.valueOf(1));
        layeredPane.add(panelTexteBouton, Integer.valueOf(2));

        // Ajout du JLayeredPane à la fenêtre
        fenetre.getFenetre().add(layeredPane);
        fenetre.getFenetre().setVisible(true);
    }

    /**
     * Méthode statique pour récupérer l'instance de StationAPI utilisée par
     * l'interface d'accueil.
     *
     * @return L'instance de StationAPI utilisée par l'interface d'accueil.
     */
    public static StationAPI getRecup() {
        return recup;
    }

}
