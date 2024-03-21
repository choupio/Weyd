package fr.univrennes.istic.l2gen.Interface;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class Onglet {
    private JTabbedPane onglets;

    public Onglet(String titreOnglet1,String titreOnglet2,int WIDTH,int HEIGTH){
        onglets = new JTabbedPane(SwingConstants.TOP);

        JButton button = new JButton("Rapport");


        String[] Granularite={"Région","Departement"};
        JComboBox<String> choixGranuralite = new JComboBox<>(Granularite);


        JPanel onglet1 = new JPanel();
        onglet1.setPreferredSize(new Dimension(WIDTH, HEIGTH));
        onglets.addTab(titreOnglet1, onglet1);

        JPanel onglet2 = new JPanel();
        onglet2.setPreferredSize(new Dimension(WIDTH,HEIGTH));
        onglet2.add(choixGranuralite);
        onglet2.add(button);
        onglets.addTab(titreOnglet2, onglet2);
        onglets.setOpaque(true);
    }

    public JTabbedPane GetOnglet(){
        return onglets;
    }

    

        
    
}
