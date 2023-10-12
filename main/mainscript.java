package main;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    static boolean OnAdventure;
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
        } while (inputViolated);
    }

    static void Adventure() {
        System.out.println("You departed from your base to start your adventure...");
        OnAdventure = true;
        do {
            EncounterMonster();
        } while (OnAdventure == true);
    }

    //three main situation: ENCOUNTER, DISCOVERY, EXPLORE 
    static void EncounterMonster() {
        GenerateMonster();
        System.out.println("\n\n\nYou Encounter A " + monster.name + "!\n");
        BattleMode();
    }

    static void Display_BattleModeYourTurn() {
        System.out.println("Your Health: " + playerCurrentHP + "|----|"+ monster.name+ "'s Health: "+monster.health);
        System.out.println("Your Turn:");
        System.out.println("1: Attack       2: Run");
    }

    static void BattleMode() {
        boolean playerTurn = false;
        if (playerSpeed > monster.speed) {
            playerTurn = true;
        }
        do {
            if (playerTurn == true) {
                
                userInput = new Scanner(System.in);
                boolean inputViolated = false;
                do {
                    try {
                    Display_BattleModeYourTurn();
                    int input = userInput.nextInt();
                    if (input == 1) {
                        int damageDealt = rng(playerLowestDamage, playerHighestDamage);
                        monster.health -= damageDealt;
                        System.out.println("You dealt " + damageDealt + " Damage!");
                        // delay outputs for visual
                        try {
                            TimeUnit.MILLISECONDS.sleep(200);
                        } catch (Exception e) {
                            continue;
                        }
                        playerTurn = false;
                        inputViolated = false;
                    } else if (input == 2) {
                        System.out.println("You Ran.");
                    } else {
                        Display_BattleModeYourTurn();
                        System.out.println("Invalid Input");
                        System.out.println("\n\n\n\n");
                        inputViolated = true;
                    }
                    } catch (Exception e) {
                        Display_BattleModeYourTurn();
                        System.out.println("Invalid Input: " + e);
                        System.out.println("\n\n\n\n");
                        userInput = new Scanner(System.in);
                        inputViolated = true;
                    }
                } while (inputViolated);
            }
            else {
                System.out.println("\n");
                System.out.println("Enemy's Turn:");
                int damageDealt = rng(monster.lowestDamage, monster.highestDamage);
                playerCurrentHP -= damageDealt;
                System.out.println("You took "+ damageDealt+ " Damage!\n");
                // delay outputs for visual
                try {
                    TimeUnit.MILLISECONDS.sleep(400);
                } catch (Exception e) {
                    continue;
                }
                playerTurn = true;
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