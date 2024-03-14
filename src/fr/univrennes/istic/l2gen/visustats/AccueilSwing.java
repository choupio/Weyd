package fr.univrennes.istic.l2gen.visustats;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccueilSwing {

    public AccueilSwing() {
        JFrame frame = new JFrame("Hello World");
        JLabel label = new JLabel("Projet GEN", JLabel.CENTER);
        JPanel panel = new JPanel();

        JButton btn1 = new JButton("Bouton 1");
        JButton btn2 = new JButton("Bouton 2");

        panel.add(btn1);
        panel.add(btn2);

        frame.add(panel);
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}
