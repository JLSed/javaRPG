package main;

class Race extends Stats{

}


/**
 * RaceDescription
 */
interface RaceDescription {
    String RaceName();
    void ShowInfo();
    void Stats();
}

class HumanDescription extends Stats implements RaceDescription {
    public String RaceName() {
        return "Human";
    }
    public void ShowInfo() {
        System.out.println("Human Race:");
        System.out.println("────────────────────────────────");
        System.out.println("HP: 100\t\t\tMP:50");
        System.out.println("STR: 5\t\t\tDEF:10");
        System.out.println("MAG: 1\t\t\tMDEF:2");
        System.out.println("AGI: 10\t\t\tDEX:10");
        System.out.println("STA: 105\t\tLUK: 50");
        System.out.println("────────────────────────────────");
        System.out.println("Continue with Human Race? [1]Yes [2]No");
    }
    public void Stats() {
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
}

class DemonDescription extends Stats implements RaceDescription {
    public String RaceName() {
        return "Demon";
    }
    public void ShowInfo() {
        System.out.println("Demon Race:");
        System.out.println("────────────────────────────────");
        System.out.println("HP: 100\t\t\tMP:100");
        System.out.println("STR: 4\t\t\tDEF:5");
        System.out.println("MAG: 5\t\t\tMDEF:5");
        System.out.println("AGI: 10\t\t\tDEX:10");
        System.out.println("STA: 100\t\tLUK: 50");
        System.out.println("────────────────────────────────");
        System.out.println("Continue with Demon Race? [1]Yes [2]No");
    }
    public void Stats() {
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
}

    class ElfDescription extends Stats implements RaceDescription {
        public String RaceName() {
        return "Elf";
        }
        public void ShowInfo() {
            System.out.println("Elf Race:");
            System.out.println("────────────────────────────────");
            System.out.println("HP: 100\t\t\tMP:200");
            System.out.println("STR: 2\t\t\tDEF:5");
            System.out.println("MAG: 7\t\t\tMDEF:15");
            System.out.println("AGI: 10\t\t\tDEX:15");
            System.out.println("STA: 100\t\tLUK: 50");
            System.out.println("────────────────────────────────");
            System.out.println("Continue with Elf Race? [1]Yes [2]No");
        }
        public void Stats() {
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
    }

    class BeastDescription extends Stats implements RaceDescription {
        public String RaceName() {
        return "Beast";
    }
        public void ShowInfo() {
            System.out.println("Beast Race:");
            System.out.println("────────────────────────────────");
            System.out.println("HP: 100\t\t\tMP:100");
            System.out.println("STR: 7\t\t\tDEF:15");
            System.out.println("MAG: 2\t\t\tMDEF:5");
            System.out.println("AGI: 15\t\t\tDEX:10");
            System.out.println("STA: 110\t\tLUK: 50");
            System.out.println("────────────────────────────────");
            System.out.println("Continue with Beast Race? [1]Yes [2]No");
        }
        public void Stats() {
            



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
