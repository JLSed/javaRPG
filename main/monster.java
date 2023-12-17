package main;
public class monster {
    String name;
    String race;
    int level;
    int exp, currentExp;
    int maxHP;
    int currentHP = maxHP;

    int spd, str, mag, def;

    double modeOfDmg;
    double basedmg_multiplier = 1.0;
    double def_penetration = 1.0;

    public monster(String monsterName, int monsterLevel, int monsterHealth, int monsterStr, int monsterMag, int monsterDef , int monsterSpeed) {
        name = monsterName;
        level = monsterLevel;
        maxHP = monsterHealth;
        currentHP = maxHP;

        str = monsterStr;
        mag = monsterMag;
        def = monsterDef;
        spd = monsterSpeed;
        modeOfDmg = str;
    }

    public int Attack(int playerDef) {
        double final_multiplier = 1 + (Math.random() * (1.125 - 1));
        double dmg = ((modeOfDmg * basedmg_multiplier) - (((playerDef * 0.5) / 1.01) * def_penetration ) ) * final_multiplier;
        // System.out.println(dmg + " " + final_multiplier);
        return (int) Math.round(dmg);
    }
    
}
