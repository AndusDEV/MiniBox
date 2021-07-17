package pl.andus.MiniBox.Email;

import pl.andus.MiniBox.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmailClient {
    public static void EmailPanel() {
        JPanel infoPanel = new JPanel();
        JPanel messagePanel = new JPanel();

        JLabel senderEmail = new JLabel("Your Email:");
        senderEmail.setForeground(Color.white);
        JTextField semailTF = new JTextField();
        semailTF.setBackground(Color.LIGHT_GRAY);
        JLabel recieverEmail = new JLabel("Reciever Email:");
        recieverEmail.setForeground(Color.white);
        JTextField remailTF = new JTextField();
        remailTF.setBackground(Color.LIGHT_GRAY);
        JPanel subjePanel = new JPanel();
        subjePanel.setBackground(Color.GRAY);
        subjePanel.setLayout(null);
        JLabel subjectL = new JLabel("Subject:");
        subjectL.setForeground(Color.white);
        subjectL.setBounds(5, 10, 100, 20);
        JTextArea subjectTF = new JTextArea();
        subjectTF.setBackground(Color.LIGHT_GRAY);
        subjectTF.setBounds(75, 12, 350, 17);
        JLabel messageL = new JLabel("Message:");
        messageL.setForeground(Color.white);
        JTextArea messageTF = new JTextArea();
        messageTF.setBackground(Color.LIGHT_GRAY);

        JButton sendBtn = new JButton("Send Email");

        infoPanel.setLayout(new GridLayout(4,1));
        infoPanel.setBackground(Color.GRAY);
        infoPanel.add(senderEmail);
        infoPanel.add(semailTF);
        infoPanel.add(recieverEmail);
        infoPanel.add(remailTF);

        messagePanel.setLayout(new GridLayout(4,1));
        messagePanel.setBackground(Color.GRAY);
        subjePanel.add(subjectL);
        subjePanel.add(subjectTF);
        messagePanel.add(subjePanel);
        messagePanel.add(messageL);
        messagePanel.add(messageTF);
        messagePanel.add(sendBtn);

        Window.pEmail.setLayout(new BorderLayout());
        Window.pEmail.add(infoPanel, BorderLayout.NORTH);
        Window.pEmail.add(messagePanel, BorderLayout.CENTER);

        sendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame sendMailFrame= new JFrame("Send Your Email");

                JPanel services = new JPanel();

                JButton gmail = new JButton("Send with Gmail");
                JButton olook = new JButton("Send with Outlook");
                JButton efoun = new JButton("Send with /e/");

                JPanel sendingInfo = new JPanel();
                sendingInfo.setLayout(new GridLayout(3,1));

                JTextField serverTF = new HintTextField("server");
                JTextField portTF = new HintTextField("port");
                JTextField userTF = new HintTextField("email");
                JPasswordField passwdTF = new HintPassField("password");
                JButton sendBtn = new JButton("Send");

                services.add(gmail);
                services.add(olook);
                services.add(efoun);
                sendingInfo.add(serverTF);
                sendingInfo.add(portTF);
                sendingInfo.add(userTF);
                sendingInfo.add(passwdTF);
                sendingInfo.add(sendBtn);

                sendMailFrame.setLayout(new FlowLayout());
                sendMailFrame.add(services);
                sendMailFrame.add(sendingInfo);
                sendMailFrame.setSize(450, 250);
                sendMailFrame.setLocationRelativeTo(null);
                sendMailFrame.setResizable(false);
                sendMailFrame.setVisible(true);

                sendBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Functions.SendMail(semailTF.getText(), remailTF.getText(), subjectTF.getText(), messageTF.getText(),
                                serverTF.getText(), Integer.valueOf(portTF.getText()), userTF.getText(), passwdTF.getText());
                    }
                });

                gmail.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        serverTF.setText("smtp.gmail.com");
                        portTF.setText("587");
                    }
                });

                olook.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        serverTF.setText("smtp-mail.outlook.com");
                        portTF.setText("587");
                    }
                });

                efoun.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        serverTF.setText("mail.ecloud.global");
                        portTF.setText("587");
                    }
                });
            }
        });
    }
}
