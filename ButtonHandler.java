package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ButtonHandler implements ActionListener {

    private JButton[][] buttons;
    private int numberOfRows;
    private Map<String, String> toDelete = new HashMap<>();

    public ButtonHandler(JButton[][] buttons, int numberOfRows) {
        this.buttons = buttons;
        this.numberOfRows = numberOfRows;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        JButton button = (JButton) event.getSource();

        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfRows; col++) {
                if (buttons[row][col].equals(button)) {
                    //System.out.println("clicked y:" + (row + 1) + " x:" + (col + 1));
                    buttonFinder(row, col);
                }
            }
        }

        //converts the cords string into integers
        if (toDelete.keySet().size() >= 3) {
            for (String cord : toDelete.keySet()) {
                int yCord = Integer.parseInt(cord.substring(0, cord.indexOf(" ")));
                int xCord = Integer.parseInt(cord.substring(cord.indexOf(" ") + 1, cord.length()));
                //System.out.println("Button: " + (yCord + 1) + " " + (xCord + 1));
                buttons[yCord][xCord].setBackground(null);

                //changes the color of the button whose color is null with the color of the button's above until it reacehes the top
                while (yCord >= 0) {
                    /*try {
                        TimeUnit.MICROSECONDS.sleep(7500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/

                    //if the it's on the top gets a randomColor equal to the ones already in the game
                    if (yCord == 0) {
                        buttons[yCord][xCord].setBackground(Window.randomColor(InicialWindow.win.getNumberOfColors()));
                        break;
                    }
                    if (!buttons[yCord][xCord].getBackground().equals(buttons[yCord - 1][xCord].getBackground())) {
                        buttons[yCord][xCord].setBackground(buttons[yCord - 1][xCord].getBackground());
                        buttons[yCord - 1][xCord].setBackground(null);
                    }
                    yCord--;
                }
            }

            //updates the score
            InicialWindow.win.setScore(toDelete.size() * toDelete.size());

            //clears the "pieces"
            toDelete.clear();

            //tests if there is any plays available
            Plays plays = new Plays(buttons);

            //if there are not, ends the game
            if (!plays.isPlayable()) {
                GameOver gg = new GameOver();
                gg.setVisible(true);
            }
        }
    }

    //looks the colors of the neaby buttons
    private void buttonFinder(int buttonY, int buttonX) {

        String cords = buttonY + " " + buttonX;

        if (toDelete.containsKey(cords)) {
            return;
        }

        toDelete.put(cords, buttons[buttonY][buttonX].getText());

        //the button above
        if (buttonY + 1 <= numberOfRows - 1) {
            if (buttons[buttonY + 1][buttonX].getBackground().equals(buttons[buttonY][buttonX].getBackground())) {
                buttonFinder(buttonY + 1, buttonX);

            }
        }

        //the button bellow
        if (buttonY - 1 >= 0) {
            if (buttons[buttonY - 1][buttonX].getBackground().equals(buttons[buttonY][buttonX].getBackground())) {
                buttonFinder(buttonY - 1, buttonX);

            }
        }

        //the button to the right
        if (buttonX + 1 <= numberOfRows - 1) {
            if (buttons[buttonY][buttonX + 1].getBackground().equals(buttons[buttonY][buttonX].getBackground())) {
                buttonFinder(buttonY, buttonX + 1);

            }
        }

        //the button to the left
        if (buttonX - 1 >= 0) {
            if (buttons[buttonY][buttonX - 1].getBackground().equals(buttons[buttonY][buttonX].getBackground())) {
                buttonFinder(buttonY, buttonX - 1);

            }
        }
    }
}
