package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Cette classe représente un panneau contenant des cases à cocher pour les régions.
 */
public class Region {

    /**
     * Panneau pour les régions.
     */
    private JPanel region = new JPanel();

    /**
     * HashMap pour stocker l'état de sélection des régions.
     */
    private static HashMap<String, Boolean> isChecked;

    /**
     * Constructeur de la classe Region.
     * Initialise le panneau avec des cases à cocher pour les régions.
     */
    public Region() {
        region.setLayout(new BoxLayout(region, BoxLayout.Y_AXIS));
        TitledBorder border = BorderFactory.createTitledBorder("Régions");
        border.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        this.region.setBorder(border);

        ArrayList<String> tabRegion = Accueil.getRecup().getNomsRegion();

        JCheckBox[] Checkbox = new JCheckBox[tabRegion.size()];

        JCheckBox tous = new JCheckBox("Toutes les régions");
        region.add(tous);

        // Liste booléenne pour savoir si la checkbox est cochée ou non
        isChecked = new HashMap<String, Boolean>(tabRegion.size());

        for (int i = 0; i < tabRegion.size(); i += 1) {
            isChecked.put(tabRegion.get(i), false);
            Checkbox[i] = new JCheckBox(tabRegion.get(i));
            this.region.add(Checkbox[i]);
            int index = i;
            Checkbox[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        isChecked.put(tabRegion.get(index), true);
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        isChecked.put(tabRegion.get(index), false);
                    }
                }
            });
        }

        tous.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    for (int i = 0; i < tabRegion.size(); i += 1) {
                        Checkbox[i].setSelected(true);
                    }
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    for (int i = 0; i < tabRegion.size(); i += 1) {
                        Checkbox[i].setSelected(false);
                    }

                }
            }
        });

    }

    /**
     * Méthode pour récupérer le panneau des régions.
     * @return Le panneau des régions.
     */
    public JPanel GetRegion() {
        return this.region;
    }

    /**
     * Méthode pour récupérer l'état de sélection des régions.
     * @return L'état de sélection des régions.
     */
    public static HashMap<String, Boolean> getIsCheckedReg() {
        return isChecked;
    }
}
