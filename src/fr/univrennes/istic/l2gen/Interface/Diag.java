package fr.univrennes.istic.l2gen.Interface;

import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Diag {
    private JPanel panel;
    private JCheckBox camembert;
    private JCheckBox barre;
    private JCheckBox colonne;

    public Diag() {
        // Initialisation des JCheckBox
        camembert = new JCheckBox("Créer un diagramme en camembert");
        barre = new JCheckBox("Créer un diagramme en barre");
        colonne = new JCheckBox("Créer un diagramme en colonne");

        // Création du JPanel avec un BoxLayout vertical
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        TitledBorder border = BorderFactory.createTitledBorder("Type de diagramme");
        border.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        panel.setBorder(border);

        // Ajout des JCheckBox au JPanel
        panel.add(camembert);
        panel.add(barre);
        panel.add(colonne);
    }

    public JPanel getPanel() {
        return panel;
    }
}
