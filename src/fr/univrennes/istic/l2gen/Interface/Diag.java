package fr.univrennes.istic.l2gen.Interface;

import java.awt.event.*;
import java.awt.*;
import java.util.HashMap;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Cette classe représente un panneau permettant de sélectionner différents
 * types de diagrammes.
 */
public class Diag {

    /**
     * Panneau contenant les composants de sélection des diagrammes.
     */
    private JPanel panel;

    /**
     * Tableau de JComboBox pour les choix de diagrammes.
     */
    @SuppressWarnings("unchecked")
    private static JComboBox<String>[] choixdiagramme = new JComboBox[5];

    /**
     * Tableau de HashMap pour les états de sélection des diagrammes.
     */
    @SuppressWarnings("unchecked")
    private static HashMap<String, Boolean>[] isChecked = new HashMap[5];

    /**
     * Map pour l'état de sélection du diagramme de prix moyen.
     */
    private static HashMap<String, Boolean> isCheckedPrixMoy;

    /**
     * Map pour l'état de sélection du diagramme de prix médian.
     */
    private static HashMap<String, Boolean> isCheckedPrixMed;

    /**
     * Map pour l'état de sélection du diagramme de prix minimum.
     */
    private static HashMap<String, Boolean> isCheckedPrixMin;

    /**
     * Map pour l'état de sélection du diagramme du nombre de station qui proposent
     * le carburant.
     */
    private static HashMap<String, Boolean> isCheckedStationCarb;

    /**
     * Map pour l'état de sélection du diagramme du nombre de station qui proposent
     * le service.
     */
    private static HashMap<String, Boolean> isCheckedStationServ;

    /**
     * Constructeur de la classe Diag.
     * Initialise le panneau contenant les composants de sélection des diagrammes.
     * Crée des JComboBox pour chaque type de diagramme et les associe à des
     * écouteurs d'événements.
     */
    public Diag() {
        // Création du JPanel avec un BoxLayout vertical
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        TitledBorder border = BorderFactory.createTitledBorder("Diagrammes");
        border.setTitleFont(new Font("SansSerif", Font.BOLD, 18));
        this.panel.setBorder(border);

        for (int i = 0; i < 5; i += 1) {
            String[] diagrammes = new String[] { "camembert", "barres", "colonnes" };
            int index = i;
            if (i == 0) { // Prix moyen
                JComboBox<String> choixdiagrammePrixMoy = new JComboBox<>(diagrammes);
                // Liste booléenne pour savoir si le comboBox est sélectionné ou non
                isCheckedPrixMoy = new HashMap<String, Boolean>(diagrammes.length);
                choixdiagrammePrixMoy.setEnabled(false);
                choixdiagramme[i] = choixdiagrammePrixMoy;
                isChecked[i] = isCheckedPrixMoy;
            } else if (i == 1) { // Prix médian
                JComboBox<String> choixdiagrammePrixMed = new JComboBox<>(diagrammes);
                // Liste booléenne pour savoir si le comboBox est sélectionné ou non
                isCheckedPrixMed = new HashMap<String, Boolean>(diagrammes.length);
                choixdiagrammePrixMed.setEnabled(false);
                choixdiagramme[i] = choixdiagrammePrixMed;
                isChecked[i] = isCheckedPrixMed;
            } else if (i == 2) { // Prix minimum
                JComboBox<String> choixdiagrammePrixMin = new JComboBox<>(diagrammes);
                // Liste booléenne pour savoir si le comboBox est sélectionné ou non
                isCheckedPrixMin = new HashMap<String, Boolean>(diagrammes.length);
                choixdiagrammePrixMin.setEnabled(false);
                choixdiagramme[i] = choixdiagrammePrixMin;
                isChecked[i] = isCheckedPrixMin;
            } else if (i == 3) { // Nombre de station qui proposent le carburant
                JComboBox<String> choixdiagrammeStationCarb = new JComboBox<>(diagrammes);
                // Liste booléenne pour savoir si le comboBox est sélectionné ou non
                isCheckedStationCarb = new HashMap<String, Boolean>(diagrammes.length);
                choixdiagrammeStationCarb.setEnabled(false);
                choixdiagramme[i] = choixdiagrammeStationCarb;
                isChecked[i] = isCheckedStationCarb;
            } else { // Nombre de station qui proposent le service
                JComboBox<String> choixdiagrammeStationServ = new JComboBox<>(diagrammes);
                // Liste booléenne pour savoir si le comboBox est sélectionné ou non
                isCheckedStationServ = new HashMap<String, Boolean>(diagrammes.length);
                choixdiagrammeStationServ.setEnabled(false);
                choixdiagramme[i] = choixdiagrammeStationServ;
                isChecked[i] = isCheckedStationServ;
            }

            // Initialisation des booléens à false, sauf camembert
            for (String diag : diagrammes) {
                if (diag.equals("camembert")) {
                    isChecked[i].put(diag, true);
                } else {
                    isChecked[i].put(diag, false);
                }
            }

            // Gestion des événements
            choixdiagramme[index].addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    String selectedChoice = (String) choixdiagramme[index].getSelectedItem();
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        if (selectedChoice.equals(diagrammes[0])) {
                            isChecked[index].put(diagrammes[0], true);
                            isChecked[index].put(diagrammes[1], false);
                            isChecked[index].put(diagrammes[2], false);
                        } else if (selectedChoice.equals(diagrammes[1])) {
                            isChecked[index].put(diagrammes[0], false);
                            isChecked[index].put(diagrammes[1], true);
                            isChecked[index].put(diagrammes[2], false);
                        } else if (selectedChoice.equals(diagrammes[2])) {
                            isChecked[index].put(diagrammes[0], false);
                            isChecked[index].put(diagrammes[1], false);
                            isChecked[index].put(diagrammes[2], true);
                        }

                    }
                }
            });
            panel.add(choixdiagramme[i]);
        }

    }

    /**
     * Méthode pour récupérer le panneau contenant les composants de sélection des
     * diagrammes.
     *
     * @return Le panneau contenant les composants de sélection des diagrammes.
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * Méthode statique pour récupérer le tableau de JComboBox pour les choix de
     * diagrammes.
     *
     * @return Le tableau de JComboBox pour les choix de diagrammes.
     */
    public static JComboBox<String>[] getDiag() {
        return choixdiagramme;
    }

    /**
     * Méthode statique pour récupérer le tableau de HashMap pour les états de
     * sélection des diagrammes.
     *
     * @return Le tableau de HashMap pour les états de sélection des diagrammes.
     */
    public static HashMap<String, Boolean>[] getIsCheckedDiag() {
        return isChecked;
    }
}
