package pt.uevora.p2.fusion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OptionsWindow extends JFrame implements MouseListener {

    private JLabel error;

    public OptionsWindow() {
        setTitle("Options");
        setSize(750, 250);
        setResizable(false);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                InicialWindow.run();
                dispose();
            }
        });

        //Frame's container w/ a GridLayout
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(4, 3));
        contentPane.setBackground(Color.WHITE);

        JLabel howManyRows = new JLabel("How many rows/columns? ");
        JLabel howManyColors = new JLabel("How many Colors:");
        JLabel sizeText = new JLabel("What is the size:");
        JLabel emptyLabel = new JLabel("");
        error = new JLabel("");

        //changing label's proprieties
        howManyRows.setHorizontalAlignment(SwingConstants.CENTER);
        howManyColors.setHorizontalAlignment(SwingConstants.CENTER);
        sizeText.setHorizontalAlignment(SwingConstants.CENTER);
        error.setHorizontalAlignment(SwingConstants.CENTER);
        error.setForeground(Color.RED);

        JTextField rows = new JTextField(15);
        JTextField colors = new JTextField(15);
        JTextField size = new JTextField(15);

        //creating and changing the proprieties of the submit button
        JButton submit = new JButton();
        submit.setBorderPainted(false);
        submit.setText("SUBMIT");
        submit.setBackground(Color.WHITE);
        submit.addMouseListener(this);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (Integer.parseInt(colors.getText()) > 9 || Integer.parseInt(colors.getText()) < 2) {
                        throw new ArithmeticException("Number of Colors is invalid, 2 <= Colors <= 9");
                    }
                    if (Integer.parseInt(rows.getText()) < 2) {
                        throw new ArithmeticException("Number of Rows/Columns is invalid, 2 <= Columns");
                    }
                    InicialWindow.newWin(Integer.parseInt(rows.getText()), Integer.parseInt(colors.getText()), Integer.parseInt(size.getText()));
                    dispose();
                } catch (java.lang.NumberFormatException e) {
                    writeError("(invalid input)");
                } catch (java.lang.ArithmeticException e) {
                    writeError(e.getMessage());
                }
            }
        });

        //creating and changing the proprieties of the clear button
        JButton clear = new JButton();
        clear.setBorderPainted(false);
        clear.setText("Clear");
        clear.setBackground(Color.WHITE);
        clear.addMouseListener(this);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rows.setText("");
                colors.setText("");
                size.setText("");
            }
        });

        //creating and changing the proprieties of the credits button
        JButton credits = new JButton();
        credits.setBorderPainted(false);
        credits.setText("Credits");
        credits.setBackground(Color.WHITE);
        credits.addMouseListener(this);
        credits.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Credits win = new Credits();
                dispose();
            }
        });

        //creating and changing the proprieties of the back button
        JButton back = new JButton();
        back.setBorderPainted(false);
        back.setText("Back");
        back.setBackground(Color.WHITE);
        back.addMouseListener(this);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                InicialWindow.run();
                dispose();
            }
        });

        //1st line
        contentPane.add(howManyRows);
        contentPane.add(rows);
        contentPane.add(submit);

        //2nd line
        contentPane.add(howManyColors);
        contentPane.add(colors);
        contentPane.add(clear);

        //3rd line
        contentPane.add(sizeText);
        contentPane.add(size);
        contentPane.add(credits);

        //4th line
        contentPane.add(emptyLabel);
        contentPane.add(error);
        contentPane.add(back);

    }

    //shows an error message
    public void writeError(String text) {
        this.error.setText(text);
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
