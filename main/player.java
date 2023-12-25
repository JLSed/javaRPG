package main;

public class Player extends Race {
    public Player (RaceDescription chosenRace, String name) {
        this.name = name;
        System.out.println(chosenRace);
        chosenRace.Stats();
        
    }
    public int Attack(int monsterDef) {
        double minValue = 1;
        double maxValue = 1.125;
        double final_multiplier = minValue + (Math.random() * (maxValue - minValue));
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
