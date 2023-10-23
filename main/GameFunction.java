package main;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class GameFunction {


    //GAME FUNCTIONS
    public static int rng(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max +=1) - min) + min;
    }

    public static void GenerateMonster() {
        String[] monsterName = {"Phantom Scourge", "Haunt", "Phantom of Purgatory", "Water Elemental", "Ghost Seeker",
        "Forest Brute", "Dark Fury", "Night Hunter", "Blood Savage", "Hair Demon", "The Cold Mutt", "Abyss Talon", "Emberling",
        "Bronze Worm", "Gaswings", "Warphood", "Cryptbeast", "Blight Cat", "Thunder Elemental", "Earth Elemental", "Void Elemental"};
        mainscript.monster =  new monster(monsterName[GameFunction.rng(1, monsterName.length) - 1], 3, 100, 1, 10,GameFunction.rng(1,10));
    }

    public static void PlayerAttack() {
        int damageDealt =GameFunction.rng(mainscript.player.lowestDamage, mainscript.player.highestDamage);
        mainscript.monster.currentHP -= damageDealt;
        System.out.println("You dealt " + damageDealt + " Damage!");
    }

    public static void EnemyAttack() {
        System.out.println("\n");
        System.out.println("Enemy's Turn:");
        int damageDealt =GameFunction.rng(mainscript.monster.lowestDamage, mainscript.monster.highestDamage);
        mainscript.player.currentHP -= damageDealt;
        System.out.println("You took "+ damageDealt+ " Damage!\n");
    }

    public static boolean EnemyDead() {
        if (mainscript.monster.currentHP < 0) {
            boolean enemyDead = true;
            double expEarned = ((GameFunction.rng(10, 15) * mainscript.player.level) / 3.3);
            System.out.println("you earned " + expEarned + "!");
            mainscript.player.currentExp += (int)expEarned;
            if (mainscript.player.currentExp >= mainscript.player.exp) {
                System.out.println("You leveled up! current lvl: " + mainscript.player.level);
                mainscript.player.level++;
                mainscript.player.exp += (int) (50 + (mainscript.player.level) * 2.5);
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
    static void Display_StartingScreen() {
        System.out.println("─────────█▄██▄█─────────\r\n" + //
                "█▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄█\r\n" + //
                "███┼█████▐████▌█████┼███\r\n" + //
                "█████████▐████▌█████████\r\n" + //
                "");
        System.out.println("---WELCOME TO JAVARPG---\r\n");
        System.out.println("\r\n-----New Character------");
    }

    static void Display_MainGame() {
        System.out.println("----------------------------------------------------------");
        System.out.println("    ^  ^  ^   ^      ___I_      ^  ^   ^  ^  ^   ^  ^\r\n" + //
                "   /|\\/|\\/|\\ /|\\    /\\-_--\\    /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n" + //
                "   /|\\/|\\/|\\ /|\\   /  \\_-__\\   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n" + //
                "   /|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\");
        System.out.println("----------------------------------------------------------");
        System.out.println("     Name: " + mainscript.player.name + "   Level: " + mainscript.player.level);
        System.out.println("     Health: " + mainscript.player.maxHP + "    Exp: " + mainscript.player.currentExp + "/" + mainscript.player.exp);
        System.out.println("----------------------------------------------------------");
        System.out.
        println("     \"1: Adventure\"                       \"2: Exit Game\"");
    }

    public static void Display_BattleModeYourTurn() {
        System.out.println("Current Exp: " + mainscript.player.currentExp  + "/" + mainscript.player.exp);
        System.out.println(mainscript.player.name+": " + mainscript.player.currentHP +"|----|"+ mainscript.monster.currentHP+" :" + mainscript.monster.name);
        System.out.println("Your Turn:");
        System.out.println("1: Attack       2: Run");
    }

    
    

    

}

    