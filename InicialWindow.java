package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InicialWindow extends MouseAdapter implements ActionListener {

    static Window win;
    static JFrame inicialFrame;

    public static void run() {

        //Frame
        inicialFrame = new JFrame("Fusion");
        inicialFrame.setSize(400, 600);
        inicialFrame.setVisible(true);
        inicialFrame.setResizable(false);
        inicialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicialFrame.setLocationRelativeTo(null);

        //Container
        Container inicialContainer = inicialFrame.getContentPane();
        inicialContainer.setLayout(new GridLayout(5, 1));
        inicialContainer.setBackground(Color.GRAY);

        //Labels
        JLabel name = new JLabel(inicialFrame.getTitle());
        JLabel devs = new JLabel("Developed by: Eduardo Medeiros and Yaroslav Kolodiy");

        //changing label's proprieties
        name.setBackground(Color.LIGHT_GRAY);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        devs.setHorizontalAlignment(SwingConstants.CENTER);

        //Buttons
        JButton playButton = new JButton("Play");
        JButton optionsButton = new JButton("Options");
        JButton quitButton = new JButton("Quit");

        //changing playButton
        playButton.setBackground(Color.WHITE);
        playButton.setBorderPainted(false);
        playButton.addMouseListener(new InicialWindow());
        playButton.addActionListener(new InicialWindow());

        //changing optionsButton
        optionsButton.setBackground(Color.WHITE);
        optionsButton.setBorderPainted(false);
        optionsButton.addMouseListener(new InicialWindow());
        optionsButton.addActionListener(new InicialWindow());

        //changing quitButton
        quitButton.setBackground(Color.WHITE);
        quitButton.setBorderPainted(false);
        quitButton.addMouseListener(new InicialWindow());
        quitButton.addActionListener(new InicialWindow());

        //Adding the components
        inicialContainer.add(name);
        inicialContainer.add(playButton);
        inicialContainer.add(optionsButton);
        inicialContainer.add(quitButton);
        inicialContainer.add(devs);
    }

    //crates a new window that has at leat one play
    public static void newWin(int rows, int colors, int size) {
        Plays plays;
        do {
            win = new Window(rows, colors, size);
            plays = new Plays(win.getButtons());
        }while (!plays.isPlayable());

        win.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Default options
        int defaultNumberOfColors = 3;
        int defaultNumberOfRows = 6;
        int defaultSize = 750;

        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();

            //Play button pressed
            if (buttonText.equalsIgnoreCase("play")) {
                newWin(defaultNumberOfRows, defaultNumberOfColors, defaultSize);
                inicialFrame.dispose();

            //Options button pressed
            } else if (buttonText.equalsIgnoreCase("options")) {
                OptionsWindow optWin = new OptionsWindow();
                optWin.setVisible(true);
                inicialFrame.dispose();

            //Quit button pressed
            } else if (buttonText.equalsIgnoreCase("quit")) {
                System.exit(0);
            }
        }
    }

    //animations when the mouse is over
    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton buttonEntered = (JButton) e.getSource();
            buttonEntered.setBackground(Color.LIGHT_GRAY);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton buttonEntered = (JButton) e.getSource();
            buttonEntered.setBackground(Color.WHITE);
        }

    }
}
