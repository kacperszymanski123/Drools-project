
package com.sample;

import javax.swing.*;
import java.awt.*;

public class Presenter {
    private static JFrame jFrame;
    private static JPanel panel;

    static {
        jFrame = new JFrame("Website IDEAS");
        jFrame.setSize(700, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        jFrame.getContentPane().add(panel);
        jFrame.setVisible(true);
    }

    public static String askQuestion(String question, String[] options) {
        panel.removeAll();

        JLabel questionLabel = new JLabel(question);
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(Box.createVerticalStrut(20));
        panel.add(questionLabel);

        final String[] selectedAnswer = new String[1];

        for (int i = 0; i < options.length; i++) {
            final int index = i;
            JButton optionButton = new JButton(options[i]);
            optionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            optionButton.setFont(new Font("Arial", Font.PLAIN, 15));
            panel.add(Box.createVerticalStrut(20));

            optionButton.addActionListener(e -> {
                selectedAnswer[0] = options[index];
            });

            panel.add(optionButton);
        }

        jFrame.revalidate();
        jFrame.repaint();

        while (selectedAnswer[0] == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return selectedAnswer[0];
    }

    public static void giveAnswer(String answer) {
        panel.removeAll();
        
        JLabel resultLabel = new JLabel(answer);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(resultLabel);

        jFrame.revalidate();
        jFrame.repaint();
    }
}
