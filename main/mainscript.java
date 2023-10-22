package main;
import java.util.Scanner;
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
        BattleMode();
    }

    static void BattleMode() {
        boolean playerTurn = false, playerDead = false;
        if (player.speed > monster.speed) {
            playerTurn = true;
        }
        do {
            if (playerTurn == true) {
                userInput = new Scanner(System.in);
                boolean inputViolated = false;
                do {
                    try {
                    GameFunction.Display_BattleModeYourTurn();
                    int input = userInput.nextInt();
                    //player attacks: function is inside GameFunction.playerAttack()
                        if (input == 1) {
                            GameFunction.playerAttack();
                                try {
                                // delay outputs for visual
                                    TimeUnit.MILLISECONDS.sleep(200);
                                } catch (Exception e) {
                                    continue;
                                }
                                if (monster.currentHP < 0) {
                                    double expEarned = ((GameFunction.rng(10, 15) * player.level) / 3.3);
                                    System.out.println("you earned " + expEarned + "!");
                                    player.currentExp += (int)expEarned;
                                    if (player.currentExp >= player.exp) {
                                        System.out.println("You leveled up! current lvl: " + player.level);
                                        player.level++;
                                        player.exp += (int) (50 + (player.level) * 2.5);
                                    }
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
            } else {
               GameFunction.enemyAttack();
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
        if (playerDead) {
            System.out.println("DEAD!");
        }
    }




}