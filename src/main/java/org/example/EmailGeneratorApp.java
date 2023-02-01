package org.example;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EmailGeneratorApp
{

    private JFrame frame;
    private JTextField emailField;
    private JButton copyButton;
    private JButton generateButton;

    public EmailGeneratorApp()
    {
        frame = new JFrame("Email Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        emailField = new JTextField(20);
        emailField.setEditable(false);
        frame.add(emailField);

        generateButton = new JButton("Generate");
        generateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String email = EmailGenerator.generateEmail();
                emailField.setText(email);
            }
        });
        frame.add(generateButton);

        copyButton = new JButton("Copy");
        copyButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                StringSelection stringSelection = new StringSelection(emailField.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }

        });
        frame.add(copyButton);
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args)
    {
        new EmailGeneratorApp();
    }

}
