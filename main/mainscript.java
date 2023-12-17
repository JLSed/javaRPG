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
        String playerName = "";
        int playerRace = 1;
        do {
            System.out.print("Name: ");
            playerName = userInput.nextLine();
            if (playerName.length() > 5) {
                GameFunction.Display_StartingScreen();
                System.out.println("----------------------");
                System.out.println("Your Name is too Long.");
                System.out.println("----------------------");
            }
            else if (playerName.length() <= 2) {
                GameFunction.Display_StartingScreen();
                System.out.println("----------------------");
                System.out.println("Your Name is too short.");
                System.out.println("----------------------");
            }
        } while (playerName.length() > 5 || playerName.length() <= 2);
        boolean inputViolated = false;
        do {
            System.out.println("Choose your race: \n [1]Human [2]Demon [3]Elf [4]Beast");
            try {
                playerRace = userInput.nextInt();
                inputViolated = false;
                if (playerRace < 1 || playerRace > 4) {
                    System.out.println("Invalid");
                    inputViolated = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid");
                userInput = new Scanner(System.in);
                inputViolated = true;
            }
        } while (inputViolated);
        switch (playerRace) {
            case 1:
                player = new player(playerName,1,100,3,0,1,10,0,"Human");
                break;
            case 2:
                player = new player(playerName,1,100,4,5,2,10,0,"Demon");
                break;
            case 3:
                player = new player(playerName,1,100,2,7,1,10,0,"Elf");
                break;
            case 4:
                player = new player(playerName,1,100,7,2,2,10,0,"Beast");
                break;
            default:
                System.out.println("Error occured. Please Restart the game.");
                break;
        }
    }

    static void MainGame() {
        boolean inputViolated = false;
        GameFunction.Display_MainGame();
        do {
             try {
                int input = userInput.nextInt();
                switch (input) {
                    case 1:
                        inputViolated = false;
                        Adventure();    
                        break;
                    case 2: 
                        System.out.println("Exit");
                        inputViolated = false; 
                        break;
                    default:
                        GameFunction.Display_MainGame();
                        System.out.println("Invalid Input");           
                        inputViolated = true;
                        break;
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
        if (player.spd >= monster.spd) {
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
                    switch (input) {
                        case 1:
                            GameFunction.PlayerAttack(player);
                            GameFunction.VisualDelay(400);
                            if (GameFunction.EnemyDead() == true) {
                                // GameFunction.EnemyDead() is also where the exp earn function is.
                                BattleOver = true;
                                continue;
                            }
                            playerTurn = false; inputViolated = false;                                
                            break;
                        case 2:
                            System.out.println("You Ran.");
                            break;
                    
                        default:
                            GameFunction.Display_BattleModeYourTurn();
                            System.out.println("Invalid Input\n\n\n\n");
                            inputViolated = true;
                            break;
                        }
                    //player attacks: function is inside GameFunction.PlayerAttack()
                    } catch (Exception e) {
                        GameFunction.Display_BattleModeYourTurn();
                        System.out.println("Invalid Input: " + e + "\n\n\n\n");
                        userInput = new Scanner(System.in);
                        inputViolated = true;
                    }
                } while (inputViolated);
                // Enemy turn:
            } else {
                GameFunction.EnemyAttack(monster);
                GameFunction.VisualDelay(400);
                GameFunction.PlayerDeadChecker();
                playerTurn = true;
            }
        } while (BattleOver == false);
    }



}