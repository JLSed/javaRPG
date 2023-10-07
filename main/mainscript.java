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
    static String playerName;
    static Scanner userInput;
    static monster monster;
    static boolean isAlive;
    public static void main(String[] args) {

        StartingScreen();
        MainGame();
    userInput.close();
    }

    static void StartingScreen() {
        System.out.println("─────────█▄██▄█─────────\r\n" + //
                "█▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄█\r\n" + //
                "███┼█████▐████▌█████┼███\r\n" + //
                "█████████▐████▌█████████\r\n" + //
                "");
        System.out.println("---WELCOME TO JAVARPG---\r\n");
        System.out.println("\r\n-----New Character------");
        userInput = new Scanner(System.in);
        do {
            System.out.print("Name: ");
            playerName = userInput.nextLine();
            if (playerName.length() > 5) {
                System.out.println("----------------------");
                System.out.println("Your Name is too Long.");
                System.out.println("----------------------");
            }
        } while (playerName.length() > 5);
    }

    static void MainGame() {
        boolean inputViolated = false;
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
                    System.out.println("Invalid Input");           
                    inputViolated = true;
                }
            } catch (Exception e) {
            System.out.println("Invalid Input: " + e);
            userInput = new Scanner(System.in);
            inputViolated = true;
            }
        } while (inputViolated == true);
    }

    static void Adventure() {
        System.out.println("You departed from your base to start your adventure...");
        
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
        do {
            
        } while (playerCurrentHP >= 0);
    }

    //GAME FUNCTIONS
    static void GenerateMonster() {
        String[] monsterName = {"Phantom Scourge", "Haunt", "Phantom of Purgatory", "Water Elemental", "Ghost Seeker",
    "Forest Brute", "Dark Fury", "Night Hunter", "Blood Savage", "Hair Demon", "The Cold Mutt", "Abyss Talon", "Emberling",
    "Bronze Worm", "Gaswings", "Warphood", "Cryptbeast", "Blight Cat", "Thunder Elemental", "Earth Elemental", "Void Elemental"};
        monster = new monster(monsterName[rng(1, monsterName.length) - 1], 1, 1, 10);
    } 


    //MISC FUNCTIONS
    static int rng(int min, int max) {
        Random rand = new Random();
        max +=1;
        return rand.nextInt(max - min) + min;
    }
}