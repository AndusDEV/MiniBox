package pl.andus.MiniBox.Email;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class HintPassField extends JPasswordField {
    Font gainFont = new Font("Tahoma", Font.PLAIN, 11);
    Font lostFont = new Font("Tahoma", Font.ITALIC, 11);

    public HintPassField(final String hint) {

        setText(hint);
        setFont(lostFont);
        setForeground(Color.GRAY);

        this.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(hint)) {
                    setText("");
                    setFont(gainFont);
                } else {
                    setText(getText());
                    setFont(gainFont);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals(hint)|| getText().length()==0) {
                    setText(hint);
                    setFont(lostFont);
                    setForeground(Color.GRAY);
                } else {
                    setText(getText());
                    setFont(gainFont);
                    setForeground(Color.BLACK);
                }
            }
        });

    }
}
