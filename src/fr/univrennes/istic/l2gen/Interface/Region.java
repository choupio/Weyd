package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Region {
    private JPanel region = new JPanel();

    public Region() {
        region.setLayout(new BoxLayout(region, BoxLayout.Y_AXIS));
        TitledBorder border = BorderFactory.createTitledBorder("Régions");
        border.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        this.region.setBorder(border);

        ArrayList<String> tabRegion = Accueil.getRecup().getNomsRegion();

        JCheckBox[] Checkbox = new JCheckBox[tabRegion.size()];

        for (int i = 0; i < tabRegion.size(); i += 1) {
            Checkbox[i] = new JCheckBox(tabRegion.get(i));
            this.region.add(Checkbox[i]);
            int index = i;
            Checkbox[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) { // TODO à changer
                        System.out.println("CheckBox" + index + "checked");
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) { // TODO à changer
                        System.out.println("CheckBox" + index + " unchecked");
                    }
                }
            });
        }

    }

    public JPanel GetRegion() {
        return this.region;
    }
}
