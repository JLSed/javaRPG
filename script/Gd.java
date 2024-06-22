package script;

import java.util.Scanner;
import player.Player;

public class Gd{

    public static void startingScreen() {
        System.out.println("\n─────────█▄██▄█─────────\r\n" + //
                "█▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄█\r\n" + //
                "███┼█████▐████▌█████┼███\r\n" + //
                "█████████▐████▌█████████\r" + //
                "");
        System.out.println("---Welcome to JavaRPG---\n\n");
    }
    
    public static void makeNewCharacter() {
        System.out.println("---New Character---");
        System.out.print("Name: ");
    }   

}
