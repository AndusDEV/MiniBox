package pl.andus.MiniBox;

import pl.andus.MiniBox.Calculator.Calc;
//import pl.andus.MiniBox.Drive.eDrive;
import pl.andus.MiniBox.Email.EmailClient;
import pl.andus.MiniBox.Notes.Notes;
import pl.andus.MiniBox.WebBrowser.Browser;
//import pl.andus.MiniBox.WebBrowser.Browser;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    Calc calc = new Calc();
    public static JPanel pMain = new JPanel();
    public static JPanel pEmail = new JPanel();
    public static JPanel pNotes = new JPanel();
    public static JPanel pCalc = new JPanel();
    public static JPanel pWeb = new JPanel();
    //public static JPanel pDrives = new JPanel();

    public Window() {
        JTabbedPane tp = new JTabbedPane();
        tp.add("Main", pMain);
        tp.add("Notes", pNotes);
        tp.add("Calc", pCalc);
        tp.add("E-mail", pEmail);
        tp.add("Web", pWeb);
        //tp.add("Drives", pDrives);


        MainPanel();
        EmailClient.EmailPanel();
        Notes.NotesPanel();
        calc.CalcPanel();
        Browser.BrowserPanel();
        //eDrive.eDrivePanel();

        add(tp);

        setLayout(new GridLayout());
        setTitle("MiniBox - Your Everything");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void MainPanel() {
        JLabel welcomeL = new JLabel("Welcome to MiniBox! Your Minimalistic app to Access Everything");

        pMain.add(welcomeL);
    }
}
