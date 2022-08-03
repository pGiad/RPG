package main.java.gr.pgiad.rpg;

import main.java.gr.pgiad.rpg.living.Hero;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventory {
    public void mainInventory(Hero myHero) {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("---------   Entered Inventory   ---------");
        System.out.println("-----------------------------------------");
        System.out.println();

        System.out.println("#   Potions: ");
        for (int i = 0; i < myHero.getPotions().size(); i++) {
            System.out.println((i + 1) + ". " + myHero.getPotions().get(i).getName()
                    + " (Kind: " + myHero.getPotions().get(i).getPotionKind()
                    + ", Gain: " + myHero.getPotions().get(i).getGain() + ")");
        }
        System.out.println();

        System.out.println("#   Spells: ");
        for (int i = 0; i < myHero.getSpells().size(); i++) {
            System.out.println((i + 1) + ". " + myHero.getSpells().get(i).name()
                    + " (Damage Range: " + myHero.getSpells().get(i).damageMin()
                    + "-" + myHero.getSpells().get(i).damageMax()
                    + ", Magic Power: " + myHero.getSpells().get(i).magicPower()
                    + ", Kind: " + myHero.getSpells().get(i).spellKind()
                    + ", Gain Percent: " + myHero.getSpells().get(i).specialValuePercent() + ")");
        }
        System.out.println();

        System.out.println("#   Weapons: ");
        for (int i = 0; i < myHero.getWeapons().size(); i++) {
            System.out.println((i + 1) + ". " + myHero.getWeapons().get(i).getName()
                    + " (Attack: " + myHero.getWeapons().get(i).getAttack() + ")");
        }
        System.out.println();

        System.out.println("#   Armors: ");
        for (int i = 0; i < myHero.getArmors().size(); i++) {
            System.out.println((i + 1) + ". " + myHero.getArmors().get(i).getName()
                    + " (Defense: " + myHero.getArmors().get(i).getDefense() + ")");
        }
        System.out.println();
        System.out.println();

        System.out.println("#   Weapon Equipped: ");
        if (myHero.getMyWeapon() == null)
            System.out.println("You have currently no Weapon equipped.");
        else
            System.out.println(myHero.getMyWeapon().getName());
        System.out.println();

        System.out.println("#   Armor Equipped: ");
        if (myHero.getMyArmor() == null)
            System.out.println("You have currently no Armor equipped.");
        else
            System.out.println(myHero.getMyArmor().getName());
        System.out.println();
        System.out.println();

        outerLoop:
        while (true) {
            System.out.println("#   What are you going to do?");
            System.out.println("1. Equip Weapon");
            System.out.println("2. Equip Armor");
            System.out.println("3. Exit Inventory");

            try {
                int choice = scan.nextInt();
                if (choice == 3) break;
                else if (choice == 1) {
                    if (myHero.getWeapons() == null || myHero.getWeapons().isEmpty()) {
                        System.out.println("You have no Weapons to equip.");
                    } else {
                        System.out.println("Choose your Weapon: ");
                        for (int i = 0; i < myHero.getWeapons().size(); i++) {
                            System.out.println((i + 1) + ". " + myHero.getWeapons().get(i).getName()
                                    + " (Attack: " + myHero.getWeapons().get(i).getAttack() + ")");
                        }
                        System.out.println((myHero.getWeapons().size() + 1) + ". Cancel");
                        while (true) {
                            try {
                                int weaponChoice = scan.nextInt();
                                if (weaponChoice == (myHero.getWeapons().size() + 1)) continue outerLoop;
                                if (weaponChoice > 0 && weaponChoice <= myHero.getWeapons().size()) {
                                    myHero.equipWeapon(weaponChoice - 1);
                                    System.out.println("You equipped: " + myHero.getMyWeapon().getName());
                                    continue outerLoop;
                                } else {
                                    System.out.println("Invalid Weapon. Please try again.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Weapon. Please try again.");
                                scan.nextLine();
                            }
                        }
                    }
                } else if (choice == 2) {
                    if (myHero.getArmors() == null || myHero.getArmors().isEmpty()) {
                        System.out.println("You have no Armors to Equip.");
                    } else {
                        System.out.println("Choose your Armor: ");
                        for (int i = 0; i < myHero.getArmors().size(); i++) {
                            System.out.println((i + 1) + ". " + myHero.getArmors().get(i).getName()
                                    + " (Defense: " + myHero.getArmors().get(i).getDefense() + ")");
                        }
                        System.out.println((myHero.getArmors().size() + 1) + ". Cancel");
                        while (true) {
                            try {
                                int armorChoice = scan.nextInt();
                                if (armorChoice == (myHero.getArmors().size() + 1)) continue outerLoop;
                                if (armorChoice > 0 && armorChoice <= myHero.getArmors().size()) {
                                    myHero.equipArmor((armorChoice - 1));
                                    System.out.println("You equipped: " + myHero.getMyArmor().getName());
                                    continue outerLoop;
                                } else {
                                    System.out.println("Invalid Armor. Please try again.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid Armor. Please try again.");
                                scan.nextLine();
                            }
                        }
                    }
                } else {
                    System.out.println("Invalid Choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Choice. Please try again.");
                scan.nextLine();
            }
        }
    }
}
