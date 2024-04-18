package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Cette classe représente un panneau affichant les options de carburants.
 * Elle permet à l'utilisateur de sélectionner les types de carburants qu'il souhaite visualiser.
 */
public class Carburant {

    /**
     * Panneau affichant les options de carburants.
     */
    private JPanel carburant = new JPanel(new GridLayout(1, 0));

    /**
     * Map des carburants et de leurs états de sélection.
     */
    private static HashMap<String, Boolean> isChecked;

    /**
     * Constructeur de la classe Carburant.
     * Ce constructeur initialise le panneau affichant les options de carburants.
     * Il crée des cases à cocher pour chaque type de carburant et les ajoute au panneau.
     * Il associe également des écouteurs d'événements aux cases à cocher pour mettre à jour l'état de sélection.
     */
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

    /**
     * Méthode pour récupérer le panneau affichant les options de carburants.
     *
     * @return Le panneau affichant les options de carburants.
     */
    public JPanel Getcarburant() {
        return this.carburant;
    }

    /**
     * Méthode statique pour récupérer la map des carburants et de leurs états de sélection.
     *
     * @return La map des carburants et de leurs états de sélection.
     */
    public static HashMap<String, Boolean> getIsCheckedCarb() {
        return isChecked;
    }
}
