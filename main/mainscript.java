package main;
import java.util.Scanner;


public class Mainscript {
    static Scanner userInput;
    static Player player;
    static monster monster;
    static boolean OnAdventure;
    static boolean BattleOver;
    static RaceDescription[] raceInfo = {new HumanDescription(), new DemonDescription(), new ElfDescription(), new BeastDescription()};
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
            int input = 0;
            RaceDescription chosenRace = null;
            System.out.println("Choose your race: ");
            for (int i = 0; i < raceInfo.length; i++) {
                System.out.print("[" + i + "]" + raceInfo[i].RaceName() + " ");
            }
            System.out.print("\n: ");
            playerRace = GameFunction.UserInput(0, raceInfo.length);
            for (int i = 0; i < raceInfo.length; i++) {
                if (playerRace == i) {
                    do {
                        chosenRace = raceInfo[i];
                        System.out.println(chosenRace);
                        raceInfo[i].ShowInfo();
                        input = GameFunction.UserInput(1, 2);
                    } while (input == -1);
                }
            }
            if (input == 1) {
                player = new Player(chosenRace, playerName);
            } else if (input == 2) {
                playerRace = -1;
                continue;
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