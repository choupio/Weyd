package fr.univrennes.istic.l2gen.Interface;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Onglet {
    private static Boolean isSationsAffichees = false;
    private static JCheckBox afficheStation;
    private JTabbedPane onglets;
    private JPanel panelOnglet = new JPanel();

    public Onglet(String titreOnglet1, String titreOnglet2, int WIDTH, int HEIGTH) {
        // Initialisation des onglets
        this.onglets = new JTabbedPane(SwingConstants.TOP);

        // Création onglet 1
        JPanel onglet1 = new JPanel();
        onglet1.setPreferredSize(new Dimension(WIDTH, HEIGTH));
        this.onglets.addTab(titreOnglet1, onglet1);

        // Création onglet 2
        JPanel onglet2 = new JPanel();
        onglet2.setLayout(new BorderLayout());
        onglet2.setPreferredSize(new Dimension(WIDTH, HEIGTH));
        // onglet2.setLayout(new BoxLayout(onglet2,BoxLayout.X_AXIS));
        this.onglets.addTab(titreOnglet2, onglet2);

        // Création d'un sous panel pour l'onglet 2
        JPanel onglet21 = new JPanel();
        onglet21.setSize((int) onglet2.getPreferredSize().getWidth(), (int) onglet2.getPreferredSize().getHeight());
        onglet2.add(onglet21);

        // Création des panneaux pour l'onglet 2
        Region Region = new Region();
        JPanel region = Region.GetRegion();
        Departement Departement = new Departement();
        JPanel dept = Departement.GetDept();
        Statistique statistique = new Statistique();
        JPanel stat = statistique.getPanel();
        Diag diagramme = new Diag();
        JPanel diag = diagramme.getPanel();
        Services services = new Services();
        JPanel serv = services.getPanel();
        Carburant carb = new Carburant();
        JPanel carburant = carb.Getcarburant();
        carburant.setLayout(new BoxLayout(carburant, BoxLayout.X_AXIS));

        // Création d'un JScrollPane pour dept
        JScrollPane scrollPaneDept = new JScrollPane(dept);
        scrollPaneDept.getVerticalScrollBar().setUnitIncrement(16); // Défilement plus rapide
        scrollPaneDept.setMaximumSize(new Dimension(230, HEIGTH - 500));
        scrollPaneDept.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // création d'un JscrollPane pour serv
        JScrollPane scrollPaneServ = new JScrollPane(serv);
        scrollPaneServ.getVerticalScrollBar().setUnitIncrement(18);
        scrollPaneServ.setMaximumSize(new Dimension(700, HEIGTH - 500));
        scrollPaneServ.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ////// Conteneurs pour mieux gérer la position à l'affichage //////
        // Création d'un JPanel pour contenir scrollPaneDept
        JPanel scrollPaneDeptContainer = new JPanel();
        scrollPaneDeptContainer.setLayout(new BoxLayout(scrollPaneDeptContainer, BoxLayout.X_AXIS));
        scrollPaneDeptContainer.add(scrollPaneDept);

        // Création d'un JPanel pour contenir region
        JPanel regionContainer = new JPanel();
        regionContainer.setLayout(new BoxLayout(regionContainer, BoxLayout.Y_AXIS));
        regionContainer.add(region);

        // Création d'un JPanel pour contenir carburant
        JPanel carburantContainer = new JPanel();
        carburantContainer.setLayout(new BoxLayout(carburantContainer, BoxLayout.X_AXIS));
        carburantContainer.add(carburant);

        // Création d'un JPanel pour contenir onglet21
        JPanel onglet21Container = new JPanel();
        onglet21Container.setLayout(new BoxLayout(onglet21Container, BoxLayout.Y_AXIS));
        onglet21Container.add(onglet21);
        afficheStation = new JCheckBox("Afficher position des stations les moins chères");
        afficheStation.addItemListener(new ItemListener() { // événement de l'affichage des stations
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    isSationsAffichees = true;
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    isSationsAffichees = false;
                }
            }
        });
        afficheStation.setEnabled(false);
        onglet21Container.add(afficheStation);
        onglet21Container.add(Box.createVerticalStrut(10));
        onglet21Container.add(carburantContainer);

        // Création d'un JPanel pour contenir les stats
        JPanel statContainer = new JPanel();
        statContainer.setLayout(new BoxLayout(statContainer, BoxLayout.Y_AXIS));
        statContainer.add(stat);

        // Création d'un JPanel pour contenir les diag
        JPanel diagContainer = new JPanel();
        diagContainer.setLayout(new BoxLayout(diagContainer, BoxLayout.Y_AXIS));
        diagContainer.add(diag);

        JPanel westContainer = new JPanel();
        westContainer.setLayout(new BoxLayout(westContainer, BoxLayout.X_AXIS));

        // Création d'un panel pour contenir les diag et stats
        JPanel southContainer = new JPanel();
        southContainer.setLayout(new BoxLayout(southContainer, BoxLayout.X_AXIS));
        southContainer.add(statContainer, BorderLayout.WEST);
        southContainer.add(onglet21Container, BorderLayout.CENTER);
        southContainer.add(diagContainer, BorderLayout.EAST);

        // Création d'un JPanel pour contenir les services
        JPanel servContainer = new JPanel();
        servContainer.setLayout(new BoxLayout(servContainer, BoxLayout.X_AXIS));
        servContainer.add(scrollPaneServ);

        // Ajout de ces panel à l'onglet 2
        onglet2.add(southContainer, BorderLayout.NORTH);
        onglet2.add(regionContainer, BorderLayout.WEST);
        onglet2.add(scrollPaneDeptContainer, BorderLayout.CENTER);
        onglet2.add(servContainer, BorderLayout.EAST);

        // Gestion de la vision au démarrage
        region.setVisible(true);
        scrollPaneDeptContainer.setVisible(false);
        carburantContainer.setVisible(true);
        southContainer.setVisible(true);
        servContainer.setVisible(true);

        // Création des éléments de contrôle pour l'onglet 2
        String[] Granularite = { "Régions", "Départements" };
        JComboBox<String> choixGranuralite = new JComboBox<>(Granularite); // Déroulant Granularité
        JLabel jLabel = new JLabel("Granularité");
        choixGranuralite.setSize(choixGranuralite.getWidth(), choixGranuralite.getMinimumSize().height);
        JButton button = new JButton("Rapport"); // Bouton pour le Rapport

        // Ajout de ces éléments de contrôle à l'onglet 2
        onglet21.add(jLabel);
        onglet21.add(choixGranuralite);
        onglet21.add(button);

        // Gestion des événements pour le choix de la granularité
        choixGranuralite.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String selectedChoice = (String) choixGranuralite.getSelectedItem();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (selectedChoice.equals("Départements")) {
                        scrollPaneDeptContainer.setVisible(true);
                        region.setVisible(false);
                    } else if (selectedChoice.equals("Régions")) {
                        region.setVisible(true);
                        scrollPaneDeptContainer.setVisible(false);
                    }
                    onglet2.revalidate();
                    onglet2.repaint();
                }
            }
        });

        // Ajout des onglets au panel principal
        panelOnglet.add(this.onglets);

    }

    public JPanel GetPanel() {
        return this.panelOnglet;
    }

    public JComponent GetOnglet1() {
        return (JComponent) this.onglets.getComponent(0);
    }

    public JComponent GetOnglet2() {
        return (JComponent) this.onglets.getComponent(1);
    }

    public static JCheckBox getAfficheStation() {
        return afficheStation;
    }

    public static Boolean getIsSationsAffichees() {
        return isSationsAffichees;
    }
}