package main;
public class monster {
    String name;
    int level;
    int maxHP = 100;
    int currentHP = maxHP;
    int lowestDamage;
    int highestDamage;
    int speed;

    public monster(String MonsterName, int MonsterLevel, int MonsterHealth, int MonsterLowDMG, int MonsterHighDMG, int MonsterSpeed) {
        name = MonsterName;
        level = MonsterLevel;
        maxHP = MonsterHealth;
        lowestDamage = MonsterLowDMG;
        highestDamage = MonsterHighDMG;
        speed = MonsterSpeed;
    }


    
}
