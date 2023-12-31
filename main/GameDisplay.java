package main;

public class GameDisplay {

    static void StartingScreen() {
        System.out.println("─────────█▄██▄█─────────\r\n" + //
                "█▄█▄█▄█▄█▐█┼██▌█▄█▄█▄█▄█\r\n" + //
                "███┼█████▐████▌█████┼███\r\n" + //
                "█████████▐████▌█████████\r\n" + //
                "");
        System.out.println("---WELCOME TO JAVARPG---\r\n");
        System.out.println("\r\n-----New Character------");
    }

    static void MainGame() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("   ___I_      Name: " + Mainscript.player.name);
        System.out.println("  /\\-_--\\    Level: " + Mainscript.player.level);
        System.out.println(" /  \\_-__\\    Race: " + Mainscript.player.race);
        System.out.println(" |[]| [] |     Exp: " + Mainscript.player.currentExp + "/" + Mainscript.player.exp);
        System.out.println("────────────────────────────────");
        System.out.println("[1] Adventure | [2] Exit Game");
    }

    static void DepartedFromBase() {
        String text = "You departed from your base to start your adventure...";
        for (int i = 0; i < text.length() ; i++) {
            try {
                System.out.print(text.charAt(i));
            } catch (Exception e) {
                System.out.println(text);
            }
            GameFunction.VisualDelay(25);
        }
        System.out.println("\n");
    }

    static void EnemyEncounter() {
        for (int i = 0; i < 4; i++) {
            System.out.print("                                       \r");  
            GameFunction.VisualDelay(i * 150);  
            System.out.print("You Encounter A " + Mainscript.monster.name + "!\r");
            GameFunction.VisualDelay(i * 250);
        }
        GameFunction.VisualDelay(100);
        System.out.println();
    }

    static void BattleModeYourTurn() {
        System.out.println("Current Exp: " + Mainscript.player.currentExp  + "/" + Mainscript.player.exp);
        System.out.println(Mainscript.player.name+": " + Mainscript.player.currentHP +"|----|"+ Mainscript.monster.currentHP+" :" + Mainscript.monster.name);
        System.out.println("Your Turn:");
        System.out.println("[1] Attack       [2] Run");
    }

    static void BattleSpeedTurnSentence(boolean playerTurn) {
        if (playerTurn == true) {
            String text[] = {"Your speed surpasses that of your opponent.",
            "You move at a pace significantly faster than your opponent.",
            "The velocity at which you operate outstrips that of your foe.",
            "You exhibit a swiftness that outpaces your enemy.",
            "Your speed is notably superior to that of your enemy.",
            "The speed you possess gives you a distinct advantage over the enemy.",
            "Your agility is far superior to that of your enemy.",
            "The pace at which you navigate is much quicker than that of your foe.",
            "Your speed provides you with a significant edge over your enemy."
            };
            System.out.println(text[GameFunction.rng(0, text.length)] + "\n");
        } else {
            String text[] = {"Your enemy possesses superior speed compared to your own capabilities.",
            "The velocity of your foe far surpasses your own.",
            "The opponent outpaces you significantly in terms of speed.",
            "The swiftness exhibited by your opponent exceeds your own pace.",
            "Your enemy moves with a velocity that outstrips your abilities.",
            "Your enemy demonstrates a speed that leaves you at a distinct disadvantage..",
            "The opponent of your adversary puts you in a disadvantaged position.",
            "Your opponent's agility far outmatches your own.",
            "The speed exhibited by your foe is notably faster than yours.",
            "Your opponent possesses a speed advantage that places you in a challenging position."
            };
            System.out.println(text[GameFunction.rng(0, text.length)] + "\n");
        }
    }
}


