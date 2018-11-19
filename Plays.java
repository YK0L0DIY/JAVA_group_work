package pt.uevora.p2.fusion;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Plays {

    private JButton[][] buttons;
    private int numberOfRows;
    private Map<String, String> buttonGroups = new HashMap<>();

    public Plays(JButton[][] buttons) {
        this.buttons = buttons;
        this.numberOfRows = buttons.length;
    }

    public boolean isPlayable() {
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfRows; col++) {
                buttonFinder(row, col);

                //returns true as soon as a play is found
                if (buttonGroups.keySet().size() >= 3) {
                    return true;
                }
                buttonGroups.clear();
            }
        }
        return false;
    }

    //looks the colors of the neaby buttons
    private void buttonFinder(int buttonY, int buttonX) {

        String cords = buttonY + " " + buttonX;

        if (buttonGroups.containsKey(cords)) {
            return;
        }

        buttonGroups.put(cords, buttons[buttonY][buttonX].getText());

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
