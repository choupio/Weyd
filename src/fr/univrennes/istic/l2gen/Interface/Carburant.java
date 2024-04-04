package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Carburant {
    private JPanel carburant = new JPanel(new GridLayout(1, 0));

    public Carburant() {
        // carburant.setLayout(new BoxLayout(carburant, BoxLayout.Y_AXIS));
        TitledBorder border = BorderFactory.createTitledBorder("Carburants");
        border.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        this.carburant.setBorder(border);

        ArrayList<String> tabcarburant = Accueil.getRecup().getNomsCarburants();

        JCheckBox[] Checkbox = new JCheckBox[tabcarburant.size()];

        for (int i = 0; i < tabcarburant.size(); i += 1) {
            Checkbox[i] = new JCheckBox(tabcarburant.get(i));
            this.carburant.add(Checkbox[i]);
            int index = i;
            Checkbox[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        System.out.println("CheckBox" + index + "checked"); // TODO à changer
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        System.out.println("CheckBox" + index + " unchecked"); // TODO à changer
                    }
                }
            });
        }

        this.carburant.revalidate();
        this.carburant.repaint();
    }

    public JPanel Getcarburant() {
        return this.carburant;
    }

}
