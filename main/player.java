package main;

public class Player extends Race {
    public Player (int chose, String name) {
        this.name = name;
        switch (chose) {
            case 1: Human();
                break;
            case 2: Demon();
                break;
            case 3: Elf();
                break;
            case 4: Beast(); 
                break;
            default:
                break;
        }
    }
    public int Attack(int monsterDef) {
        double final_multiplier = 1 + (Math.random() * (1.125 - 1));
        double dmg = ((modeOfDmg * basedmg_multiplier) - (((monsterDef * 0.5) / 1.01) * def_penetration ) ) * final_multiplier;
        // System.out.println(dmg + " " + final_multiplier);
        return (int) Math.round(dmg);
        
    }

    public int BaseExpUpdate() {
        // FORMULA: (50 + (level * 2.5))
        int exp = (int)(50 + (this.level) * 2.5);
        return exp;
    }

    public int ExpEarned() {
        // FORMULA: expEarned = ((rngNum) * level) / 3.3
        double expEarned = ((GameFunction.rng(25, 30) * Mainscript.player.level) / 3.3);
        return (int) Math.round(expEarned);
    }
}
