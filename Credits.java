package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Credits extends JFrame {
    public Credits() {

        //Frame's proprieties
        setSize(700, 170);
        setLocation(300, 300);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                OptionsWindow optWind = new OptionsWindow();
                optWind.setVisible(true);
            }
        });

        //container that will have the info about the devs ^_^
        Container info = getContentPane();
        info.setLayout(new GridLayout(3, 1));
        JLabel worckInfo = new JLabel("Estre trabalho foi realizado no ambito da disciplina de Programação 2 pelos alunos:");
        worckInfo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel yaroslav = new JLabel("Yaroslav Kolodiy nº 39859 Curso E.I.");
        yaroslav.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel eduardo = new JLabel("Eduardo Medeiros nº 39873 Cruso E.I.");
        eduardo.setHorizontalAlignment(SwingConstants.CENTER);

        info.add(worckInfo);
        info.add(yaroslav);
        info.add(eduardo);

    }
}
