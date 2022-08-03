package main.java.gr.pgiad.rpg;

import main.java.gr.pgiad.rpg.enumeration.MonsterKind;
import main.java.gr.pgiad.rpg.item.Potion;
import main.java.gr.pgiad.rpg.living.Hero;
import main.java.gr.pgiad.rpg.living.Monster;
import main.java.gr.pgiad.rpg.monsterNames.MonsterNames;

import java.util.*;

public class Battle {
    private int spellAttack = 0;
    private int spellCounter = 0;    // Counts for how many rounds the spell is active

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    // Function to Trigger what should be done when a spell is used
    private void castSpell(Hero myHero, Monster monster, Spell spell) {
        // Reduce Hero's magic power
        myHero.setCurrentMP(myHero.getCurrentMP() - spell.magicPower());
        // Set Hero's round attack based on the attack range of the spell and the dexterity of Hero
        spellAttack = getRandomNumber((int) (spell.damageMin() * myHero.getDexterity())
                , (int) (spell.damageMax() * myHero.getDexterity()));
        monster.setCurrentHP(monster.getCurrentHP() - spellAttack);
        spellCounter = 3;
        switch (spell.spellKind()) {
            case ICESPELL:      // reduces damage range of the opponent
                monster.setDamageMin(monster.getDamageMin() / (2 * spell.minLevel()));
            case FIRESPELL:     // reduces defense of the opponent
                monster.setDefense(monster.getDefense() / (2 * spell.minLevel()));
            case LIGHTINGSPELL: // reduces the chance of the opponent to dodge an attack
                monster.setDodgeChance(monster.getDodgeChance() / (2 * spell.minLevel()));
        }
    }

    // Function to raise the value of a stat based on the potion kind that the Hero used
    private void usePotion(Hero myHero, Potion potion) {
        switch (potion.getPotionKind()) {
            case STRENGTH:
                myHero.setStrength(myHero.getStrength() + potion.getGain());
            case DEXTERITY:
                myHero.setDexterity(myHero.getDexterity() + potion.getGain());
            case AGILITY:
                myHero.setAgility(myHero.getAgility() + potion.getGain());
        }
    }

