package pl.andus.MiniBox.Calculator;

import pl.andus.MiniBox.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Code from: https://github.com/himanshushukla254/Java-Swing-Calculator/blob/master/calculator.java

public class Calc extends JPanel implements ActionListener {
    private JTextField display = new JTextField("0");
    private double result = 0;
    private String operator = "=";
    private boolean calculating = true;

    public void CalcPanel() {
        setLayout(new BorderLayout());
        //seteditable false user cant edit disp field
        display.setEditable(false);
        display.setPreferredSize(new Dimension(70,70));
        add(display, "North");
        Font bigFont = display.getFont().deriveFont(Font.PLAIN, 25f);
        display.setFont(bigFont);
        //setting Jpanel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));
        //labeling of buttons
        String buttonLabels = "789/456*123-0.=+";
        for (int i = 0; i < buttonLabels.length(); i++) {
            JButton b = new JButton(buttonLabels.substring(i, i + 1));
            b.setFont(bigFont);
            panel.add(b);
            b.addActionListener(this);
        }
        add(panel, "Center");
        Window.pCalc.add(this);
    }

    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        if ('0' <= cmd.charAt(0) && cmd.charAt(0) <= '9' || cmd.equals(".")) {
            if (calculating)
                display.setText(cmd);
            else
                display.setText(display.getText() + cmd);
            calculating = false;
        } else {
            if (calculating) {
                if (cmd.equals("-")) {
                    display.setText(cmd);
                    calculating = false;
                } else
                    operator = cmd;
            } else {
                double x = Double.parseDouble(display.getText());
                calculate(x);
                operator = cmd;
                calculating = true;
            }
        }
    }

    private void calculate(double n) {
        if (operator.equals("+"))
            result += n;
        else if (operator.equals("-"))
            result -= n;
        else if (operator.equals("*"))
            result *= n;
        else if (operator.equals("/"))
            result /= n;
        else if (operator.equals("="))
            result = n;
        display.setText("" + result);
    }
}
