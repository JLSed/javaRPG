import java.util.Scanner;

public class GameDisplay {

    public static void StartingScreen() {
        System.out.println("\n─────────█▄██▄█─────────\r\n" + //
                "█▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄█\r\n" + //
                "███┼█████▐████▌█████┼███\r\n" + //
                "█████████▐████▌█████████\r" + //
                "");
        System.out.println("---Welcome to JavaRPG---");
    }

    public static void MakeNewCharacter(String input, Player player) {
        System.out.println("---New Character---");
        System.out.print("Name: ");
        player.name = input;

    }
}
