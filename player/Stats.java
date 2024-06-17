
class Stats {
    protected String name;
    protected String race;
    protected int lvl;
    protected int exp, currentEXP;
    protected int hp, currentHP;
    protected int mp, currentMP;
    protected int sta, currentSta;
    protected int def, mdef;
    protected int str, mag, agi, dex, luk, spd;

    // attack modifiers
    protected double baseDmgMultiplier = 1.0;
    // 0.0 means 100% def penetration, 1.0 means 0% def penetration ; (1.0 - def
    // penetration) * 100
    protected double defPen = 1.0;
    // protected double modeOfDmg;

}
