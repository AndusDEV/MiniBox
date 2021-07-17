package pl.andus.MiniBox.Notes;

import javafx.scene.chart.Chart;
import pl.andus.MiniBox.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notes {
    static JPanel writeP = new JPanel();
    static JPanel userP = new JPanel();

    static JEditorPane editPane = new JEditorPane();
    static JScrollPane scrollPane = new JScrollPane(editPane);

    static JButton saveBtn = new JButton("Save to file");
    static JButton openBtn = new JButton("Open a file");
    static JButton copyBtn = new JButton("Copy text");
    static JButton allBtn = new JButton("Select all text");

    public static void NotesPanel() {
        writeP.setBackground(Color.gray);
        editPane.setPreferredSize(new Dimension(400,170));
        editPane.setBackground(Color.lightGray);
        editPane.setText("Write something here!");

        userP.setBackground(Color.cyan);
        saveBtn.setBounds(20, 10, 35, 20);
        openBtn.setBounds(20, 10, 35, 20);
        copyBtn.setBounds(20, 10, 35, 20);
        allBtn.setBounds(20, 10, 35, 20);

        writeP.add(scrollPane);

        userP.add(saveBtn);
        userP.add(openBtn);
        userP.add(copyBtn);
        userP.add(allBtn);

        Window.pNotes.add(writeP);
        Window.pNotes.add(userP);
        Window.pNotes.setLayout(new FlowLayout());

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Functions.SaveFunc();
            }
        });

        openBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Functions.OpenFunc();
            }
        });

        copyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPane.copy();
            }
        });

        allBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPane.selectAll();
            }
        });
    }
}
