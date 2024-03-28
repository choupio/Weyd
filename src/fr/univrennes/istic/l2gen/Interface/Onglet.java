package fr.univrennes.istic.l2gen.Interface;

import java.awt.event.*;
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
        onglet2.add(jLabel);
        onglet2.add(choixGranuralite);
        onglet2.add(button);

        Region Region = new Region();
        JPanel region = Region.GetRegion();
        Departement Departement = new Departement();
        JPanel dept = Departement.GetDept();
        Carburant carb=new Carburant();
        JPanel carburant = carb.Getcarburant();

        choixGranuralite.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
                String selectedChoice = (String) choixGranuralite.getSelectedItem();
                    if (selectedChoice.equals("Département")) {
                        dept.setVisible(false);
                        region.setVisible(true);
                    } else {
                        dept.setVisible(true);
                        region.setVisible(false);
                    }
            }
        });
        /*else{
            dept.setVisible(false);
            region.setVisible(false);
        }*/
         
        
        onglet2.setPreferredSize(new Dimension(WIDTH, HEIGTH));
        // onglet2.add(onglet21,BorderLayout.WEST);
        onglets.addTab(titreOnglet2, onglet2);

        onglet2.add(dept);
        onglet2.add(region);
        onglet2.add(dept);

        panelOnglet.add(onglets);

    }

    public JPanel GetPanel() {
        return panelOnglet;
    }

}
