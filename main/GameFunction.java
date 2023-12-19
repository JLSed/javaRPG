// This is the function dumpster of the game.
// I made this for a better readability and to reduce complicated looks on the mainscript.
// Functions That start with Display_ indicates it is a function that display a visual of some sort.

package main;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameFunction {


    //GAME FUNCTIONS
    public static int rng(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static int UserInput(int min, int max) {
        mainscript.userInput = new Scanner(System.in);
        int inputHolder = 0;
        try {
            inputHolder = mainscript.userInput.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid " + e);
            mainscript.userInput = new Scanner(System.in);
            return -1;
        }
        if (inputHolder >= min && inputHolder <= max) {
            return inputHolder;
        } else {
            return -1;
        }
    }

    public static void GenerateMonster() {
        String[] monsterName = {"Phantom Scourge", "Haunt", "Phantom of Purgatory", "Water Elemental", "Ghost Seeker",
        "Forest Brute", "Dark Fury", "Night Hunter", "Blood Savage", "Hair Demon", "The Cold Mutt", "Abyss Talon", "Emberling",
        "Bronze Worm", "Gaswings", "Warphood", "Cryptbeast", "Blight Cat", "Thunder Elemental", "Earth Elemental", "Void Elemental"};
        mainscript.monster =  new monster(monsterName[(int)GameFunction.rng(0, monsterName.length)], 1, 100, 7, 7, 1,10);
    }

    public static void PlayerAttack(player player) {
        int damageDealt = player.Attack(mainscript.monster.def);
        if (damageDealt < 0) {
            damageDealt = 0;
            System.out.println("The Enemy blocked your attack!");
        }
        mainscript.monster.currentHP -= damageDealt;
        System.out.println("You dealt " + damageDealt + " Damage!");
    }

    public static void EnemyAttack(monster monster) {
        // System.out.println("\n");
        System.out.println("Enemy's Turn:");
        int damageDealt = monster.Attack(mainscript.player.def); 
        mainscript.player.currentHP -= damageDealt;
        System.out.println("You took "+ damageDealt+ " Damage!");
    }

    public static boolean EnemyDead() {
        if (mainscript.monster.currentHP < 0) {
            boolean enemyDead = true;
            int expEarned = mainscript.player.ExpEarned();
            System.out.println("you earned " + expEarned + "!");
            mainscript.player.currentExp += expEarned;
            if (mainscript.player.currentExp >= mainscript.player.exp) {
                System.out.println("You leveled up! current lvl: " + mainscript.player.level);
                mainscript.player.level++;
                mainscript.player.exp += mainscript.player.ExpEarned();
            }
            return enemyDead;
        }
        // If the condition doesnt meet. return false
        return false;
    }


    
    public static void PlayerDeadChecker() {
        if (mainscript.player.currentHP < 0) {
            System.out.println("YOU DIED");
        }
    }

    public static void VisualDelay(int ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (Exception e) {
            // do nothing
        }
    }

    //VISUAL
    
    

    
    

    

}

    