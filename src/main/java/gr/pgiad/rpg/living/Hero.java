package main.java.gr.pgiad.rpg.living;

import main.java.gr.pgiad.rpg.Spell;
import main.java.gr.pgiad.rpg.enumeration.HeroKind;
import main.java.gr.pgiad.rpg.enumeration.PotionKind;
import main.java.gr.pgiad.rpg.enumeration.SpellKind;
import main.java.gr.pgiad.rpg.item.Armor;
import main.java.gr.pgiad.rpg.item.Potion;
import main.java.gr.pgiad.rpg.item.Weapon;

import java.util.ArrayList;

public class Hero extends Living {
    // Defense is the amount of power that we reduce from the opponent's attack
    private int money;
    private int experience;
    private int defense;
    private int roundAttack;
    private int armorDefense;
    private int weaponDamage;
    private int magicPower;
    private int currentMP;
    private int strength;
    private int dexterity;
    private int agility;
    private HeroKind heroKind;
    private ArrayList<Weapon> weapons;
    private ArrayList<Armor> armors;
    private ArrayList<Potion> potions;

    // Constructor
    public Hero(String name, HeroKind heroKind) {
        super(name, 0, 1000);
        this.heroKind = heroKind;
        this.money = 200;
        this.experience = 0;
        this.defense = 0;
        this.magicPower = 500;
        this.currentMP = 500;
        if (heroKind == HeroKind.WARRIOR) {
            this.strength = 700;
            this.dexterity = 500;
            this.agility = 700;
        } else if (heroKind == HeroKind.SORCERER) {
            this.strength = 500;
            this.dexterity = 700;
            this.agility = 700;
        } else if (heroKind == HeroKind.PALADIN) {
            this.strength = 700;
            this.dexterity = 700;
            this.agility = 500;
        }

        System.out.println("Constructed a Hero of kind: " + this.heroKind + ", named: " + this.getName());       // Print message
        System.out.println("Money: " + this.money);
        System.out.println("XP: " + this.experience);
        System.out.println("Defense: " + this.defense);
        System.out.println("Magic Power: " + this.magicPower);
        System.out.println("Strength: " + this.strength);
        System.out.println("Dexterity: " + this.dexterity);
        System.out.println("Agility: " + this.agility);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getRoundAttack() {
        return roundAttack;
    }

    public void setRoundAttack(int roundAttack) {
        this.roundAttack = roundAttack;
    }

    public int getArmorDefense() {
        return armorDefense;
    }

    public void setArmorDefense(int armorDefense) {
        this.armorDefense = armorDefense;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public HeroKind getHeroKind() {
        return heroKind;
    }

    public void setHeroKind(HeroKind heroKind) {
        this.heroKind = heroKind;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public ArrayList<Armor> getArmors() {
        return armors;
    }

    public void setArmors(ArrayList<Armor> armors) {
        this.armors = armors;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    // Function that changes the stats of the Hero when he has enough xp to level up
    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
        this.setHealthPower(this.getHealthPower() * 2);
        this.magicPower *= 2;
        if (this.heroKind == HeroKind.WARRIOR) {
            this.strength += 300;
            this.dexterity += 200;
            this.agility += 300;
        } else if (this.heroKind == HeroKind.SORCERER) {
            this.strength += 200;
            this.dexterity += 300;
            this.agility += 300;
        } else {
            this.strength += 300;
            this.dexterity += 300;
            this.agility += 200;
        }
    }

    // Function to give Hero extra defense if armor is equipped
    public void equipArmor(Armor armor) {
        this.setArmorDefense(armor.getDefense());
    }

    // Function to give Hero extra attack/strength if weapon is equipped
    public void equipWeapon(Weapon weapon) {
        this.setWeaponDamage(weapon.getAttack());
    }

    // Function to raise the value of a stat based on the potion kind that the Hero used
    public void usePotion(Potion potion) {
        PotionKind potionKind = potion.getPotionKind();
        switch (potionKind) {
            case STRENGTH:
                this.setStrength(this.getStrength() + potion.getGain());
            case DEXTERITY:
                this.setDexterity(this.getDexterity() + potion.getGain());
            case AGILITY:
                this.setAgility(this.getAgility() + potion.getGain());
        }

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    // Function to Trigger what should be done when a spell is used. This function should not be under this class...
    public void castSpell(Spell spell) {
        if (this.magicPower < spell.getMagicPower()) {
            // Don't let Hero cast the Spell
        }
        // Do the basics for all the spells
        this.magicPower -= spell.getMagicPower();
        //   roundAttack = getRandomNumber(spellMinAttack, spellMaxAttack);
        SpellKind spellKind = spell.getSpellKind();
        switch (spellKind) {
            case ICESPELL:      // reduces damage range of the opponent
            case FIRESPELL:     // reduces defense of the opponent
            case LIGHTINGSPELL: // reduces the chance of the opponent to dodge an attack
        }
    }

    public static void main(String[] args) {
        new Hero("Arthur", HeroKind.PALADIN);
    }
}
