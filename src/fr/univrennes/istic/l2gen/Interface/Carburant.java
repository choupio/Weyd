package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Carburant {
    private JPanel carburant = new JPanel(new GridLayout(1, 0));
    private static HashMap<String, Boolean> isChecked;

    public Carburant() {
        // carburant.setLayout(new BoxLayout(carburant, BoxLayout.Y_AXIS));
        TitledBorder border = BorderFactory.createTitledBorder("Carburants");
        border.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        this.carburant.setBorder(border);

        ArrayList<String> tabcarburant = Accueil.getRecup().getNomsCarburants();

        JCheckBox[] Checkbox = new JCheckBox[tabcarburant.size()];

        // Liste booléenne pour savoir si la checkbox est cochée ou non
        isChecked = new HashMap<String, Boolean>(tabcarburant.size());

        for (int i = 0; i < tabcarburant.size(); i += 1) {
            isChecked.put(tabcarburant.get(i), false);
            Checkbox[i] = new JCheckBox(tabcarburant.get(i));
            this.carburant.add(Checkbox[i]);
            int index = i;
            Checkbox[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        isChecked.put(tabcarburant.get(index), true);
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        isChecked.put(tabcarburant.get(index), false);
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

    public static HashMap<String, Boolean> getIsCheckedCarb() {
        return isChecked;
    }
}
