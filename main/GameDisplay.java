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
        System.out.println("   ___I_      Name: " + mainscript.player.name);
        System.out.println("  /\\-_--\\    Level: " + mainscript.player.level);
        System.out.println(" /  \\_-__\\    Race: " + mainscript.player.race);
        System.out.println(" |[]| [] |     Exp: " + mainscript.player.currentExp + "/" + mainscript.player.exp);
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
            System.out.print("You Encounter A " + mainscript.monster.name + "!\r");
            GameFunction.VisualDelay(i * 250);
        }
        GameFunction.VisualDelay(100);
        System.out.println();
    }

    static void BattleModeYourTurn() {
        System.out.println("Current Exp: " + mainscript.player.currentExp  + "/" + mainscript.player.exp);
        System.out.println(mainscript.player.name+": " + mainscript.player.currentHP +"|----|"+ mainscript.monster.currentHP+" :" + mainscript.monster.name);
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

    static void HumanDescription() {
        System.out.println("Human Race:");
        System.out.println("────────────────────────────────");
        System.out.println("HP: 100\t\t\tMP:50");
        System.out.println("STR: 5\t\t\tDEF:10");
        System.out.println("MAG: 1\t\t\tMDEF:2");
        System.out.println("AGI: 10\t\t\tDEX:10");
        System.out.println("STA: 105\t\tLUK: 50");
        System.out.println("────────────────────────────────");
        System.out.println("Continue with Human Race? [1]Yes [2]No");
    }

    static void DemonDescription() {
        System.out.println("Demon Race:");
        System.out.println("────────────────────────────────");
        System.out.println("HP: 100\t\t\tMP:100");
        System.out.println("STR: 4\t\t\tDEF:5");
        System.out.println("MAG: 5\t\t\tMDEF:5");
        System.out.println("AGI: 10\t\t\tDEX:10");
        System.out.println("STA: 100\t\tLUK: 50");
        System.out.println("────────────────────────────────");
        System.out.println("Continue with Demon Race? [1]Yes [2]No");
    }

    static void ElfDescription() {
        System.out.println("Elf Race:");
        System.out.println("────────────────────────────────");
        System.out.println("HP: 100\t\t\tMP:100");
        System.out.println("STR: 2\t\t\tDEF:5");
        System.out.println("MAG: 7\t\t\tMDEF:15");
        System.out.println("AGI: 10\t\t\tDEX:15");
        System.out.println("STA: 100\t\tLUK: 50");
        System.out.println("────────────────────────────────");
        System.out.println("Continue with Elf Race? [1]Yes [2]No");
    }

    static void BeastDescription() {
        System.out.println("Beast Race:");
        System.out.println("────────────────────────────────");
        System.out.println("HP: 100\t\t\tMP:100");
        System.out.println("STR: 7\t\t\tDEF:15");
        System.out.println("MAG: 2\t\t\tMDEF:5");
        System.out.println("AGI: 15\t\t\tDEX:10");
        System.out.println("STA: 110\t\tLUK: 50");
        System.out.println("────────────────────────────────");
        System.out.println("Continue with Beast Race? [1]Yes [2]No");
    }

}
