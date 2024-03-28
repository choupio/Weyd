package fr.univrennes.istic.l2gen.Interface;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import fr.univrennes.istic.l2gen.station.StationAPI;

public class Departement {
    private JPanel departements = new JPanel();

    public Departement() {
        Border border2 = BorderFactory.createTitledBorder("Departement");
        this.departements.setBorder(border2);

        StationAPI recup = new StationAPI();

        // Noms des départements en France
        ArrayList<String> tabDepart = recup.getNomsDepartement();

        ButtonGroup groupdept = new ButtonGroup();
        JRadioButton[] radioButtons = new JRadioButton[tabDepart.size()];

        for (int i = 0; i < tabDepart.size(); i += 1) {
            radioButtons[i] = new JRadioButton(tabDepart.get(i));
            groupdept.add(radioButtons[i]);
            this.departements.add(radioButtons[i]);
        }
    }

    public JPanel GetDept() {
        return this.departements;
    }

}
