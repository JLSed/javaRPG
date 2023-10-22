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
        exp = (int) (50 + (level) * 2.5);

    }

    public int attack(int MonHP) {
        return MonHP = GameFunction.rng(this.lowestDamage, this.highestDamage);
    }

}
