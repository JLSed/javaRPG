package ui;

import java.awt.Color;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import player.Player;
import script.Gf; // Game Functions
import script.Gd; // Game Displays

public class Main extends JFrame {

    static Player player;
    static Scanner scanner;

    public Main() {
        setTitle("Java RPG");
        setSize(600, 400);

        JTextArea gameUI = new JTextArea("test test");
        gameUI.setForeground(Color.GREEN);
        gameUI.setBackground(Color.BLACK);
        add(gameUI);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
        scanner = new Scanner(System.in);
        StartingMenu();
        System.out.println(player.getName());
    }

    public static void StartingMenu() {
        Gd.startingScreen();
        if (player == null) {
            System.out.println("No Save Found");
            Gd.makeNewCharacter();
            player = Gf.makeNewPlayer(Gf.stringInput(scanner));
        } else {

        }
    }

    public static void MainGame(Player player) {

    }
}
