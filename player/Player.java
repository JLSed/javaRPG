package player;
public class Player extends Stats {

    public Player(String name, String race) {
        this.name = name;
        this.race = race;
    }

    public Player(String name) {
        this.name = name;
    }

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

    public String getName() {
        return this.name;
    }

    public String state() {
        String platerState = this.name + "/";
        platerState += this.race + "/";
        platerState += Integer.toString(this.lvl) + "/";
        platerState += Integer.toString(this.exp) + "/";
        platerState += Integer.toString(this.currentEXP) + "/";
        platerState += Integer.toString(this.hp) + "/";
        platerState += Integer.toString(this.currentHP) + "/";
        platerState += Integer.toString(this.mp) + "/";
        platerState += Integer.toString(this.currentMP) + "/";
        platerState += Integer.toString(this.sta) + "/";
        platerState += Integer.toString(this.currentSta) + "/";
        platerState += Integer.toString(this.def) + "/";
        platerState += Integer.toString(this.mdef) + "/";
        platerState += Integer.toString(this.str) + "/";
        platerState += Integer.toString(this.mag) + "/";
        platerState += Integer.toString(this.agi) + "/";
        platerState += Integer.toString(this.dex) + "/";
        platerState += Integer.toString(this.luk) + "/";
        platerState += Integer.toString(this.spd) + "/";
        return platerState;
          
    }
}
