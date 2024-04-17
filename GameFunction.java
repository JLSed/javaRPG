import java.util.Scanner;

public class GameFunction {

    public static String VerifyStringInput(Scanner scanner) {
        try {
            return scanner.nextLine();
        } catch (Exception e) {
        }
    }

}
