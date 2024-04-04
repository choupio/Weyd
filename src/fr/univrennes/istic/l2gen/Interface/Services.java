package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Services {
    private JPanel services = new JPanel();
    private Boolean[] isChecked;

    public Services() {
        services.setLayout(new BoxLayout(services, BoxLayout.Y_AXIS));
        TitledBorder border2 = BorderFactory.createTitledBorder("Services proposés");
        border2.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        this.services.setBorder(border2);

        // Noms des départements en France
        ArrayList<String> tabDepart = Accueil.getRecup().getNomsServices();

        JCheckBox[] radioCheck = new JCheckBox[tabDepart.size()];

        // Liste booléenne pour savoir si la checkbox est cochée ou non
        this.isChecked = new Boolean[tabDepart.size()];

        for (int i = 0; i < tabDepart.size(); i += 1) {
            radioCheck[i] = new JCheckBox(tabDepart.get(i));
            this.services.add(radioCheck[i]);
            int index = i;
            radioCheck[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) { // TODO à changer
                        isChecked[index] = true;
                        System.out.println("isChecked[" + index + "] = " + isChecked[index]); // TODO verif à enlever
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) { // TODO à changer
                        isChecked[index] = false;
                        System.out.println("isUnchecked[" + index + "] = " + isChecked[index]); // TODO verif à enlever
                    }
                }
            });
        }

        this.services.setSize(services.getMinimumSize().width, services.getMinimumSize().width);

    }

    public JPanel getPanel() {
        return this.services;
    }

    public Boolean[] getIsCheckedServ() {
        return this.isChecked;
    }
}
