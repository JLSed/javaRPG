package script;

import java.util.Scanner;

import player.Player;

public class Gf{

    public static String stringInput(Scanner scanner) {
        String input = scanner.nextLine();
        if (input.matches("^[a-zA-Z]+$")) {
            return input;
        } else {
            System.out.println("Invalid Input.");
        }
        return null;
    }

   public static Player makeNewPlayer(String input) {
        Player player = new Player(input);
        return player;
    }

}
