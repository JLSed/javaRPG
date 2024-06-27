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
import java.awt.event.KeyListener;
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

public class GameGui extends JFrame {

    static Player player;
    static Scanner scanner;

    public GameGui() {
        setTitle("Java RPG");
        setSize(600, 400);
        // setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // STARTING SCREEN
        StartingMenu();
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
        StartingMenuPanel.setLayout(null);
        StartingMenuPanel.setBackground(Color.BLACK);
        String labels[][] = {{"CONTINUE"}, {"NEW"}, {"QUIT"}};
        KeyListener SMchangePanel = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    String entered = ((JButton) e.getComponent()).getText();
                    if (entered.equals("CONTINUE")) {
                         remove(StartingMenuPanel);
                         MainGame();
                         revalidate();
                         repaint();
                    System.out.println("C");
            
                    } else if (entered.equals("NEW")) {
                        System.out.println("N");
            
                    } else if (entered.equals("QUIT")) {
                        System.out.println("Q");
            
                    }
                }
            }
        };
        GameButton SMbuttonPanel = new GameButton(3, 1, labels, SMchangePanel);
        SMbuttonPanel.setBounds(240, 200, 100, 100);
        JLabel SMTitle = new JLabel("javaRP{G}");
        SMTitle.setFont(new Font("Arial", Font.BOLD, 50));
        SMTitle.setBounds(170, 10, 300, 200);
        StartingMenuPanel.add(SMbuttonPanel);
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
        JTextArea MainScreen = new JTextArea("ASDASD");
        //TODO: make scrollpane that will automatically scroll down with animation when text is not fit
        MainScreen.setBackground(Color.BLACK);
        MainScreen.setForeground(Color.GREEN);
        MainScreen.setText("asdasdadasdasda");
        MainScreenContainer.add(MainScreen, BorderLayout.CENTER);

        JTextField TestScreen = new JTextField("asdasd asdasd ");
        TestScreen.setBackground(Color.BLACK);
        TestScreen.setForeground(Color.GREEN);
        MainScreenContainer.setPreferredSize(new Dimension(200, 100));
        MainScreenContainer.add(TestScreen, BorderLayout.PAGE_END);

        add(MainScreenContainer, BorderLayout.CENTER);

        JPanel RightPanel = new JPanel();
        RightPanel.setPreferredSize(new Dimension(120, 200));
        RightPanel.add(new JTextArea("TESTTT"), BorderLayout.LINE_START);
        add(RightPanel, BorderLayout.LINE_END);

        JPanel BottomPanel = new JPanel();
        BottomPanel.setPreferredSize(new Dimension(500, 100));
        add(BottomPanel, BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                scanner = new Scanner(System.in);
                new GameGui();
            }
        });

        // StartingMenu();
        // System.out.println(player.getName());
    }
}
