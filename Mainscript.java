
import java.util.Scanner;


import script.Gf; // Game Functions
import script.Gd; // Game Displays
import player.Player;

public class Mainscript {
    
    static Player player;
    static Scanner scanner;

    public static void main(String[] args) {
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
