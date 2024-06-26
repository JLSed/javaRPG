package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import player.Player;
import script.Gf; // Game Functions
import script.Gd; // Game Displays

public class Main extends JFrame {

    static Player player;
    static Scanner scanner;
    int Choice = 0;

    public Main() {
        setTitle("Java RPG");
        setSize(600, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // STARTING SCREEN
        StartingMenu();
        if (Choice == 1) {
            System.out.println("hello");
        }
        // JTextArea StartingMenuScreen = new JTextArea("ghello :)");
        // StartingMenuScreen.setBackground(Color.BLACK);
        // add(StartingMenuScreen, BorderLayout.CENTER);
        setVisible(true);
        // if (player == null) {
        // StartingMenu();
        // }

    }

    public void StartingMenu() {
        JPanel StartingMenuPanel = new JPanel();
        JPanel SMbuttonPanel = new JPanel();
        StartingMenuPanel.setLayout(null);
        SMbuttonPanel.setLayout(new GridLayout(3, 1, 100, 20));
        StartingMenuPanel.setBackground(Color.BLACK);
        SMbuttonPanel.setBackground(Color.BLACK);

        JButton buttons[] = new JButton[3];
        String labels[] = { "CONTINUE", "NEW", "QUIT" };
        for (int i = 0; i < buttons.length; i++) {
            final int ii = i;
            JButton b = new JButton(labels[i]);
            b.setBackground(Color.BLACK);
            b.setForeground(Color.GREEN);
            b.setFocusPainted(false);
            b.setBorder(BorderFactory.createEmptyBorder());
            // Browse through the buttons using Arrow Keys
            b.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_UP) {
                        if (ii > 0)
                            buttons[ii - 1].requestFocus();
                        if (ii == 0)
                            buttons[2].requestFocus();
                    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        if (ii < 2)
                            buttons[ii + 1].requestFocus();
                        if (ii == 2)
                            buttons[0].requestFocus();
                    }
                }
            });
            // Call when Enter pressed
            b.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        // TODO:
                        if (b.getText().equals("CONTINUE")) {
                            System.out.println(b.getText());
                            Choice = 1;
                            remove(StartingMenuPanel);
                            MainGame();
                            revalidate();
                            repaint();
                        } else if (b.getText().equals("NEW")) {
                            Choice = 2;
                        } else if (b.getText().equals("EXIT")) {
                            Choice = 3;
                        }
                    }
                }
            });
            // Change Colors when changing focused button
            b.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    b.setBackground(Color.GREEN);
                    b.setForeground(Color.BLACK);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    b.setBackground(Color.BLACK);
                    b.setForeground(Color.GREEN);
                }
            });
            SMbuttonPanel.add(buttons[i] = b);
        }
        SMbuttonPanel.setBounds(245, 200, 100, 100);
        StartingMenuPanel.add(SMbuttonPanel);
        JLabel SMTitle = new JLabel("javaRP{G}");
        SMTitle.setFont(new Font("Arial", Font.BOLD, 52));
        SMTitle.setBounds(175, 10, 300, 200);
        StartingMenuPanel.add(SMTitle);
        add(StartingMenuPanel, BorderLayout.CENTER);

        // Gd.startingScreen();
        // if (player == null) {
        // System.out.println("No Save Found");
        // Gd.makeNewCharacter();
        // player = Gf.makeNewPlayer(Gf.stringInput(scanner));
        // } else {

        // }
    }

    public void MainGame() {
        JPanel MainScreenContainer = new JPanel();
        MainScreenContainer.setLayout(new BorderLayout());
        JTextArea MainScreen = new JTextArea("test test");
        MainScreen.setForeground(Color.GREEN);
        MainScreen.setBackground(Color.BLACK);
        MainScreenContainer.add(MainScreen, BorderLayout.CENTER);

        JTextField TestScreen = new JTextField("asdasd asdasd ");
        TestScreen.setBackground(Color.WHITE);
        TestScreen.setForeground(Color.BLACK);
        MainScreenContainer.setPreferredSize(new Dimension(200, 100));
        MainScreenContainer.add(TestScreen, BorderLayout.PAGE_END);

        add(MainScreenContainer, BorderLayout.LINE_START);

        JPanel BottomPanel = new JPanel();
        BottomPanel.setPreferredSize(new Dimension(500, 200));
        add(BottomPanel, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                scanner = new Scanner(System.in);
                new Main();
            }
        });

        // StartingMenu();
        // System.out.println(player.getName());
    }
}
