package main;

public class testground {
    
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            double stat = 100;
            double basedmg_multiplier = 1.0;
            int def = 100;
            double final_multiplier = 1 + (Math.random() * (1.125 - 1));
            double def_penetration = 1.0; //0.0 means 100% pen, 1.0 means 0% pen ; for visual: (1.0 - def_penetration) * 100
            double dmg = ((stat * basedmg_multiplier) - (((def * 0.5) / 1.01) * def_penetration ) ) * final_multiplier;
            System.out.println(dmg + " " + final_multiplier);
            
        }
    }


}