    private int heroMove(Hero myHero, Monster monster) {
        Scanner scan = new Scanner(System.in);

        outerLoop:
        while (true) {
            System.out.println("Choose your move: ");
            System.out.println("1. Attack");
            System.out.println("2. Cast Spell");
            System.out.println("3. Use Potion");
            System.out.println("4. Equip Armor & Weapon");

            try {
                int choice = scan.nextInt();
                if (choice == 1) {
                    // Regular attack
                    myHero.setRoundAttack(spellAttack + myHero.getStrength() + myHero.getWeaponDamage()
                            - monster.getDefense());
                    monster.setCurrentHP(monster.getCurrentHP() - myHero.getRoundAttack());
                    break;
                } else if (choice == 2) {
                    // Cast a Spell
                    if (myHero.getSpells() == null || myHero.getSpells().isEmpty()) {
                        System.out.println("You have no Spells in your inventory. Select another move to do.");
                    } else {
                        System.out.println("Magic Power: " + myHero.getCurrentMP());
                        System.out.println("Choose your Spell: ");
                        for (int i = 0; i < myHero.getSpells().size(); i++) {
                            if (myHero.getCurrentMP() >= myHero.getSpells().get(i).magicPower()) {
                                System.out.println((i + 1) + ". " + myHero.getSpells().get(i).name()
                                        + " (Magic Power Required: " + myHero.getSpells().get(i).magicPower()
                                        + ", Attack Range: " + myHero.getSpells().get(i).damageMin()
                                        + "-" + myHero.getSpells().get(i).damageMax()
                                        + ", Kind: " + myHero.getSpells().get(i).spellKind()
                                        + ", Gain Percent: " + myHero.getSpells().get(i).specialValuePercent() + ")");
                            }
                        }
                        System.out.println((myHero.getSpells().size() + 1) + ". Cancel");
                        // Scan user's choice
                        int spellChoice = scan.nextInt();
                        if (spellChoice == (myHero.getSpells().size() + 1)) continue;
                        // Call function castSpell with selected spell
                        castSpell(myHero, monster, myHero.getSpells().get(spellChoice - 1));
                        break;
                    }
                } else if (choice == 3) {
                    // Use a Potion
                    if (myHero.getPotions() == null || myHero.getPotions().isEmpty()) {
                        System.out.println("You have no Potions in your inventory. Select another move to do.");
                    } else {
                        System.out.println("Choose your Potion: ");
                        for (int i = 0; i < myHero.getPotions().size(); i++) {
                            System.out.println((i + 1) + ". " + myHero.getPotions().get(i).getName()
                                    + "(Kind: " + myHero.getPotions().get(i).getPotionKind()
                                    + ", Gain: " + myHero.getPotions().get(i).getGain() + ")");
                        }
                        System.out.println((myHero.getPotions().size() + 1) + ". Cancel");
                        // Scan user's choice
                        int potionChoice = scan.nextInt();
                        if (potionChoice == (myHero.getPotions().size() + 1)) continue;
                        // Call function usePotion with the selected potion
                        usePotion(myHero, myHero.getPotions().get(potionChoice - 1));
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
                    if ((myHero.getWeapons() == null || myHero.getWeapons().isEmpty()) && (myHero.getArmors() == null
                            || myHero.getArmors().isEmpty())) {
                        System.out.println("You have no Weapons or Armor in your inventory. Select another move to do.");
                    } else {
                        while (true) {
                            if (myHero.getWeapons() != null && !myHero.getWeapons().isEmpty()) {
                                System.out.println("Choose a Weapon: ");
                                for (int i = 0; i < myHero.getWeapons().size(); i++) {
                                    System.out.println((i + 1) + ". " + myHero.getWeapons().get(i).getName()
                                            + " (Attack: " + myHero.getWeapons().get(i).getAttack()
                                            + ", Equipped: " + myHero.getWeapons().get(i).isEquipped() + ")");
                                }
                                System.out.println((myHero.getWeapons().size() + 1) + ". Skip Weapons and go to Armors");
                                System.out.println((myHero.getWeapons().size() + 2) + ". Cancel");
                                int weaponChoice = scan.nextInt();
                                if (weaponChoice == (myHero.getWeapons().size() + 2))
                                    continue outerLoop;
                                if (weaponChoice != (myHero.getWeapons().size() + 1)) {
                                    if (myHero.getWeapons().get(weaponChoice - 1).isEquipped()) {
                                        System.out.println("This Weapon is Equipped. Please choose another one.");
                                        continue;
                                    }
                                    myHero.equipWeapon(weaponChoice - 1);
                                    break;
                                }
                                break;
                            }
                        }
                        while (true) {
                            if (myHero.getArmors() != null && !myHero.getArmors().isEmpty()) {
                                System.out.println("Choose an Armor: ");
                                for (int i = 0; i < myHero.getArmors().size(); i++) {
                                    System.out.println((i + 1) + ". " + myHero.getArmors().get(i).getName()
                                            + " (Defense: " + myHero.getArmors().get(i).getDefense()
                                            + ", Equipped: " + myHero.getArmors().get(i).isEquipped() + ")");
                                }
                                System.out.println((myHero.getArmors().size() + 1) + ". Skip Armors");
                                int armorChoice = scan.nextInt();
                                if (armorChoice != (myHero.getArmors().size() + 1)) {
                                    if (myHero.getArmors().get(armorChoice - 1).isEquipped()) {
                                        System.out.println("This Armor is Equipped. Please choose another one.");
                                        continue;
                                    }
                                    myHero.equipArmor(armorChoice - 1);
                                    break;
                                }
                                System.out.println();
                                break;
                            }
                        }
                        break;
                    }
                } else {
                    System.out.println("Invalid move. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid move. Please try again.");
                scan.nextLine();
            }
        }
        return monster.getCurrentHP();
    }

    private int monsterMove(Hero myHero, Monster monster) {
        int attack = getRandomNumber(monster.getDamageMin(), monster.getDamageMax());
        myHero.setCurrentHP(myHero.getCurrentHP() + myHero.getDefense() + myHero.getArmorDefense() - attack);
        return myHero.getCurrentHP();
    }

    public void main(Hero myHero) throws InterruptedException {
        double threshold = Math.random();
        Monster monster;
        MonsterNames monsterNames = new MonsterNames();
        if (threshold < 0.33) {
            monster = new Monster(monsterNames.monsterName(MonsterKind.DRAGON), myHero.getLevel(), myHero.getHealthPower(), MonsterKind.DRAGON);
        } else if (threshold < 0.66) {
            monster = new Monster(monsterNames.monsterName(MonsterKind.EXOSKELETON), myHero.getLevel(), myHero.getHealthPower(), MonsterKind.EXOSKELETON);
        } else {
            monster = new Monster(monsterNames.monsterName(MonsterKind.SPIRIT), myHero.getLevel(), myHero.getHealthPower(), MonsterKind.SPIRIT);
        }

        System.out.println();
        System.out.println("---------------------------------------------------");
        System.out.println(myHero.getHeroKind() + " " + myHero.getName() + "   VS   " + monster.getMonsterKind() + " "
                + monster.getName());
        System.out.println("---------------------------------------------------");
        System.out.println();
        Thread.sleep(1000);
        System.out.println("#  " + myHero.getName() + "'s Stats: ");
        System.out.println("Level: " + myHero.getLevel());
        System.out.println("XP: " + myHero.getExperience() + "/" + myHero.getLevelUpExperience());
        System.out.println("HP: " + myHero.getCurrentHP() + "/" + myHero.getHealthPower());
        System.out.println("Magic Power: " + myHero.getCurrentMP() + "/" + myHero.getMagicPower());
        System.out.println("Defense: " + myHero.getDefense());
        System.out.println("Strength: " + myHero.getStrength());
        System.out.println("Dexterity: " + myHero.getDexterity());
        System.out.println("Agility: " + myHero.getAgility());
        if (myHero.getMyWeapon() != null)
            System.out.println("Weapon: " + myHero.getMyWeapon().getName() + " (Attack: "
                    + myHero.getMyWeapon().getAttack() + ")");
        else
            System.out.println("No Weapon Equipped");
        if (myHero.getMyArmor() != null)
            System.out.println("Armor: " + myHero.getMyArmor().getName() + " (Defense: "
                    + myHero.getMyArmor().getDefense() + ")");
        else
            System.out.println("No Armor Equipped");
        System.out.println();

        Thread.sleep(1000);
        System.out.println("#  " + monster.getName() + "'s Stats: ");
        System.out.println("Level: " + monster.getLevel());
        System.out.println("HP: " + monster.getCurrentHP() + "/" + monster.getHealthPower());
        System.out.println("Defense: " + monster.getDefense());
        System.out.println("Attack Range: " + monster.getDamageMin() + "-" + monster.getDamageMax());
        System.out.println();
        System.out.println();
        Thread.sleep(1000);

        while (true) {
            if (spellCounter > 0)
                spellCounter--;
            else
                spellAttack = 0;

            System.out.println("Hero's life: " + myHero.getCurrentHP() + "/" + myHero.getHealthPower());
            System.out.println("Monster's life: " + monster.getCurrentHP() + "/" + monster.getHealthPower());

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
            if (myHero.getExperience() >= myHero.getLevelUpExperience()) {
                myHero.levelUp();
            }
        }
    }
}
