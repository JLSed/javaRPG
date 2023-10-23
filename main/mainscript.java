package main;
import java.util.Scanner;


public class mainscript {
    static Scanner userInput;
    static player player;
    static monster monster;
    static boolean OnAdventure;
    static boolean BattleOver;

    public static void main(String[] args) {
        StartingScreen();
        MainGame();
        userInput.close();
    }
    
    static void StartingScreen() {
        GameFunction.Display_StartingScreen();
        userInput = new Scanner(System.in);
        do {
            System.out.print("Name: ");
            player = new player(userInput.nextLine(), 1, 1000, 10, 50, 100, 0);
            if (player.name.length() > 5) {
                GameFunction.Display_StartingScreen();
                System.out.println("----------------------");
                System.out.println("Your Name is too Long.");
                System.out.println("----------------------");
            }
            else if (player.name.length() <= 2) {
                GameFunction.Display_StartingScreen();
                System.out.println("----------------------");
                System.out.println("Your Name is too short.");
                System.out.println("----------------------");
            }
        } while (player.name.length() > 5 || player.name.length() <= 2);
    }

    static void MainGame() {
        boolean inputViolated = false;
        GameFunction.Display_MainGame();
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
                    GameFunction.Display_MainGame();
                    System.out.println("Invalid Input");           
                    inputViolated = true;
                }
            } catch (Exception e) {
            GameFunction.Display_MainGame();
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

    //three main situations: ENCOUNTER, DISCOVERY, EXPLORE 
    static void EncounterMonster() {
        GameFunction.GenerateMonster();
        System.out.println("\n\n\nYou Encounter A " + monster.name + "!\n");
        do {
            BattleMode();
        } while (BattleOver == false);
        System.out.println("BATTLE IS OVER!!!");
    }

    static void BattleMode() {
        BattleOver = false;
        boolean playerTurn = false;
        if (player.speed > monster.speed) {
            playerTurn = true;
        }
        do {
            //Player turn:
            if (playerTurn == true) {
                userInput = new Scanner(System.in);
                boolean inputViolated = false;
                do {
                    try {
                    GameFunction.Display_BattleModeYourTurn();
                    int input = userInput.nextInt();
                    //player attacks: function is inside GameFunction.PlayerAttack()
                        if (input == 1) {
                            GameFunction.PlayerAttack();
                            GameFunction.VisualDelay(400);
                            if (GameFunction.EnemyDead() == true) {
                                // GameFunction.EnemyDead() is also where the exp earn function is.
                                BattleOver = true;
                                continue;
                            }
                            playerTurn = false; inputViolated = false;
                        } else if (input == 2) {
                            System.out.println("You Ran.");
                        } else {
                            GameFunction.Display_BattleModeYourTurn();
                            System.out.println("Invalid Input\n\n\n\n");
                            inputViolated = true;
                        }
                    } catch (Exception e) {
                        GameFunction.Display_BattleModeYourTurn();
                        System.out.println("Invalid Input: " + e + "\n\n\n\n");
                        userInput = new Scanner(System.in);
                        inputViolated = true;
                    }
                } while (inputViolated);
                // Enemy turn:
            } else {
                GameFunction.EnemyAttack();
                GameFunction.VisualDelay(400);
                GameFunction.PlayerDeadChecker();
            }
        } while (BattleOver == false);
    }



}