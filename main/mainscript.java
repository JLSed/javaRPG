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
        GameDisplay.StartingScreen();
        userInput = new Scanner(System.in);
        String playerName = "";
        int playerRace = 1;
        do {
            System.out.print("Name: ");
            playerName = userInput.nextLine();
            if (playerName.length() > 5) {
                GameDisplay.StartingScreen();
                System.out.println("----------------------");
                System.out.println("Your Name is too Long.");
                System.out.println("----------------------");
            }
            else if (playerName.length() <= 2) {
                GameDisplay.StartingScreen();
                System.out.println("----------------------");
                System.out.println("Your Name is too short.");
                System.out.println("----------------------");
            }
        } while (playerName.length() > 5 || playerName.length() <= 2);
        boolean inputViolated = false;
        do {
            System.out.println("Choose your race: \n [1]Human [2]Demon [3]Elf [4]Beast");
           playerRace = GameFunction.UserInput(1, 4, userInput);
            switch (playerRace) {
            case 1:
                GameDisplay.HumanDescription();
                player = new player(playerName,1,100,5,0,1,10,0,"Human");
                break;
            case 2:
                GameDisplay.DemonDescription();
                player = new player(playerName,1,100,4,5,2,10,0,"Demon");
                break;
            case 3:
                GameDisplay.ElfDescription();
                player = new player(playerName,1,100,2,7,1,10,0,"Elf");
                break;
            case 4:
                GameDisplay.BeastDescription();    
                player = new player(playerName,1,100,7,2,2,10,0,"Beast");
                break;
            default:
                System.out.println("Error occured. Please Restart the game.");
                break;
            }
        } while (inputViolated);
       
    }

    static void MainGame() {
        boolean inputViolated = false;
        GameDisplay.MainGame();
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
                        GameDisplay.MainGame();
                        System.out.println("Invalid Input");           
                        inputViolated = true;
                        break;
                }
            } catch (Exception e) {
            GameDisplay.MainGame();
            System.out.println("Invalid Input: " + e);
            userInput = new Scanner(System.in);
            inputViolated = true;
            }
        } while (inputViolated);
    }

    static void Adventure() {
        GameDisplay.DepartedFromBase();
        OnAdventure = true;
        do {
            EncounterMonster();
        } while (OnAdventure == true);
    }

    //three main situations: ENCOUNTER, DISCOVERY, EXPLORE 
    static void EncounterMonster() {
        GameFunction.GenerateMonster();
        GameDisplay.EnemyEncounter();
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
            GameDisplay.BattleSpeedTurnSentence(playerTurn);
        } else {
            GameDisplay.BattleSpeedTurnSentence(playerTurn);
        }
        do {
            //Player turn:
            if (playerTurn == true) {
                userInput = new Scanner(System.in);
                boolean inputViolated = false;
                do {
                    try {
                    GameDisplay.BattleModeYourTurn();
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
                            GameDisplay.BattleModeYourTurn();
                            System.out.println("Invalid Input\n\n\n\n");
                            inputViolated = true;
                            break;
                        }
                    //player attacks: function is inside GameFunction.PlayerAttack()
                    } catch (Exception e) {
                        GameDisplay.BattleModeYourTurn();
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