package main.java.gr.pgiad.rpg;

import main.java.gr.pgiad.rpg.enumeration.MonsterKind;
import main.java.gr.pgiad.rpg.item.Potion;
import main.java.gr.pgiad.rpg.living.Hero;
import main.java.gr.pgiad.rpg.living.Monster;

import java.util.ArrayList;
import java.util.Scanner;

public class Battle extends Grid {
    private int heroMove(Hero myHero, Monster monster) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose your move: ");
        System.out.println("1. Attack");
        System.out.println("2. Cast Spell");
        System.out.println("3. Use Potion");
        System.out.println("4. Equip Armor & Weapon");

        while (true) {
            int choice = scan.nextInt();
            if (choice == 1) {
                myHero.setRoundAttack(myHero.getStrength() + myHero.getWeaponDamage() - monster.getDefense());
                monster.setCurrentHP(monster.getCurrentHP() - myHero.getRoundAttack());
                break;
            } else if (choice == 2) {
                // Choose one of your spells
                break;
            } else if (choice == 3) {
                if (myHero.getPotions() == null || myHero.getPotions().isEmpty()) {
                    System.out.println("You have no Potions in your inventory. Select another move to do");
                } else {
                    System.out.println("Choose your Potion: ");
                    for (int i = 0; i < myHero.getPotions().size(); i++) {
                        System.out.println((i + 1) + ". " + myHero.getPotions().get(i));
                    }
                    // Scan user's choice
                    int potionChoice = scan.nextInt();
                    // Call function usePotion with the selected potion
                    myHero.usePotion(myHero.getPotions().get(potionChoice - 1));
                    // Create a temporary list with potions
                    ArrayList<Potion> tempList = myHero.getPotions();
                    // Remove the selected potion
                    tempList.remove(potionChoice - 1);
                    // Replace potion list with the updated one
                    myHero.setPotions(tempList);
                    break;
                }
            } else if (choice == 4) {
                // Choose armor and weapons from your inventory
                break;
            } else {
                System.out.println("Choose again...");
            }
        }
        return monster.getCurrentHP();
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private int monsterMove(Hero myHero, Monster monster) {
        int attack = getRandomNumber(monster.getDamageMin(), monster.getDamageMax());
        myHero.setCurrentHP(myHero.getCurrentHP() - attack);
        return myHero.getCurrentHP();
    }

    public void main(Hero myHero) {
        double threshold = Math.random();
        Monster monster;
        if (threshold < 0.33) {
            monster = new Monster("Name", myHero.getLevel(), 1000, MonsterKind.DRAGON);
            System.out.println("Choose Dragon");
        } else if (threshold < 0.66) {
            monster = new Monster("Name", myHero.getLevel(), 1000, MonsterKind.EXOSKELETON);
            System.out.println("Choose Exoskeleton");
        } else {
            monster = new Monster("Name", myHero.getLevel(), 1000, MonsterKind.SPIRIT);
            System.out.println("Choose Spirit");
        }

        while (true) {
            System.out.println("Hero's life: " + myHero.getCurrentHP());
            System.out.println("Monster's life: " + monster.getCurrentHP());
            if (heroMove(myHero, monster) <= 0) break;        // Hero won
            if (monsterMove(myHero, monster) <= 0) break;     // Monster won
            /* Restore Health Power */
            if (myHero.getCurrentHP() < myHero.getHealthPower() - 50) myHero.setCurrentHP(myHero.getCurrentHP() + 50);
            else myHero.setCurrentHP(myHero.getHealthPower());
            if (monster.getCurrentHP() < monster.getHealthPower() - 50)
                monster.setCurrentHP(monster.getCurrentHP() + 50);
            else monster.setCurrentHP(monster.getHealthPower());
            System.out.println("Health restored");
            /* Restore Magic Power */
            if (myHero.getCurrentMP() < myHero.getMagicPower() - 50) myHero.setCurrentMP(myHero.getCurrentMP() + 50);
            else myHero.setCurrentMP(myHero.getMagicPower());
            System.out.println("Magic power restored");
        }
        // If Hero lost the battle
        if (myHero.getCurrentHP() <= 0) {
            System.out.println("You lost the battle");
            myHero.setCurrentHP(myHero.getHealthPower() / 2);
            myHero.setMoney(myHero.getMoney() / 2);
        }
        // If Hero won the battle
        else {
            System.out.println("You won the battle");
            myHero.setMoney(myHero.getMoney() + (100 * myHero.getLevel()));
            myHero.setExperience(myHero.getExperience() + (100 * myHero.getLevel()));
        }
    }
}
