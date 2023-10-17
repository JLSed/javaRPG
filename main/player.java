package main;

public class player {
    int level;
    int exp;
    int maxHP;
    int currentHP = maxHP;
    int highestDamage;
    int lowestDamage;
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
        exp = playerExp;
    }

    public int attack(int MonHP) {
        return MonHP = miscFunction.rng(this.lowestDamage, this.highestDamage);
    }

}
