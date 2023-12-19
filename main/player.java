package main;

public class player {
    String name;
    String race;
    int level;
    int exp, currentExp;
    int maxHP;
    int currentHP = maxHP;
    int str, mag, agi, dex, luk, sta,spd;
    int def, mdef;

    double modeOfDmg;
    double basedmg_multiplier = 1.0;
    double def_penetration = 1.0; //0.0 means 100% pen, 1.0 means 0% pen ; for visual: (1.0 - def_penetration) * 100
    
    public player(String pName, int pLevel, int pHealth, int pStr, int pMag, int pAgi, int pDex, int pLuk, int pSta, int pDef, int pMdef, int pSpeed, int pExp, String pRace) {
        name = pName;
        race = pRace;
        level = pLevel;
        maxHP = pHealth;
        currentHP = maxHP;

        str = pStr;
        mag = pMag;
        spd = pSpeed;
        def = pDef;

        exp = BaseExpUpdate();

        if (race == "Elf") {
            modeOfDmg = mag;
        } else {
            modeOfDmg = str;
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
        double expEarned = ((GameFunction.rng(25, 30) * mainscript.player.level) / 3.3);
        return (int) Math.round(expEarned);
    }
}
