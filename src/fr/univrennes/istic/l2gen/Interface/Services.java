package fr.univrennes.istic.l2gen.Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Cette classe représente un panneau contenant des cases à cocher pour les
 * services proposés.
 */
public class Services {

    /**
     * Panneau pour les services proposés.
     */
    private JPanel services = new JPanel();

    /**
     * HashMap pour stocker l'état de sélection des services.
     */
    private static HashMap<String, Boolean> isChecked;

    /**
     * JCkeckBox pour les services proposés.
     */
    private static JCheckBox[] radioCheck;

    /**
     * JCheckBox pour tous les services.
     */
    private static JCheckBox tousServices;

    /**
     * Constructeur de la classe Services.
     * Initialise le panneau avec des cases à cocher pour les services proposés.
     */
    public Services() {
        services.setLayout(new BoxLayout(services, BoxLayout.Y_AXIS));
        TitledBorder border2 = BorderFactory.createTitledBorder("Services proposés");
        border2.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        this.services.setBorder(border2);

        tousServices = new JCheckBox("Tous les services");
        tousServices.setEnabled(false);
        services.add(tousServices);

        // Noms des départements en France
        ArrayList<String> tabServ = Accueil.getRecup().getNomsServices();

        radioCheck = new JCheckBox[tabServ.size()];

        // Liste booléenne pour savoir si la checkbox est cochée ou non
        isChecked = new HashMap<String, Boolean>(tabServ.size());

        for (int i = 0; i < tabServ.size(); i += 1) {
            isChecked.put(tabServ.get(i), false);
            radioCheck[i] = new JCheckBox(tabServ.get(i));
            radioCheck[i].setEnabled(false);
            this.services.add(radioCheck[i]);
            int index = i;
            radioCheck[i].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        isChecked.put(tabServ.get(index), true);
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        isChecked.put(tabServ.get(index), false);
                    }
                }
            });
        }

        tousServices.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    for (int i = 0; i < tabServ.size(); i++) {
                        radioCheck[i].setSelected(true);
                    }
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    for (int i = 0; i < tabServ.size(); i++) {
                        radioCheck[i].setSelected(false);
                    }
                }
            }
        });

        this.services.setSize(services.getMinimumSize().width, services.getMinimumSize().width);

    }

    /**
     * Méthode pour récupérer le panneau des services proposés.
     * 
     * @return Le panneau des services proposés.
     */
    public JPanel getPanel() {
        return this.services;
    }

    /**
     * Méthode pour récupérer l'état de sélection des services.
     * 
     * @return L'état de sélection des services.
     */
    public static HashMap<String, Boolean> getIsCheckedServ() {
        return isChecked;
    }

    /**
     * Méthode pour récupérer les JCheckbox des services.
     * 
     * @return L'attribut correspondant.
     */
    public static JCheckBox[] getRadioCheck() {
        return radioCheck;
    }

    /**
     * Méthode pour récupérer la JCheckbox de tous les services.
     * 
     * @return L'attribut correspondant.
     */
    public static JCheckBox getTousServices() {
        return tousServices;
    }
}
