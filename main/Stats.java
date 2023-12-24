package main;

class Stats {
    protected String name;
    protected String race;
    protected int level;
    protected int exp, currentExp;
    protected int maxHP;
    protected int currentHP = maxHP;
    protected int mp;
    protected int str, mag, agi, dex, luk, sta,spd;
    protected int def, mdef;

    protected double modeOfDmg;
    protected double basedmg_multiplier = 1.0;
    protected double def_penetration = 1.0; //0.0 means 100% pen, 1.0 means 0% pen ; for visual: (1.0 - def_penetration) * 100
}
