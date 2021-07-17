package pl.andus.MiniBox.Notes;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Functions {
    public static void SaveFunc() {
        JFileChooser j = new JFileChooser("f:");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt", "text");
        j.setFileFilter(filter);

        int r = j.showSaveDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            File fi = new File(j.getSelectedFile().getAbsolutePath());

            try {
                FileWriter wr = new FileWriter(fi, false);

                BufferedWriter w = new BufferedWriter(wr);

                w.write(Notes.editPane.getText());

                w.flush();
                w.close();
            } catch (Exception evt) {
                evt.printStackTrace();
            }
        } else {

        }
    }

    public static void OpenFunc() {
        JFileChooser j = new JFileChooser("f:");

        int r = j.showOpenDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            File fi = new File(j.getSelectedFile().getAbsolutePath());

            try {
                String s1;
                StringBuilder sl;

                FileReader fr = new FileReader(fi);

                BufferedReader br = new BufferedReader(fr);

                sl = new StringBuilder(br.readLine());

                while ((s1 = br.readLine()) != null) {
                    sl.append("\n").append(s1);
                }

                Notes.editPane.setText(sl.toString());
            } catch (Exception evt) {
                evt.printStackTrace();
            }
        }
    }
}
