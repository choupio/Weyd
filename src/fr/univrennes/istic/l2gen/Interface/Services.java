package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Services {
    private JPanel services = new JPanel();
    private int tructest;

    public Services() {
        services.setLayout(new BoxLayout(services, BoxLayout.Y_AXIS));
        TitledBorder border2 = BorderFactory.createTitledBorder("Services proposés");
        border2.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        this.services.setBorder(border2);

        // Noms des départements en France
        ArrayList<String> tabDepart = Accueil.getRecup().getNomsServices();

        JCheckBox[] radioCheck = new JCheckBox[tabDepart.size()];

        for (int i = 0; i < tabDepart.size(); i += 1) {
            radioCheck[i] = new JCheckBox(tabDepart.get(i));
            this.services.add(radioCheck[i]);
            this.tructest = i;
            // ajout de l'événement
            radioCheck[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) { // TODO à changer
                        System.out.println("CheckBox" + tructest + "checked");
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) { // TODO à changer
                        System.out.println("CheckBox" + tructest + " unchecked");
                    }
                }
            });
        }

        this.services.setSize(services.getMinimumSize().width, services.getMinimumSize().width);

    }

    public JPanel getPanel() {
        return this.services;
    }

}
