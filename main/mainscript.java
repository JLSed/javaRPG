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
        int playerRace = 0;
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

        do {
            System.out.println("Choose your race: \n [1]Human [2]Demon [3]Elf [4]Beast");
            playerRace = GameFunction.UserInput(1,4);
            int input = 0;
            switch (playerRace) {
                case 1:
                    do {
                        GameDisplay.HumanDescription();
                        input = GameFunction.UserInput(1, 2);
                    } while (input == -1);
                    if (input == 1) {
                        player = new player(playerName, 1, 100, 5, 1, 10, 10, 50, 105, 10, 2, 10, 0,"Human");
                    } else if(input == 2) {
                        playerRace = -1;
                        continue;                    
                    }
                    break;
                case 2:
                    do {
                        GameDisplay.DemonDescription();
                        input = GameFunction.UserInput(1, 2);
                    } while (input == -1);
                    if (input == 1) {
                                    player = new player(playerName, 1, 100, 4, 5, 10, 10, 50, 100, 5, 5, 10, 0,"Demon");
                    } else if(input == 2) {
                        playerRace = -1;
                        continue;                    
                    }
                    break;
                case 3:
                    do {
                        GameDisplay.ElfDescription();
                        input = GameFunction.UserInput(1, 2);
                    } while (input == -1);
                    if (input == 1) {
                        player = new player(playerName, 1, 100, 2, 7, 10, 15, 50, 100, 5, 15, 10, 0,"Elf");
                    } else if(input == 2) {
                        playerRace = -1;
                        continue;                    
                    }
                    break;
                case 4:
                    do {
                        GameDisplay.BeastDescription(); 
                        input = GameFunction.UserInput(1, 2);
                    } while (input == -1);
                    if (input == 1) {
                        player = new player(playerName, 1, 100, 7, 2, 15, 10, 50, 110, 15, 5, 10, 0,"Beast");
                    } else if(input == 2) {
                        playerRace = -1;
                        continue;                    
                    }
                       
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while (playerRace == -1);
        
    }

    static void MainGame() {
        int input;
        GameDisplay.MainGame();
        do {
            input = GameFunction.UserInput(1, 2);
        } while (input == -1);

        switch (input) {
            case 1:
                Adventure();    
                break;
            case 2: 
                System.out.println("Exit");
                break;
            default:
                GameDisplay.MainGame();
                System.out.println("Invalid Input");           
                break;
        }
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
                int input = 0;
                do {
                    GameDisplay.BattleModeYourTurn();
                    input = GameFunction.UserInput(1, 2);
                } while (input == -1);
                switch (input) {
                    case 1:
                        GameFunction.PlayerAttack(player);
                        GameFunction.VisualDelay(400);
                        if (GameFunction.EnemyDead() == true) {
                            // GameFunction.EnemyDead() is also where the exp earn function is.
                            BattleOver = true;
                            continue;
                        }
                        playerTurn = false;                               
                        break;
                    case 2:
                        System.out.println("You Ran.");
                        break;
                    default:
                        GameDisplay.BattleModeYourTurn();
                        System.out.println("Invalid Input\n\n\n\n");
                        break;
                    }
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