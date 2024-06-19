package player;
public class Player extends Stats {

    // public Player(String name, String race) {
    // this.name = name;
    // this.race = race;
    // }

    // public Player() {

    // }

    public void setBasicStats(int hp, int mp, int def, int mdef, int sta) {
        this.hp = hp;
        this.mp = mp;
        this.def = def;
        this.mdef = mdef;
        this.sta = sta;

        this.currentHP = this.hp;
        this.currentMP = this.mp;
        this.currentSta = this.sta;
    }

    public void setAbilityStats(int str, int mag, int agi, int dex, int luk, int spd) {
        this.str = str;
        this.mag = mag;
        this.agi = agi;
        this.dex = dex;
        this.luk = luk;
        this.spd = spd;
    }

    public void setLevel(int lvl, int exp) {
        this.lvl = lvl;
        this.exp = exp;

        this.currentEXP = this.exp;

    }
}
