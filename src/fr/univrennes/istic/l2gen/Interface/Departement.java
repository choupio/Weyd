package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Departement {
    private JPanel departements = new JPanel();
    private int tructest;

    public Departement() {
        departements.setLayout(new BoxLayout(departements, BoxLayout.Y_AXIS));
        Border border2 = BorderFactory.createTitledBorder("Departement");
        this.departements.setBorder(border2);

        // Noms des départements en France
        ArrayList<String> tabDepart = Accueil.getRecup().getNomsDepartement();

        JCheckBox[] radioCheck = new JCheckBox[tabDepart.size()];

        for (int i = 0; i < tabDepart.size(); i += 1) {
            radioCheck[i] = new JCheckBox(tabDepart.get(i));
            this.departements.add(radioCheck[i]);
            this.tructest = i;
            // ajout de l'événement
            radioCheck[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        System.out.println("CheckBox" + tructest + "checked");
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        System.out.println("CheckBox" + tructest + " unchecked");
                    }
                }
            });
        }

        this.departements.setSize(departements.getMinimumSize().width, departements.getMinimumSize().width);

    }

    public JPanel GetDept() {
        return this.departements;
    }

}
