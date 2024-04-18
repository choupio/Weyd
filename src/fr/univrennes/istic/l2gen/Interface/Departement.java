package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Cette classe représente un panneau affichant les options de départements.
 * Elle permet à l'utilisateur de sélectionner les départements qu'il souhaite visualiser.
 */
public class Departement {

    /**
     * Panneau affichant les options de départements.
     */
    private JPanel departements = new JPanel();

    /**
     * Map des départements et de leurs états de sélection.
     */
    private static HashMap<String, Boolean> isChecked;

    /**
     * Constructeur de la classe Departement.
     * Ce constructeur initialise le panneau affichant les options de départements.
     * Il crée des cases à cocher pour chaque département et les ajoute au panneau.
     * Il associe également des écouteurs d'événements aux cases à cocher pour mettre à jour l'état de sélection.
     */
    public Departement() {
        departements.setLayout(new BoxLayout(departements, BoxLayout.Y_AXIS));
        TitledBorder border2 = BorderFactory.createTitledBorder("Départements");
        border2.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        this.departements.setBorder(border2);

        // Noms des départements en France
        ArrayList<String> tabDepart = Accueil.getRecup().getNomsDepartement();

        JCheckBox[] radioCheck = new JCheckBox[tabDepart.size()];

        JCheckBox tous = new JCheckBox("Tous les départements");
        departements.add(tous);

        // Liste booléenne pour savoir si la checkbox est cochée ou non
        isChecked = new HashMap<String, Boolean>(tabDepart.size());

        for (int i = 0; i < tabDepart.size(); i += 1) {
            isChecked.put(tabDepart.get(i), false);
            radioCheck[i] = new JCheckBox(tabDepart.get(i));
            this.departements.add(radioCheck[i]);
            int index = i;
            radioCheck[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        isChecked.put(tabDepart.get(index), true);
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        isChecked.put(tabDepart.get(index), false);
                    }
                }
            });
        }

        tous.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    for (int i = 0; i < tabDepart.size(); i += 1) {
                        radioCheck[i].setSelected(true);
                    }
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    for (int i = 0; i < tabDepart.size(); i += 1) {
                        radioCheck[i].setSelected(false);
                    }

                }
            }
        });

        this.departements.setSize(departements.getMinimumSize().width, departements.getMinimumSize().width);

    }

    /**
     * Méthode pour récupérer le panneau affichant les options de départements.
     *
     * @return Le panneau affichant les options de départements.
     */
    public JPanel GetDept() {
        return this.departements;
    }

    /**
     * Méthode statique pour récupérer la map des départements et de leurs états de sélection.
     *
     * @return La map des départements et de leurs états de sélection.
     */
    public static HashMap<String, Boolean> getIsCheckedDept() {
        return isChecked;
    }
}
