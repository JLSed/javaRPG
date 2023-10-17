package main;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class mainscript {
    static Scanner userInput;
    static player player;
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
            player = new player(userInput.nextLine(), 1, 100, 1, 10, 100, 0);
            if (player.name.length() > 5) {
                Display_StartingScreen();
                System.out.println("----------------------");
                System.out.println("Your Name is too Long.");
                System.out.println("----------------------");
            }
            else if (player.name.length() <= 2) {
                Display_StartingScreen();
                System.out.println("----------------------");
                System.out.println("Your Name is too short.");
                System.out.println("----------------------");
            }
        } while (player.name.length() > 5 || player.name.length() <= 2);
    }

    static void Display_MainGame() {
        System.out.println("----------------------------------------------------------");
        System.out.println("    ^  ^  ^   ^      ___I_      ^  ^   ^  ^  ^   ^  ^\r\n" + //
                "   /|\\/|\\/|\\ /|\\    /\\-_--\\    /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n" + //
                "   /|\\/|\\/|\\ /|\\   /  \\_-__\\   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\\r\n" + //
                "   /|\\/|\\/|\\ /|\\   |[]| [] |   /|\\/|\\ /|\\/|\\/|\\ /|\\/|\\");
        System.out.println("----------------------------------------------------------");
        System.out.println("     Name: " + player.name + "                         Level: " + player.level);
        System.out.println("     Health: " + player.maxHP + "                       Exp: " + player.exp);
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
        System.out.println(player.name+": " + player.currentHP +"|----|"+monster.currentHP+" :" + monster.name);
        System.out.println("Your Turn:");
        System.out.println("1: Attack       2: Run");
    }

    static void BattleMode() {
        boolean playerTurn = false;
        boolean playerDead = false;
        if (player.speed > monster.speed) {
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
                        int damageDealt =miscFunction.rng(player.lowestDamage, player.highestDamage);
                        monster.currentHP -= damageDealt;
                        System.out.println("You dealt " + damageDealt + " Damage!");
                        try {
                        // delay outputs for visual
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
                        System.out.println("Invalid Input\n\n\n\n");
                        inputViolated = true;
                    }
                    } catch (Exception e) {
                        Display_BattleModeYourTurn();
                        System.out.println("Invalid Input: " + e + "\n\n\n\n");
                        userInput = new Scanner(System.in);
                        inputViolated = true;
                    }
                } while (inputViolated);
            } else {
                System.out.println("\n");
                System.out.println("Enemy's Turn:");
                int damageDealt =miscFunction.rng(monster.lowestDamage, monster.highestDamage);
                player.currentHP -= damageDealt;
                System.out.println("You took "+ damageDealt+ " Damage!\n");
                try {
                // delay outputs for visual
                    TimeUnit.MILLISECONDS.sleep(400);
                } catch (Exception e) {
                    continue;
                }
                if (player.currentHP < 0) {
                    playerDead = true;
                } else {
                    playerTurn = true;
                }
            }
            
        } while (playerDead == false);

        System.out.println("DEAD!");
    }

    //GAME FUNCTIONS
    static void GenerateMonster() {
        String[] monsterName = {"Phantom Scourge", "Haunt", "Phantom of Purgatory", "Water Elemental", "Ghost Seeker",
    "Forest Brute", "Dark Fury", "Night Hunter", "Blood Savage", "Hair Demon", "The Cold Mutt", "Abyss Talon", "Emberling",
    "Bronze Worm", "Gaswings", "Warphood", "Cryptbeast", "Blight Cat", "Thunder Elemental", "Earth Elemental", "Void Elemental"};
        monster = new monster(monsterName[miscFunction.rng(1, monsterName.length) - 1], 1, 100, 1, 10,miscFunction.rng(1,10));
    } 