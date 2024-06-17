package script;

import java.util.Scanner;

public class GameFunction {

    public static String StringInput(Scanner scanner) {
        String input = scanner.nextLine();
        if (input.matches("^[a-zA-Z]+$")) {
            return input;
        } else {
            System.out.println("Invalid Input.");
        }
        return null;
    }

}
