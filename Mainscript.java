
import java.util.Scanner;
import script.GameFunction;
import player.Player;

public class Mainscript {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player();
        GameDisplay.StartingScreen();
        GameDisplay.MakeNewCharacter(StringInput(scanner), player);
        System.out.println(player.name);

    }

    public static void MainGame(Player player) {

    }
}
