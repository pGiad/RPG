package main.java.gr.pgiad.rpg;

import main.java.gr.pgiad.rpg.living.Hero;

// This class is not used because I want to find a way to print statistics of Hero whenever player wants/presses a key
public class PrintPlayerStats {
    public static void printStats(Hero myHero) {
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println(myHero.getHeroKind() + " " + myHero.getName() + "'s Statistics:");
        System.out.println("-----------------------------------------------");
        System.out.println();
        System.out.println("Level: " + myHero.getLevel());
        System.out.println("Experience: " + myHero.getExperience() + "/" + myHero.getLevelUpExperience());
        System.out.println("Health Power: " + myHero.getCurrentHP() + "/" + myHero.getHealthPower());
        System.out.println("Magic Power: " + myHero.getCurrentMP() + " " + myHero.getMagicPower());
        System.out.println("Money: " + myHero.getMoney());
        System.out.println("Strength: " + myHero.getStrength());
        System.out.println("Dexterity: " + myHero.getDexterity());
        System.out.println("Agility: " + myHero.getAgility());
        System.out.println("Defense: " + myHero.getDefense());
        if (myHero.getMyWeapon() != null)
            System.out.println("Weapon Equipped: " + myHero.getMyWeapon());
        if (myHero.getMyArmor() != null)
            System.out.println("Armor Equipped: " + myHero.getMyArmor());
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println();
    }
}
