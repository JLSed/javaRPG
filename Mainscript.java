import java.util.Scanner;

public class Mainscript {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        GameDisplay.StartingScreen();
        GameDisplay.MakeNewCharacter(scanner, player);
        System.out.println(player.name);

    }

    public static void MainGame(Player player) {

    }
}
