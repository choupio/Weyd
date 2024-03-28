package fr.univrennes.istic.l2gen.Interface;

import javax.swing.*;
import java.awt.*;

public class Onglet {
    private JTabbedPane onglets;
    private JPanel panelOnglet = new JPanel();

    public Onglet(String titreOnglet1, String titreOnglet2, int WIDTH, int HEIGTH) {
        onglets = new JTabbedPane(SwingConstants.TOP);

        String[] Granularite = { "Région", "Departement" };
        JComboBox<String> choixGranuralite = new JComboBox<>(Granularite);
        JButton button = new JButton("Rapport");
        JLabel jLabel = new JLabel("Granularité");

        JPanel onglet1 = new JPanel();
        onglet1.setPreferredSize(new Dimension(WIDTH, HEIGTH));
        onglets.addTab(titreOnglet1, onglet1);

        JPanel onglet2 = new JPanel();
        // JPanel onglet21 = new JPanel(new GridLayout(1, 1));
        // onglet21.setLayout(new FlowLayout(FlowLayout.LEFT));
        // onglet21.setSize(onglet2.getWidth()*(25/100), onglet2.getHeight());
        onglet2.add(jLabel);
        onglet2.add(choixGranuralite);
        // onglet21.add(new JSeparator(),BorderLayout.WEST);
        onglet2.add(button);

        Region Region = new Region();
        JPanel region = Region.GetRegion();

        /*
         * if(choixGranuralite.getItemAt(choixGranuralite.getSelectedIndex()).equals(
         * "Région")){
         * Region.setVisible(true);
         * }else Region.setVisible(false);
         */

        Departement Departement = new Departement();
        JPanel dept = Departement.GetDept();

        /*
         * if(choixGranuralite.getItemAt(choixGranuralite.getSelectedIndex()).equals(
         * "Departement")){
         * Departement.setVisible(true);
         * }else Departement.setVisible(false);
         */

        onglet2.setPreferredSize(new Dimension(WIDTH, HEIGTH));
        // onglet2.add(onglet21,BorderLayout.WEST);
        onglets.addTab(titreOnglet2, onglet2);

        panelOnglet.add(onglets);

    }

    public JPanel GetPanel() {
        return panelOnglet;
    }

}
