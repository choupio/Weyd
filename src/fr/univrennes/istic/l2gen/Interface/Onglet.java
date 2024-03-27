package fr.univrennes.istic.l2gen.Interface;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Onglet {
    private JTabbedPane onglets;
    private JPanel panelOnglet=new JPanel();


    public Onglet(String titreOnglet1,String titreOnglet2,int WIDTH,int HEIGTH){
        onglets = new JTabbedPane(SwingConstants.TOP);

        String[] Granularite={"Région","Departement"};
        JComboBox<String> choixGranuralite = new JComboBox<>(Granularite);
        JButton button = new JButton("Rapport");
        JLabel jLabel = new JLabel("Granularité");

        JPanel onglet1 = new JPanel();
        onglet1.setPreferredSize(new Dimension(WIDTH, HEIGTH));
        onglets.addTab(titreOnglet1, onglet1);

        JPanel onglet2 = new JPanel();
        //JPanel onglet21 = new JPanel(new GridLayout(1, 1));
        //onglet21.setLayout(new FlowLayout(FlowLayout.LEFT));
        //onglet21.setSize(onglet2.getWidth()*(25/100), onglet2.getHeight());
        onglet2.add(jLabel);
        onglet2.add(choixGranuralite);
        //onglet21.add(new JSeparator(),BorderLayout.WEST);
        onglet2.add(button);

        JPanel Region = new JPanel(new GridLayout(1, 1));
        Border border = BorderFactory.createTitledBorder("région");
        Region.setBorder(border);

        ButtonGroup groupregion = new ButtonGroup();
        JRadioButton radioregion1 = new JRadioButton("Auvergne-Rhône-Alpes");
        JRadioButton radioregion2 = new JRadioButton("Nouvelle-Aquitaine");
        JRadioButton radioregion3 = new JRadioButton("Occitanie");
        JRadioButton radioregion4 = new JRadioButton("Île-de-France");
        JRadioButton radioregion5 = new JRadioButton("Grand Est");
        JRadioButton radioregion6 = new JRadioButton("Hauts-de-France");
        JRadioButton radioregion7 = new JRadioButton("Provence-Alpes-Côte d'Azur");
        JRadioButton radioregion8 = new JRadioButton("Bourgogne-Franche-Comté");
        JRadioButton radioregion9 = new JRadioButton("Normandie");
        JRadioButton radioregion10 = new JRadioButton("Bretagne");
        JRadioButton radioregion11 = new JRadioButton("Pays de la Loire");
        JRadioButton radioregion12 = new JRadioButton("Centre-Val de Loire");
        JRadioButton radioregion13 = new JRadioButton("Corse");

        groupregion.add(radioregion1);
        groupregion.add(radioregion2);
        groupregion.add(radioregion3);
        groupregion.add(radioregion4);
        groupregion.add(radioregion5);
        groupregion.add(radioregion6);
        groupregion.add(radioregion7);
        groupregion.add(radioregion8);
        groupregion.add(radioregion9);
        groupregion.add(radioregion10);
        groupregion.add(radioregion11);
        groupregion.add(radioregion12);
        groupregion.add(radioregion13);


        Region.add(radioregion1);
        Region.add(radioregion2);
        Region.add(radioregion3);
        Region.add(radioregion4);
        Region.add(radioregion5);
        Region.add(radioregion6);
        Region.add(radioregion7);
        Region.add(radioregion8);
        Region.add(radioregion9);
        Region.add(radioregion10);
        Region.add(radioregion11);
        Region.add(radioregion12);
        Region.add(radioregion13);

        /* if(choixGranuralite.getItemAt(choixGranuralite.getSelectedIndex()).equals("Région")){
            Region.setVisible(true);
        }else Region.setVisible(false); */

        

        JPanel Departement=new JPanel(new GridLayout(0, 1));
        Border border2 = BorderFactory.createTitledBorder("Departement");
        Region.setBorder(border2);
        ButtonGroup groupdept = new ButtonGroup();
        JRadioButton radiodept1 = new JRadioButton("Bouches-du-Rhône");
        JRadioButton radiodept2 = new JRadioButton("Nord");
        JRadioButton radiodept3 = new JRadioButton("Pas-de-Calais");
        JRadioButton radiodept4 = new JRadioButton("Gironde");
        JRadioButton radiodept5 = new JRadioButton("Rhône");
        JRadioButton radiodept6 = new JRadioButton("Haute-Garonne");
        JRadioButton radiodept7 = new JRadioButton("Isère");
        JRadioButton radiodept8 = new JRadioButton("Bourgogne-Franche-Comté");
        JRadioButton radiodept9 = new JRadioButton("Loire-Atlantique");
        JRadioButton radiodept10 = new JRadioButton("Seine-et-Marne");
        JRadioButton radiodept11 = new JRadioButton("Var");
        JRadioButton radiodept12 = new JRadioButton("Seine-Maritime");
        JRadioButton radiodept13 = new JRadioButton("Hérault");
        JRadioButton radiodept14 = new JRadioButton("Finistère");
        JRadioButton radiodept15= new JRadioButton("Bas-Rhin");
        JRadioButton radiodept16= new JRadioButton("Ille-et-Vilaine");
        JRadioButton radiodept17= new JRadioButton("Yvelines");
        JRadioButton radiodept18= new JRadioButton("Morbihan");
        JRadioButton radiodept19= new JRadioButton("Saône-et-Loire");
        JRadioButton radiodept20= new JRadioButton("Alpes-Maritimes");
        JRadioButton radiodept21 = new JRadioButton("Gard");
        JRadioButton radiodept22= new JRadioButton("Moselle");
        JRadioButton radiodept23= new JRadioButton("Essonne");
        JRadioButton radiodept24= new JRadioButton("Loire");
        JRadioButton radiodept25= new JRadioButton("Calvados");
        JRadioButton radiodept26= new JRadioButton("Côte-d'Or");
        JRadioButton radiodept27= new JRadioButton("Haute-Savoie");
        JRadioButton radiodept28= new JRadioButton("Puy-de-Dôme");
        JRadioButton radiodept29= new JRadioButton("Côtes-d'Armor");
        JRadioButton radiodept31= new JRadioButton("Ain");
        JRadioButton radiodept32= new JRadioButton("Vendée");
        JRadioButton radiodept33= new JRadioButton("Charente-Maritime");
        JRadioButton radiodept34= new JRadioButton("Manche");
        JRadioButton radiodept35= new JRadioButton("Oise");
        JRadioButton radiodept36= new JRadioButton("Pyrénées-Atlantiques");
        JRadioButton radiodept37= new JRadioButton("Drôme");
        JRadioButton radiodept38= new JRadioButton("Haut-Rhin");
        JRadioButton radiodept39= new JRadioButton("Val-d'Oise");
        JRadioButton radiodept40= new JRadioButton("Somme");
        JRadioButton radiodept41= new JRadioButton("Loiret");
        JRadioButton radiodept42= new JRadioButton("Vaucluse");
        JRadioButton radiodept43= new JRadioButton("Landes");
        JRadioButton radiodept44= new JRadioButton("Maine-et-Loire");
        JRadioButton radiodept45= new JRadioButton("Doubs");
        JRadioButton radiodept46= new JRadioButton("Sarthe");
        JRadioButton radiodept47= new JRadioButton("Maurthe-et-Moselle");
        JRadioButton radiodept48= new JRadioButton("Eure");
        JRadioButton radiodept49= new JRadioButton("Dordogne");
        JRadioButton radiodept50= new JRadioButton("Indre-et-Loire");
        JRadioButton radiodept51= new JRadioButton("Savoie");
        JRadioButton radiodept52= new JRadioButton("Aisne");
        JRadioButton radiodept53= new JRadioButton("Marne");
        JRadioButton radiodept54= new JRadioButton("Aveyron");
        JRadioButton radiodept55= new JRadioButton("Yonne");
        JRadioButton radiodept56= new JRadioButton("Aude");
        JRadioButton radiodept57= new JRadioButton("Seine-Saint-Denis");
        JRadioButton radiodept58= new JRadioButton("Haute-Vienne");
        JRadioButton radiodept59= new JRadioButton("Vosges");
        JRadioButton radiodept60= new JRadioButton("Val-de-Marne");
        JRadioButton radiodept61= new JRadioButton("Lot-et-Garonne");
        JRadioButton radiodept62= new JRadioButton("Allier");
        JRadioButton radiodept63= new JRadioButton("Hauts-de-Seine");
        JRadioButton radiodept64= new JRadioButton();
        JRadioButton radiodept65= new JRadioButton();
        JRadioButton radiodept66= new JRadioButton();
        JRadioButton radiodept67= new JRadioButton();
        JRadioButton radiodept68= new JRadioButton();
        JRadioButton radiodept69= new JRadioButton();
        JRadioButton radiodept70= new JRadioButton();
        JRadioButton radiodept71= new JRadioButton();
        JRadioButton radiodept72= new JRadioButton();
        JRadioButton radiodept73= new JRadioButton();
        JRadioButton radiodept74= new JRadioButton();
        JRadioButton radiodept75= new JRadioButton();
        JRadioButton radiodept76= new JRadioButton();
        JRadioButton radiodept77= new JRadioButton();
        JRadioButton radiodept78= new JRadioButton();
        JRadioButton radiodept79= new JRadioButton();
        JRadioButton radiodept80= new JRadioButton();
        JRadioButton radiodept81= new JRadioButton();
        JRadioButton radiodept82= new JRadioButton();
        JRadioButton radiodept83= new JRadioButton();
        JRadioButton radiodept84= new JRadioButton();
        JRadioButton radiodept85= new JRadioButton();
        JRadioButton radiodept86= new JRadioButton();
        JRadioButton radiodept87= new JRadioButton();
        JRadioButton radiodept88= new JRadioButton();
        JRadioButton radiodept89= new JRadioButton();
        JRadioButton radiodept90= new JRadioButton();
        JRadioButton radiodept91= new JRadioButton();
        JRadioButton radiodept92= new JRadioButton();
        JRadioButton radiodept93= new JRadioButton();
        JRadioButton radiodept94= new JRadioButton();
        JRadioButton radiodept95= new JRadioButton();
        JRadioButton radiodept96= new JRadioButton();
        JRadioButton radiodept97= new JRadioButton();
        JRadioButton radiodept98= new JRadioButton();
        JRadioButton radiodept99= new JRadioButton();
        JRadioButton radiodept100= new JRadioButton();
        JRadioButton radiodept101= new JRadioButton();
        JRadioButton radiodept102= new JRadioButton();
        JRadioButton radiodept103= new JRadioButton();
        JRadioButton radiodept104= new JRadioButton();
        JRadioButton radiodept105= new JRadioButton();
        JRadioButton radiodept106= new JRadioButton();
        JRadioButton radiodept107= new JRadioButton();
        JRadioButton radiodept108= new JRadioButton();
        JRadioButton radiodept109= new JRadioButton();

        /* if(choixGranuralite.getItemAt(choixGranuralite.getSelectedIndex()).equals("Departement")){
            Departement.setVisible(true);
        }else Departement.setVisible(false); */

        onglet2.setPreferredSize(new Dimension(WIDTH,HEIGTH));
        //onglet2.add(onglet21,BorderLayout.WEST);
        onglets.addTab(titreOnglet2, onglet2);

        panelOnglet.add(onglets);

    }

    public JPanel GetPanel(){
        return panelOnglet;
    }

    

        
    
}
