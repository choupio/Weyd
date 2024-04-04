package fr.univrennes.istic.l2gen.Interface;

import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Statistique {
    private JPanel panel;
    private JCheckBox prix_moyen;
    private JCheckBox prix_Median;
    private JCheckBox prix_min;
    private JCheckBox nombre_station_carburant;
    private JCheckBox nombre_station_services;

    public Statistique() {
        // Initialisation des JCheckBox
        prix_moyen = new JCheckBox("Prix moyen");
        prix_Median = new JCheckBox("Prix médian");
        prix_min = new JCheckBox("Prix minimum");
        nombre_station_carburant = new JCheckBox("Nombre de stations proposant ce carburant");
        nombre_station_services = new JCheckBox("Nombre stations proposant d'autres services");

        // Création du JPanel avec un BoxLayout vertical
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        TitledBorder border = BorderFactory.createTitledBorder("Statistiques");
        border.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        panel.setBorder(border);

        // Ajout des JCheckBox au JPanel
        panel.add(prix_moyen);
        panel.add(prix_Median);
        panel.add(prix_min);
        panel.add(nombre_station_carburant);
        panel.add(nombre_station_services);
    }

    public JPanel getPanel() {
        return panel;
    }
}