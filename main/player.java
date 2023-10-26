package main;

public class player {
    int level;
    int exp, currentExp;
    int maxHP;
    int currentHP = maxHP;
    int highestDamage, lowestDamage;
    int speed;
    String name;
    
    public player(String playerName, int playerLevel, int playerHealth, int playerLowDMG, int playerHighDMG, int playerSpeed, int playerExp) {
        name = playerName;
        level = playerLevel;
        maxHP = playerHealth;
        currentHP = maxHP;
        lowestDamage = playerLowDMG;
        highestDamage = playerHighDMG;
        speed = playerSpeed;
        exp = BaseExpUpdate();

    }

    public int Attack() {
        int atkdealt = GameFunction.rng(this.lowestDamage, this.highestDamage);
        return atkdealt;
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
