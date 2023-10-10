package main;
import java.util.Scanner;
import java.util.Random;

public class mainscript {

    static int playerLevel = 1;
    static int playerExp = 0;
    static int playerMaxHP = 100;
    static int playerCurrentHP = playerMaxHP;
    static int playerHighestDamage = 10;
    static int playerLowestDamage = 0;
    static int playerSpeed = 11;
    static String playerName;
    static Scanner userInput;
    static monster monster;
    static boolean isAlive;
    public static void main(String[] args) {

        StartingScreen();
        MainGame();
    userInput.close();
    }

    static void Display_StartingScreen() {
        System.out.println("─────────█▄██▄█─────────\r\n" + //
                "█▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄█\r\n" + //
                "███┼█████▐████▌█████┼███\r\n" + //
                "█████████▐████▌█████████\r\n" + //
                "");
        System.out.println("---WELCOME TO JAVARPG---\r\n");
        System.out.println("\r\n-----New Character------");
    }
    static void StartingScreen() {
        Display_StartingScreen();
        userInput = new Scanner(System.in);
        do {
            System.out.print("Name: ");
            playerName = userInput.nextLine();
            if (playerName.length() > 5) {
                Display_StartingScreen();
                System.out.println("----------------------");
                System.out.println("Your Name is too Long.");
                System.out.println("----------------------");
            }
            else if (playerName.length() <= 2) {
                Display_StartingScreen();
                System.out.println("----------------------");
                System.out.println("Your Name is too short.");
                System.out.println("----------------------");
            }
        } while (playerName.length() > 5 || playerName.length() <= 2);
    }

    static void Display_MainGame() {
        System.out.println("----------------------------------------------------------");
        System.out.println("    ^  ^  ^   ^      ___I_      ^  ^   ^  ^  ^   ^  ^\r\n" + //
                "   /|\\/|\\/|\\ /|\\    /\\-_--\\    /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n" + //
                "   /|\\/|\\/|\\ /|\\   /  \\_-__\\   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n" + //
                "   /|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\");
        System.out.println("----------------------------------------------------------");
        System.out.println("     Name: " + playerName + "                         Level: " + playerLevel);
        System.out.println("     Health: " + playerMaxHP + "                       Exp: " + playerExp);
        System.out.println("----------------------------------------------------------");
        System.out.
        println("     \"1: Adventure\"                       \"2: Exit Game\"");
    }

    static void MainGame() {
        boolean inputViolated = false;
        Display_MainGame();
        do {
             try {
                int input = userInput.nextInt();
                if (input == 1) {
                    inputViolated = false;
                    Adventure();
                } else if (input == 2) {
                    System.out.println("Exit");
                    inputViolated = false;
                } else {
                    Display_MainGame();
                    System.out.println("Invalid Input");           
                    inputViolated = true;
                }
            } catch (Exception e) {
            Display_MainGame();
            System.out.println("Invalid Input: " + e);
            userInput = new Scanner(System.in);
            inputViolated = true;
            }
        } while (inputViolated == true);
    }

    static void Adventure() {
        System.out.println("You departed from your base to start your adventure...");
        isAlive = true;
        do {
            EncounterMonster();
        } while (isAlive == true);
    }

    //three main situation: ENCOUNTER, DISCOVERY, EXPLORE 
    static void EncounterMonster() {
        GenerateMonster();
        System.out.println("You Encounter A " + monster.name + "!");
        BattleMode();
    }

    static void BattleMode() {
        boolean playerTurn = false;
        boolean enemyTurn = false;
        if (playerSpeed > monster.speed) {
            playerTurn = true;
        } else {
            enemyTurn = true;
        }
        do {
            if (playerTurn == true) {
                System.out.println("Your Turn");
                System.out.println("1: Attack       2: Run");
                userInput = new Scanner(System.in);
                int input = userInput.nextInt();
                try {
                    if (input == 1) {
                        int damageDealt = rng(playerLowestDamage, playerHighestDamage);
                        monster.health -= damageDealt;
                        System.out.println("you dealt " + damageDealt + " Damage!");
                        
                    } else if (input == 2) {
                        System.out.println("You Ran.");
                    } else {
                        System.out.println("Invalid Input");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Input: " + e);
                }
            }
            else {
                System.out.println("Enemy's Turn");
            }
        } while (playerCurrentHP > 0);
    }

    //GAME FUNCTIONS
    static void GenerateMonster() {
        String[] monsterName = {"Phantom Scourge", "Haunt", "Phantom of Purgatory", "Water Elemental", "Ghost Seeker",
    "Forest Brute", "Dark Fury", "Night Hunter", "Blood Savage", "Hair Demon", "The Cold Mutt", "Abyss Talon", "Emberling",
    "Bronze Worm", "Gaswings", "Warphood", "Cryptbeast", "Blight Cat", "Thunder Elemental", "Earth Elemental", "Void Elemental"};
        monster = new monster(monsterName[rng(1, monsterName.length) - 1], 1, 100, 1, 10, rng(1,10));
    } 

    //MISC FUNCTIONS
    static int rng(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max +=1) - min) + min;
    }
}