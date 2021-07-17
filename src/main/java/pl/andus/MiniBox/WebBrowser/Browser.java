package pl.andus.MiniBox.WebBrowser;

import pl.andus.MiniBox.Window;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Browser implements HyperlinkListener {
    private static final JTextField txtURL= new JTextField("");
    static JButton searchBtn = new JButton("Search");
    static JEditorPane ep = new JEditorPane();
    private static final JLabel lblStatus= new JLabel(" ");

    public static void BrowserPanel() {
        Window.pWeb.setLayout(new BorderLayout());
        JPanel pnlURL = new JPanel();
        pnlURL.setLayout(new BorderLayout());
        pnlURL.add(new JLabel("URL: "), BorderLayout.WEST);
        pnlURL.add(txtURL, BorderLayout.CENTER);
        pnlURL.add(searchBtn, BorderLayout.EAST);
        Window.pWeb.add(pnlURL, BorderLayout.NORTH);
        Window.pWeb.add( ep, BorderLayout.CENTER);
        Window.pWeb.add(lblStatus, BorderLayout.SOUTH);
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String url = txtURL.getText();
                    if (url.contains("http://") || url.contains("https://")) {
                        ep.setPage(url);
                    } else {
                        ep.setPage("http://" + url);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent hle) {
        HyperlinkEvent.EventType evtype = hle.getEventType();
        if (evtype == HyperlinkEvent.EventType.ENTERED)
            lblStatus.setText(hle.getURL().toString());
        else if (evtype == HyperlinkEvent.EventType.EXITED)
            lblStatus.setText(" ");
    }
}
