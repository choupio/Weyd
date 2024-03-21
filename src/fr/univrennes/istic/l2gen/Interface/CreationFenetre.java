package fr.univrennes.istic.l2gen.Interface;

import javax.swing.*;

public class CreationFenetre {
    private JFrame fenetre;

    public CreationFenetre(String nomFenetre) {
        JFrame frame = new JFrame(nomFenetre);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        this.fenetre = frame;
    }

    public JFrame getFenetre() {
        return this.fenetre;
    }
}
