package main;

class Race extends Stats{
    
    public void Human() {
        race = "Human";
        level = 1;
        maxHP = 100;
        mp = 50;
        str = 5;
        mag = 1;
        agi = 10;
        dex = 10;
        sta = 105;
        spd = 10;
        def = 10;
        mdef = 2;
        luk = 50;
        currentHP = maxHP;
        modeOfDmg = str;
    } 

    public void Demon() {
        race = "Demon";
        level = 1;
        maxHP = 100;
        mp = 100;
        str = 4;
        mag = 5;
        agi = 10;
        dex = 10;
        sta = 100;
        spd = 10;
        def = 5;
        mdef = 5;
        luk = 50;
        currentHP = maxHP;
        modeOfDmg = str;
    } 

    public void Elf() {
        race = "Elf";
        level = 1;
        maxHP = 100;
        mp = 200;
        str = 2;
        mag = 7;
        agi = 10;
        dex = 15;
        sta = 100;
        spd = 10;
        def = 5;
        mdef = 15;
        luk = 50;
        currentHP = maxHP;
        modeOfDmg = mag;
    } 

    public void Beast() {
        race = "Beast";
        level = 1;
        maxHP = 200;
        mp = 50;
        str = 7;
        mag = 2;
        agi = 15;
        dex = 10;
        sta = 110;
        spd = 10;
        def = 15;
        mdef = 5;
        luk = 50;
        currentHP = maxHP;
        modeOfDmg = str;
    } 
}