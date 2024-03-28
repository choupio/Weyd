package fr.univrennes.istic.l2gen.Interface;

import javax.swing.*;
import javax.swing.border.Border;

public class Region {
    private JPanel region = new JPanel();

    public Region() {
        Border border = BorderFactory.createTitledBorder("région");
        this.region.setBorder(border);

        String[] tabRegion = { "Auvergne-Rhône-Alpes", "Nouvelle-Aquitaine", "Occitanie", "Île-de-France", "Grand Est",
                "Hauts-de-France", "Provence-Alpes-Côte d'Azur", "Bourgogne-Franche-Comté", "Normandie", "Bretagne",
                "Pays de la Loire", "Centre-Val de Loire", "Corse" };

        ButtonGroup groupregion = new ButtonGroup();
        JRadioButton[] radioButtons = new JRadioButton[tabRegion.length];

        for (int i = 0; i < tabRegion.length; i += 1) {
            radioButtons[i] = new JRadioButton(tabRegion[i]);
            groupregion.add(radioButtons[i]);
            this.region.add(radioButtons[i]);
        }

    }

    public JPanel GetRegion() {
        return this.region;
    }

}
