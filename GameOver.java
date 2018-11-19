package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOver extends JFrame implements ActionListener, MouseListener {

    public GameOver() {

        //Frame's proprieties
        setTitle("Game Over");
        setSize(InicialWindow.win.getWinSize(), 250);
        setResizable(false);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                InicialWindow.run();
                InicialWindow.win.dispose();
                dispose();
            }
        });

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 1));
        contentPane.setBackground(Color.WHITE);

        //Labels
        JLabel gameOver = new JLabel("Game Over.");
        JLabel scoreText = new JLabel("Score: " + InicialWindow.win.getScore());

        //changing label's proprieties
        gameOver.setHorizontalAlignment(SwingConstants.CENTER);
        gameOver.setForeground(Color.RED);
        scoreText.setHorizontalAlignment(SwingConstants.CENTER);

        //Buttons
        JButton playAgain = new JButton("Play Again");
        JButton quit = new JButton("Quit");

        //changing button's proprieties
        playAgain.setBorderPainted(false);
        playAgain.setBackground(Color.WHITE);
        playAgain.addMouseListener(this);
        playAgain.addActionListener(this);
        quit.setBorderPainted(false);
        quit.setBackground(Color.WHITE);
        quit.addMouseListener(this);
        quit.addActionListener(this);

        //adding the components to the panel
        contentPane.add(gameOver);
        contentPane.add(scoreText);
        contentPane.add(playAgain);
        contentPane.add(quit);
    }

    //tells every button what to do when pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();

            InicialWindow.win.dispose();
            //Play button pressed
            if (buttonText.equalsIgnoreCase("play again")) {
                InicialWindow.newWin(InicialWindow.win.getNumberOfRows(), InicialWindow.win.getNumberOfColors(), InicialWindow.win.getWinSize());
                dispose();

                //Quit button pressed
            } else if (buttonText.equalsIgnoreCase("quit")) {
                InicialWindow.run();
                dispose();
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

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
