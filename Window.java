package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Window extends JFrame {

    private JLabel score;
    private int size;
    private int numberOfRows;
    private int numberOfColors;
    private JButton[][] buttons;

    public Window(int numberOfRows, int numberOfColors, int size) {

        this.numberOfColors = numberOfColors;
        this.numberOfRows = numberOfRows;
        this.size = size;

        //frame proprieties
        setTitle("Fusion");
        setSize(size, size);
        setResizable(true);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                InicialWindow.run();
                dispose();
            }
        });

        //General container w/BorderLayout
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //Adding "smaller" containers to the general one
        Container contentPaneCenter = new Container();
        contentPane.add(contentPaneCenter, BorderLayout.CENTER);

        Container contentPaneNorth = new Container();
        contentPane.add(contentPaneNorth, BorderLayout.NORTH);

        Container contentPaneSouth = new Container();
        contentPane.add(contentPaneSouth, BorderLayout.SOUTH);

        //Adding components to the North container
        contentPaneNorth.setLayout(new GridLayout(1, 2));
        JLabel scoreText = new JLabel("Points: ");
        scoreText.setHorizontalAlignment(SwingConstants.RIGHT);
        score = new JLabel("0");
        contentPaneNorth.add(scoreText);
        contentPaneNorth.add(score);

        //Adding components to the South container
        contentPaneSouth.setLayout(new GridLayout(1, 1));
        JButton quitButton = new JButton("Quit");
        quitButton.setBackground(Color.RED);

        //telling quitButton what to do when pressed
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InicialWindow.run();
                dispose();
            }
        });
        contentPaneSouth.add(quitButton);

        //Adding components to the Center container
        contentPaneCenter.setLayout(new GridLayout(numberOfRows, numberOfRows));

        //JButtons that will be the "pieces" of the game
        buttons = new JButton[numberOfRows][numberOfRows];

        for (int index = 0; index < numberOfRows; index++) {
            for (int index2 = 0; index2 < numberOfRows; index2++) {
                buttons[index][index2] = new JButton();
                JButton button = buttons[index][index2];

                //button.setText("Y: " + (index + 1) + " X: " + (index2 + 1));
                button.addActionListener(new ButtonHandler(buttons, numberOfRows));
                button.setPreferredSize(new Dimension(size / numberOfRows, size / numberOfRows));
                button.setBackground(randomColor(numberOfColors));
                //button.setBorderPainted(false);
                contentPaneCenter.add(button);
            }
        }

    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getWinSize() {
        return size;
    }

    public int getNumberOfColors() {
        return numberOfColors;
    }

    public JButton[][] getButtons() {
        return buttons;
    }
    public String getScore(){
        return score.getText();
    }

    //updates the score
    public void setScore(int newScoreText) {
        this.score.setText("" + (Integer.parseInt(this.score.getText()) + newScoreText));
    }

    //generates a random color in a certain range
    public static Color randomColor(int numOfColors) {
        Color color;

        Random random = new Random();

        int num = random.nextInt(numOfColors);

        switch (num) {
            case 0:
                color = Color.BLACK;
                break;
            case 1:
                color = Color.ORANGE;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.BLUE;
                break;
            case 4:
                color = Color.CYAN;
                break;
            case 5:
                color = Color.RED;
                break;
            case 6:
                color = Color.GRAY;
                break;
            case 7:
                color = Color.YELLOW;
                break;
            case 8:
                color = Color.MAGENTA;
                break;
            default:
                color = Color.PINK;
                break;
        }
        return color;
    }
}
